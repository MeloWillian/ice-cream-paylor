package br.edu.ifpb.ice_cream_parlor.patterns.repository;

import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.config.GlobalDatabaseConfig;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientRepository {
    private final String table = "clients";

    private final ConnectionFactory connectionFactory;

    public ClientRepository() {
        this.connectionFactory = GlobalDatabaseConfig.getInstance().getConnectionFactory();
    }

    public Client save(Client client) {
        String sql = "INSERT INTO " + table + " (id, name) VALUES (?, ?)";

        try (Connection conn = connectionFactory.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, client.getId());
            stmt.setString(2, client.getName());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falha ao inserir cliente, nenhuma linha afetada.");
            }

            return client;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar cliente", e);
        }
    }

    public Client findByName(String name) {
        String sql = "SELECT id, name FROM " + table + " WHERE LOWER(name) = LOWER(?)";

        try (Connection conn = connectionFactory.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Client client = new Client(rs.getString("name"));
                    setClientId(client, rs.getString("id"));
                    return client;
                } else {
                    return null; // ou você pode lançar uma exceção se preferir
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar cliente por nome", e);
        }
    }

    public List<Client> findAll() {
        String sql = "SELECT id, name FROM " + table;
        List<Client> clients = new ArrayList<>();

        try (Connection conn = connectionFactory.createConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Client client = new Client(rs.getString("name"));
                setClientId(client, rs.getString("id"));
                clients.add(client);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar todos os clientes", e);
        }

        return clients;
    }

    private void setClientId(Client client, String id) {
        try {
            java.lang.reflect.Field field = Client.class.getDeclaredField("id");
            field.setAccessible(true);
            field.set(client, id);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao setar id no client via reflection", e);
        }
    }
}

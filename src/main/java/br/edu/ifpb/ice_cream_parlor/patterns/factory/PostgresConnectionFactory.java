package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import br.edu.ifpb.ice_cream_parlor.config.AppProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnectionFactory implements ConnectionFactory {

    private static final String URL;
    private static final String USER;
    private static final String PASSWORD;

    static {
        try {
            Class.forName("org.postgresql.Driver");
            URL = AppProperties.get("db.url");
            USER = AppProperties.get("db.user");
            PASSWORD = AppProperties.get("db.password");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver não encontrado.", e);
        }
    }

    @Override
    public Connection createConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

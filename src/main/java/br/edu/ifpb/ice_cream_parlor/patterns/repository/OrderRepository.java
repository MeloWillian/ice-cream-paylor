package br.edu.ifpb.ice_cream_parlor.patterns.repository;

import br.edu.ifpb.ice_cream_parlor.config.GlobalDatabaseConfig;
import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;
import br.edu.ifpb.ice_cream_parlor.model.entities.OrderItem;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderItemView;
import br.edu.ifpb.ice_cream_parlor.model.view.OrderView;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.CouponFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.OrderStateFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.observer.OrderStatusNotifier;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class OrderRepository {
    private final ConnectionFactory connectionFactory;

    public OrderRepository() {
        this.connectionFactory = GlobalDatabaseConfig.getInstance().getConnectionFactory();
    }

    public void save(Order order) {
        String orderSql = "INSERT INTO orders (id, client_id, date, status, coupon_code, subtotal, total) VALUES (?, ?, ?, ?, ?, ?, ?)";
        String itemSql = "INSERT INTO order_items (order_id, ice_cream_name, quantity, subtotal) VALUES (?, ?, ?, ?)";

        try (Connection conn = connectionFactory.createConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement orderStmt = conn.prepareStatement(orderSql);
                 PreparedStatement itemStmt = conn.prepareStatement(itemSql)) {

                // Salva pedido
                orderStmt.setString(1, order.getId());
                orderStmt.setString(2, order.getClient().getId());
                orderStmt.setDate(3, Date.valueOf(order.getDate()));
                orderStmt.setString(4, order.getStatus());
                orderStmt.setString(5, order.getCoupon() != null ? order.getCoupon().getCode() : null);
                orderStmt.setDouble(6, order.getSubTotal());
                orderStmt.setDouble(7, order.getTotal());

                orderStmt.executeUpdate();

                // Salva itens
                for (OrderItem item : order.getItems()) {
                    itemStmt.setString(1, order.getId());
                    itemStmt.setString(2, item.getIceCream().getDescription());
                    itemStmt.setInt(3, item.getQuantity());
                    itemStmt.setDouble(4, item.getSubtotal());
                    itemStmt.addBatch();
                }

                itemStmt.executeBatch();
                conn.commit();

            } catch (SQLException e) {
                conn.rollback();
                System.out.println("ERRO [save order]: "+e);
                throw new RuntimeException("Erro ao salvar pedido", e);
            } finally {
                conn.setAutoCommit(true);
            }

        } catch (SQLException e) {
            throw new RuntimeException("Erro de conexão ao salvar pedido", e);
        }
    }

    public List<OrderView> findByClientId(String clientId) {
        List<OrderView> orders = new ArrayList<>();

        String orderSql = """
        SELECT o.id, date, status, coupon_code, client_id, c.name AS client_name, subtotal, total 
        FROM orders AS o
        JOIN clients AS c ON(o.client_id = c.id)
        WHERE client_id = ?
    """;

        String itemSql = """
        SELECT ice_cream_name, quantity, subtotal 
        FROM order_items 
        WHERE order_id = ?
    """;

        try (Connection conn = connectionFactory.createConnection();
             PreparedStatement orderStmt = conn.prepareStatement(orderSql)) {

            orderStmt.setString(1, clientId);
            ResultSet orderRs = orderStmt.executeQuery();

            while (orderRs.next()) {
                OrderView orderView = new OrderView();

                // Preenche os dados do pedido
                String orderId = orderRs.getString("id");
                orderView.setId(orderId);
                orderView.setDate(orderRs.getDate("date").toLocalDate());
                orderView.setStatus(orderRs.getString("status"));
                orderView.setCoupon(orderRs.getString("coupon_code"));
                orderView.setClient(orderRs.getString("client_name"));
                orderView.setSubtotal(orderRs.getDouble("subtotal"));
                orderView.setTotal(orderRs.getDouble("total"));

                // Busca os itens do pedido
                List<OrderItemView> itemViews = new ArrayList<>();
                try (PreparedStatement itemStmt = conn.prepareStatement(itemSql)) {
                    itemStmt.setString(1, orderId);
                    ResultSet itemRs = itemStmt.executeQuery();

                    while (itemRs.next()) {
                        OrderItemView itemView = new OrderItemView();
                        itemView.setIceCream(itemRs.getString("ice_cream_name"));
                        itemView.setQuantity(itemRs.getInt("quantity"));
                        itemView.setSubtotal(itemRs.getDouble("subtotal"));
                        itemViews.add(itemView);
                    }
                }

                orderView.setItems(itemViews);
                orders.add(orderView);
            }

        } catch (SQLException e) {
            System.out.println("ERRO [findByClientId]: " + e.getMessage());
            throw new RuntimeException("Erro ao buscar pedidos do cliente", e);
        }

        return orders;
    }

}

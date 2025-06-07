package br.edu.ifpb.ice_cream_parlor.patterns.repository;

import br.edu.ifpb.ice_cream_parlor.config.GlobalDatabaseConfig;
import br.edu.ifpb.ice_cream_parlor.model.entities.Order;
import br.edu.ifpb.ice_cream_parlor.model.entities.OrderItem;
import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.patterns.decorator.IceCream;
import br.edu.ifpb.ice_cream_parlor.patterns.strategy.Coupon;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.CouponFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {

    private final Connection connection;

    public OrderRepository() throws SQLException {
        this.connection = GlobalDatabaseConfig.getInstance().getConnectionFactory().createConnection();
    }

    // CREATE
    public void save(Order order) throws SQLException {
        String sqlOrder = "INSERT INTO orders (id, client_id, date, status, coupon_id, final_price) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sqlOrder)) {
            stmt.setString(1, order.getId());
            stmt.setString(2, order.getClient().getId());
            stmt.setDate(3, Date.valueOf(order.getDate()));
            stmt.setString(4, order.getStatus());
            stmt.setString(5, order.getCoupon() != null ? order.getCoupon().getName() : null);
            stmt.setDouble(6, order.getFinalPrice());
            stmt.executeUpdate();
        }

        // Save Order Items
        String sqlItem = "INSERT INTO order_items (order_id, ice_cream_id, quantity) VALUES (?, ?, ?)";
        for (OrderItem item : order.getItems()) {
            try (PreparedStatement stmt = connection.prepareStatement(sqlItem)) {
                stmt.setString(1, order.getId());
                stmt.setString(2, item.getIceCreamId());  // pega o id do sorvete do OrderItem, não do IceCream!
                stmt.setInt(3, item.getQuantity());
                stmt.executeUpdate();
            }
        }
    }

    // READ (por ID)
    public Order findById(String id) throws SQLException {
        String sql = "SELECT * FROM orders WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    String clientId = rs.getString("client_id");
                    Client client = new ClientRepository().findById(clientId);

                    Order order = new Order(client);
                    order.setStatus(rs.getString("status"));
                    order.setFinalPrice(rs.getDouble("final_price"));

                    String couponCode = rs.getString("coupon_id");
                    Coupon coupon = CouponFactory.createCoupon(couponCode);
                    order.setCoupon(coupon);

                    List<OrderItem> items = getOrderItems(id);
                    for (OrderItem item : items) {
                        order.addItem(item);
                    }

                    return order;
                }
                return null;
            }
        }
    }

    private List<OrderItem> getOrderItems(String orderId) throws SQLException {
        String sql = "SELECT * FROM order_items WHERE order_id = ?";
        List<OrderItem> items = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, orderId);
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    String iceCreamId = rs.getString("ice_cream_id");
                    IceCream iceCream = new IceCreamRepository().findById(iceCreamId);
                    int quantity = rs.getInt("quantity");
                    items.add(new OrderItem(iceCream, quantity));
                }
            }
        }
        return items;
    }

    // UPDATE
    public void updateStatus(String orderId, String status) throws SQLException {
        String sql = "UPDATE orders SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(2, orderId);
            stmt.executeUpdate();
        }
    }

    // DELETE
    public void delete(String orderId) throws SQLException {
        String deleteItems = "DELETE FROM order_items WHERE order_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteItems)) {
            stmt.setString(1, orderId);
            stmt.executeUpdate();
        }

        String deleteOrder = "DELETE FROM orders WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(deleteOrder)) {
            stmt.setString(1, orderId);
            stmt.executeUpdate();
        }
    }

    // LIST ALL
    public List<Order> findAll() throws SQLException {
        List<Order> orders = new ArrayList<>();
        String sql = "SELECT * FROM orders";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Order order = findById(rs.getString("id"));
                if (order != null) {
                    orders.add(order);
                }
            }
        }
        return orders;
    }
}

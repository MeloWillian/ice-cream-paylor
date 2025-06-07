package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLConnectionFactory implements ConnectionFactory {
    @Override
    public Connection createConnection() throws SQLException {
        // TODO
        return null;
    }
}

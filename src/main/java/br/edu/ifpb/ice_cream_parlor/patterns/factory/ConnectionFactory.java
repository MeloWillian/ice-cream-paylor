package br.edu.ifpb.ice_cream_parlor.patterns.factory;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionFactory {
    Connection createConnection() throws SQLException;
}

package br.edu.ifpb.ice_cream_parlor.patterns.factory;

public class ConnectionFactoryProvider {

    public enum DbType {
        POSTGRES, MYSQL
    }

    public static ConnectionFactory getFactory(DbType dbType) {
        return switch (dbType) {
            case POSTGRES -> new PostgresConnectionFactory();
            case MYSQL -> new MySQLConnectionFactory();
        };
    }
}

package br.edu.ifpb.ice_cream_parlor.config;

import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactoryProvider;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactoryProvider.DbType;

public class GlobalDatabaseConfig {

    private static GlobalDatabaseConfig instance;

    private final ConnectionFactory connectionFactory;

    private GlobalDatabaseConfig() {
        String dbTypeProp = AppProperties.get("db.type");
        DbType dbType;

        if ("MYSQL".equalsIgnoreCase(dbTypeProp)) {
            dbType = DbType.MYSQL;
        } else {
            dbType = DbType.POSTGRES;
        }

        this.connectionFactory = ConnectionFactoryProvider.getFactory(dbType);
    }

    public static synchronized GlobalDatabaseConfig getInstance() {
        if (instance == null) {
            instance = new GlobalDatabaseConfig();
        }
        return instance;
    }

    public ConnectionFactory getConnectionFactory() {
        return connectionFactory;
    }
}

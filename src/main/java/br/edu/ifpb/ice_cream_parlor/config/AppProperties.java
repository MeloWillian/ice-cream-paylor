package br.edu.ifpb.ice_cream_parlor.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AppProperties {

    private static final Properties properties = new Properties();

    static {
        try (InputStream input = AppProperties.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            if (input == null) {
                throw new RuntimeException("Arquivo application.properties não encontrado no classpath");
            }
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar propriedades do banco de dados", e);
        }
    }

    public static String get(String key) {
        return properties.getProperty(key);
    }
}

package br.edu.ifpb.ice_cream_parlor.model.entities;

import java.util.UUID;

public class Client {

    private String id;
    private String name;

    public Client(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("+--------------------------------------+------------------+\n");
        sb.append(String.format("| %-36s | %-16s |\n", "id", "name"));
        sb.append("+--------------------------------------+------------------+\n");
        sb.append(String.format("| %-36s | %-16s |\n", id, name));
        sb.append("+--------------------------------------+------------------+\n");
        return sb.toString();
    }

}

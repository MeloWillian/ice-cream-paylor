package br.edu.ifpb.ice_cream_parlor;

import br.edu.ifpb.ice_cream_parlor.cli.MainMenu;
import br.edu.ifpb.ice_cream_parlor.controller.MenuUI;
import br.edu.ifpb.ice_cream_parlor.model.entities.Client;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactory;
import br.edu.ifpb.ice_cream_parlor.patterns.factory.ConnectionFactoryProvider;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        MainMenu mainMenu = new MainMenu();
        MenuUI ui = new MenuUI(mainMenu);
        ui.start();

//        ClientRepository clientRepository = new ClientRepository();

//        Client client = new Client("Jéfter Lucas");

//        Client savedClient = clientRepository.save(client);
//        System.out.println("Cliente salvo com ID: " + savedClient.getId());

//        List<Client> findClients = clientRepository.findByName("Lucas");
//        System.out.println(findClients);

    }
}

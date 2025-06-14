package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.command.register_menu.ListClientsCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.command.register_menu.RegisterClientCommand;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.Scanner;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class RegisterMenu implements Menu {
    @Override
    public void show() {
        System.out.println("\n" + CYAN + "=== 👤 Registro de Cliente ===" + RESET);
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Listar clientes");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        switch (input) {
            case "1":
                RegisterClientCommand registerClientCommand = new RegisterClientCommand();
                registerClientCommand.execute();
                break;
            case "2":
                ListClientsCommand listClientsCommand = new ListClientsCommand();
                listClientsCommand.execute();
                break;
            case "0":
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
        }
    }
}

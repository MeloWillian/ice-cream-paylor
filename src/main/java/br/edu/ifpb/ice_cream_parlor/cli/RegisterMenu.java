package br.edu.ifpb.ice_cream_parlor.cli;

import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.Scanner;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;

public class RegisterMenu implements Menu {

    private final IceCreamParlorFacade facade = new IceCreamParlorFacade();

    @Override
    public void show() {
        System.out.println("\n" + CYAN + "=== 👤 Registro de Cliente ===" + RESET);
        System.out.println("1. Cadastrar novo cliente");
        System.out.println("2. Login");
        System.out.println("3. Listar clientes");
        System.out.println("0. Voltar ao menu principal");
        System.out.print("Escolha uma opção: ");
    }

    @Override
    public void handleInput(String input) {
        Scanner scanner = new Scanner(System.in);

        switch (input) {
            case "1":
                System.out.print("Digite o nome do cliente: ");
                String name = scanner.nextLine();

                try {
                    facade.registerClient(name);
                    System.out.println(GREEN + "✅ Cliente registrado com sucesso!" + RESET);
                } catch (Exception e) {
                    System.out.println(RED + "❌ Erro ao registrar cliente: " + e.getMessage() + RESET);
                }
                break;

                case "2":
                    //facade.listClients();
                    break;
            case "0":
                System.out.println("Voltando ao menu principal...");
                break;
            default:
                System.out.println(RED + "Opção inválida. Tente novamente." + RESET);
        }
    }
}

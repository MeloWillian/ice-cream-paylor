package br.edu.ifpb.ice_cream_parlor.patterns.command.register_menu;

import br.edu.ifpb.ice_cream_parlor.patterns.command.Command;
import br.edu.ifpb.ice_cream_parlor.patterns.facade.IceCreamParlorFacade;

import java.util.Scanner;

import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.*;
import static br.edu.ifpb.ice_cream_parlor.utils.AnsiColor.RESET;

public class RegisterClientCommand implements Command {

    private final IceCreamParlorFacade facade = IceCreamParlorFacade.getInstance();
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.print("Digite o nome do cliente: ");
        String name = scanner.nextLine();

        try {
            facade.registerClient(name);
            System.out.println(GREEN + "✅ Cliente registrado com sucesso!" + RESET);
        } catch (Exception e) {
            System.out.println(RED + "❌ Erro ao registrar cliente: " + e.getMessage() + RESET);
        }
    }

    @Override
    public void undo() {

    }
}

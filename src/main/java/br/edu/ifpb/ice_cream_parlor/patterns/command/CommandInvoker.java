package br.edu.ifpb.ice_cream_parlor.patterns.command;

import java.util.Stack;

public class CommandInvoker {

    private final Stack<Command> history = new Stack<>();

    public void executeCommand(Command command) {
        command.execute();
        history.push(command);
    }

    public void undoLastCommand() {
        if (!history.isEmpty()) {
            Command last = history.pop();
            last.undo();
        } else {
            System.out.println("❌ Nenhum comando para desfazer.");
        }
    }
}

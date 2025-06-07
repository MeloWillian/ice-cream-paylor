package br.edu.ifpb.ice_cream_parlor.patterns.command;

public interface Command {
    void execute();
    void undo();
    void redo();
}

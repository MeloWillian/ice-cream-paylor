package br.edu.ifpb.ice_cream_parlor.patterns.observer;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ClientNotificationTest {

    @Test
    void shouldPrintNotificationMessage() {
        // Captura a saída do console
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(output));

        // Criação do observer e simulação de notificação
        ClientNotification client = new ClientNotification("Alice");
        client.update("ORDER-123", "Delivered");

        // Restaura saída original
        System.setOut(originalOut);

        // Verifica se a mensagem foi impressa corretamente
        String printedMessage = output.toString().trim();
        assertTrue(printedMessage.contains("Alice"));
        assertTrue(printedMessage.contains("ORDER-123"));
        assertTrue(printedMessage.contains("Delivered"));
    }
}

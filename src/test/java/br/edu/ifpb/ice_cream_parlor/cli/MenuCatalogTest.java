//package br.edu.ifpb.ice_cream_parlor.cli;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import java.io.*;
//import java.util.Scanner;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//public class MenuCatalogTest {
//
//    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//    private final PrintStream originalOut = System.out;
//    private final InputStream originalIn = System.in;
//
//    @BeforeEach
//    public void setUpStreams() {
//        System.setOut(new PrintStream(outputStream));
//    }
//
//    @AfterEach
//    public void restoreStreams() {
//        System.setOut(originalOut);
//        System.setIn(originalIn);
//    }
//
//    @Test
//    public void testShowMenuOptions() {
//        MenuCatalog menu = new MenuCatalog();
//        menu.show();
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("=== 📋 CARDÁPIO ==="));
//        assertTrue(output.contains("1. Listar sabores disponíveis"));
//        assertTrue(output.contains("2. Ver tipos de sorvete"));
//        assertTrue(output.contains("3. Ver complementos"));
//        assertTrue(output.contains("0. Voltar ao menu principal"));
//    }
//
//    @Test
//    public void testHandleInput_ListarSabores() {
//        String input = "1\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//
//        MenuCatalog menu = new MenuCatalog();
//        menu.handleInput(scanner);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Sabores disponíveis"));
//        assertTrue(output.contains("Chocolate"));
//        assertTrue(output.contains("Morango"));
//    }
//
//    @Test
//    public void testHandleInput_VerTipos() {
//        String input = "2\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//
//        MenuCatalog menu = new MenuCatalog();
//        menu.handleInput(scanner);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Tipos de sorvete disponíveis"));
//        assertTrue(output.contains("POPSICLE"));
//        assertTrue(output.contains("SCOOPED"));
//        assertTrue(output.contains("MILKSHAKE"));
//    }
//
//    @Test
//    public void testHandleInput_VerComplementos() {
//        String input = "3\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//
//        MenuCatalog menu = new MenuCatalog();
//        menu.handleInput(scanner);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Complementos disponíveis"));
//        assertTrue(output.contains("Cobertura de Chocolate"));
//        assertTrue(output.contains("Chantilly"));
//    }
//
//    @Test
//    public void testHandleInput_Voltar() {
//        String input = "0\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//
//        MenuCatalog menu = new MenuCatalog();
//        menu.handleInput(scanner);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Voltando ao menu principal"));
//    }
//
//    @Test
//    public void testHandleInput_OpcaoInvalida() {
//        String input = "99\n";
//        System.setIn(new ByteArrayInputStream(input.getBytes()));
//        Scanner scanner = new Scanner(System.in);
//
//        MenuCatalog menu = new MenuCatalog();
//        menu.handleInput(scanner);
//
//        String output = outputStream.toString();
//        assertTrue(output.contains("Opção inválida"));
//    }
//}

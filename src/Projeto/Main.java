package Projeto;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        boolean sair = false;

        sistema.cadUsuario(scanner);

        while (!sair) {

            sistema.imprimirMenu(scanner);
            String opcao = scanner.nextLine().trim();

            switch (opcao) {
                case "1":
                    sistema.criarPlaylist(scanner);
                    break;
                case "2":
                    sistema.removerPlaylist(scanner);
                    break;
                case "3":
                    sistema.adicionarMidia(scanner);
                    break;
                case "4":
                    sistema.removerMidia(scanner);
                    break;
                case "5":
                    sistema.listarPlaylist(scanner);
                    break;
                case "6":
                    sistema.listarMidiasDaPlaylist(scanner);
                    break;
                case "7":
                    sair = true;
                    break;

                default:
                    System.out.println("Opção inválida, informe uma opção dentro das fornecidas!");
                    break;
            }
        }
        System.out.println("Obrigado por usar o sistema!");
    }
}
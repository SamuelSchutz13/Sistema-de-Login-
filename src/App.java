import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("### Bem-vindo ao Sistema ###");
            System.out.println("1. Login");
            System.out.println("2. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite seu login:");
                    String login = scanner.nextLine();
                    System.out.println("Digite sua senha:");
                    String senha = scanner.nextLine();
                    sistema.login(login, senha);
                    if (sistema.getLogado()) {
                        if (sistema.getTipoUsuarioLogado().equals("administrador")) {
                            menuAdministrador(sistema, scanner);
                        } else {
                            menuUsuario(sistema, scanner);
                        }
                    }
                    break;
                case 2:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuAdministrador(Sistema sistema, Scanner scanner) {
        while (true) {
            System.out.println("### Menu do Administrador ###");
            System.out.println("1. Adicionar Dispositivo Eletrônico");
            System.out.println("2. Listar Dispositivos Eletrônicos");
            System.out.println("3. Adicionar Usuário");
            System.out.println("4. Listar Usuários");
            System.out.println("5. Logout");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do dispositivo:");
                    String nomeDispositivo = scanner.nextLine();
                    System.out.println("Digite a marca do dispositivo:");
                    String marcaDispositivo = scanner.nextLine();
                    DispositivoEletronico dispositivo = new DispositivoEletronico(nomeDispositivo, marcaDispositivo);
                    sistema.adicionarDispositivo(dispositivo);
                    break;
                case 2:
                    sistema.listarDispositivos();
                    break;
                case 3:
                    System.out.println("Digite o login do usuário:");
                    String loginUsuario = scanner.nextLine();
                    System.out.println("Digite a senha do usuário:");
                    String senhaUsuario = scanner.nextLine();
                    Usuario usuario = new Usuario(loginUsuario, senhaUsuario);
                    sistema.adicionarUsuario(usuario);
                    break;
                case 4:
                    sistema.listarUsuarios();
                    break;
                case 5:
                    sistema.logout();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static void menuUsuario(Sistema sistema, Scanner scanner) {
        while (true) {
            System.out.println("### Menu do Usuário ###");
            System.out.println("1. Adicionar Dispositivo Eletrônico");
            System.out.println("2. Visualizar Dispositivos Eletrônicos");
            System.out.println("3. Visualizar Histórico de Consumo");
            System.out.println("4. Logout");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o nome do dispositivo:");
                    String nomeDispositivo = scanner.nextLine();
                    System.out.println("Digite a marca do dispositivo:");
                    String marcaDispositivo = scanner.nextLine();
                    DispositivoEletronico dispositivo = new DispositivoEletronico(nomeDispositivo, marcaDispositivo);
                    sistema.adicionarDispositivo(dispositivo);
                    break;
                case 2:
                    sistema.listarDispositivos();
                    break;
                case 3:
                    System.out.println("Digite o índice do dispositivo para ver o histórico de consumo:");
                    int indice = scanner.nextInt();
                    scanner.nextLine();
                    DispositivoEletronico dispositivoSelecionado = sistema.getDispositivoByIndex(indice - 1); 
                    if (dispositivoSelecionado != null) {
                        sistema.visualizarHistoricoConsumo(dispositivoSelecionado);
                    } else {
                        System.out.println("Dispositivo não encontrado!");
                    }
                    break;
                case 4:
                    sistema.logout();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}

import java.util.ArrayList;
import java.util.List;

public class Sistema {
    private List<DispositivoEletronico> dispositivos;
    private List<Usuario> usuarios;
    private String tipoUsuarioLogado;
    private boolean logado;

    public Sistema() {
        this.dispositivos = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.logado = false;
    }

    public void login(String login, String senha) {
        if (login.equals("admin") && senha.equals("admin")) {
            tipoUsuarioLogado = "administrador";
            logado = true;
            System.out.println("Login efetuado como administrador.");
        } else if (validarCredenciaisUsuario(login, senha)) {
            tipoUsuarioLogado = "usuario";
            logado = true;
            System.out.println("Login efetuado como usuário.");
        } else {
            System.out.println("Credenciais inválidas!");
        }
    }

    public void logout() {
        logado = false;
        tipoUsuarioLogado = null;
        System.out.println("Logout realizado com sucesso.");
    }

    public boolean getLogado() {
        return logado;
    }

    public String getTipoUsuarioLogado() {
        return tipoUsuarioLogado;
    }

private boolean validarCredenciaisUsuario(String login, String senha) {
    for (Usuario usuario : usuarios) {
        if (usuario.getLogin().equals(login) && usuario.getSenha().equals(senha)) {
            return true; 
        }
    }
    return false; 
}
    public void adicionarDispositivo(DispositivoEletronico dispositivo) {
        dispositivos.add(dispositivo);
        System.out.println("Dispositivo adicionado com sucesso: " + dispositivo);
    }

    public void listarDispositivos() {
        if (dispositivos.isEmpty()) {
            System.out.println("Nenhum dispositivo cadastrado.");
        } else {
            System.out.println("### Dispositivos Eletrônicos ###");
            for (int i = 0; i < dispositivos.size(); i++) {
                System.out.println((i + 1) + ". " + dispositivos.get(i));
            }
        }
    }

    public DispositivoEletronico getDispositivoByIndex(int index) {
        if (index >= 0 && index < dispositivos.size()) {
            return dispositivos.get(index);
        }
        return null;
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuario adicionado com sucesso: " + usuario.getLogin());
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuario cadastrado.");
        } else {
            System.out.println("### Usuarios ###");
            for (Usuario usuario : usuarios) {
                System.out.println("Login: " + usuario.getLogin());
            }
        }
    }

    public void visualizarHistoricoConsumo(DispositivoEletronico dispositivo) {
        dispositivo.consultarConsumo();
    }

    public void registrarConsumo(int indiceDispositivo) {
        DispositivoEletronico dispositivo = getDispositivoByIndex(indiceDispositivo - 1);
        if (dispositivo != null) {
            dispositivo.registrarConsumo();
        } else {
            System.out.println("Dispositivo nao encontrado");
        }
    }
}

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DispositivoEletronico {
    private String nome;
    private String marca;
    private List<RegistroConsumo> historicoConsumo;
    private int contadorConsultas;

    public DispositivoEletronico(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
        this.historicoConsumo = new ArrayList<>();
        this.contadorConsultas = 0;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public List<RegistroConsumo> getHistoricoConsumo() {
        return historicoConsumo;
    }

    public void registrarConsumo() {
        Random random = new Random();
        float consumo = Math.round(random.nextFloat() * 1000 * 100) / 100f;
        LocalDateTime horaAtual = LocalDateTime.now();
        RegistroConsumo registro = new RegistroConsumo(++contadorConsultas, consumo, horaAtual);
        historicoConsumo.add(registro);
        mostrarHistoricoConsumo();
    }

    public void consultarConsumo() {
        Random random = new Random();
        float consumo = Math.round(random.nextFloat() * 1000 * 100) / 100f;
        LocalDateTime horaAtual = LocalDateTime.now();
        RegistroConsumo registro = new RegistroConsumo(++contadorConsultas, consumo, horaAtual);
        historicoConsumo.add(registro);
        mostrarHistoricoConsumo();
    }

    public void mostrarHistoricoConsumo() {
        System.out.println("Histórico de consumo para o dispositivo " + nome + ":");
        for (RegistroConsumo registro : historicoConsumo) {
            System.out.println(registro);
        }
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Marca: " + marca;
    }

    public class RegistroConsumo {
        private int numeroConsulta;
        private float consumo;
        private LocalDateTime horario;

        public RegistroConsumo(int numeroConsulta, float consumo, LocalDateTime horario) {
            this.numeroConsulta = numeroConsulta;
            this.consumo = consumo;
            this.horario = horario;
        }

        public int getNumeroConsulta() {
            return numeroConsulta;
        }

        public float getConsumo() {
            return consumo;
        }

        public LocalDateTime getHorario() {
            return horario;
        }

        @Override
        public String toString() {
            return "Consulta " + numeroConsulta + ": Consumo: " + consumo + " kWh, Horario: " + horario.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        }
    }
}

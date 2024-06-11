import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DispositivoEletronico {
    private String nome;
    private String marca;
    private List<RegistroConsumo> historicoConsumo;

    public DispositivoEletronico(String nome, String marca) {
        this.nome = nome;
        this.marca = marca;
        this.historicoConsumo = new ArrayList<>();
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
        RegistroConsumo registro = new RegistroConsumo(consumo, horaAtual);
        historicoConsumo.add(registro);
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Marca: " + marca;
    }

    public void consultarConsumo() {
        Random random = new Random();
        float consumo = Math.round(random.nextFloat() * 1000 * 100) / 100f;
        LocalDateTime horaAtual = LocalDateTime.now();
        RegistroConsumo registro = new RegistroConsumo(consumo, horaAtual);
        historicoConsumo.add(registro);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String horaFormatada = horaAtual.format(formatter);
        
        System.out.println("Consumo: " + consumo + " kWh, Horario: " + horaFormatada);
    }

    public class RegistroConsumo {
        private float consumo;
        private LocalDateTime horario;

        public RegistroConsumo(float consumo, LocalDateTime horario) {
            this.consumo = consumo;
            this.horario = horario;
        }

        public float getConsumo() {
            return consumo;
        }

        public LocalDateTime getHorario() {
            return horario;
        }

        @Override
        public String toString() {
            return "Consumo: " + consumo + " kWh, Horario: " + horario;
        }
    }
}

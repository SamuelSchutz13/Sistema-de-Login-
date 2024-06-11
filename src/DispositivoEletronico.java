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
        System.out.println("Consumo registrado com sucesso para o dispositivo " + nome + ": " + consumo + " kWh");
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Marca: " + marca;
    }

    public void consultarConsumo() {
        if (!historicoConsumo.isEmpty()) {
            Random random = new Random();
            RegistroConsumo registro = historicoConsumo.get(random.nextInt(historicoConsumo.size()));
            
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
            String horaFormatada = registro.getHorario().format(formatter);
            
            float consumo = Math.round(registro.getConsumo() * 100) / 100f;
            
            System.out.printf("Consulta de consumo para o dispositivo %s: Número aleatório: %.2f, Horário da consulta: %s%n", 
                            nome, consumo, horaFormatada);
        }
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
            return "Consumo: " + consumo + " kWh, Horário: " + horario;
        }
    }
}

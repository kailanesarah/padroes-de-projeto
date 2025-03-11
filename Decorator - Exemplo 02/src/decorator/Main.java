// Classe base concreta para Consulta
class Consulta {
    private final String paciente;
    private final String medico;

    public Consulta(String paciente, String medico) {
        this.paciente = paciente;
        this.medico = medico;
    }

    public void agendar() {
        System.out.println("Consulta agendada para o paciente: " + paciente + " com o médico: " + medico);
    }

    public void cancelar() {
        System.out.println("Consulta cancelada para o paciente: " + paciente);
    }
}

// Classe base para os Decorators
class ConsultaDecorator extends Consulta {
    protected final Consulta consultaDecorada;

    public ConsultaDecorator(Consulta consulta) {
        super("decorador", "decorador"); // Valores fictícios para evitar erros de compilação
        this.consultaDecorada = consulta;
    }

    @Override
    public void agendar() {
        consultaDecorada.agendar();
    }

    @Override
    public void cancelar() {
        consultaDecorada.cancelar();
    }
}

// Decorator para adicionar um lembrete à consulta
class ConsultaComLembrete extends ConsultaDecorator {
    public ConsultaComLembrete(Consulta consulta) {
        super(consulta);
    }

    @Override
    public void agendar() {
        super.agendar();
        enviarLembrete();
    }

    private void enviarLembrete() {
        System.out.println("Lembrete enviado ao paciente sobre a consulta.");
    }
}

// Decorator para consulta prioritária
class ConsultaPrioritaria extends ConsultaDecorator {
    public ConsultaPrioritaria(Consulta consulta) {
        super(consulta);
    }

    @Override
    public void agendar() {
        super.agendar();
        marcarComoPrioritaria();
    }

    private void marcarComoPrioritaria() {
        System.out.println("Consulta marcada como PRIORITÁRIA!");
    }
}

// Testando o padrão Decorator
public class Main {
    public static void main(String[] args) {
        // Criando uma consulta normal
        Consulta consulta = new Consulta("João", "Dr. Carlos");

        // Adicionando funcionalidade de lembrete
        consulta = new ConsultaComLembrete(consulta);

        // Adicionando funcionalidade de prioridade
        consulta = new ConsultaPrioritaria(consulta);

        // Agendando a consulta com os decorators aplicados
        consulta.agendar();

        // Cancelando a consulta
        consulta.cancelar();
    }
}

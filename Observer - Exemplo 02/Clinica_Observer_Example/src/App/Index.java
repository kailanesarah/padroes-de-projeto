package App;

import java.time.LocalDateTime;
import java.util.ArrayList;

interface Subscriber {
    public abstract String update();
}

//Observer
class Consulta implements Subscriber {
	String Paciente;
	String Medico;
	String Descricao;
	LocalDateTime DataHora = LocalDateTime.now();
	String Atendente;
	Boolean Realizada = false;

	public Consulta(String paciente, String medico, String descricao, String atendente) {
		super();
		Paciente = paciente;
		Medico = medico;
		Descricao = descricao;
		Atendente = atendente;
	}

	@Override
	public String update() {
		return Paciente + " - " + Medico + " - " + Descricao + " - " + DataHora + " - " + Atendente + " - " + Realizada;
	}
}

//Subject
class Agenda {
    protected ArrayList<Consulta> Lista;
    protected Consulta c;
 
    public Agenda() {
        Lista = new ArrayList<Consulta>();
    }
    
    public void exibirInformacoes() {
    	System.out.println("Lista de Consultas");
        for (Consulta c : Lista) {
			System.out.println(c.update());
		}
    	System.out.println("");
    }
 
    public void marcarConsulta(Consulta c) {
        Lista.add(c);
        exibirInformacoes();
    }
 
    public void cancelarConsulta(String paciente) {
    	Lista.removeIf(c -> c.Paciente.equals(paciente) && c.Realizada == false);
    	exibirInformacoes();
    }
}

class Recepcionista extends Agenda{
	String nome;
	
	public Recepcionista(String nome) {
		super();
		this.nome = nome;
	}
}

public class Index {
	public static void main(String[] args) {
		Recepcionista r = new Recepcionista("Clara");
		ArrayList<Consulta> Consultas = new ArrayList<Consulta>();
		
		Consultas.add(new Consulta("p1", "m1", "1", r.nome));
		Consultas.add(new Consulta("p2", "m2", "2", r.nome));
		Consultas.add(new Consulta("p3", "m3", "3", r.nome));
		Consultas.add(new Consulta("p4", "m4", "4", r.nome));
		Consultas.add(new Consulta("p5", "m5", "5", r.nome));
		
		for (Consulta c : Consultas) {
			r.marcarConsulta(c);
		}
		
		r.cancelarConsulta("p3");
		
		Consultas.clear();
		r.Lista.clear();
	}
}

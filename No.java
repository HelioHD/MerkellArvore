package arvoreDeMerkell;

public class No {
	// Propriedades da classe
	
	private String remetente = "";
	private String destinatario = "";
	private double valor = 0;
	
	// Metodos construtores da arvore
	public No() {
		super();
	}
	public No(String remetente, String destinatario, double valor) {
		super();
		this.remetente = remetente;
		this.destinatario = destinatario;
		this.valor = valor;
	}
	
	// Get e Set
	public String getRemetente() {
		return remetente;
	}
	public void setRemetente(String remetente) {
		this.remetente = remetente;
	}
	public String getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
}

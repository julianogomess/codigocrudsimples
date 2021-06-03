package ps2.p1.dao;

public class Time {
	private long id;
	private String nome;
	private String mascote;
	private String treinador;
	private long qtd;
	
	public Time() {
		this.id = 0;
		this.nome = "";
		this.mascote = "";
		this.treinador = "";
		this.qtd = 0;
	}
	public Time(long id, String n, String m, String t, long q) {
		this.id = id;
		this.nome = n;
		this.mascote = m;
		this.treinador = t;
		this.qtd = q;
	}
	public long getId() {return id;}
	public void setId(long id) {this.id = id;}
	public String getNome() {return nome;}
	public void setNome(String n) { this.nome = n;}
	public String getMascote() {return mascote;}
	public void setMascote(String n) { this.mascote = n;}
	public String getTreinador() {return treinador;}
	public void setTreinador(String n) { this.treinador = n;}
	public long getQtd() {return qtd;}
	public void setQtd(long q) {this.qtd = q;}
	
	
	
}

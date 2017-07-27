package model;

public class CampoBean {
	private String nome;
	private int fasciaOraria;
	private String luogo;
	private String tipo;
	private float prezzo;
	
	public CampoBean(){
		this.nome= null;
		this.fasciaOraria= 0;
		this.luogo= null;
		this.tipo= null;
		this.prezzo= 0;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getFasciaOraria() {
		return fasciaOraria;
	}

	public void setFasciaOraria(int fasciaOraria) {
		this.fasciaOraria = fasciaOraria;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "CampoBean [nome=" + nome + ", fasciaOraria=" + fasciaOraria + ", luogo=" + luogo + ", tipo=" + tipo
				+ ", prezzo=" + prezzo + "]";
	}
	
}

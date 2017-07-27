package model;

public class UtenteBean {

	private String nome;
	private String cognome;
	private String citta;
	private String provincia;
	private int cap;
	private int telefono;
	private String email;
	private String username;
	private String password;
	private String tipo;
	
	public UtenteBean() {
		this.nome = null;
		this.cognome = null;
		this.citta = null;
		this.provincia = null;
		this.cap = 0;
		this.telefono = 0;
		this.email = null;
		this.username = null;
		this.password = null;
		this.tipo = null;
	}

	@Override
	public String toString() {
		return "UtenteBean [nome=" + nome + ", cognome=" + cognome + ", citta=" + citta + ", provincia=" + provincia
				+ ", cap=" + cap + ", telefono=" + telefono + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", tipo=" + tipo + "]";
	}

	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getcitta() {
		return citta;
	}

	public void setcitta(String citta) {
		this.citta = citta;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public int getCap() {
		return cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

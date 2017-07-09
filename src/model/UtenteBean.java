package model;

public class UtenteBean {

	private String nome;
	private String cognome;
	private String città;
	private String provincia;
	private int cap;
	private int telefono;
	private String email;
	private String username;
	private String password;
	private String confpassword;
	private String possiediCampiSportivi;
	
	public UtenteBean() {
		this.nome = null;
		this.cognome = null;
		this.città = null;
		this.provincia = null;
		this.cap = 0;
		this.telefono = 0;
		this.email = null;
		this.username = null;
		this.password = null;
		this.confpassword = null;
		this.possiediCampiSportivi = null;
	}

	@Override
	public String toString() {
		return "Utente [nome=" + nome + ", cognome=" + cognome + ", città=" + città + ", provincia=" + provincia
				+ ", cap=" + cap + ", telefono=" + telefono + ", email=" + email + ", username=" + username
				+ ", password=" + password + ", confpassword=" + confpassword + ", possiediCampiSportivi="
				+ possiediCampiSportivi + "]";
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

	public String getCittà() {
		return città;
	}

	public void setCittà(String città) {
		this.città = città;
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

	public String getConfpassword() {
		return confpassword;
	}

	public void setConfpassword(String confpassword) {
		this.confpassword = confpassword;
	}

	public String getPossiediCampiSportivi() {
		return possiediCampiSportivi;
	}

	public void setPossiediCampiSportivi(String possiediCampiSportivi) {
		this.possiediCampiSportivi = possiediCampiSportivi;
	}
}

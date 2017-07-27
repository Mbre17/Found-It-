package model;

public class OffertaBean {
	private int idOfferta;
	private String usernameUtente;
	private String periodoDiValidita;
	private int percentualeSconto;
	
	public OffertaBean(){
		this.idOfferta= 0;
		this.usernameUtente= null;
		this.periodoDiValidita= null;
		this.percentualeSconto= 0;
	}

	public int getIdOfferta() {
		return idOfferta;
	}

	public void setIdOfferta(int idOfferta) {
		this.idOfferta = idOfferta;
	}

	public String getUsernameUtente() {
		return usernameUtente;
	}

	public void setUsernameUtente(String usernameUtente) {
		this.usernameUtente = usernameUtente;
	}

	public String getPeriodoDiValidita() {
		return periodoDiValidita;
	}

	public void setPeriodoDiValidita(String periodoDiValidita) {
		this.periodoDiValidita = periodoDiValidita;
	}

	public int getPercentualeSconto() {
		return percentualeSconto;
	}

	public void setPercentualeSconto(int percentualeSconto) {
		this.percentualeSconto = percentualeSconto;
	}

	@Override
	public String toString() {
		return "OffertaBean [idOfferta=" + idOfferta + ", usernameUtente=" + usernameUtente + ", periodoDiValidita="
				+ periodoDiValidita + ", percentualeSconto=" + percentualeSconto + "]";
	}
	
}

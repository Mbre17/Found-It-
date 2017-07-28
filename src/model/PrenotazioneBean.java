package model;

import java.sql.Date;
import java.sql.Time;

public class PrenotazioneBean {
	
	private Date data;
	private Time ora;
	private String idUtente;
	private String nomeCampoSportivo;
	
	public PrenotazioneBean(){
		this.idUtente= null;
		this.nomeCampoSportivo= null;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Time getOra() {
		return ora;
	}

	public void setOra(Time ora) {
		this.ora = ora;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	public String getNomeCampoSportivo() {
		return nomeCampoSportivo;
	}

	public void setNomeCampoSportivo(String nomeCampoSportivo) {
		this.nomeCampoSportivo = nomeCampoSportivo;
	}

	@Override
	public String toString() {
		return "PrenotazioneBean [data=" + data + ", ora=" + ora + ", idUtente=" + idUtente + ", nomeCampoSportivo="
				+ nomeCampoSportivo + "]";
	}
	
}

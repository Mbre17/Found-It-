package model;

import java.sql.SQLException;
import java.util.Collection;

public class PrenotazioneModelDM {
public void doSave(PrenotazioneBean ) throws SQLException;
	
	public boolean doDelete(String ) throws SQLException;
	
	public UtenteBean doRetrieveByKey(String ) throws SQLException;
	
	public boolean doUpdate(PrenotazioneBean) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll(String ) throws SQLException;

}

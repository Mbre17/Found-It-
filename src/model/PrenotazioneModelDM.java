package model;

import java.sql.SQLException;
import java.util.Collection;

public class PrenotazioneModelDM implements PrenotazioneModel {

	@Override
	public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean doDelete(PrenotazioneBean prenotazioneToDelete) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<UtenteBean> doRetrieveAll(String username, String order) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}

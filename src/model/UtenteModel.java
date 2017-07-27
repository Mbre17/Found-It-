package model;

import java.sql.SQLException;
import java.util.Collection;

public interface UtenteModel 
{
	public void doSave(UtenteBean utenteToSave) throws SQLException;
	
	public boolean doDelete(String aUsurname) throws SQLException;
	
	public UtenteBean doRetrieveByKey(String aUsurname) throws SQLException;
	
	public boolean doUpdate(UtenteBean utenteToUpdate) throws SQLException;
	
	public Collection<UtenteBean> doRetrieveAll(String order) throws SQLException;
}
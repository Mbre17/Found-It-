package model;

import java.sql.SQLException;
import java.util.Collection;

public interface CampoModel {
	
	public void doSave(CampoBean campoToSave) throws SQLException;
	
	public boolean doDelete(String aNome) throws SQLException;
	
	public CampoBean doRetrieveByKey(String aNome) throws SQLException;
	
	public boolean doUpdate(CampoBean campoToUpdate) throws SQLException;
	
	public Collection<CampoBean> doRetrieveAll(String order) throws SQLException;
}

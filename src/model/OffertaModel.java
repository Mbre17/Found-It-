package model;

import java.sql.SQLException;

public interface OffertaModel {
	
public void doSave(OffertaBean offertaToSave) throws SQLException;
	
	public boolean doDelete(int idOfferta) throws SQLException;
}

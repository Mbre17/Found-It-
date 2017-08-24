package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OffertaModelDM {
	private static final String TABLE_NAME = "Offerta";

	public synchronized void doSave(OffertaBean offerta) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + OffertaModelDM.TABLE_NAME
				+ " (ID OFFERTA,USERNAME UTENTE,PERIODO DI VALIDITA,PERCENTUALE SCONTO) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, offerta.getIdOfferta());
			preparedStatement.setString(2, offerta.getUsernameUtente());
			preparedStatement.setString(3, offerta.getPeriodoDiValidita());
			preparedStatement.setInt(4, offerta.getPercentualeSconto());


			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	public synchronized boolean doDelete(int idOfferta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + OffertaModelDM.TABLE_NAME + " WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, idOfferta);

			result = preparedStatement.executeUpdate();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}
}

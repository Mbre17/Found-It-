package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Collection;
import java.util.LinkedList;

public class PrenotazioneModelDM implements PrenotazioneModel {

	private static final String TABLE_NAME = "Prenotazione";


	@Override
	public void doSave(PrenotazioneBean prenotazioneToSave) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String insertSQL = "INSERT INTO " + PrenotazioneModelDM.TABLE_NAME
				+ " (DATA, ORA, IDUTENTE, NOMECAMPOSPORTIVO) VALUES (?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setDate(1, prenotazioneToSave.getData());
			preparedStatement.setTime(2, prenotazioneToSave.getOra());
			preparedStatement.setString(3, prenotazioneToSave.getIdUtente());
			preparedStatement.setString(4, prenotazioneToSave.getNomeCampoSportivo());

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

	@Override
	public boolean doDelete(PrenotazioneBean prenotazioneToDelete) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + PrenotazioneModelDM.TABLE_NAME + " WHERE DATA = ? AND ORA = ? AND IDUTENTE = ? AND NOMECAMPOSPORTIVO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setDate(1, prenotazioneToDelete.getData());
			preparedStatement.setTime(2, prenotazioneToDelete.getOra());
			preparedStatement.setString(3, prenotazioneToDelete.getIdUtente());
			preparedStatement.setString(4, prenotazioneToDelete.getNomeCampoSportivo());

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

	@Override
	public boolean doUpdate(PrenotazioneBean prenotazioneToUpdate, Date oldData, Time oldTime) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE" + PrenotazioneModelDM.TABLE_NAME
				+ " SET DATA = ?, ORA = ?, IDUTENTE = ?, NOMECAMPOSPORTIVO = ?"
				+ " WHERE DATA = ? AND ORA = ? AND IDUTENTE = ? AND NOMECAMPOSPORTIVO = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setDate(1, prenotazioneToUpdate.getData());
			preparedStatement.setTime(2, prenotazioneToUpdate.getOra());
			preparedStatement.setString(3, prenotazioneToUpdate.getIdUtente());
			preparedStatement.setString(4, prenotazioneToUpdate.getNomeCampoSportivo());
			preparedStatement.setDate(5, oldData);
			preparedStatement.setTime(6, oldTime);
			preparedStatement.setString(7, prenotazioneToUpdate.getIdUtente());
			preparedStatement.setString(8, prenotazioneToUpdate.getNomeCampoSportivo());
			
			result = preparedStatement.executeUpdate();

			connection.commit();
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

	@Override
	public Collection<PrenotazioneBean> doRetrieveAll(String username, String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<PrenotazioneBean> prenotazioni = new LinkedList<PrenotazioneBean>();

		String selectSQL = "SELECT * FROM " + PrenotazioneModelDM.TABLE_NAME +"WHERE IDUTENTE = ?";

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, username);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PrenotazioneBean prenotazione = new PrenotazioneBean();

				prenotazione.setData(rs.getDate("DATA"));
				prenotazione.setOra(rs.getTime("ORA"));
				prenotazione.setIdUtente(rs.getString("IDUTENTE"));
				prenotazione.setNomeCampoSportivo(rs.getString("NOMECAMPOSPORTIVO"));
				
				prenotazioni.add(prenotazione);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return prenotazioni;

	}

}

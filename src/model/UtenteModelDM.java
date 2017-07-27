package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;



public class UtenteModelDM implements UtenteModel {

	private static final String TABLE_NAME = "Utente";

	@Override
	public synchronized void doSave(UtenteBean utente) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + UtenteModelDM.TABLE_NAME
				+ " (USERNAME, PASSWORD, NOME, COGNOME, CITTA, PROVINCIA, CAP, TEL, TIPO, EMAIL) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, utente.getUsername());
			preparedStatement.setString(2, utente.getPassword());
			preparedStatement.setString(3, utente.getNome());
			preparedStatement.setString(4, utente.getCognome());
			preparedStatement.setString(5, utente.getcitta());
			preparedStatement.setString(6, utente.getProvincia());
			preparedStatement.setInt(7, utente.getCap());
			preparedStatement.setInt(8, utente.getTelefono());
			preparedStatement.setString(9, utente.getTipo());
			preparedStatement.setString(10, utente.getEmail());



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
	public synchronized UtenteBean doRetrieveByKey(String aUsername) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		UtenteBean utente = new UtenteBean();

		String selectSQL = "SELECT * FROM " + UtenteModelDM.TABLE_NAME + " WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, aUsername);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) { 
				utente.setUsername(rs.getString("USERNAME"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setcitta(rs.getString("CITTA"));
				utente.setProvincia(rs.getString("PROVINCIA"));
				utente.setCap(rs.getInt("CAP"));
				utente.setTelefono(rs.getInt("TEL"));
				utente.setTipo(rs.getString("TIPO"));
				utente.setEmail(rs.getString("EMAIL"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return utente;
	}

	@Override
	public synchronized boolean doDelete(String aUsername) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + UtenteModelDM.TABLE_NAME + " WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, aUsername);

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
	public synchronized Collection<UtenteBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<UtenteBean> users = new LinkedList<UtenteBean>();

		String selectSQL = "SELECT * FROM " + UtenteModelDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				UtenteBean utente = new UtenteBean();

				utente.setUsername(rs.getString("USERNAME"));
				utente.setPassword(rs.getString("PASSWORD"));
				utente.setNome(rs.getString("NOME"));
				utente.setCognome(rs.getString("COGNOME"));
				utente.setcitta(rs.getString("CITTA"));
				utente.setProvincia(rs.getString("PROVINCIA"));
				utente.setCap(rs.getInt("CAP"));
				utente.setTelefono(rs.getInt("TEL"));
				utente.setTipo(rs.getString("TIPO"));
				utente.setEmail(rs.getString("EMAIL"));

				users.add(utente);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return users;
	}

	@Override
	public boolean doUpdate(UtenteBean utenteToUpdate) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE" + UtenteModelDM.TABLE_NAME
				+ "SET USERNAME = ?, PASSWORD = ?, NOME = ?, COGNOME = ?, CITTA = ?, PROVINCIA = ?, CAP = ?, TEL = ?, TIPO = ?, EMAIL = ?"
				+ " WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, utenteToUpdate.getUsername());
			preparedStatement.setString(2, utenteToUpdate.getPassword());
			preparedStatement.setString(3, utenteToUpdate.getNome());
			preparedStatement.setString(4, utenteToUpdate.getCognome());
			preparedStatement.setString(5, utenteToUpdate.getcitta());
			preparedStatement.setString(6, utenteToUpdate.getProvincia());
			preparedStatement.setInt(7, utenteToUpdate.getCap());
			preparedStatement.setInt(8, utenteToUpdate.getTelefono());
			preparedStatement.setString(9, utenteToUpdate.getTipo());
			preparedStatement.setString(10, utenteToUpdate.getEmail());
			preparedStatement.setString(11, utenteToUpdate.getUsername());

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

}
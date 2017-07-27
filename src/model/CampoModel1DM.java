package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.LinkedList;

public class CampoModel1DM {
	private static final String TABLE_NAME = "Campo sportivo";

	public synchronized void doSave(CampoBean campo) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + CampoModel1DM.TABLE_NAME
				+ " (NOME,FASCIAORARIA,LUOGO,TIPO,PREZZO,USERNAMEPROPRIETARIO,OFFERTAAPPLICATA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, campo.getNome());
			preparedStatement.setInt(2, campo.getFasciaOraria());
			preparedStatement.setString(3, campo.getLuogo());
			preparedStatement.setString(4, campo.getTipo());
			preparedStatement.setFloat(5, campo.getPrezzo());
			preparedStatement.setString(6, campo.getUsernameProprietario());
			preparedStatement.setInt(7, campo.getOffertaApplicata());



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

	public synchronized CampoBean doRetrieveByKey(String aNome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		CampoBean campo = new CampoBean();

		String selectSQL = "SELECT * FROM " + CampoModel1DM.TABLE_NAME+ " WHERE USERNAME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, aNome);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) { 
				campo.setNome(rs.getString("NOME"));
				campo.setFasciaOraria(rs.getInt("FASCIAORARIA"));
				campo.setLuogo(rs.getString("LUOGO"));
				campo.setTipo(rs.getString("TIPO"));
				campo.setPrezzo(rs.getFloat("PREZZO"));
				campo.setUsernameProprietario(rs.getString("USERNAMEPROPRIETARIO"));
				campo.setOffertaApplicata(rs.getInt("OFFERTAAPPLICATA"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return campo;
	}

	public synchronized boolean doDelete(String aNome) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + CampoModel1DM.TABLE_NAME + " WHERE NOME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, aNome);

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

	public synchronized Collection<CampoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		Collection<CampoBean> campi = new LinkedList<CampoBean>();

		String selectSQL = "SELECT * FROM " + CampoModel1DM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				CampoBean campo = new CampoBean();

				campo.setNome(rs.getString("NOME"));
				campo.setFasciaOraria(rs.getInt("FASCIAORARIA"));
				campo.setLuogo(rs.getString("LUOGO"));
				campo.setTipo(rs.getString("TIPO"));
				campo.setPrezzo(rs.getFloat("PREZZO"));
				campo.setUsernameProprietario(rs.getString("USERNAMEPROPRIETARIO"));
				campo.setOffertaApplicata(rs.getInt("OFFERTAAPPLICATA"));

				campi.add(campo);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return campi;
	}

	public boolean doUpdate(CampoBean campo) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		int result = 0;
		
		String updateSQL = "UPDATE" + CampoModel1DM.TABLE_NAME
				+ "SET NOME = ?, FASCIAORARIA = ?, LUOGO = ?, TIPO = ?, PREZZO = ?, USERNAMEPROPRIETARIO= ?, OFFERTAAPPLICATA= ?"
				+ " WHERE NOME = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, campo.getNome());
			preparedStatement.setInt(2, campo.getFasciaOraria());
			preparedStatement.setString(3, campo.getLuogo());
			preparedStatement.setString(4, campo.getTipo());
			preparedStatement.setFloat(5, campo.getPrezzo());
			preparedStatement.setString(6, campo.getUsernameProprietario());
			preparedStatement.setInt(7, campo.getOffertaApplicata());

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

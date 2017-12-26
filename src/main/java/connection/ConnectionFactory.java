package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection connectionFactory;// object maintain a reference
												// to a connection created
	private final String DRIVER = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://localhost:3306/BANCO";
	private final String USER = "root";
	private final String PASS = "admin";

	public ConnectionFactory() throws ClassNotFoundException, SQLException {
		if (connectionFactory != null && !connectionFactory.isClosed())
			return;
		else {
			Class.forName(DRIVER);// Encountering from the
									// class name.(Reflections)
			connectionFactory = DriverManager.getConnection(URL, USER, PASS);
		}
	}

	public Connection getConnection() {
		return connectionFactory;
	}

	public void closeConnection() throws SQLException {
		if (connectionFactory == null || connectionFactory.isClosed())
			return;
		connectionFactory.close();

	}

	public void committeTransaction() throws SQLException {
		if (connectionFactory == null || connectionFactory.isClosed())
			return;
		connectionFactory.commit();
	}

	public void cancelTransaction() throws SQLException {
		if (connectionFactory == null || connectionFactory.isClosed())
			return;
		connectionFactory.rollback();

	}

}

package application.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCUtil {
	private static final String DBDRIVER = "com.mysql.jdbc.Driver";
	private static final String DBURL = "jdbc:mysql://localhost:3306/order_system?useSSL=true";
	private static final String USER = "root";
	private static final String PASSWORD = "admin2019";

	private Connection conn = null;
	private PreparedStatement ps = null;

	public void initDBC() throws ClassNotFoundException, SQLException {
		Class.forName(DBDRIVER);
		this.conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
	}
	public void beginTran() throws SQLException{
		this.conn.setAutoCommit(false);
	}
	public void stopTran() throws SQLException{
		this.conn.setAutoCommit(true);
	}

	public void rollBack() throws SQLException {
		this.conn.rollback();
	}

	public void commit() throws SQLException {
		this.conn.commit();
	}

	public void close() throws SQLException {
		if (this.ps != null) {
			this.ps.close();
		}
		if (this.conn != null) {
			this.conn.close();
		}
	}

	private void setPrepareStatementParams(String sql, Object... params) throws SQLException {
		this.ps = this.conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				this.ps.setObject(i + 1, params[i]);
			}
		}
	}

	public ResultSet executeQuery(String sql, Object... params) throws SQLException {
		ResultSet rs = null;
		this.setPrepareStatementParams(sql, params); 
		rs = this.ps.executeQuery(); 
                System.out.println(rs);
		return rs;
	}

	public int executeUpdate(String sql, Object... params) throws SQLException {
		this.setPrepareStatementParams(sql, params); 
		return this.ps.executeUpdate(); 
	}
}

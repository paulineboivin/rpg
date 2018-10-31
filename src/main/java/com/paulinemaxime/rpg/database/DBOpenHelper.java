package com.paulinemaxime.rpg.database;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;



public class DBOpenHelper {

		
	    private DBOpenHelper()
	    {
	    	MysqlDataSource dataSource = new MysqlDataSource();
	    	dataSource.setUser("root");
			dataSource.setPassword("");
			dataSource.setServerName("127.0.0.1");
			dataSource.setDatabaseName("databaserpg");
			try {
				dataSource.setServerTimezone("UTC");
				conn = dataSource.getConnection();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	     
	    /** Instance unique non préinitialisée */
	    private static DBOpenHelper INSTANCE = null;
	     
	    /** Point d'accès pour l'instance unique du singleton */
	    public static synchronized DBOpenHelper getInstance()
	    {           
	        if (INSTANCE == null)
	        {   INSTANCE = new DBOpenHelper(); 
	        }
	        return INSTANCE;
	    }

		private Connection conn;

		public Connection getConn() {
			return conn;
		}
}


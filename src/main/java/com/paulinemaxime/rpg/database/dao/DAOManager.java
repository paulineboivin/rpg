package com.paulinemaxime.rpg.database.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.paulinemaxime.rpg.database.DBItem;
import com.paulinemaxime.rpg.database.DBOpenHelper;
import com.paulinemaxime.rpg.database.contract.Contract;
import com.paulinemaxime.rpg.database.dto.DTO;


public class DAOManager<T extends DBItem> {
	
	public ArrayList<T> selectAll(Contract contract, DTO<T> dto) {
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append("(");
		request.append(contract.getSelectFields());
		request.append(")");
		request.append(" FROM ");
		request.append(contract.getTable());
		
		Statement stmt = null;
		
		parser(dto, result, request, stmt);
		
		
		return result;
	}
	
	public ArrayList<T> select(Contract contract, DTO<T> dto, String desc, String value) {
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append("(");
		request.append(contract.getSelectFields());
		request.append(")");
		request.append(" FROM ");
		request.append(contract.getTable());
		request.append(" WHERE ");
		request.append(desc);
		request.append(" = ");
		request.append(value);
		
		Statement stmt = null;
		
		parser(dto, result, request, stmt);
		
		return result;
	}

	private void parser(DTO<T> dto, ArrayList<T> result, StringBuilder request, Statement stmt) {
		ResultSet rs;
		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			rs = stmt.executeQuery(request.toString());
			while (rs.next()) {
				result.add(dto.mySQLToJava(rs));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// the mysql insert statement https://alvinalexander.com/java/java-mysql-insert-example-preparedstatement
    String query = " insert into databaserpg(first_name, last_name, date_created, is_admin, num_points)"
      + " values (?, ?, ?, ?, ?)";
	
}




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

	public DAOManager() {

	}

	public ArrayList<T> selectAll(Contract contract, DTO<T> dto) {
		ArrayList<T> result = new ArrayList<T>();
		
		StringBuilder request = new StringBuilder();
		request.append("SELECT ");
		request.append(contract.getSelectFields());
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
		request.append(contract.getSelectFields());
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

	public void insert(Contract contract, DTO<T> dto, String item){

		StringBuilder request = new StringBuilder();
		request.append("INSERT INTO ");
		request.append(contract.getTable());
		request.append(" (");
		request.append(contract.getInsertFields());
		request.append(") values (");
		request.append(item);
		request.append(")");

		Statement stmt = null;

		try {
		    stmt = DBOpenHelper.getInstance().getConn().createStatement();
            stmt.executeUpdate(request.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
		    try {
		        if (stmt != null)
		        stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public void createTable(Contract contract) {
		Statement stmt = null;

		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			stmt.executeUpdate(contract.getCreateTable());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void dropTable(Contract contract) {
		Statement stmt = null;

		try {
			stmt = DBOpenHelper.getInstance().getConn().createStatement();
			stmt.executeUpdate("DROP TABLE IF EXISTS " + contract.getTable());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
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

}




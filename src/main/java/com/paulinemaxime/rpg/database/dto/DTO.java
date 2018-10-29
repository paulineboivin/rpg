package com.paulinemaxime.rpg.database.dto;

import java.sql.ResultSet;

public interface DTO <T extends DBItem> {

	String javaToMySQL(T item);
	T mySQLToJava(ResultSet rs) throws SQLException;
}
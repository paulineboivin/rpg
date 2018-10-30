package com.paulinemaxime.rpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paulinemaxime.rpg.database.DBItem;

public interface DTO <T extends DBItem> {

	String javaToMySQL(T item);
	T mySQLToJava(ResultSet rs) throws SQLException;
}
package com.paulinemaxime.rpg.database.contract;

public interface Contract {

	String getTable();
	String[] getFields();
	String getCreateTable();
	String getSelectFields();
	String getInsertFields();
}

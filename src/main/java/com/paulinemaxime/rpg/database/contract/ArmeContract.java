package com.paulinemaxime.rpg.database.contract;

public class ArmeContract implements Contract {

	public static final String TABLE = "arme";
	public static final String[] FIELDS = { "name", "pArmure" };
	public static final String CREATE_TABLE = "CREATE TABLE " + TABLE + "(" + FIELDS[0] + " INT " + " NOT NULL "
			+ " PRIMARY KEY AUTO_INCREMENT " + "," + FIELDS[1] + " VARCHAR(255) " + ")";
	public static final String SELECT_FIELDS = 
			FIELDS[0] + "," + FIELDS[1];
	
	@Override
	public String getTable() {
		return TABLE;
	}

	@Override
	public String[] getFields() {
		return FIELDS;
	}

	@Override
	public String getCreateTable() {
		return CREATE_TABLE;
	}

	@Override
	public String getSelectFields() {
		return SELECT_FIELDS;
	}
}

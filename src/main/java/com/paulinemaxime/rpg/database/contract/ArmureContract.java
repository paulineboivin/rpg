package com.paulinemaxime.rpg.database.contract;

public class ArmureContract implements Contract {

	public static final String TABLE = "armure";
	public static final String[] FIELDS = { "id", "name", "pArmure", "type"};
	public static final String CREATE_TABLE =
			"CREATE TABLE " + TABLE + "(" + 
			FIELDS[0] + " INT " + " NOT NULL " + " PRIMARY KEY AUTO_INCREMENT " + "," + 
			FIELDS[1] + " VARCHAR(255) " + " NOT NULL " +
			FIELDS[2] + " INT " + " NOT NULL " +
			FIELDS[3] + " VARCHAR(255) " + " NOT NULL " +
			")";
	
	public static final String SELECT_FIELDS = 
			FIELDS[0] + "," + FIELDS[1] + "," + FIELDS[2] + "," + FIELDS[3];
	
	public static final String INSERT_FIELDS = FIELDS[1] + "," + FIELDS[2] + "," + FIELDS[3];
	

	public String getTable() {
		return TABLE;
	}


	public String[] getFields() {
		return FIELDS;
	}


	public String getCreateTable() {
		return CREATE_TABLE;
	}


	public String getSelectFields() {
		return SELECT_FIELDS;
	}
	
	public String getInsertFields() {
		return INSERT_FIELDS;
	}
}

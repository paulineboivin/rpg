package com.paulinemaxime.rpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paulinemaxime.rpg.database.contract.ArmureContract;
import com.paulinemaxime.rpg.entities.items.Armure;
import com.paulinemaxime.rpg.entities.items.armure.Armuremagique;
import com.paulinemaxime.rpg.entities.items.armure.Armuremixte;
import com.paulinemaxime.rpg.entities.items.armure.Armurephysique;


public class ArmureDTO implements DTO<Armure> {

	@Override
	public String javaToMySQL(Armure item) {

		StringBuilder sqlObject = new StringBuilder();
		sqlObject.append(item.getName());
		sqlObject.append(String.valueOf(item.getpArmure()));
		sqlObject.append(item.getType());

		return sqlObject.toString();
	}

	@Override
	public Armure mySQLToJava(ResultSet rs) throws SQLException {

		String name = rs.getString(rs.findColumn(ArmureContract.FIELDS[1]));
		int pArmure = rs.getInt(rs.findColumn(ArmureContract.FIELDS[2]));
		String type = rs.getString(rs.findColumn(ArmureContract.FIELDS[3]));

		Armure armure = null;

		switch (type) {
			case "magique":
				armure = new Armuremagique(name, pArmure);
				break;
			case "physique":
				armure = new Armurephysique(name, pArmure);
				break;
			case "mixte":
				armure = new Armuremixte(name, pArmure);
				break;
		}

		return armure;
	}

}
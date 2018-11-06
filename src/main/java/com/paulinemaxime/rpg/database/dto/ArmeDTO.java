package com.paulinemaxime.rpg.database.dto;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.paulinemaxime.rpg.database.contract.ArmeContract;
import com.paulinemaxime.rpg.entities.items.Armes;
import com.paulinemaxime.rpg.entities.items.arme.Armedefault;
import com.paulinemaxime.rpg.entities.items.arme.Armemagique;
import com.paulinemaxime.rpg.entities.items.arme.Armemixte;
import com.paulinemaxime.rpg.entities.items.arme.Armephysique;

public class ArmeDTO implements DTO<Armes> {

	@Override
	public String javaToMySQL(Armes item) {

		StringBuilder sqlObject = new StringBuilder();
		sqlObject.append("'");
		sqlObject.append(item.getName());
		sqlObject.append("'");
		sqlObject.append(String.valueOf(item.getDegat()));
		sqlObject.append(String.valueOf(item.getPa()));
		sqlObject.append("'");
		sqlObject.append(item.getType());
		sqlObject.append("'");

		return sqlObject.toString();
	}

	@Override
	public Armes mySQLToJava(ResultSet rs) throws SQLException {

		String name = rs.getString(rs.findColumn(ArmeContract.FIELDS[1]));
		int degat = rs.getInt(rs.findColumn(ArmeContract.FIELDS[2]));
		int pa = rs.getInt(rs.findColumn(ArmeContract.FIELDS[3]));
		String type = rs.getString(rs.findColumn(ArmeContract.FIELDS[4]));

		Armes arme = null;

		switch (type) {
			case "magique":
				arme = new Armemagique(name, degat, pa);
				break;
			case "physique":
				arme = new Armephysique(name, degat, pa);
				break;
			case "mixte":
				arme = new Armemixte(name, degat, pa);
				break;
			case "aucun":
				arme = new Armedefault(name, degat, pa);
				break;
		}

		return arme;
	}
}
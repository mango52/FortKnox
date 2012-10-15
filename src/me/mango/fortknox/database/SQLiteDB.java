package me.mango.fortknox.database;

import java.sql.ResultSet;

import lib.PatPeter.SQLibrary.SQLite;

import org.bukkit.Bukkit;

public class SQLiteDB implements Database {
	private SQLite db;

	public void load() throws Exception {
		db = new SQLite(Bukkit.getLogger(), "[FortKnox] ", "FortKnox", "plugins/FortKnox/");
		db.open();
		if (!db.checkConnection()) {
			Bukkit.getLogger().info("Database creation failed!");
			throw new Exception("Database creation failed.");
		}
		Bukkit.getLogger().info("SQLite database loaded");
		checkTables();
	}

	private void checkTables() {
		if (!this.db.checkTable("stock")) {
			String query = "create table data('player' varchar(16) not null,'quantity' integer not null)";
			db.createTable(query);
			Bukkit.getLogger().info("Created data table");
		}
	}

	public ResultSet query(String query) {
		return db.query(query);
	}

	public void unload() {
		db.close();
	}

}
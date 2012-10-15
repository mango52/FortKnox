package me.mango.fortknox.database;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.bukkit.Bukkit;

public class DatabaseManager {

	private static SQLiteDB database;

	public static void initialize() {
		database = new SQLiteDB();
		try {
			database.load();
		} catch (Exception e) {
			Bukkit.getLogger().info("Error loading database!");
		}
	}

	public static void close() {
		database.unload();
	}

	public static void openAccount(String player, int quantity) {
		String query = "insert into data(player,quantity) values('" + player + "'," + quantity + ")";
		database.query(query);
	}

	public static int getBalance(String player) {
		String query = "select quantity from data where player = '" + player + "'";
		return parseQueryToInt(database.query(query));
	}

	public static void updateQuantity(String player, int quantity) {
		String query = "update data set quantity = " + quantity + " where player = '" + player + "'";
		database.query(query);
	}

	public static void deleteAccount(String player) {
		String query = "delete from data where player = '" + player + "'";
		database.query(query);
	}

	//TODO log changes

	public static int parseQueryToInt(ResultSet query) {
		int result = 0;
		try {
			result =  query.getInt("quantity");
			query.close();
		} catch (SQLException e) {
		}
		return result;
	}
}
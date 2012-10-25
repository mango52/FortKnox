package me.mango.managers;

import me.mango.fortknox.FortKnox;

import org.bukkit.configuration.file.FileConfiguration;

public class ConfigManager {

	static FileConfiguration config;


	public static void initialize(FortKnox plugin) {
		repairConfig(plugin);
		config = plugin.getConfig();
	}

	private static void repairConfig(FortKnox plugin) {
		FileConfiguration config = plugin.getConfig();
		if (!config.contains("usePermissions")) {
			config.set("usePermissions", true);
		}
		if (!config.contains("OPsOverridePermissions")) {
			config.set("OPsOverridePermissions", false);
		}
		if (!config.contains("useMySQL")) {
			config.set("useMySQL", false);
		}
		if (!config.contains("MySQL.host")) {
			config.set("MySQL.host", "localhost");
		}
		if (!config.contains("MySQL.port")) {
			config.set("MySQL.port", 3306);
		}
		if (!config.contains("MySQL.username")) {
			config.set("MySQL.username", "root");
		}
		if (!config.contains("MySQL.password")) {
			config.set("MySQL.password", "password");
		}
		if (!config.contains("MySQL.database")) {
			config.set("MySQL.database", "minecraft");
		}
		plugin.saveConfig();
	}

	public static boolean usePermissions() {
		return config.getBoolean("usePermissions", true);
	}
	
	public static boolean OPOverride() {
		return config.getBoolean("OPsOverridePermissions", false);
	}

	public static boolean useMySQL() {
		return config.getBoolean("useMySQL", false);
	}

	public static String MySQLHost() {
		return config.getString("MySQL.host", "localhost");
	}

	public static int MySQLPort() {
		return config.getInt("MySQL.port", 3306);
	}

	public static String MySQLUsername() {
		return config.getString("MySQL.username", "root");
	}

	public static String MySQLPassword() {
		return config.getString("MySQL.password", "password");
	}

	public static String MySQLDatabase() {
		return config.getString("MySQL.database", "minecraft");
	}
}

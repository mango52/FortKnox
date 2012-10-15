package me.mango.fortknox;

import me.mango.fortknox.database.DatabaseManager;

import org.bukkit.plugin.java.JavaPlugin;

public class FortKnox extends JavaPlugin {
	@Override
	public void onEnable() {
		DatabaseManager.initialize();
		getCommand("deposit").setExecutor(new FKCommandExecutor(this));
		getCommand("withdraw").setExecutor(new FKCommandExecutor(this));
		getCommand("balance").setExecutor(new FKCommandExecutor(this));
		getLogger().info(getDescription().getName() + " " + getDescription().getVersion() + " by Mango enabled.");
	}
	
	@Override
	public void onDisable() {
		DatabaseManager.close();
		getLogger().info(getDescription().getName() + " " + getDescription().getVersion() + " by Mango disabled.");
	}
}

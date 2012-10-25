package me.mango.fortknox;

import me.mango.fortknox.commands.Balance;
import me.mango.fortknox.commands.Deposit;
import me.mango.fortknox.commands.Withdraw;
import me.mango.managers.ConfigManager;
import me.mango.managers.DatabaseManager;
import me.mango.managers.VaultManager;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class FortKnox extends JavaPlugin {
	@Override
	public void onEnable() {
		DatabaseManager.initialize();
		ConfigManager.initialize(this);
		VaultManager.initialize(this);
		getLogger().info(getDescription().getVersion() + " by Mango enabled.");
	}

	@Override
	public void onDisable() {
		DatabaseManager.close();
		getLogger().info(getDescription().getVersion() + " by Mango disabled.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String commandName = cmd.getName().toLowerCase();
		if (commandName.startsWith("balance")) Balance.execute((Player) sender, args);
		else if (commandName.startsWith("gold")) Balance.execute((Player) sender, args);
		else if (!(sender instanceof Player)) {
			sender.sendMessage("You cannot execute that command from the console!");
		}
		else if (commandName.startsWith("deposit")) Deposit.execute((Player) sender, args);
		else if (commandName.startsWith("store")) Deposit.execute((Player) sender, args);
		else if (commandName.startsWith("withdraw")) Withdraw.execute((Player) sender, args);

		return true;
	}
}

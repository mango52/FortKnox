package me.mango.fortknox;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FKCommandExecutor implements CommandExecutor {
	
	@SuppressWarnings("unused")
	private FortKnox plugin;

	public FKCommandExecutor(FortKnox plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
		String commandName = cmd.getName().toLowerCase();
		if (!(sender instanceof Player)) {
			sender.sendMessage("You cannot execute that command from the console!");
		}
		if (commandName.startsWith("deposit")) {
			//TODO
			return true;
		} else if (commandName.startsWith("withdraw")) {
			//TODO
			return true;
		} else if (commandName.startsWith("balance")) {
			//TODO
			return true;
		}
		return false;
	}
}

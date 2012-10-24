package me.mango.fortknox.commands;

import me.mango.managers.DatabaseManager;
import me.mango.managers.VaultManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Balance {
	public static void execute(Player sender, String[] args) {
		if (!VaultManager.hasPermission(sender, "fortknox.balance")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
		}
		int balance = DatabaseManager.getBalance(sender.getName());
		if (balance == 0) {
			sender.sendMessage(ChatColor.GREEN + "You have no stored ingots.");
		} else if (balance == 1) {
			sender.sendMessage(ChatColor.GREEN + "Your current balance is " + balance + " ingot.");
		} else {
			sender.sendMessage(ChatColor.GREEN + "Your current balance is " + balance + " ingots.");
		}
	}
}

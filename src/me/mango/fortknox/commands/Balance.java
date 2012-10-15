package me.mango.fortknox.commands;

import me.mango.fortknox.database.DatabaseManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Balance {
	public static void execute(Player sender) {
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

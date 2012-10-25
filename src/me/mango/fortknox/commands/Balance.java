package me.mango.fortknox.commands;

import me.mango.managers.DatabaseManager;
import me.mango.managers.VaultManager;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Balance {
	public static void execute(Player sender, String[] args) {
		if ((args.length != 0) && (args.length != 1)) {
			sender.sendMessage(ChatColor.RED + "Correct usage: /balance [player]");
			return;
		}
		if (!VaultManager.hasPermission(sender, "fortknox.balance")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
		}
		if (args.length == 1) {
			if (!VaultManager.hasPermission(sender, "fortknox.balance.others")) {
				sender.sendMessage(ChatColor.RED + "You don't have permission to check the balance of other players!");
				return;
			}
			int balance = DatabaseManager.getBalance(args[0]);
			if (balance == 0) {
				sender.sendMessage(ChatColor.GREEN + args[0] + " has no stored ingots.");
			} else if (balance == 1) {
				sender.sendMessage(ChatColor.GREEN + args[0] + " has a balance of " + balance + " ingot.");
			} else {
				sender.sendMessage(ChatColor.GREEN + args[0] + " has a balance of " + balance + " ingots.");
			}
		} else if (args.length == 0) {
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
}
package me.mango.fortknox.commands;

import me.mango.managers.DatabaseManager;
import me.mango.managers.VaultManager;
import me.mango.utils.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Deposit {
	public static void execute(Player sender, String[] args) {
		if (!VaultManager.hasPermission(sender, "fortknox.deposit")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
		}
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Correct usage: /deposit <amount>");
			return;
		}

		int number = Utils.parseInteger(args[0]);
		if (number < 0) {
			sender.sendMessage(ChatColor.RED + "That is not a valid number.");
			return;
		}
		if(!sender.getInventory().contains(Material.GOLD_INGOT, number)) {
			sender.sendMessage(ChatColor.RED + "You don't have that many gold ingots!");
			return;
		}
		String player = sender.getName();
		sender.getInventory().removeItem(new ItemStack(Material.GOLD_INGOT, number));
		if(DatabaseManager.getBalance(player) == 0) {
			DatabaseManager.openAccount(player, number);
		} else {
			int newBalance = DatabaseManager.getBalance(player) + number;
			DatabaseManager.updateQuantity(player, newBalance);
		}
		sender.sendMessage(ChatColor.GREEN + "Successfully deposited " + number + " ingots.");
		sender.sendMessage(ChatColor.GREEN + "Your balance is now " + DatabaseManager.getBalance(player) + " ingots.");
	}
}

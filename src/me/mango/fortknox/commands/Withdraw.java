package me.mango.fortknox.commands;

import me.mango.managers.DatabaseManager;
import me.mango.managers.VaultManager;
import me.mango.utils.Utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Withdraw {
	public static void execute(Player sender, String[] args) {
		if (!VaultManager.hasPermission(sender, "fortknox.withdraw")) {
			sender.sendMessage(ChatColor.RED + "You don't have permission to do that!");
			return;
		}
		if(args.length != 1) {
			sender.sendMessage(ChatColor.RED + "Correct usage: /withdraw <amount>");
			return;
		}
		int number = Utils.parseInteger(args[0]);
		if (number < 0) {
			sender.sendMessage(ChatColor.RED + "That is not a valid number.");
			return;
		}
		if ((DatabaseManager.getBalance(sender.getName()) < number)) {
			sender.sendMessage(ChatColor.RED + "You don't have enough ingots stored to withdraw that many!");
			return;
		}
		if ((Utils.freeSpaceForItem(sender.getInventory().getContents(), Material.GOLD_INGOT) < number)) {
			sender.sendMessage(ChatColor.RED + "You don't have enough inventory space to withdraw that many!");
			return;
		}
		if (DatabaseManager.getBalance(sender.getName()) == number) {
			DatabaseManager.deleteAccount(sender.getName());
		} else {
			int newBalance = DatabaseManager.getBalance(sender.getName()) - number;
			DatabaseManager.updateQuantity(sender.getName(), newBalance);
		}
		sender.getInventory().addItem(new ItemStack(Material.GOLD_INGOT, number));
		sender.sendMessage(ChatColor.GREEN + "Successfully withdrew " + number + " ingots.");
		sender.sendMessage(ChatColor.GREEN + "Your balance is now " + DatabaseManager.getBalance(sender.getName()) + " ingots.");
	}
}
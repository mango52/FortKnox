package me.mango.utils;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Utils {
	public static int parseInteger(String s) {
		try {
			int i = Integer.parseInt(s);
			if (i > 0) return i;
		} catch (NumberFormatException ex) {
			return -1;
		}
		return -1;
	}

	public static int freeSpaceForItem(ItemStack[] i, Material item) {
		int freeSpace = 0;
		for (ItemStack stack : i) {
			if (stack == null) {
				freeSpace = freeSpace + 64;
			} else if (stack.getType() == item) {
				freeSpace = freeSpace + (64 - stack.getAmount());
			}
		}
		return freeSpace;
	}
}
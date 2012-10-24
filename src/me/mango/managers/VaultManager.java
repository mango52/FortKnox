package me.mango.managers;

import me.mango.fortknox.FortKnox;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VaultManager {

	public static Permission permissions;
	public static boolean permissionsLoaded = false;

	public static void initialize(FortKnox plugin) {
		if(setupPermissions(plugin)) {
			permissionsLoaded = true;
			Bukkit.getLogger().info("Successfully registered permissions through " + permissions.getName());
		} else {
			Bukkit.getLogger().info("No permissions plugin found - defaulting to OPs");
		}
	}

	private static boolean setupPermissions(FortKnox plugin) {
		RegisteredServiceProvider<Permission> rsp = plugin.getServer().getServicesManager().getRegistration(Permission.class);
		permissions = rsp.getProvider();
		return permissions != null;
	}
	
	public static boolean hasPermission(Player player, String permission) {
		if (permissionsLoaded && permissions.has(player, permission)) {
			return true;
		}
		else if (player.isOp() && ConfigManager.OPOverride()) {
			return true;
		}
		else {
			return false;
		}
	}
}

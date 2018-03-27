package me.yb.hungercore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class EventHandle implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        // Init variables
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        Bukkit.broadcastMessage("§a+ §2» §f" + p.getName() + " §7joined the server!");
        // Take them to the menu on spawn
        HUD.menu(p);
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        Bukkit.broadcastMessage("§c- §2» §f" + p.getName() + " §7left the server.");

    }
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if (e.getAction() == Action.LEFT_CLICK_AIR) {
            if (!HungerCore.inGame.contains(p)) {

            }
        }
    }
}

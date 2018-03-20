package me.yb.hungercore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.HashMap;

public class EventHandle implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(null);
        Bukkit.broadcastMessage("§a+ §2» §f" + p.getName() + " §7joined the server!");
        p.teleport(new Location(p.getWorld(), 0.0, 100.0, 0.0, -90.0f, 0.0f));
        p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 200000, 256, false, false));
    }
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(null);
        Bukkit.broadcastMessage("§c- §2» §f" + p.getName() + " §7left the server.");

    }
}

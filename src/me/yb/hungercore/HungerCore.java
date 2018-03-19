package me.yb.hungercore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class HungerCore extends JavaPlugin {
    @Override
    public void onEnable() {
        System.out.print("[HC] HungerCore class loaded");
        Bukkit.getServer().getPluginManager().registerEvents(new EventHandle(), this);
        System.out.print("[HC] HungerCore class load complete");
    }
    @Override
    public void onDisable() {

    }
}
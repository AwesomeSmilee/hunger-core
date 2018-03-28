package me.yb.hungercore;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class HungerCore extends JavaPlugin {
    public static HungerCore instance;
    public static ArrayList<Player> inGame = new ArrayList<>();
    public static HashMap<Player, String> menuSel = new HashMap<>();
    public static HashMap<Player, BossBar> bossBars = new HashMap<>();
    @Override
    public void onEnable() {
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(new EventHandle(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                Game.loop();
            }
        }, 0, 1);
        getServer().getConsoleSender().sendMessage("§2HungerCore v" + getDescription().getVersion() + " has been enabled!");
    }
    @Override
    public void onDisable() {

    }
}
package me.yb.hungercore;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class HungerCore extends JavaPlugin {
    public static HungerCore instance;
    public static ArrayList<Player> inGame = new ArrayList<>();
    public static HashMap<Player, String> menuSel = new HashMap<>();
    @Override
    public void onEnable() {
        System.out.print("[HC] HungerCore class loaded");
        instance = this;
        Bukkit.getServer().getPluginManager().registerEvents(new EventHandle(), this);
        Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                // Server loop
                for (Player p : Bukkit.getServer().getOnlinePlayers()) {
                    // Player loop
                    Float yaw = (p.getLocation().getYaw() + 180) % 360;
                    // Menu loop
                    // Displays
                    if (inGame.contains(p)) {
                        HUD.displayMenu(p, yaw);
                        HUD.displayBossBar(p, yaw);
                    } else {

                    }

                }
            }
        }, 0, 1);
        System.out.print("[HC] HungerCore class load complete");
    }
    @Override
    public void onDisable() {

    }
}

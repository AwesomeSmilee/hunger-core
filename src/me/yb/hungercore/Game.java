package me.yb.hungercore;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

public class Game {
    public static void loop() {
        // Server loop
        for (Player p : Bukkit.getServer().getOnlinePlayers()) {
            // Player loop
            Float yaw = (p.getLocation().getYaw() + 180) % 360;
            yaw = yaw < 0 ? yaw + 360 : yaw;
            // Menu loop
            // Displays
            if (HungerCore.inGame.contains(p)) {
                HUD.displayMenu(p, yaw);
                HUD.displayBossBar(p, yaw);
            } else {

            }

        }
    }
    public static void menu(Player p) {
        p.teleport(new Location(p.getWorld(), 0.0, 100.0, 0.0, 0.0f, 0.0f));
        p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, Integer.MAX_VALUE, -1, false, false), true);
        if (!HungerCore.inGame.contains(p)) {
            HungerCore.inGame.add(p);
            HungerCore.menuSel.put(p, "none");
        }
    }
    public static void game(Player p, Location loc) {
        for (Player other : Bukkit.getOnlinePlayers()) {
            other.showPlayer(HungerCore.instance, p);
        }
        p.teleport(loc);
    }
    public static void newGame(Player p) {
        Random rand = new Random();
        Location loc = new Location(p.getWorld(), rand.nextInt(30000 ) - 15000, 64, rand.nextInt(30000 ) - 15000);
        game(p, loc);
    }
    public static void settings(Player p) {
        p.openInventory(InventoryEdit.newInventory());
    }
}

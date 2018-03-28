package me.yb.hungercore;

import com.connorlinfoot.actionbarapi.ActionBarAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.List;

public class HUD {
    public static void menu(Player p) {
        p.teleport(new Location(p.getWorld(), 0.0, 100.0, 0.0, 0.0f, 0.0f));
        p.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, Integer.MAX_VALUE, -1, false, false), true);
        if (!HungerCore.inGame.contains(p)) {
            HungerCore.inGame.add(p);
            HungerCore.menuSel.put(p, "none");
        }
        for (Player other : Bukkit.getOnlinePlayers()) {
            other.hidePlayer(HungerCore.instance, p);
        }
    }
    public static void displayMenu(Player p, Float yaw) {
        // Init menu items
        ArrayList<String> menu = new ArrayList<>();
        menu.add("New Game");
        menu.add("Settings");
        String s1 = "";
        // Select items
        int sel = Math.round((yaw - 180) / 60);
        if (sel >= menu.size()) {
            sel = -1;
        }
        if (sel < 0) {
            sel = -1;
        }
        // Put selected item into display
        if (sel != -1) {
            for (int i = 0; i < menu.size(); i++) {
                if (i == sel) {
                    s1 = s1 + "§a§l ";
                } else {
                    if ((i + 1) % 2 == 0) {
                        s1 = s1 + "§3 ";
                    } else {
                        s1 = s1 + "§7 ";
                    }
                }
                s1 = s1 + menu.get(i);
            }
        } else {
            for (int i = 0; i < menu.size(); i++) {
                if ((i + 1) % 2 == 0) {
                    s1 = s1 + "§3 ";
                } else {
                    s1 = s1 + "§7 ";
                }
                s1 = s1 + menu.get(i);
            }
        }
        if (menu.get(sel) != HungerCore.menuSel.get(p)) {
            p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_FAIL, 1.0f, 1.0f);
        }
        if (sel != -1) {
            HungerCore.menuSel.replace(p, menu.get(sel));
        } else {
            HungerCore.menuSel.replace(p, "none");
        }
        // Display
        p.sendTitle("§2HUNGER²", s1, 0, 20, 10);
        ActionBarAPI.sendActionBar(p, "§7[§2Mouse§7] §3Select §8| §7[§2LClick§7] §3Confirm");
    }
    public static void displayBossBar(Player p, Float yaw) {
    }
}

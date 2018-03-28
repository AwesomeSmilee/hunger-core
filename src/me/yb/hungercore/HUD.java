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
        if (sel >= 0) {
            if (!menu.get(sel).equals(HungerCore.menuSel.get(p))) {
                p.playSound(p.getLocation(), Sound.BLOCK_DISPENSER_FAIL, 1.0f, 1.0f);
            }
            if (sel >= 0) {
                HungerCore.menuSel.replace(p, menu.get(sel));
            } else {
                HungerCore.menuSel.replace(p, "none");
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
            // Display
            // TODO : Something's broken here and I can't be bothered to fix it right now
            p.sendTitle("§2HUNGER²", s1, 0, 20, 10);
            ActionBarAPI.sendActionBar(p, "§7[§2Mouse§7] §3Select §8| §7[§2LClick§7] §3Confirm");
        }
    }
    public static void displayBossBar(Player p, Float yaw) {
        if (!HungerCore.bossBars.containsKey(p)) {
            HungerCore.bossBars.put(p, Bukkit.createBossBar("", BarColor.GREEN, BarStyle.SOLID));
        }
        BossBar bar = HungerCore.bossBars.get(p);
        bar.setTitle(compass(yaw));
        bar.addPlayer(p);
    }
    public static String compass(Float yaw) {
        String ret = "§a§l" + String.format("%3s", Integer.toString(yaw.intValue())).replace(' ', '0');
        for (int i = 1; i <= 4; i++) {
            double newIn = yaw;
            // Generate both sides of the compass
            if (i <= 2) {
                newIn = Math.ceil((newIn - ((i * 5) + 1)) / 5) * 5;
            } else {
                newIn = Math.floor((newIn + ((i - 2) * 5)) / 5) * 5;
            }
            // Overflow
            newIn = newIn < 0 ? newIn + 360 : newIn;
            newIn = newIn >= 360 ? newIn - 360 : newIn;
            // Pad the result
            String out = Integer.toString((int)newIn);
            out = String.format("%3s", out).replace(' ', '0');
            if (i <= 2) {
                ret = "§7" + out + " " + ret;
            } else {
                ret = ret + " §7" + out;
            }
        }
        return ret;
    }
}

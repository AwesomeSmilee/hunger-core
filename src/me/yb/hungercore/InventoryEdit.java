package me.yb.hungercore;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryEdit {
    public static Inventory newInventory() {
        // Create inventory
        Inventory inv = Bukkit.createInventory(null, 54, "§7« §fSettings§7 »");
        // Create white pane (placeholder)
        ItemStack whitePane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)0);
        ItemMeta meta = whitePane.getItemMeta();
        meta.setDisplayName("§a");
        whitePane.setItemMeta(meta);
        // Create black pane (placeholder)
        ItemStack blackPane = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short)15);
        meta = blackPane.getItemMeta();
        meta.setDisplayName("§a");
        blackPane.setItemMeta(meta);
        // Create inventory
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, whitePane);
            if (i == 8) {
                i += 8;
            }
        }
        for (int i = 0; i < 54; i++) {
            inv.setItem(i, blackPane);
            if (i + 1 % 9 == 1) {
                i += 8;
            }
        }
        return inv;
    }
}

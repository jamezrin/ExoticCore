package me.jaime29010.work.exoticcore.utils;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemCreator {
    private Material material;
    private int amount;
    private short damage;
    private String name;
    private List<String> lore;
    private ItemMeta meta;

    private ItemCreator(Material material) {
        this.material = material;
    }

    public static ItemStack create(Material material) {
        return new ItemCreator(material).create();
    }

    public static ItemStack create(Material material, String name) {
        return new ItemCreator(material).name(name).create();
    }

    public static ItemStack create(Material material, String name, int amount) {
        return new ItemCreator(material).name(name).amount(amount).create();
    }

    public static ItemStack create(Material material, int amount, short damage) {
        return new ItemCreator(material).amount(amount).damage(damage).create();
    }

    public static ItemStack create(Material material, String name, List<String> lore, int amount, short damage) {
        return new ItemCreator(material).name(name).lore(lore).amount(amount).damage(damage).create();
    }

    public static ItemStack create(Material material, String name, List<String> lore) {
        return new ItemCreator(material).name(name).lore(lore).create();
    }

    public static ItemStack create(Material material, String name, List<String> lore, int amount) {
        return new ItemCreator(material).name(name).lore(lore).amount(amount).create();
    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&', text);
    }

    public ItemCreator material(Material material) {
        this.material = material;
        return this;
    }

    public ItemCreator meta(ItemMeta meta) {
        this.meta = meta;
        return this;
    }

    public ItemCreator lore(List<String> lore) {
        if (lore != null) {
            for (int index = 0; index <= lore.size() - 1; index++) {
                String text = lore.get(index);
                if (text != null) {
                    text = color(text);
                }
                lore.set(index, text);
            }
        }
        this.lore = lore;
        return this;
    }

    public ItemCreator name(String name) {
        if (name != null) {
            name = color(name);
        }
        this.name = name;
        return this;
    }

    public ItemCreator damage(short damage) {
        this.damage = damage;
        return this;
    }

    public ItemCreator amount(int amount) {
        this.amount = amount;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public ItemMeta getMeta() {
        return meta;
    }

    public List<String> getLore() {
        return lore;
    }

    public String getName() {
        return name;
    }

    public short getDamage() {
        return damage;
    }

    public int getAmount() {
        return amount;
    }

    public ItemStack create() {
        ItemStack result = new ItemStack(material);
        result.setAmount(amount);
        result.setDurability(damage);
        ItemMeta meta = result.getItemMeta();
        meta.setDisplayName(name);
        meta.setLore(lore);
        result.setItemMeta(meta);
        return result;
    }
}

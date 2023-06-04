package fr.nkri.jobs.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;

/*
Author: NKRI
Github: https://github.com/NKRIDev/ItemsLib
 */

public class ItemsBuilder {

    /*
    @Allows you to create an item with a material and its amount.
     */
    public static ItemStack createItem(Material material, int amount){
        ItemStack itemStack = new ItemStack(material, amount);
        return itemStack;
    }

    /*
    @Allows you to create an item with a material, its amount and a custom name
     */
    public static ItemStack createItemWithName(Material material, int amount, String name){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /*
    @Allows you to create an item with a material, its amount as well as a custom name and description.
     */
    public static ItemStack createItemWithNameAndLore(Material material, int amount, String name, String[] lore){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(new ArrayList<>(Arrays.asList(lore)));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /*
    @Allows you to create an entire itemstack: material type, amount, description, custom name and enchantment.
     */
    public static ItemStack createCustomItem(Material material, int amount, String name, String[] lore, Enchantment enchantment, int lvlEnch){
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(new ArrayList<>(Arrays.asList(lore)));
        itemStack.addEnchantment(enchantment, lvlEnch);
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}

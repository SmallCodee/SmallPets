package it.smallcode.smallpets.v1_13.pets;
/*

Class created by SmallCode
10.07.2020 15:22

*/

import net.minecraft.server.v1_13_R2.NBTTagCompound;
import org.bukkit.craftbukkit.v1_13_R2.inventory.CraftItemStack;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;

public class Tiger extends it.smallcode.smallpets.v1_15.pets.Tiger {

    public Tiger(Player owner, Long xp) {
        super(owner, xp);
    }

    @Override
    public ItemStack getUnlockItem(Plugin plugin) {

        ItemStack item = getItem();

        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName("§6Tiger");

        ArrayList<String> lore = new ArrayList<>();

        lore.add("");
        lore.add("§6RIGHT CLICK TO UNLOCK");

        itemMeta.setLore(lore);

        item.setItemMeta(itemMeta);

        item = addNBTTag(item, "pet", getName());

        return item;

    }

    private ItemStack addNBTTag(ItemStack itemStack, String key, String value){

        net.minecraft.server.v1_13_R2.ItemStack item = CraftItemStack.asNMSCopy(itemStack);

        NBTTagCompound tag = item.getTag() != null ? item.getTag() : new NBTTagCompound();

        tag.setString(key, value);

        item.setTag(tag);

        itemStack = CraftItemStack.asCraftMirror(item);

        return itemStack;

    }

}

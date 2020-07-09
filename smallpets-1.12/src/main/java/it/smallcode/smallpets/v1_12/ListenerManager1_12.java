package it.smallcode.smallpets.v1_12;
/*

Class created by SmallCode
09.07.2020 19:42

*/

import it.smallcode.smallpets.manager.InventoryCache;
import it.smallcode.smallpets.manager.ListenerManager;
import it.smallcode.smallpets.manager.PetMapManager;
import it.smallcode.smallpets.manager.UserManager;
import it.smallcode.smallpets.v1_12.listener.InventoryClickListener;
import it.smallcode.smallpets.v1_12.listener.UnlockListener;
import it.smallcode.smallpets.v1_12.listener.BlockPlaceListener;
import it.smallcode.smallpets.v1_15.listener.*;
import it.smallcode.smallpets.v1_15.listener.abilities.EntityDamageListener;
import it.smallcode.smallpets.v1_12.listener.abilities.PlayerMoveListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class ListenerManager1_12 extends ListenerManager {

    private UserManager userManager;
    private PetMapManager petMapManager;
    private InventoryCache inventoryCache;
    private String prefix;
    private double xpMultiplier;

    public ListenerManager1_12(JavaPlugin plugin, UserManager userManager, PetMapManager petMapManager, InventoryCache inventoryCache, String prefix, double xpMultiplier) {

        super(plugin);

        this.userManager = userManager;
        this.petMapManager = petMapManager;
        this.inventoryCache = inventoryCache;
        this.prefix = prefix;
        this.xpMultiplier = xpMultiplier;

    }

    @Override
    public void registerListener() {

        //ABILITIES

        Bukkit.getPluginManager().registerEvents(new EntityDamageListener(userManager), getPlugin());
        Bukkit.getPluginManager().registerEvents(new PlayerMoveListener(userManager), getPlugin());

        //OTHERS

        Bukkit.getPluginManager().registerEvents(new PetLevelUpListener(), getPlugin());
        Bukkit.getPluginManager().registerEvents(new InventoryClickListener(userManager, prefix), getPlugin());
        Bukkit.getPluginManager().registerEvents(new UnlockListener(getPlugin(), userManager, prefix), getPlugin());
        Bukkit.getPluginManager().registerEvents(new ArmorStandInteractListener(petMapManager), getPlugin());
        Bukkit.getPluginManager().registerEvents(new BlockPlaceListener(getPlugin()), getPlugin());
        Bukkit.getPluginManager().registerEvents(new GiveExpListener(getPlugin(), userManager, xpMultiplier), getPlugin());
        Bukkit.getPluginManager().registerEvents(new WorldChangeListener(userManager), getPlugin());

    }
}

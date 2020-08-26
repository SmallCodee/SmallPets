package it.smallcode.smallpets.v1_15.listener.experience;
/*

Class created by SmallCode
25.08.2020 22:04

*/

import it.smallcode.smallpets.manager.ExperienceManager;
import it.smallcode.smallpets.manager.UserManager;
import it.smallcode.smallpets.manager.types.User;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class BlockBreakListener implements Listener {

    private JavaPlugin plugin;

    private UserManager userManager;
    private ExperienceManager experienceManager;

    private double xpMultiplier;

    public BlockBreakListener(JavaPlugin plugin, UserManager userManager, ExperienceManager experienceManager, double xpMultiplier){

        this.userManager = userManager;
        this.experienceManager = experienceManager;

        this.xpMultiplier = xpMultiplier;

    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e){

        Player p = e.getPlayer();

        User user = userManager.getUser(p.getUniqueId().toString());

        if(user != null){

            if(user.getSelected() != null){

                String type = e.getBlock().getType().toString().toLowerCase();

                if(experienceManager.getExperienceTableAll().containsKey(type)){

                    int exp = experienceManager.getExperienceTableAll().get(type);

                    if(experienceManager.getPetTypeOfType(type) != user.getSelected().getPetType()) {

                        exp /= 2;

                    }

                    user.getSelected().giveExp((int) (exp * xpMultiplier), plugin);

                }

            }

        }

    }

}
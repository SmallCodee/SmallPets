package it.smallcode.smallpets.cmds.subcmd;
/*

Class created by SmallCode
17.08.2020 13:29

*/

import it.smallcode.smallpets.SmallPets;
import it.smallcode.smallpets.cmds.SubCommand;
import org.bukkit.command.CommandSender;

public class PetTypesSubCMD extends SubCommand {

    public PetTypesSubCMD(String name, String permission) {
        super(name, permission);
    }

    @Override
    protected void handleCommand(CommandSender s, String[] args) {

        String list = "";

        for(String type : SmallPets.getInstance().getPetMapManager().getPetMap().keySet()){

            list += type + ", ";

        }

        list = list.substring(0, list.length() - 2);

        s.sendMessage(SmallPets.getInstance().PREFIX + list);

    }

    @Override
    public String getHelp() {
        return getName();
    }
}
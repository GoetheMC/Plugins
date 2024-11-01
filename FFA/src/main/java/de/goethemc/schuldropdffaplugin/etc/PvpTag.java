package de.goethemc.schuldropdffaplugin.etc;

import org.bukkit.ChatColor;

public class PvpTag {
    private String tag = ChatColor.BLUE + "[" + ChatColor.GOLD + ChatColor.BOLD + "GoetheMC" +  ChatColor.BLUE + "]";

    public String getTag(){
        return this.tag;
    }
}

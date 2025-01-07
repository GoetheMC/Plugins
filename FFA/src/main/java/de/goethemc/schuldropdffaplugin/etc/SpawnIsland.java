package de.goethemc.schuldropdffaplugin.etc;

import de.goethemc.schuldropdffaplugin.SchulFFA;

public class SpawnIsland {
    private final SchulFFA plugin;
    public SpawnIsland(SchulFFA plugin){
        this.plugin = plugin;
    }

    public boolean isSpawnIsland(double x, double y, double z){
        int smallerX = smallerValue("X");
        int greaterX = greaterValue("X");
        int smallerY = smallerValue("Y");
        int greaterY = greaterValue("Y");
        int smallerZ = smallerValue("Z");
        int greaterZ = greaterValue("Z");


        return x >= smallerX && x < greaterX &&
                y > smallerY && y < greaterY &&
                z > smallerZ && z < greaterZ;
    }



    private int greaterValue(String path) {
        int a = plugin.getConfig().getInt("spawn-area."+path+"1");
        int b = plugin.getConfig().getInt("spawn-area."+path+"2");

        if(a > b) return a;
        return b;
    }
    private int smallerValue(String path){
        int a = this.plugin.getConfig().getInt("spawn-area."+path+"1");
        int b = this.plugin.getConfig().getInt("spawn-area."+path+"2");

        if(a <= b) return a;
        return b;
    }
}
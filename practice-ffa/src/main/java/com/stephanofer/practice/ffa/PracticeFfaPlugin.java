package com.stephanofer.practice.ffa;

import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeFfaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("FFA plugin loaded and ready to manage free-for-all gameplay.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeFfa disabled.");
    }
}

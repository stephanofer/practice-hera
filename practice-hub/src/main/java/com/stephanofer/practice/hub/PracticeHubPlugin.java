package com.stephanofer.practice.hub;

import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeHubPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Hub plugin loaded and ready to start developing menus, queues and social features.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeHub disabled.");
    }
}

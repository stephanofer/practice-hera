package com.stephanofer.practice.match;

import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeMatchPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Match plugin loaded and ready to host arenas and duel lifecycles.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeMatch disabled.");
    }
}

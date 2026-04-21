package com.stephanofer.practice.hub;

import com.stephanofer.practice.api.bootstrap.PracticePlatform;
import com.stephanofer.practice.api.bootstrap.PracticePluginInfo;
import com.stephanofer.practice.core.bootstrap.StartupMessageFactory;
import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeHubPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        var pluginInfo = new PracticePluginInfo(getName(), PracticePlatform.HUB);

        getLogger().info(StartupMessageFactory.build(pluginInfo));
        getLogger().info(DataLayerInfo.describe());
        getLogger().info("Hub plugin loaded and ready to start developing menus, queues and social features.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeHub disabled.");
    }
}

package com.stephanofer.practice.ffa;

import com.stephanofer.practice.api.bootstrap.PracticePlatform;
import com.stephanofer.practice.api.bootstrap.PracticePluginInfo;
import com.stephanofer.practice.core.bootstrap.StartupMessageFactory;
import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeFfaPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        var pluginInfo = new PracticePluginInfo(getName(), PracticePlatform.FFA);

        getLogger().info(StartupMessageFactory.build(pluginInfo));
        getLogger().info(DataLayerInfo.describe());
        getLogger().info("FFA plugin loaded and ready to manage free-for-all gameplay.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeFfa disabled.");
    }
}

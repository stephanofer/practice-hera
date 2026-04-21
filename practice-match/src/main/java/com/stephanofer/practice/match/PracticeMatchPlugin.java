package com.stephanofer.practice.match;

import com.stephanofer.practice.api.bootstrap.PracticePlatform;
import com.stephanofer.practice.api.bootstrap.PracticePluginInfo;
import com.stephanofer.practice.core.bootstrap.StartupMessageFactory;
import com.stephanofer.practice.data.bootstrap.DataLayerInfo;
import org.bukkit.plugin.java.JavaPlugin;

public class PracticeMatchPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        var pluginInfo = new PracticePluginInfo(getName(), PracticePlatform.MATCH);

        getLogger().info(StartupMessageFactory.build(pluginInfo));
        getLogger().info(DataLayerInfo.describe());
        getLogger().info("Match plugin loaded and ready to host arenas and duel lifecycles.");
    }

    @Override
    public void onDisable() {
        getLogger().info("PracticeMatch disabled.");
    }
}

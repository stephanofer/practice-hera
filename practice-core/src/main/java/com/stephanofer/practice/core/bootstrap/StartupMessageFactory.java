package com.stephanofer.practice.core.bootstrap;

import com.stephanofer.practice.api.bootstrap.PracticePluginInfo;

public final class StartupMessageFactory {

    private StartupMessageFactory() {
    }

    public static String build(PracticePluginInfo pluginInfo) {
        return "Bootstrapping " + pluginInfo.pluginId() + " on platform " + pluginInfo.platform() + '.';
    }
}

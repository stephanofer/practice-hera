package com.stephanofer.practice.proxy;

import com.google.inject.Inject;
import com.stephanofer.practice.api.bootstrap.PracticePlatform;
import com.stephanofer.practice.api.bootstrap.PracticePluginInfo;
import com.stephanofer.practice.core.bootstrap.StartupMessageFactory;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import org.slf4j.Logger;

@Plugin(
    id = "practice-proxy",
    name = "Practice Proxy",
    version = "1.0.0-SNAPSHOT",
    url = "https://stephanofer.com",
    authors = {"stephanofer"}
)
public final class PracticeProxyPlugin {

    private final Logger logger;

    @Inject
    public PracticeProxyPlugin(Logger logger) {
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        var pluginInfo = new PracticePluginInfo("practice-proxy", PracticePlatform.PROXY);

        logger.info(StartupMessageFactory.build(pluginInfo));
        logger.info("Proxy plugin loaded and ready to manage transfers and routing.");
    }
}

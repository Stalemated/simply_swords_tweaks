package com.stalemated.simplytweaks.config;

import com.stalemated.lib.config.SLibConfig;
import com.stalemated.lib.config.manager.SyncedConfigManager;
import com.stalemated.lib.util.io.PathUtils;

import static com.stalemated.simplytweaks.SimplySwordsTweaks.*;

public class ConfigManager {
    public static final SyncedConfigManager<SSTConfig> MANAGER = SLibConfig.syncedBuilder(SSTConfig.class)
            .configPath(PathUtils.buildPath("simply_tweaks", "config.json5"))
            .logger(LOGGER)
            .modId(MOD_ID)
            .register();

    public static void register() {
    }

    public static SSTConfig getActiveConfig() {
        return MANAGER.getActiveConfig();
    }
}

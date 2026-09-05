package com.stalemated.simplytweaks;

import com.stalemated.simplytweaks.config.ConfigManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class SimplySwordsTweaks {
    public static final String MOD_ID = "simply_swords_tweaks";
    public static final Logger LOGGER = LoggerFactory.getLogger("Simply Swords Tweaks");

    public static void init() {
        ConfigManager.register();
        LOGGER.info("Simply Swords Tweaks initialized successfully!");
    }
}

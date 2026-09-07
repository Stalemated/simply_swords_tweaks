package com.stalemated.simplytweaks.fixes;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;

public final class IcewhisperSlownessFixer {

    private IcewhisperSlownessFixer() {}

    public static int calculateAmplifier(int nextAmplifier, int fallback) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null || config.icewhisper_slowness_cap < 0) {
            return Math.max(nextAmplifier, fallback);
        }

        return Math.min(nextAmplifier, config.icewhisper_slowness_cap);
    }
}


package com.stalemated.simplytweaks.battlestandard;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;

public final class BattleStandardHandler {

    private BattleStandardHandler() {}

    public static int getRadius(String standardType, int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;

        if ("sunfire".equals(standardType)) {
            return config.sunfire_aoe_radius;
        }

        if ("nullification".equals(standardType)) {
            return config.nullification_aoe_radius;
        }

        return originalValue;
    }

    public static int getSunfireStrengthAmplifier(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;

        return config.sunfire_strength_amplifier;
    }

    public static int getSunfireAoeRadius() {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return 6;

        return config.sunfire_aoe_radius;
    }

    public static int getNullificationAoeRadius() {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return 6;

        return config.nullification_aoe_radius;
    }
}

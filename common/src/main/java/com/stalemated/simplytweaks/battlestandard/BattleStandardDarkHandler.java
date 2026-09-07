package com.stalemated.simplytweaks.battlestandard;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;

public final class BattleStandardDarkHandler {

    private BattleStandardDarkHandler() {}

    public static int getHasteAmplifier(String standardType, int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;

        if ("enigma".equals(standardType)) {
            return config.galeforce_haste_amplifier;
        }
        return config.abyssal_standard_haste_amplifier;
    }

    public static float getHasteRadius(String standardType, float originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;

        if ("enigma".equals(standardType)) {
            return config.galeforce_haste_radius;
        }
        return config.abyssal_standard_haste_radius;
    }

    public static int getAbyssalAoeRadius(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;
        return config.abyssal_standard_aoe_radius;
    }

    public static int getAbyssalAoeRadius() {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return 6;
        return config.abyssal_standard_aoe_radius;
    }

    public static int getGaleforceAoeRadius(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;
        return config.galeforce_aoe_radius;
    }

    public static int getGaleforcePainAmplifier(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;
        return config.galeforce_pain_amplifier;
    }

    public static int getAbyssalAoeHasteAmplifier(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;
        return config.abyssal_standard_aoe_haste_amplifier;
    }

    public static int getAbyssalAoeSlownessAmplifier(int originalValue) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null) return originalValue;
        return config.abyssal_standard_aoe_slowness_amplifier;
    }
}

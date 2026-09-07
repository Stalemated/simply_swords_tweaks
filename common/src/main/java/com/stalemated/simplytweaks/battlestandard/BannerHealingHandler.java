package com.stalemated.simplytweaks.battlestandard;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import net.minecraft.entity.LivingEntity;
import net.sweenus.simplyswords.entity.BattleStandardDarkEntity;
import net.sweenus.simplyswords.entity.BattleStandardEntity;

public final class BannerHealingHandler {

    private BannerHealingHandler() {}

    public static boolean shouldPreventHealing(LivingEntity entity) {
        if (entity == null) return false;

        SSTConfig config = ConfigManager.getActiveConfig();
        if (config != null && config.banner_healing_allowed) {
            return false;
        }

        return entity instanceof BattleStandardEntity || entity instanceof BattleStandardDarkEntity;
    }
}

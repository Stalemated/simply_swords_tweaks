package com.stalemated.simplytweaks.fixes;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sweenus.simplyswords.effect.instance.SimplySwordsStatusEffectInstance;

public final class StackingStatusEffectFixer {

    private StackingStatusEffectFixer() {}

    public static boolean handleIncrementStatusEffect(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int amplifierMax) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config != null && !config.fix_status_effect_stacking) {
            return false;
        }

        StatusEffectInstance current = livingEntity.getStatusEffect(statusEffect);
        if (current == null) return false;

        int currentDuration = current.getDuration();
        livingEntity.addStatusEffect(new StatusEffectInstance(
                statusEffect, Math.max(currentDuration, duration), amplifierMax, false, false, true
        ));

        return true;
    }

    public static SimplySwordsStatusEffectInstance handleIncrementSimplySwordsStatusEffect(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int amplifierMax) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config != null && !config.fix_status_effect_stacking) {
            return null;
        }

        StatusEffectInstance current = livingEntity.getStatusEffect(statusEffect);
        if (current == null) return null;

        int currentDuration = current.getDuration();
        SimplySwordsStatusEffectInstance statusReturn = new SimplySwordsStatusEffectInstance(
                statusEffect, Math.max(currentDuration, duration), amplifierMax, false, false, true
        );

        livingEntity.addStatusEffect(statusReturn);
        return statusReturn;
    }
}

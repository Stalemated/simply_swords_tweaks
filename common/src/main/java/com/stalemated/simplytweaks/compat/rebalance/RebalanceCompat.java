package com.stalemated.simplytweaks.compat.rebalance;

import com.stalemated.simplytweaks.battlestandard.BattleStandardCombatContext;
import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import elocindev.rebalance.ReBalance;
import elocindev.rebalance.config.ReBalanceConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public final class RebalanceCompat {

    private RebalanceCompat() {}

    public static float modifyDamage(LivingEntity entity, float originalAmount, float damage) {
        if (!(entity instanceof PlayerEntity)) return damage;

        if (!BattleStandardCombatContext.isBannerDamage()) return damage;

        SSTConfig config = ConfigManager.getActiveConfig();
        if (config != null && !config.rebalance_compat_enabled) return damage;

        ReBalanceConfig rebalanceConfig = ReBalance.CONFIG;
        if (rebalanceConfig == null) rebalanceConfig = ReBalanceConfig.INSTANCE;
        if (rebalanceConfig == null) return damage;

        float newAmount = damage;

        if (rebalanceConfig.enable_global_reduction && originalAmount > rebalanceConfig.global_reduction_start) {
            newAmount *= rebalanceConfig.global_reduction_multiplier;
            newAmount += rebalanceConfig.global_reduction_start;
        }

        if (rebalanceConfig.enable_pvp_rebalance) {
            newAmount *= rebalanceConfig.pvp_damage_multiplier;
        }

        return newAmount;
    }
}


package com.stalemated.simplytweaks.netherfused;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public final class NullificationCooldownManager {

    private static final Map<UUID, Long> COOLDOWN_MAP = new ConcurrentHashMap<>();
    private static final int TICKS_PER_SECOND = 20;

    private NullificationCooldownManager() {}

    public static boolean isCoolingDown(LivingEntity attacker, StatusEffect originalEffect) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null || !config.nullification_prevent_battle_fatigue) {
            return attacker.hasStatusEffect(originalEffect);
        }

        long currentTime = attacker.getWorld().getTime();
        Long lastCast = COOLDOWN_MAP.get(attacker.getUuid());
        if (lastCast == null) {
            return false;
        }

        long elapsed = currentTime - lastCast;
        float cooldown = config.nullification_cooldown * TICKS_PER_SECOND;
        if (elapsed >= 0 && elapsed < cooldown) {
            return true;
        }

        COOLDOWN_MAP.remove(attacker.getUuid());
        return false;
    }

    public static boolean applyCooldown(LivingEntity attacker, StatusEffectInstance effectInstance, Entity source) {
        SSTConfig config = ConfigManager.getActiveConfig();
        if (config == null || !config.nullification_prevent_battle_fatigue) {
            return attacker.addStatusEffect(effectInstance, source);
        }

        COOLDOWN_MAP.put(attacker.getUuid(), attacker.getWorld().getTime());
        return true;
    }
}

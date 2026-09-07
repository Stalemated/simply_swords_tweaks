package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.netherfused.NullificationCooldownManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.sweenus.simplyswords.power.powers.NullificationPower;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NullificationPower.class)
public abstract class NullificationPowerMixin {

    @Redirect(
            method = "postHit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;hasStatusEffect(Lnet/minecraft/entity/effect/StatusEffect;)Z"
            )
    )
    private boolean sst$redirectHasStatusEffect(LivingEntity attacker, StatusEffect effect) {
        return NullificationCooldownManager.isCoolingDown(attacker, effect);
    }

    @Redirect(
            method = "postHit",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;Lnet/minecraft/entity/Entity;)Z"
            )
    )
    private boolean sst$redirectAddStatusEffect(LivingEntity attacker, StatusEffectInstance effect, Entity source) {
        return NullificationCooldownManager.applyCooldown(attacker, effect, source);
    }
}

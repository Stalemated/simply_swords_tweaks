package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.fixes.StackingStatusEffectFixer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.sweenus.simplyswords.effect.instance.SimplySwordsStatusEffectInstance;
import net.sweenus.simplyswords.util.HelperMethods;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(HelperMethods.class)
public abstract class HelperMethodsMixin {

    @Inject(
            method = "incrementStatusEffect",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z",
                    ordinal = 0
            ),
            cancellable = true
    )
    private static void sst$fixHigherEffects(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax, CallbackInfo ci) {
        if (StackingStatusEffectFixer.handleIncrementStatusEffect(livingEntity, statusEffect, duration, amplifierMax)) {
            ci.cancel();
        }
    }

    @Inject(
            method = "incrementSimplySwordsStatusEffect",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/LivingEntity;addStatusEffect(Lnet/minecraft/entity/effect/StatusEffectInstance;)Z",
                    ordinal = 0
            ),
            cancellable = true
    )
    private static void sst$fixHigherSimplySwordsEffects(LivingEntity livingEntity, StatusEffect statusEffect, int duration, int amplifier, int amplifierMax, CallbackInfoReturnable<SimplySwordsStatusEffectInstance> cir) {
        SimplySwordsStatusEffectInstance status = StackingStatusEffectFixer.handleIncrementSimplySwordsStatusEffect(livingEntity, statusEffect, duration, amplifierMax);
        if (status != null) {
            cir.setReturnValue(status);
        }
    }
}

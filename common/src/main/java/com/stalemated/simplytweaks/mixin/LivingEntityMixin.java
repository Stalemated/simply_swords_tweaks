package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.battlestandard.BannerHealingHandler;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "heal", at = @At("HEAD"), cancellable = true)
    private void sst$preventBannerHealing(float amount, CallbackInfo ci) {
        if (BannerHealingHandler.shouldPreventHealing((LivingEntity) (Object) this)) {
            ci.cancel();
        }
    }
}

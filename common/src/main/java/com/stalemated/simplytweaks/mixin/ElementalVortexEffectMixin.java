package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.fixes.ElementalVortexFixer;
import net.minecraft.entity.LivingEntity;
import net.sweenus.simplyswords.effect.ElementalVortexEffect;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ElementalVortexEffect.class)
public abstract class ElementalVortexEffectMixin {

    @Inject(method = "applyUpdateEffect", at = @At("HEAD"))
    private void sst$resetSourceEntityData(LivingEntity entity, int amplifier, CallbackInfo ci) {
        ElementalVortexFixer.onApplyUpdateEffect((ElementalVortexEffect) (Object) this);
    }
}

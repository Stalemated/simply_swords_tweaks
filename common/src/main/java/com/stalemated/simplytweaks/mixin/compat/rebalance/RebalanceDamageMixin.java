package com.stalemated.simplytweaks.mixin.compat.rebalance;

import com.stalemated.simplytweaks.compat.rebalance.RebalanceCompat;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = LivingEntity.class, priority = 2000)
public abstract class RebalanceDamageMixin {

    @Inject(method = "modifyAppliedDamage", at = @At("RETURN"), cancellable = true)
    private void sst$applyRebalanceDamage(DamageSource source, float amount, CallbackInfoReturnable<Float> cir) {

        float modified = RebalanceCompat.modifyDamage((LivingEntity) (Object) this, amount, cir.getReturnValue());
        cir.setReturnValue(modified);
    }
}

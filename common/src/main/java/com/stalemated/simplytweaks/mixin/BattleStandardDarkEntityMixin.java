package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.battlestandard.BattleStandardCombatContext;
import com.stalemated.simplytweaks.battlestandard.BattleStandardDarkHandler;
import net.sweenus.simplyswords.entity.BattleStandardDarkEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BattleStandardDarkEntity.class)
public abstract class BattleStandardDarkEntityMixin {

    @Shadow
    public String standardType;

    @Inject(method = "baseTick", at = @At("HEAD"))
    private void sst$startCombatContext(CallbackInfo ci) {
        BattleStandardCombatContext.enter();
    }

    @Inject(method = "baseTick", at = @At("RETURN"))
    private void sst$endCombatContext(CallbackInfo ci) {
        BattleStandardCombatContext.exit();
    }

    @ModifyArg(
            method = "baseTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/sweenus/simplyswords/util/HelperMethods;incrementStatusEffect(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/effect/StatusEffect;III)V"
            ),
            index = 4
    )
    private int sst$modifyHasteAmplifier(int originalValue) {
        return BattleStandardDarkHandler.getHasteAmplifier(this.standardType, originalValue);
    }

    @ModifyConstant(
            method = "baseTick",
            constant = @Constant(floatValue = 3.0f, ordinal = 0)
    )
    private float sst$modifyHasteRadius(float originalValue) {
        return BattleStandardDarkHandler.getHasteRadius(this.standardType, originalValue);
    }

    @ModifyConstant(
            method = "baseTick",
            constant = @Constant(intValue = 6, ordinal = 1)
    )
    private int sst$modifyAbyssalStandardAoeRadius(int originalValue) {
        return BattleStandardDarkHandler.getAbyssalAoeRadius(originalValue);
    }

    @ModifyConstant(
            method = "baseTick",
            constant = @Constant(intValue = 2, ordinal = 0)
    )
    private int sst$modifyGaleforceAoeRadius(int originalValue) {
        return BattleStandardDarkHandler.getGaleforceAoeRadius(originalValue);
    }

    @ModifyArg(
            method = "baseTick",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/sweenus/simplyswords/util/HelperMethods;incrementSimplySwordsStatusEffect(Lnet/minecraft/entity/LivingEntity;Lnet/minecraft/entity/effect/StatusEffect;III)Lnet/sweenus/simplyswords/effect/instance/SimplySwordsStatusEffectInstance;"
            ),
            index = 4
    )
    private int sst$modifyPainAmplifier(int originalValue) {
        return BattleStandardDarkHandler.getGaleforcePainAmplifier(originalValue);
    }

    @ModifyConstant(
            method = "baseTick",
            constant = @Constant(intValue = 2, ordinal = 0),
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "intValue=80")
            )
    )
    private int sst$modifyAbyssalStandardAoeHasteAmplifier(int originalValue) {
        return BattleStandardDarkHandler.getAbyssalAoeHasteAmplifier(originalValue);
    }

    @ModifyConstant(
            method = "baseTick",
            constant = @Constant(intValue = 0, ordinal = 0),
            slice = @Slice(
                    from = @At(value = "CONSTANT", args = "intValue=120")
            )
    )
    private int sst$modifyAbyssalStandardAoeSlownessAmplifier(int originalValue) {
        return BattleStandardDarkHandler.getAbyssalAoeSlownessAmplifier(originalValue);
    }
}

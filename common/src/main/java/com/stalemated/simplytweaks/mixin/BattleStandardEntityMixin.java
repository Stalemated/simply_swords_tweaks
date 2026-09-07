package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.battlestandard.BattleStandardCombatContext;
import com.stalemated.simplytweaks.battlestandard.BattleStandardHandler;
import net.sweenus.simplyswords.entity.BattleStandardEntity;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.Slice;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BattleStandardEntity.class)
public abstract class BattleStandardEntityMixin {

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

    @ModifyConstant(method = "baseTick", constant = @Constant(intValue = 6, ordinal = 0))
    private int sst$modifyRadius(int originalValue) {
        return BattleStandardHandler.getRadius(this.standardType, originalValue);
    }

    @ModifyArg(
            method = "baseTick",
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/minecraft/entity/effect/StatusEffects;STRENGTH:Lnet/minecraft/entity/effect/StatusEffect;", opcode = Opcodes.GETSTATIC)
            ),
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/entity/effect/StatusEffectInstance;<init>(Lnet/minecraft/entity/effect/StatusEffect;II)V",
                    ordinal = 0
            ),
            index = 2
    )
    private int sst$modifySunfireStrengthAmplifier(int originalValue) {
        return BattleStandardHandler.getSunfireStrengthAmplifier(originalValue);
    }
}

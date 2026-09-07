package com.stalemated.simplytweaks.mixin.client;

import com.stalemated.simplytweaks.battlestandard.BattleStandardDarkHandler;
import net.sweenus.simplyswords.client.renderer.BattleStandardDarkRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

import static com.stalemated.simplytweaks.client.ModernFieldHandler.EXTRA_CULLING_RADIUS;

@Mixin(BattleStandardDarkRenderer.class)
public abstract class BattleStandardDarkRendererMixin {

    @ModifyConstant(
            method = "shouldRender(Lnet/sweenus/simplyswords/entity/BattleStandardDarkEntity;Lnet/minecraft/client/render/Frustum;DDD)Z",
            constant = @Constant(doubleValue = 6.25)
    )
    private double sst$modifyHarbingerCullingRadius(double originalValue) {
        return BattleStandardDarkHandler.getAbyssalAoeRadius() + EXTRA_CULLING_RADIUS;
    }
}

package com.stalemated.simplytweaks.mixin.client;

import com.stalemated.simplytweaks.client.ModernFieldHandler;
import com.stalemated.simplytweaks.battlestandard.BattleStandardHandler;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.sweenus.simplyswords.client.renderer.BattleStandardRenderer;
import net.sweenus.simplyswords.entity.BattleStandardEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static com.stalemated.simplytweaks.client.ModernFieldHandler.EXTRA_CULLING_RADIUS;

@Mixin(BattleStandardRenderer.class)
public abstract class BattleStandardRendererMixin {

    @ModifyConstant(
            method = "shouldRender(Lnet/sweenus/simplyswords/entity/BattleStandardEntity;Lnet/minecraft/client/render/Frustum;DDD)Z",
            constant = @Constant(doubleValue = 6.25)
    )
    private double sst$modifySunfireCullingRadius(double originalValue) {
        return BattleStandardHandler.getSunfireAoeRadius() + EXTRA_CULLING_RADIUS;
    }

    @Inject(
            method = "shouldRender(Lnet/sweenus/simplyswords/entity/BattleStandardEntity;Lnet/minecraft/client/render/Frustum;DDD)Z",
            at = @At("RETURN"),
            cancellable = true
    )
    private void sst$shouldRenderField(BattleStandardEntity entity, Frustum frustum, double x, double y, double z, CallbackInfoReturnable<Boolean> cir) {
        if (!cir.getReturnValueZ() && ModernFieldHandler.shouldRenderField(entity, frustum)) {
            cir.setReturnValue(true);
        }
    }

    @Inject(
            method = "render(Lnet/sweenus/simplyswords/entity/BattleStandardEntity;FFLnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;I)V",
            at = @At("TAIL")
    )
    private void sst$renderField(BattleStandardEntity entity, float yaw, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, CallbackInfo ci) {
        ModernFieldHandler.renderBattleStandard(entity, matrices, vertexConsumers);
    }
}


package com.stalemated.simplytweaks.mixin.client;

import com.stalemated.simplytweaks.client.ModernFieldHandler;
import com.stalemated.simplytweaks.battlestandard.BattleStandardDarkHandler;
import com.stalemated.simplytweaks.battlestandard.BattleStandardHandler;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.sweenus.simplyswords.client.renderer.ModernFieldRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModernFieldRenderer.class)
public abstract class ModernFieldRendererMixin {

    @Inject(method = "renderSunfire", at = @At("HEAD"))
    private static void sst$beforeRenderSunfire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int age, CallbackInfo ci) {
        ModernFieldHandler.setCurrentRadius(BattleStandardHandler.getSunfireAoeRadius());
    }

    @Inject(method = "renderSunfire", at = @At("RETURN"))
    private static void sst$afterRenderSunfire(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int age, CallbackInfo ci) {
        ModernFieldHandler.resetCurrentRadius();
    }

    @Inject(method = "renderHarbinger", at = @At("HEAD"))
    private static void sst$beforeRenderHarbinger(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int age, CallbackInfo ci) {
        ModernFieldHandler.setCurrentRadius(BattleStandardDarkHandler.getAbyssalAoeRadius());
    }

    @Inject(method = "renderHarbinger", at = @At("RETURN"))
    private static void sst$afterRenderHarbinger(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int age, CallbackInfo ci) {
        ModernFieldHandler.resetCurrentRadius();
    }

    @ModifyConstant(
            method = "renderRing",
            constant = @Constant(floatValue = 6.0f)
    )
    private static float sst$modifyFieldRadius(float originalValue) {
        return ModernFieldHandler.getCurrentRadius(originalValue);
    }
}

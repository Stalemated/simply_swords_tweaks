package com.stalemated.simplytweaks.client;

import com.stalemated.simplytweaks.battlestandard.BattleStandardHandler;
import net.minecraft.client.render.Frustum;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.util.math.MatrixStack;
import net.sweenus.simplyswords.client.renderer.ModernFieldRenderer;
import net.sweenus.simplyswords.entity.BattleStandardEntity;

public final class ModernFieldHandler {

    public static final double EXTRA_CULLING_RADIUS = 0.25;

    private static final ThreadLocal<Float> CURRENT_RADIUS = new ThreadLocal<>();

    // Same color as Styles.NETHERFUSED (0xDB5E71)
    private static final int NULLIFICATION_RED = 219;
    private static final int NULLIFICATION_GREEN = 94;
    private static final int NULLIFICATION_BLUE = 113;

    private ModernFieldHandler() {}

    public static void setCurrentRadius(float radius) {
        CURRENT_RADIUS.set(radius);
    }

    public static void resetCurrentRadius() {
        CURRENT_RADIUS.remove();
    }

    public static float getCurrentRadius(float fallback) {
        Float current = CURRENT_RADIUS.get();
        return current != null ? current : fallback;
    }

    public static void renderBattleStandard(BattleStandardEntity entity, MatrixStack matrices, VertexConsumerProvider vertexConsumers) {
        if (!ModernFieldRenderer.isEnabled()) return;

        if ("nullification".equals(entity.getStandardType())) {
            renderNullification(matrices, vertexConsumers, entity.age);
        }
    }

    public static void renderNullification(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int age) {
        if (!ModernFieldRenderer.isEnabled()) return;

        try {
            setCurrentRadius(BattleStandardHandler.getNullificationAoeRadius());
            ModernFieldRenderer.renderRing(matrices, vertexConsumers, age, NULLIFICATION_RED, NULLIFICATION_GREEN, NULLIFICATION_BLUE);
        } finally {
            resetCurrentRadius();
        }
    }

    public static boolean shouldRenderField(BattleStandardEntity entity, Frustum frustum) {
        if (!ModernFieldRenderer.isEnabled()) return false;

        if ("nullification".equals(entity.getStandardType())) {
            double cullingRadius = BattleStandardHandler.getNullificationAoeRadius() + EXTRA_CULLING_RADIUS;
            return frustum.isVisible(entity.getBoundingBox().expand(cullingRadius, 1.0, cullingRadius));
        }

        return false;
    }
}


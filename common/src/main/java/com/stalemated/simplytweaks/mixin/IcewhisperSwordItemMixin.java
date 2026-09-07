package com.stalemated.simplytweaks.mixin;

import com.stalemated.simplytweaks.fixes.IcewhisperSlownessFixer;
import net.sweenus.simplyswords.item.custom.IcewhisperSwordItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(IcewhisperSwordItem.class)
public abstract class IcewhisperSwordItemMixin {

    @Redirect(
            method = "tickPassiveAura",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/lang/Math;max(II)I"
            )
    )
    private static int sst$capIcewhisperSlowness(int a, int b) {
        return IcewhisperSlownessFixer.calculateAmplifier(a, b);
    }
}


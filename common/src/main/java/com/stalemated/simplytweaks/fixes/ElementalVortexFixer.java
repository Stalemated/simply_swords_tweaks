package com.stalemated.simplytweaks.fixes;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.config.SSTConfig;
import net.sweenus.simplyswords.effect.ElementalVortexEffect;

public final class ElementalVortexFixer {

    private ElementalVortexFixer() {}

    public static void onApplyUpdateEffect(ElementalVortexEffect effect) {
        if (effect == null) return;

        SSTConfig config = ConfigManager.getActiveConfig();
        if (config != null && !config.fix_elemental_vortex_leak) {
            return;
        }

        effect.sourceEntity = null;
        effect.additionalData = 0;
    }
}

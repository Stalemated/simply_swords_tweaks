package com.stalemated.simplytweaks.forge;

import com.stalemated.simplytweaks.SimplySwordsTweaks;
import com.stalemated.simplytweaks.forge.client.SimplySwordsTweaksForgeClient;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SimplySwordsTweaks.MOD_ID)
public final class SimplySwordsTweaksForge {

    public SimplySwordsTweaksForge() {
        SimplySwordsTweaks.init();

        if (FMLEnvironment.dist == Dist.CLIENT) {
            SimplySwordsTweaksForgeClient.init();
        }
    }
}

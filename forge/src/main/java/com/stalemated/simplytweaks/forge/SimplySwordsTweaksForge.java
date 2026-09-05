package com.stalemated.simplytweaks.forge;

import com.stalemated.simplytweaks.SimplySwordsTweaks;
import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.forge.client.SimplySwordsTweaksForgeClient;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.loading.FMLEnvironment;

@Mod(SimplySwordsTweaks.MOD_ID)
public final class SimplySwordsTweaksForge {

    public SimplySwordsTweaksForge() {
        SimplySwordsTweaks.init();

        MinecraftForge.EVENT_BUS.addListener(this::onPlayerJoin);

        if (FMLEnvironment.dist == Dist.CLIENT) {
            SimplySwordsTweaksForgeClient.init();
        }
    }

    private void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayerEntity serverPlayer) {
            ConfigManager.MANAGER.sendConfigToPlayer(serverPlayer);
        }
    }
}

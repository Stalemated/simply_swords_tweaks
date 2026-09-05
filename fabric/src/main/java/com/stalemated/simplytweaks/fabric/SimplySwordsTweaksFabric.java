package com.stalemated.simplytweaks.fabric;

import com.stalemated.simplytweaks.SimplySwordsTweaks;
import com.stalemated.simplytweaks.config.ConfigManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

public final class SimplySwordsTweaksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SimplySwordsTweaks.init();

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) ->
                ConfigManager.MANAGER.sendConfigToPlayer(handler.player));
    }
}

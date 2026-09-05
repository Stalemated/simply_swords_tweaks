package com.stalemated.simplytweaks.fabric.client;

import com.stalemated.simplytweaks.config.ConfigManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.networking.v1.ClientPlayConnectionEvents;

public final class SimplySwordsTweaksFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ClientPlayConnectionEvents.DISCONNECT.register((handler, client) ->
                ConfigManager.MANAGER.clearServerConfig());
    }
}

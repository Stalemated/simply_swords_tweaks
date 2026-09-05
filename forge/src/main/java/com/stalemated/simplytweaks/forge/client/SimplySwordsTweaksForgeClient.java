package com.stalemated.simplytweaks.forge.client;

import com.stalemated.simplytweaks.config.ConfigManager;
import com.stalemated.simplytweaks.gui.screen.SSTConfigScreen;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.ClientPlayerNetworkEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;

@SuppressWarnings("removal")
public final class SimplySwordsTweaksForgeClient {

    private SimplySwordsTweaksForgeClient() {}

    public static void init() {
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory((client, parent) -> SSTConfigScreen.create(parent))
        );
        MinecraftForge.EVENT_BUS.addListener(SimplySwordsTweaksForgeClient::onPlayerLogout);
    }

    private static void onPlayerLogout(ClientPlayerNetworkEvent.LoggingOut event) {
        ConfigManager.MANAGER.clearServerConfig();
    }
}

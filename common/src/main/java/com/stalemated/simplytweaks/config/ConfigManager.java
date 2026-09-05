package com.stalemated.simplytweaks.config;

import com.stalemated.lib.config.ConfigProvider;
import com.stalemated.lib.config.SyncedConfigManager;
import com.stalemated.lib.config.permissions.ServerConfigPermissions;
import com.stalemated.simplytweaks.SimplySwordsTweaks;
import dev.isxander.yacl3.config.v2.api.ConfigClassHandler;
import dev.isxander.yacl3.config.v2.api.serializer.GsonConfigSerializerBuilder;
import net.minecraft.util.Identifier;

import java.nio.file.Path;

public class ConfigManager {

    private static final Path CONFIG_PATH = SyncedConfigManager.buildPath(SimplySwordsTweaks.MOD_ID + ".json5");
    public static final Identifier SYNC_CHANNEL = new Identifier(SimplySwordsTweaks.MOD_ID, "sync_config");
    public static final Identifier CONFIG = new Identifier(SimplySwordsTweaks.MOD_ID, "config");

    public static final ConfigClassHandler<SSTConfig> HANDLER = ConfigClassHandler.createBuilder(SSTConfig.class)
            .id(CONFIG)
            .serializer(config -> GsonConfigSerializerBuilder.create(config)
                    .setPath(CONFIG_PATH)
                    .setJson5(true)
                    .build())
            .build();

    public static final SyncedConfigManager<SSTConfig> MANAGER = new SyncedConfigManager<>(
            new ConfigProvider<SSTConfig>() {
                @Override
                public boolean load() {
                    return HANDLER.load();
                }

                @Override
                public void save() {
                    HANDLER.save();
                }

                @Override
                public SSTConfig instance() {
                    return HANDLER.instance();
                }
            },
            CONFIG_PATH,
            SimplySwordsTweaks.LOGGER,
            SYNC_CHANNEL,
            SSTConfig.class,
            ServerConfigPermissions.OP_ONLY,
            (source, dest) -> dest.copyFrom(source)
    );

    public static boolean configLoadFailed = false;

    public static void register() {
        MANAGER.register();
        configLoadFailed = MANAGER.configLoadFailed;
    }

    public static SSTConfig getActiveConfig() {
        return MANAGER.getActiveConfig();
    }
}

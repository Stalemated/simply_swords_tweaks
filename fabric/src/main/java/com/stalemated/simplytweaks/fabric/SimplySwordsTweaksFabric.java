package com.stalemated.simplytweaks.fabric;

import com.stalemated.simplytweaks.SimplySwordsTweaks;
import net.fabricmc.api.ModInitializer;

public final class SimplySwordsTweaksFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        SimplySwordsTweaks.init();
    }
}

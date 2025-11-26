package com.github.smallinger.copperagebackport.fabric.platform;

import com.github.smallinger.copperagebackport.fabric.compat.FastChestCompat;
import com.github.smallinger.copperagebackport.platform.services.IPlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

/**
 * Fabric implementation of the platform helper service.
 */
public class FabricPlatformHelper implements IPlatformHelper {

    private final FabricLoader loader = FabricLoader.getInstance();

    @Override
    public String getPlatformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String modId) {
        return loader.isModLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {
        return loader.isDevelopmentEnvironment();
    }
    
    @Override
    public boolean isFastChestSimplifiedEnabled() {
        return FastChestCompat.isSimplifiedChestEnabled();
    }
}

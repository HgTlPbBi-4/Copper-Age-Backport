package com.github.smallinger.copperagebackport.neoforge.platform;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.registry.RegistryHelper;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * NeoForge implementation of the registry helper using DeferredRegister.
 */
public class NeoForgeRegistryHelper extends RegistryHelper {

    private final Map<ResourceKey<?>, DeferredRegister<?>> registers = new HashMap<>();
    private final IEventBus modEventBus;

    public NeoForgeRegistryHelper(IEventBus modEventBus) {
        this.modEventBus = modEventBus;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Supplier<T> register(ResourceKey<? extends Registry<? super T>> registryKey,
                                    String name,
                                    Supplier<T> supplier) {
        DeferredRegister<T> register = (DeferredRegister<T>) registers.computeIfAbsent(registryKey, key -> {
            ResourceKey<? extends Registry<T>> typedKey = (ResourceKey<? extends Registry<T>>) key;
            DeferredRegister<T> newRegister = DeferredRegister.create(typedKey, Constants.MOD_ID);
            newRegister.register(modEventBus);
            return newRegister;
        });

        return register.register(name, supplier);
    }

    @Override
    public void fireRegistrationCallbacks() {
        super.fireRegistrationCallbacks();
    }
}

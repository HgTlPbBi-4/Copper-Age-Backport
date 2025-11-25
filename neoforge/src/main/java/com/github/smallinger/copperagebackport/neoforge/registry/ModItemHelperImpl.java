package com.github.smallinger.copperagebackport.neoforge.registry;

import com.github.smallinger.copperagebackport.neoforge.item.Copper3DBlockItem;
import com.github.smallinger.copperagebackport.registry.ModEntities;
import com.github.smallinger.copperagebackport.registry.ModItemHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;

/**
 * NeoForge implementation of the platform-specific item helper.
 */
public class ModItemHelperImpl implements ModItemHelper {

    private static final int PRIMARY_COPPER = 0xB87333;
    private static final int SECONDARY_OXIDIZED = 0x48D1CC;

    @Override
    public Item createSpawnEgg() {
        return new DeferredSpawnEggItem(
            ModEntities.COPPER_GOLEM,
            PRIMARY_COPPER,
            SECONDARY_OXIDIZED,
            new Item.Properties()
        );
    }

    @Override
    public BlockItem create3DBlockItem(Block block, Item.Properties properties) {
        return new Copper3DBlockItem(block, properties);
    }
}

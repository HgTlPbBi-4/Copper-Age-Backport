package com.github.smallinger.copperagebackport.fabric.registry;

import com.github.smallinger.copperagebackport.fabric.item.Copper3DBlockItem;
import com.github.smallinger.copperagebackport.registry.ModEntities;
import com.github.smallinger.copperagebackport.registry.ModItemHelper;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;

/**
 * Fabric implementation of the platform-specific item helper.
 */
public class ModItemHelperImpl implements ModItemHelper {

    private static final int PRIMARY_COPPER = 0xB87333;
    private static final int SECONDARY_OXIDIZED = 0x48D1CC;

    @Override
    public Item createSpawnEgg() {
        return new SpawnEggItem(
            ModEntities.COPPER_GOLEM.get(),
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

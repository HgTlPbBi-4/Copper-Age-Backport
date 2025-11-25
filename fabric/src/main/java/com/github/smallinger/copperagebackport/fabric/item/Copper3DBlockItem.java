package com.github.smallinger.copperagebackport.fabric.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;

/**
 * Simple Fabric-only BlockItem used to mark items that need custom builtin rendering.
 */
public class Copper3DBlockItem extends BlockItem {

    public Copper3DBlockItem(Block block, Properties properties) {
        super(block, properties);
    }
}

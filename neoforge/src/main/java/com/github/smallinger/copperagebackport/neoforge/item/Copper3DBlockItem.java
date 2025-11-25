package com.github.smallinger.copperagebackport.neoforge.item;

import com.github.smallinger.copperagebackport.client.renderer.CopperItemRenderer;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;

import java.util.function.Consumer;

/**
 * NeoForge BlockItem that wires up the custom Copper item renderer via IClientItemExtensions.
 */
public class Copper3DBlockItem extends BlockItem {

    private static CopperItemRenderer renderer;

    public Copper3DBlockItem(Block block, Properties properties) {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                if (renderer == null) {
                    renderer = new CopperItemRenderer();
                }
                return renderer;
            }
        });
    }
}

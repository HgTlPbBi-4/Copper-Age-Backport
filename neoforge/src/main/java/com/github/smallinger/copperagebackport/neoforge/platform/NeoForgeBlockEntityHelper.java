package com.github.smallinger.copperagebackport.neoforge.platform;

import com.github.smallinger.copperagebackport.platform.services.IBlockEntityHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * NeoForge implementation of the block entity helper service.
 */
public class NeoForgeBlockEntityHelper implements IBlockEntityHelper {

    @Override
    public <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BlockEntityFactory<T> factory,
                                                                           Block... blocks) {
        return BlockEntityType.Builder.of(factory::create, blocks).build(null);
    }
}

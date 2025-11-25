package com.github.smallinger.copperagebackport.fabric.platform;

import com.github.smallinger.copperagebackport.platform.services.IBlockEntityHelper;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

/**
 * Fabric implementation of the block entity helper service.
 */
public class FabricBlockEntityHelper implements IBlockEntityHelper {

    @Override
    public <T extends BlockEntity> BlockEntityType<T> createBlockEntityType(BlockEntityFactory<T> factory,
                                                                           Block... blocks) {
        return BlockEntityType.Builder.of(factory::create, blocks).build(null);
    }
}

package com.github.smallinger.copperagebackport.fabric.client;

import com.github.smallinger.copperagebackport.client.model.CopperGolemModel;
import com.github.smallinger.copperagebackport.client.renderer.CopperChestRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperGolemRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperGolemStatueRenderer;
import com.github.smallinger.copperagebackport.client.renderer.CopperItemRenderer;
import com.github.smallinger.copperagebackport.client.renderer.ShelfRenderer;
import com.github.smallinger.copperagebackport.registry.ModBlockEntities;
import com.github.smallinger.copperagebackport.registry.ModEntities;
import com.github.smallinger.copperagebackport.registry.ModItems;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;

/**
 * Fabric client initializer responsible for all renderer registrations.
 */
public class CopperAgeBackportFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerModelLayers();
        registerRenderers();
        register3DItemRenderers();
    }

    private void registerModelLayers() {
        EntityModelLayerRegistry.registerModelLayer(CopperGolemModel.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CopperGolemModel.STATUE_STANDING, CopperGolemModel::createStandingStatueBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CopperGolemModel.STATUE_RUNNING, CopperGolemModel::createRunningPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CopperGolemModel.STATUE_SITTING, CopperGolemModel::createSittingPoseBodyLayer);
        EntityModelLayerRegistry.registerModelLayer(CopperGolemModel.STATUE_STAR, CopperGolemModel::createStarPoseBodyLayer);
    }

    private void registerRenderers() {
        EntityRendererRegistry.register(ModEntities.COPPER_GOLEM.get(), CopperGolemRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.COPPER_CHEST_BLOCK_ENTITY.get(), CopperChestRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), CopperGolemStatueRenderer::new);
        BlockEntityRenderers.register(ModBlockEntities.SHELF_BLOCK_ENTITY.get(), ShelfRenderer::new);
    }

    private void register3DItemRenderers() {
        CopperItemRenderer renderer = new CopperItemRenderer();
        BuiltinItemRendererRegistry.DynamicItemRenderer dynamicRenderer = renderer::renderByItem;

        // Chest items
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get(), dynamicRenderer);

        // Statue items
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
        BuiltinItemRendererRegistry.INSTANCE.register(ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get(), dynamicRenderer);
    }
}

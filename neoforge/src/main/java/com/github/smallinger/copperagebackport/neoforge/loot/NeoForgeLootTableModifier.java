package com.github.smallinger.copperagebackport.neoforge.loot;

import com.github.smallinger.copperagebackport.Constants;
import com.github.smallinger.copperagebackport.loot.CopperHorseArmorLoot;
import com.github.smallinger.copperagebackport.registry.ModItems;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

/**
 * NeoForge implementation for adding Copper Horse Armor to loot tables.
 * Uses Global Loot Modifiers to inject items into existing loot tables.
 */
public class NeoForgeLootTableModifier extends LootModifier {
    
    // Registry for loot modifier serializers
    private static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = 
        DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Constants.MOD_ID);
    
    public static final MapCodec<NeoForgeLootTableModifier> CODEC = RecordCodecBuilder.mapCodec(instance ->
        codecStart(instance).apply(instance, NeoForgeLootTableModifier::new)
    );
    
    public static final Supplier<MapCodec<NeoForgeLootTableModifier>> ADD_COPPER_HORSE_ARMOR = 
        LOOT_MODIFIERS.register("add_copper_horse_armor", () -> CODEC);

    public NeoForgeLootTableModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }
    
    /**
     * Register the loot modifier with the mod event bus.
     */
    public static void register(IEventBus modEventBus) {
        LOOT_MODIFIERS.register(modEventBus);
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ResourceLocation lootTableId = context.getQueriedLootTableId();
        
        // Use common class for loot table checks
        if (CopperHorseArmorLoot.shouldModifyLootTable(lootTableId)) {
            // Check if iron horse armor was generated, if so add copper with same probability
            boolean hasIronHorseArmor = generatedLoot.stream()
                .anyMatch(CopperHorseArmorLoot::isIronHorseArmor);
            
            if (hasIronHorseArmor) {
                // Add copper horse armor alongside iron horse armor
                generatedLoot.add(new ItemStack(ModItems.COPPER_HORSE_ARMOR.get()));
            }
        }
        
        return generatedLoot;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}

package com.github.smallinger.copperagebackport.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import java.util.Set;
import java.util.function.Supplier;

/**
 * Common loot table configuration for Copper Horse Armor.
 * This class provides shared data for all platform-specific loot modifier implementations.
 */
public class CopperHorseArmorLoot {
    
    /**
     * Loot tables that should contain Copper Horse Armor (same locations as Iron Horse Armor).
     * Based on Minecraft 1.21.10 loot tables.
     */
    public static final Set<ResourceLocation> TARGET_LOOT_TABLES = Set.of(
        ResourceLocation.withDefaultNamespace("chests/simple_dungeon"),
        ResourceLocation.withDefaultNamespace("chests/desert_pyramid"),
        ResourceLocation.withDefaultNamespace("chests/jungle_temple"),
        ResourceLocation.withDefaultNamespace("chests/nether_bridge"),
        ResourceLocation.withDefaultNamespace("chests/stronghold_corridor"),
        ResourceLocation.withDefaultNamespace("chests/end_city_treasure"),
        ResourceLocation.withDefaultNamespace("chests/village/village_weaponsmith")
    );
    
    /**
     * Weight for Copper Horse Armor in loot tables.
     * Same as Iron Horse Armor weight in vanilla.
     */
    public static final int LOOT_WEIGHT = 15;
    
    /**
     * Checks if a loot table should have Copper Horse Armor added.
     * @param lootTableId The loot table identifier
     * @return true if this loot table should contain Copper Horse Armor
     */
    public static boolean shouldModifyLootTable(ResourceLocation lootTableId) {
        return TARGET_LOOT_TABLES.contains(lootTableId);
    }
    
    /**
     * Checks if an ItemStack is Iron Horse Armor.
     * Used to determine if Copper Horse Armor should be added alongside it.
     * @param stack The ItemStack to check
     * @return true if the stack is Iron Horse Armor
     */
    public static boolean isIronHorseArmor(ItemStack stack) {
        return stack.getItem() == Items.IRON_HORSE_ARMOR;
    }
}

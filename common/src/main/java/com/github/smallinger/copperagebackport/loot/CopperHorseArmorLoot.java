package com.github.smallinger.copperagebackport.loot;

import net.minecraft.resources.ResourceLocation;

import java.util.Set;

/**
 * Common loot table configuration for Copper Horse Armor.
 * Defines which loot tables should contain Copper Horse Armor.
 * 
 * Spawn chances (implemented in platform-specific modifiers) based on Minecraft Wiki:
 * - Monster Room (simple_dungeon): 19.4%
 * - Desert Pyramid: 17%
 * - End City: 4.6%
 * - Jungle Pyramid: 4.4%
 * - Nether Fortress: 17.9%
 * - Stronghold (corridor): 2.5%
 * - Village Weaponsmith: 5.6%
 */
public class CopperHorseArmorLoot {
    
    /**
     * Loot tables that should contain Copper Horse Armor.
     */
    private static final Set<ResourceLocation> TARGET_LOOT_TABLES = Set.of(
        ResourceLocation.withDefaultNamespace("chests/simple_dungeon"),
        ResourceLocation.withDefaultNamespace("chests/desert_pyramid"),
        ResourceLocation.withDefaultNamespace("chests/nether_bridge"),
        ResourceLocation.withDefaultNamespace("chests/jungle_temple"),
        ResourceLocation.withDefaultNamespace("chests/stronghold_corridor"),
        ResourceLocation.withDefaultNamespace("chests/end_city_treasure"),
        ResourceLocation.withDefaultNamespace("chests/village/village_weaponsmith")
    );
    
    /**
     * Checks if a loot table should have Copper Horse Armor added.
     * @param lootTableId The loot table identifier
     * @return true if this loot table should contain Copper Horse Armor
     */
    public static boolean shouldModifyLootTable(ResourceLocation lootTableId) {
        return TARGET_LOOT_TABLES.contains(lootTableId);
    }
}

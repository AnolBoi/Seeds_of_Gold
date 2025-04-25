package net.anoltongi.seedsofgold.item;

import net.anoltongi.seedsofgold.SeedsOfGold;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item SUNFLOWER_SEEDS = registerItem("sunflower_seeds",
            new Item(new FabricItemSettings().food(ModFoodComponents.SUNFLOWER_SEEDS)));
    public static final Item ROASTED_SUNFLOWER_SEEDS = registerItem("roasted_sunflower_seeds",
            new Item(new FabricItemSettings().food(ModFoodComponents.ROASTED_SUNFLOWER_SEEDS)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(SeedsOfGold.MOD_ID, name), item);
    }

    private static void itemGroupFoods(FabricItemGroupEntries entries) {
        entries.addAfter(Items.SPIDER_EYE, ModItems.SUNFLOWER_SEEDS);
        entries.addAfter(ModItems.SUNFLOWER_SEEDS, ModItems.ROASTED_SUNFLOWER_SEEDS);
    }

    public static void registerModItems() {
        SeedsOfGold.LOGGER.info("Registering Mod Items for " + SeedsOfGold.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::itemGroupFoods);
    }
}
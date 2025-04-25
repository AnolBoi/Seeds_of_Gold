package net.anoltongi.seedsofgold.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent SUNFLOWER_SEEDS = new FoodComponent.Builder().hunger(2).saturationModifier(0.2f).build();
    public static final FoodComponent ROASTED_SUNFLOWER_SEEDS = new FoodComponent.Builder().hunger(3).saturationModifier(0.25f).build();
}
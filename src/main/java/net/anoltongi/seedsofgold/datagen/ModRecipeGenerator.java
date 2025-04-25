package net.anoltongi.seedsofgold.datagen;

import net.anoltongi.seedsofgold.SeedsOfGold;
import net.anoltongi.seedsofgold.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeGenerator extends FabricRecipeProvider {
    public ModRecipeGenerator(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SUNFLOWER_SEEDS, 2)
                .pattern("SS")
                .input('S', Items.SUNFLOWER)
                .criterion(
                        FabricRecipeProvider.hasItem(Items.SUNFLOWER),
                        FabricRecipeProvider.conditionsFromItem(Items.SUNFLOWER)).offerTo(exporter);

        offerSmelting(exporter, List.of(ModItems.ROASTED_SUNFLOWER_SEEDS, ModItems.SUNFLOWER_SEEDS), RecipeCategory.MISC, ModItems.ROASTED_SUNFLOWER_SEEDS,
                0f, 200, "sunflower_seeds");
        CookingRecipeJsonBuilder.createSmoking(Ingredient.ofItems(ModItems.SUNFLOWER_SEEDS),
                        RecipeCategory.MISC,
                        ModItems.ROASTED_SUNFLOWER_SEEDS,
                        0f,
                        100
                )
                .criterion(
                        hasItem(ModItems.SUNFLOWER_SEEDS),
                        conditionsFromItem(ModItems.SUNFLOWER_SEEDS)
                )
                .offerTo(exporter,
                        new Identifier(SeedsOfGold.MOD_ID, "roasted_sunflower_seeds_smoking")
                );
    }
}

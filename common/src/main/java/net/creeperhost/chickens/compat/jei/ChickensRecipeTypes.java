package net.creeperhost.chickens.compat.jei;

import mezz.jei.api.recipe.RecipeType;
import net.creeperhost.chickens.Chickens;

public class ChickensRecipeTypes
{
    public static final RecipeType<ChickenBreedingCategory.Recipe> BREEDING = RecipeType.create(Chickens.MOD_ID, "breeding", ChickenBreedingCategory.Recipe.class);

    public static final RecipeType<ChickenDropsCategory.Recipe> DROPS = RecipeType.create(Chickens.MOD_ID, "drops", ChickenDropsCategory.Recipe.class);

    public static final RecipeType<ChickenLayingCategory.Recipe> LAYING = RecipeType.create(Chickens.MOD_ID, "laying", ChickenLayingCategory.Recipe.class);
}
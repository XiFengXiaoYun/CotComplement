package com.xifeng.cot_complement.projectile;

import com.xifeng.cot_complement.utils.Recipe;
import com.xifeng.cot_complement.utils.Function;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.ArrayList;
import java.util.List;

@ZenClass("mods.cc.tic.ProjTraitBuilder")
@ZenRegister
@ModOnly("tconstruct")
public class ProjTraitBuilder {

    @ZenProperty
    public String identifier;

    @ZenProperty
    public int color = 0xffffff;

    @ZenProperty
    public int maxLevel = 0;

    @ZenProperty
    public int countPerLevel = 0;

    @ZenProperty
    public boolean hidden = false;

    @ZenProperty
    public Function.OnLaunch onLaunch = null;

    @ZenProperty
    public Function.OnMovement onMovement = null;

    @ZenProperty
    public Function.OnProjectileUpdate onProjectileUpdate = null;

    @ZenProperty
    public Function.AfterProjHit afterProjHit = null;
/*
    @ZenProperty
    public Function.ApplyProjEffect applyEffect = null;
*/
    @ZenProperty
    public String localizedName = null;

    @ZenProperty
    public String localizedDescription = null;

    private final List<Recipe> recipe = new ArrayList<>();

    private final List<RecipeMatch> recipes = new ArrayList<>();

    public ProjTraitBuilder(String identifier) {
        this.identifier = identifier;
    }

    @ZenMethod
    public static ProjTraitBuilder create(String identifier) {
        return new ProjTraitBuilder(identifier);
    }

    @ZenMethod
    public void addItem(IIngredient ingredient, @Optional(valueLong = 1) int amountNeeded, @Optional(valueLong = 1) int amountMatched) {
        recipe.add(new Recipe(ingredient, amountMatched, amountNeeded));
    }

    @ZenMethod
    public void addMultiItem(int amount, IItemStack... items) {
        recipes.add(new RecipeMatch.ItemCombination(amount, CraftTweakerMC.getItemStacks(items)));
    }

    @ZenMethod
    public void removeItem(IItemStack itemStack) {
        recipe.removeIf(Recipe -> Recipe.matches(itemStack));
    }

    @ZenMethod
    public ProjTraitRepresentation register() {
        ProjTrait trait = new ProjTrait(identifier, color, maxLevel, countPerLevel);
        trait.onLaunch = this.onLaunch;
        trait.onMovement = this.onMovement;
        trait.onProjectileUpdate = this.onProjectileUpdate;
        trait.afterProjHit = this.afterProjHit;
        //trait.applyEffect = this.applyEffect;
        trait.hidden = this.hidden;
        trait.localizedName = this.localizedName;
        trait.localizedDescription = this.localizedDescription;

        for (Recipe recipes : recipe) {
            trait.addItem(recipes);
        }

        for (RecipeMatch recipe : recipes) {
            trait.addItem(recipe);
        }

        TinkerRegistry.addTrait(trait);

        return new ProjTraitRepresentation(trait);
    }
}

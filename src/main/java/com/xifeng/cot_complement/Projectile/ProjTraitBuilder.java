package com.xifeng.cot_complement.Projectile;

import com.xifeng.cot_complement.utils.Recipe;
import com.xifeng.cot_complement.utils.Function;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
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

    @ZenProperty
    public String localizedName = null;

    @ZenProperty
    public String localizedDescription = null;

    private List<Recipe> recipe = new ArrayList<>();

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
    public void removeItem(IItemStack itemStack) {
        recipe.removeIf(Recipe -> Recipe.matches(itemStack));
    }

    @ZenMethod
    public ProjTraitRepresentation register() {
        ProjTrait trait = new ProjTrait(identifier, color, maxLevel, countPerLevel);

        trait.hidden = this.hidden;
        trait.localizedName = this.localizedName;
        trait.localizedDescription = this.localizedDescription;
        trait.onLaunch = this.onLaunch;
        trait.onProjectileUpdate = this.onProjectileUpdate;
        trait.onMovement = this.onMovement;
        trait.afterProjHit = this.afterProjHit;
        for (Recipe recipes : recipe) {
            trait.addItem(recipes);
        }

        TinkerRegistry.addTrait(trait);

        return new ProjTraitRepresentation(trait);
    }
}

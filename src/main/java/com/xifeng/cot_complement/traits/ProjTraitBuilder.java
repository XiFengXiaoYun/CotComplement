package com.xifeng.cot_complement.traits;

import com.xifeng.cot_complement.utils.CCRecipeMatch;
import com.xifeng.cot_complement.utils.Functions;
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

@ZenClass("mods.cc.ProjTraitBuilder")
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
    public Functions.OnLaunch onLaunch = null;

    @ZenProperty
    public Functions.OnMovement onMovement = null;

    @ZenProperty
    public Functions.OnProjectileUpdate onProjectileUpdate = null;

    @ZenProperty
    public Functions.AfterHit afterHit = null;

    @ZenProperty
    public String localizedName = null;

    @ZenProperty
    public String localizedDescription = null;

    private List<CCRecipeMatch> recipeMatches = new ArrayList<>();

    public ProjTraitBuilder(String identifier) {
        this.identifier = identifier;
    }

    @ZenMethod
    public static ProjTraitBuilder create(String identifier) {
        return new ProjTraitBuilder(identifier);
    }

    @ZenMethod
    public void addItem(IIngredient ingredient, @Optional(valueLong = 1) int amountNeeded, @Optional(valueLong = 1) int amountMatched) {
        recipeMatches.add(new CCRecipeMatch(ingredient, amountMatched, amountNeeded) {
        });
    }

    @ZenMethod
    public void removeItem(IItemStack itemStack) {
        recipeMatches.removeIf(coTRecipeMatch -> coTRecipeMatch.matches(itemStack));
    }

    @ZenMethod
    public TicTraitRepresentation register() {
        ProjTrait trait = new ProjTrait(identifier, color, maxLevel, countPerLevel);
        trait.onLaunch = this.onLaunch;
        trait.onProjectileUpdate = this.onProjectileUpdate;
        trait.onMovement = this.onMovement;
        trait.afterHit = this.afterHit;
        trait.hidden = this.hidden;
        trait.localizedName = this.localizedName;
        trait.localizedDescription = this.localizedDescription;

        for (CCRecipeMatch recipeMatch : recipeMatches) {
            trait.addItem(recipeMatch);
        }

        TinkerRegistry.addTrait(trait);

        return new TicTraitRepresentation(trait);
    }
}

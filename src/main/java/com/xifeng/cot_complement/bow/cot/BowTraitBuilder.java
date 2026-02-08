package com.xifeng.cot_complement.bow.cot;

import com.xifeng.cot_complement.utils.Function;
import com.xifeng.cot_complement.utils.Recipe;
import com.xifeng.cot_complement.utils.TraitRepresentation;
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

@ZenClass("mods.cc.tic.BowTraitBuilder")
@ZenRegister
@ModOnly("tconstruct")
public class BowTraitBuilder {
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
    public Function.onArrowNock onArrowNock = null;

    @ZenProperty
    public Function.onArrowLoose onArrowLoose = null;

    @ZenProperty
    public Function.calcArrowDamage calcArrowDamage = null;

    @ZenProperty
    public Function.onDrawingBow onDrawingBow = null;

    @ZenProperty
    public Function.CanApplyTogetherTrait canApplyTogetherTrait = null;

    @ZenProperty
    public Function.CanApplyTogetherEnchantment canApplyTogetherEnchantment = null;

    @ZenProperty
    public Function.ExtraInfo extraInfo = null;

    @ZenProperty
    public Function.ApplyToolEffect applyEffect =null;

    @ZenProperty
    public Function.getAttributeModifiers getAttributeModifiers = null;

    @ZenProperty
    public String localizedName = null;

    @ZenProperty
    public String localizedDescription = null;

    private final List<Recipe> recipe = new ArrayList<>();

    public BowTraitBuilder(String identifier) {
        this.identifier = identifier;
    }

    @ZenMethod
    public static BowTraitBuilder create(String identifier) {
        return new BowTraitBuilder(identifier);
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
    public TraitRepresentation register() {
        BowTrait trait = new BowTrait(identifier, color, maxLevel, countPerLevel);
        trait.onArrowNock = onArrowNock;
        trait.onArrowLoose = onArrowLoose;
        trait.onDrawingBow = onDrawingBow;
        trait.calcArrowDamage = calcArrowDamage;
        trait.canApplyTogetherTrait = this.canApplyTogetherTrait;
        trait.canApplyTogetherEnchantment = this.canApplyTogetherEnchantment;
        trait.extraInfo = this.extraInfo;
        trait.applyEffect = this.applyEffect;
        trait.getAttributeModifiers = this.getAttributeModifiers;
        trait.hidden = hidden;
        trait.localizedDescription = localizedDescription;
        trait.localizedName = localizedName;
        for (Recipe recipes : recipe) {
            trait.addItem(recipes);
        }
        TinkerRegistry.addTrait(trait);
        return new TraitRepresentation(trait);
    }
}

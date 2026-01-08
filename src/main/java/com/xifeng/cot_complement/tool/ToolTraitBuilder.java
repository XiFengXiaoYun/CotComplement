package com.xifeng.cot_complement.tool;

import com.xifeng.cot_complement.utils.Recipe;
import com.xifeng.cot_complement.utils.Function;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenProperty;

import java.util.ArrayList;
import java.util.List;

@ZenClass("mods.cc.tic.ToolTraitBuilder")
@ZenRegister
@ModOnly("tconstruct")
public class ToolTraitBuilder {

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

   // @ZenProperty
    //public ModifierAspect aspect = null;

    @ZenProperty
    public Function.AfterBlockBreak afterBlockBreak = null;

    @ZenProperty
    public Function.BeforeBlockBreak beforeBlockBreak = null;

    @ZenProperty
    public Function.BlockHarvestDrops onBlockHarvestDrops = null;

    @ZenProperty
    public Function.Damage calcDamage = null;

    @ZenProperty
    public Function.IsCriticalHit calcCrit = null;

    @ZenProperty
    public Function.MiningSpeed getMiningSpeed = null;

    @ZenProperty
    public Function.OnHit onHit = null;

    @ZenProperty
    public Function.OnUpdate onUpdate = null;

    @ZenProperty
    public Function.AfterHit afterHit = null;

    @ZenProperty
    public Function.KnockBack calcKnockBack = null;

    @ZenProperty
    public Function.OnBlock onBlock = null;

    @ZenProperty
    public Function.OnToolDamage onToolDamage = null;

    @ZenProperty
    public Function.OnToolHeal calcToolHeal = null;

    @ZenProperty
    public Function.OnToolRepair onToolRepair = null;

    @ZenProperty
    public Function.OnPlayerHurt onPlayerHurt = null;

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

    private final List<RecipeMatch> recipes = new ArrayList<>();

    public ToolTraitBuilder(String identifier) {
        this.identifier = identifier;
    }

    @ZenMethod
    public static ToolTraitBuilder create(String identifier) {
        return new ToolTraitBuilder(identifier);
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
    public ToolTraitRepresentation register() {
        ToolTrait trait = new ToolTrait(identifier, color, maxLevel, countPerLevel);
        trait.afterBlockBreak = this.afterBlockBreak;
        trait.beforeBlockBreak = this.beforeBlockBreak;
        trait.onBlockHarvestDrops = this.onBlockHarvestDrops;
        trait.calcDamage = this.calcDamage;
        trait.calcCrit = this.calcCrit;
        trait.getMiningSpeed = this.getMiningSpeed;
        trait.onHit = this.onHit;
        trait.onUpdate = this.onUpdate;
        trait.afterHit = this.afterHit;
        trait.calcKnockBack = this.calcKnockBack;
        trait.onBlock = this.onBlock;
        trait.onToolDamage = this.onToolDamage;
        trait.calcToolHeal = this.calcToolHeal;
        trait.onToolRepair = this.onToolRepair;
        trait.onPlayerHurt = this.onPlayerHurt;
        trait.hidden = this.hidden;
        trait.canApplyTogetherTrait = this.canApplyTogetherTrait;
        trait.canApplyTogetherEnchantment = this.canApplyTogetherEnchantment;
        trait.extraInfo = this.extraInfo;
        trait.applyEffect = this.applyEffect;
        trait.getAttributeModifiers = this.getAttributeModifiers;
        trait.localizedName = this.localizedName;
        trait.localizedDescription = this.localizedDescription;
        //trait.aspect = this.aspect;

        for (Recipe recipes : recipe) {
            trait.addItem(recipes);
        }

        for (RecipeMatch recipeMatch : recipes) {
            trait.addItem(recipeMatch);
        }

        TinkerRegistry.addTrait(trait);

        return new ToolTraitRepresentation(trait);
    }
}

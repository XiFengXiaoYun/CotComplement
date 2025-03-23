package com.xifeng.cot_complement.traits;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.mantle.util.RecipeMatchRegistry;
import slimeknights.tconstruct.library.TinkerRegistry;
import slimeknights.tconstruct.library.modifiers.ProjectileModifierTrait;
import slimeknights.tconstruct.library.traits.IProjectileTrait;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

import java.util.Arrays;

@ZenClass("mods.cc.ProjTrait")
@ZenRegister
@ModOnly("tconstruct")
public class ProjTraitRepresentation {
    private final IProjectileTrait projectileTrait;

    public ProjTraitRepresentation(IProjectileTrait trait) {
        this.projectileTrait = trait;
    }

    @SuppressWarnings("unused")
    public static ProjTraitRepresentation getFromString(String identifier) {
        IProjectileTrait trait = (IProjectileTrait) TinkerRegistry.getTrait(identifier);
        if(trait == null) {
            CraftTweakerAPI.logError("Cannot identify trait " + "<ticontrait:" + identifier + ">");
            return null;
        }
        return new ProjTraitRepresentation(trait);
    }


    @ZenMethod
    public void addItem(IIngredient item, @Optional(valueLong = 1) int amountNeeded, @Optional(valueLong = 1) int amountMatched) {

        if(!(projectileTrait instanceof RecipeMatchRegistry)) {
            CraftTweakerAPI.logError("Cannot add item " + item.toCommandString() + " to trait " + toCommandString());
            return;
        }

        RecipeMatchRegistry trait = (RecipeMatchRegistry) this.projectileTrait;
        if(item instanceof IItemStack) {
            trait.addItem(CraftTweakerMC.getItemStack(item), amountNeeded, amountMatched);
        } else if(item instanceof IOreDictEntry) {
            trait.addItem(((IOreDictEntry) item).getName(), amountNeeded, amountMatched);
        } else {
            for (IItemStack itemStack : item.getItems()) {
                addItem(itemStack, amountNeeded, amountMatched);
            }
        }
    }

    @ZenMethod
    public void addMultiItem(int amountMatched, IItemStack... items) {
        if(!(projectileTrait instanceof RecipeMatchRegistry)){
            CraftTweakerAPI.logError("Cannot add items " + Arrays.toString(items) + " to trait " + toCommandString());
            return;
        }
        RecipeMatchRegistry recipeMatchRegistry = (RecipeMatchRegistry) this.projectileTrait;
        recipeMatchRegistry.addRecipeMatch(new RecipeMatch.ItemCombination(amountMatched, CraftTweakerMC.getItemStacks(items)));
    }

    @ZenGetter("identifier")
    public String getIdentifier() {
        return projectileTrait.getIdentifier();
    }

    @ZenGetter("commandString")
    public String toCommandString() {
        return "<ticontrait:" + projectileTrait.getIdentifier() + ">";
    }

    @ZenMethod
    public ProjTraitData getData(IItemStack itemStack) {
        if(projectileTrait instanceof ProjectileModifierTrait) {
            return new ProjTraitData(((ProjectileModifierTrait) projectileTrait).getData(CraftTweakerMC.getItemStack(itemStack)));
        }
        CraftTweakerAPI.logError("Trait " + projectileTrait.getIdentifier() + " is not applicable to the getData function!");
        return null;
    }

    public IProjectileTrait getProjectileTrait() {
        return projectileTrait;
    }
}

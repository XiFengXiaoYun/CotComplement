package com.xifeng.cot_complement.bow.cot;

import com.xifeng.cot_complement.bow.modifier.BowModifierTrait;
import com.xifeng.cot_complement.bow.trait.IBowTrait;
import com.xifeng.cot_complement.utils.TraitDataRepresentation;
import crafttweaker.CraftTweakerAPI;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.oredict.IOreDictEntry;
import slimeknights.mantle.util.RecipeMatchRegistry;
import stanhebben.zenscript.annotations.Optional;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.cc.tic.BowTrait")
@ZenRegister
@ModOnly("tconstruct")
public class BowTraitRepresentation {
    private final IBowTrait bowTrait;

    public BowTraitRepresentation(IBowTrait bowTrait) {
        this.bowTrait = bowTrait;
    }

    @ZenMethod
    public void addItem(IIngredient item, @Optional(valueLong = 1) int amountNeeded, @Optional(valueLong = 1) int amountMatched) {

        if(!(bowTrait instanceof RecipeMatchRegistry)) {
            CraftTweakerAPI.logError("Cannot add item " + item.toCommandString() + " to trait " + toCommandString());
            return;
        }

        RecipeMatchRegistry trait = (RecipeMatchRegistry) this.bowTrait;
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

    @ZenGetter("identifier")
    public String getIdentifier() {
        return bowTrait.getIdentifier();
    }

    @ZenGetter("commandString")
    public String toCommandString() {
        return "<ticontrait:" + bowTrait.getIdentifier() + ">";
    }

    @ZenMethod
    public TraitDataRepresentation getData(IItemStack itemStack) {
        if(bowTrait instanceof BowModifierTrait) {
            return new TraitDataRepresentation(((BowModifierTrait) bowTrait).getData(CraftTweakerMC.getItemStack(itemStack)));
        }
        CraftTweakerAPI.logError("Trait " + bowTrait.getIdentifier() + " is not applicable to the getData function!");
        return null;
    }


}

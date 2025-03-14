package com.xifeng.cot_complement.utils;

import crafttweaker.api.item.IIngredient;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import slimeknights.mantle.util.RecipeMatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class CCRecipeMatch extends RecipeMatch {
    public final IIngredient ingredient;
    public CCRecipeMatch(IIngredient ingredients, int amountMatched, int amountNeeded) {
        super(amountMatched, amountNeeded);
        this.ingredient = ingredients;
    }
    @Override
    public List<ItemStack> getInputs() {
        List<ItemStack> output = new ArrayList<>();
        if(ingredient != null) {
            for (IItemStack itemStack : ingredient.getItems()) {
                if(itemStack != null) {
                    output.add(CraftTweakerMC.getItemStack(itemStack));
                }
            }
        }
        return output;
    }
    @Override
    public Optional<Match> matches(NonNullList<ItemStack> stacks) {
        int stillNeeded = amountNeeded;
        List<ItemStack> found = new ArrayList<>();
        for (ItemStack item : stacks) {
            if(ingredient != null && ingredient.matchesExact(CraftTweakerMC.getIItemStack(item))) {
                ItemStack copy = item.copy();
                copy.setCount(Math.min(copy.getCount(), stillNeeded));
                stillNeeded -= copy.getCount();
                found.add(copy);
            }
        }
        return stillNeeded > 0 ? Optional.empty() : Optional.of(new Match(found, amountMatched));
    }
    public boolean matches(IItemStack itemStack) {
        if(ingredient == null) {
            return itemStack == null;
        }
        return ingredient.matches(itemStack);
    }
}

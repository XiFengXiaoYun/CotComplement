package com.xifeng.cot_complement.utils;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.TinkerGuiException;
import slimeknights.tconstruct.library.tinkering.Category;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.cc.tic.Aspect")
@ZenRegister
@ModOnly("tconstruct")
public class Aspect extends ModifierAspect {
    public ModifierAspect aspect;
    public Aspect(ModifierAspect aspect) {
        this.aspect = aspect;
    }

    /*
    @ZenMethod
    public static ModifierAspect freeModifierAspect(int required) {
        return new ModifierAspect.FreeModifierAspect(required);
    }

    @ZenMethod
    public static ModifierAspect CategoryAspect(String... categories) {
        Category[] cat = new Category[categories.length];
        for (int  i = 0; i < categories.length; i++) {
            cat[i] = new Category(categories[i]);
        }
        return new ModifierAspect.CategoryAspect(cat);
    }

    @ZenMethod
    public static ModifierAspect CategoryAnyAspect(String... categories) {
        Category[] cat = new Category[categories.length];
        for (int  i = 0; i < categories.length; i++) {
            cat[i] = new Category(categories[i]);
        }
        return new ModifierAspect.CategoryAnyAspect(cat);
    }

     */

    @Override
    public boolean canApply(ItemStack itemStack, ItemStack itemStack1) {
        return false;
    }

    @Override
    public void updateNBT(NBTTagCompound nbtTagCompound, NBTTagCompound nbtTagCompound1) {

    }
}

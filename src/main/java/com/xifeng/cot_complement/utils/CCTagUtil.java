package com.xifeng.cot_complement.utils;

import com.google.common.collect.Multimap;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.entity.attribute.IEntityAttributeModifier;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tools.ToolNBT;
import stanhebben.zenscript.annotations.*;

import slimeknights.tconstruct.library.utils.TagUtil;

import java.util.UUID;

@ZenClass("mods.cc.CCTagUtil")
@ZenRegister
@ModOnly("tconstruct")
public class CCTagUtil {
    @ZenMethod
    public static IData getDataByNBT(NBTTagCompound nbt) {
        return CraftTweakerMC.getIData(nbt);
    }

    @ZenMethod
    public static ToolNBT getToolNBT(NBTTagCompound root) {
        return new ToolNBT(TagUtil.getToolTag(root));
    }
/*
    @ZenMethod
    public static ModifierAspect getAspect()

 */

    @ZenMethod
    public static void addModifier(Multimap<String, AttributeModifier> attributeMap, String attributeName, IEntityAttributeModifier entityModifier, String uuid) {
        AttributeModifier modifier1 = new AttributeModifier(UUID.fromString(uuid), entityModifier.getName(), entityModifier.getAmount(), entityModifier.getOperation());
        attributeMap.put(attributeName, modifier1);
    }

    @ZenMethod
    public static void addModifier(Multimap<String, AttributeModifier> attributeMap, String attributeName, String uuid, String modifierName, double amount, int operation) {
        AttributeModifier modifier = new AttributeModifier(UUID.fromString(uuid), modifierName, amount, operation);
        attributeMap.put(attributeName, modifier);
    }

    @ZenMethod
    public static IData getModMap(IData data) {
        NBTTagCompound root = CraftTweakerMC.getNBTCompound(data);
        return CraftTweakerMC.getIData(TagUtil.getModifiersTagList(root));
    }

    @ZenMethod
    public static IData getModMap(IItemStack item) {
        ItemStack itemStack = CraftTweakerMC.getItemStack(item);
        return CraftTweakerMC.getIData(TagUtil.getModifiersTagList(itemStack));
    }

    @ZenMethod
    public static IData getBaseModMap(IData data) {
        NBTTagCompound root = CraftTweakerMC.getNBTCompound(data);
        return CraftTweakerMC.getIData(TagUtil.getBaseModifiersTagList(root));
    }

    @ZenMethod
    public static IData getBaseModMap(IItemStack item) {
        ItemStack itemStack = CraftTweakerMC.getItemStack(item);
        return CraftTweakerMC.getIData(TagUtil.getBaseModifiersTagList(itemStack));
    }
//最终方案！
    @ZenMethod
    public static void setFloat(NBTTagCompound root, float amount, String key) {
        root.getCompoundTag("Stats").setFloat(key, amount);
    }

    @ZenMethod
    public static void setInt(NBTTagCompound root, int amount, String key) {
        root.getCompoundTag("Stats").setInteger(key, amount);
    }
}


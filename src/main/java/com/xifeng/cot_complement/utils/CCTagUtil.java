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
import slimeknights.tconstruct.library.tools.ProjectileLauncherNBT;
import slimeknights.tconstruct.library.tools.ToolNBT;
import stanhebben.zenscript.annotations.*;

import slimeknights.tconstruct.library.utils.TagUtil;

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

    @ZenMethod
    public static void addModifier(Multimap<String, AttributeModifier> attributeMap, String attributeName, IEntityAttributeModifier entityModifier) {
        AttributeModifier modifier = CraftTweakerMC.getAttributeModifier(entityModifier);
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

    @ZenMethod
    public static ProjectileLauncherNBT getLauncherNBT(NBTTagCompound root) {
        return new ProjectileLauncherNBT(TagUtil.getToolTag(root));
    }
//工具类型
    @ZenMethod
    public static void setFloat(NBTTagCompound root, ToolNBT toolNBT, float amount, String key) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setFloat(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }

    @ZenMethod
    public static void setInt(NBTTagCompound root, ToolNBT toolNBT, int amount, String key) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setInteger(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }
//发射器类型
    @ZenMethod
    public static void setFloat(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float amount, String key) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }
}


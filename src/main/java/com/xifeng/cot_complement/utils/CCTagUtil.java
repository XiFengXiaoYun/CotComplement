package com.xifeng.cot_complement.utils;

import com.google.common.collect.Multimap;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.entity.attribute.IEntityAttributeModifier;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.ai.attributes.AttributeModifier;
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
    public static ProjectileLauncherNBT getLauncherNBT(NBTTagCompound root) {
        return new ProjectileLauncherNBT(TagUtil.getToolTag(root));
    }
//工具类型
    @ZenMethod
    public static float getFloat(ToolNBT toolNBT, String stats, String key) {
        return toolNBT.get().getCompoundTag(stats).getFloat(key);
    }

    @ZenMethod
    public static int getInt(ToolNBT toolNBT, String stats, String key) {
        return toolNBT.get().getCompoundTag(stats).getInteger(key);
    }

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
    public static float getFloat(ProjectileLauncherNBT projectileLauncherNBT, String stats, String key) {
        return projectileLauncherNBT.get().getCompoundTag(stats).getFloat(key);
    }

    @ZenMethod
    public static void setFloat(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float amount, String key) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }
}


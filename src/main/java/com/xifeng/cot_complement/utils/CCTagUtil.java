package com.xifeng.cot_complement.utils;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.minecraft.CraftTweakerMC;
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
    public static ProjectileLauncherNBT getLauncherNBT(NBTTagCompound root) {
        return new ProjectileLauncherNBT(TagUtil.getToolTag(root));
    }
//工具类型
    @ZenMethod
    public static float getAttack(ToolNBT toolNBT) {
        return toolNBT.attack;
    }

    @ZenMethod
    public static void setFloat(NBTTagCompound root, ToolNBT toolNBT, float amount, String key) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setFloat(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }

    @ZenMethod
    public static float getAttackSpeed(ToolNBT toolNBT) {
        return toolNBT.attackSpeedMultiplier;
    }

    @ZenMethod
    public static float getSpeed(ToolNBT toolNBT) {
        return toolNBT.speed;
    }

    @ZenMethod
    public static int getDurability(ToolNBT toolNBT) {
        return toolNBT.durability;
    }

    @ZenMethod
    public static void setInt(NBTTagCompound root, ToolNBT toolNBT, int amount, String key) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setInteger(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }

    @ZenMethod
    public static int getHarvestLevel(ToolNBT toolNBT) {
        return toolNBT.harvestLevel;
    }

    @ZenMethod
    public static int getModifiers(ToolNBT toolNBT) {
        return toolNBT.modifiers;
    }
//发射器类型
    @ZenMethod
    public static float getDrawSpeed(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.drawSpeed;
    }

    @ZenMethod
    public static void setLauncherFloat(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float amount, String key) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat(key, amount);
        root.getCompoundTag("Stats").setTag(key, nbt.getTag(key));
    }

    @ZenMethod
    public static float getRange(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.range;
    }

    @ZenMethod
    public static float getBonusDmg(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.bonusDamage;
    }
}


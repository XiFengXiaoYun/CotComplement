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
        return CraftTweakerMC.getIDataModifyable(nbt);
    }

    @ZenMethod
    public static ToolNBT getToolNBT(NBTTagCompound root) {
        return new ToolNBT(TagUtil.getToolTag(root));
    }

    @ZenMethod
    public static float getAttack(ToolNBT toolNBT) {
        return toolNBT.attack;
    }

    @ZenMethod
    public static void setAttack(NBTTagCompound root, ToolNBT toolNBT, float attack) {
        NBTTagCompound nbt = toolNBT.get();
        System.out.println(nbt);
        nbt.setFloat("Attack", attack);
        root.getCompoundTag("Stats").setTag("Attack", nbt.getTag("Attack"));
    }

    @ZenMethod
    public static float getAttackSpeed(ToolNBT toolNBT) {
        return toolNBT.attackSpeedMultiplier;
    }

    @ZenMethod
    public static void setAttackSpeedMultiplier(NBTTagCompound root, ToolNBT toolNBT, float attackSpeedMultiplier) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setFloat("AttackSpeedMultiplier", attackSpeedMultiplier);
        root.getCompoundTag("Stats").setTag("AttackSpeedMultiplier", nbt.getTag("AttackSpeedMultiplier"));
    }

    @ZenMethod
    public static float getSpeed(ToolNBT toolNBT) {
        return toolNBT.speed;
    }

    @ZenMethod
    public static void setSpeed(NBTTagCompound root, ToolNBT toolNBT, float speed) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setFloat("MiningSpeed", speed);
        root.getCompoundTag("Stats").setTag("MiningSpeed", nbt.getTag("MiningSpeed"));
    }

    @ZenMethod
    public static int getDurability(ToolNBT toolNBT) {
        return toolNBT.durability;
    }

    @ZenMethod
    public static void setDurability(NBTTagCompound root, ToolNBT toolNBT, int dur) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setInteger("Durability", dur);
        root.getCompoundTag("Stats").setTag("Durability", nbt.getTag("Durability"));
    }

    @ZenMethod
    public static int getHarvestLevel(ToolNBT toolNBT) {
        return toolNBT.harvestLevel;
    }

    @ZenMethod
    public static void setHarvestLevel(NBTTagCompound root, ToolNBT toolNBT, int level) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setInteger("HarvestLevel", level);
        root.getCompoundTag("Stats").setTag("HarvestLevel", nbt.getTag("HarvestLevel"));
    }

    @ZenMethod
    public static int getModifiers(ToolNBT toolNBT) {
        return toolNBT.modifiers;
    }

    @ZenMethod
    public static void setModifiers(NBTTagCompound root, ToolNBT toolNBT, int mod) {
        NBTTagCompound nbt = toolNBT.get();
        nbt.setInteger("FreeModifiers", mod);
        root.getCompoundTag("Stats").setTag("FreeModifiers", nbt.getTag("FreeModifiers"));
    }

    @ZenMethod
    public static float getDrawSpeed(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.drawSpeed;
    }

    @ZenMethod
    public static void setDrawSpeed(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float speed) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat("DrawSpeed", speed);
        root.getCompoundTag("Stats").setTag("DrawSpeed", nbt.getTag("DrawSpeed"));
    }

    @ZenMethod
    public static float getRange(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.range;
    }

    @ZenMethod
    public static void setRange(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float range) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat("Range", range);
        root.getCompoundTag("Stats").setTag("Range", nbt.getTag("Range"));
    }

    @ZenMethod
    public static float getBonusDmg(ProjectileLauncherNBT projectileLauncherNBT) {
        return projectileLauncherNBT.bonusDamage;
    }

    @ZenMethod
    public static void setBonusDmg(NBTTagCompound root, ProjectileLauncherNBT projectileLauncherNBT, float dmg) {
        NBTTagCompound nbt = projectileLauncherNBT.get();
        nbt.setFloat("ProjectileBonusDamage", dmg);
        root.getCompoundTag("Stats").setTag("ProjectileBonusDamage", nbt.getTag("ProjectileBonusDamage"));
    }
}



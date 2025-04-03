package com.xifeng.cot_complement.utils;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.*;

import static slimeknights.tconstruct.library.utils.TagUtil.getToolTag;
import static slimeknights.tconstruct.library.utils.TagUtil.setToolTag;

@ZenClass("mods.cc.CCTagUtil")
@ZenRegister
@ModOnly("tconstruct")
public class CCTagUtil {
    private CCTagUtil() {
    }
    public static IToolNBT getToolStats(NBTTagCompound nbt) {
        return new IToolNBT(getToolTag(nbt));
    }

    @ZenMethod
    public static IData getDataByNBT(NBTTagCompound nbt) {
        return CraftTweakerMC.getIDataModifyable(nbt);
    }

    @ZenMethod
    public static IToolNBT getToolTags(NBTTagCompound root) {
        return getToolStats(root);
    }
    @ZenMethod
    public static void setToolTags(NBTTagCompound rootTag, NBTTagCompound newTag) {
        if (rootTag != null) {
            setToolTag(rootTag, newTag);
        }
    }
}



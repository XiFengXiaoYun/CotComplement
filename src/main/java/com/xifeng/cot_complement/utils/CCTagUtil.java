package com.xifeng.cot_complement.utils;
/*
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.data.NBTConverter;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import slimeknights.tconstruct.library.utils.TagUtil;
import slimeknights.tconstruct.library.utils.Tags;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("mods.cc.TagUtil")
@ZenRegister
@ModOnly("tconstruct")
public class CCTagUtil {
    private final NBTTagCompound toolData;
    private ToolNBT nbt;

    public CCTagUtil(NBTTagCompound toolData) {
        this.toolData = toolData;
    }

    public NBTTagCompound getToolData() {
        return toolData;
    }

    @ZenMethod("getToolTag")
    public IData getToolTag(IData root) {
        NBTTagCompound rootTag = CraftTweakerMC.getNBTCompound(root);
        return CraftTweakerMC.getIData(TagUtil.getTagSafe(rootTag, Tags.TOOL_DATA));
    }

    @ZenMethod("setToolTag")
    public void setToolTag(IData root, IData newTag) {
        if (root != null) {
            NBTTagCompound rootTag = CraftTweakerMC.getNBTCompound(root);
            rootTag.setTag(Tags.TOOL_DATA, NBTConverter.from(newTag));
        }
    }

    @ZenMethod("getToolStats")
    public ToolNBT getToolStats(IData root) {
        return new ToolNBT(TagUtil.getToolTag(CraftTweakerMC.getNBTCompound(root)));
    }

    @ZenMethod("getToolStatsOriginal")
    public ToolNBT getToolStatsOriginal(IData root) {
        return new ToolNBT(TagUtil.getTagSafe(CraftTweakerMC.getNBTCompound(root), Tags.TOOL_DATA_ORIG));
    }
}

 */

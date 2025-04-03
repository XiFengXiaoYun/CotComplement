package com.xifeng.cot_complement.utils;

import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import net.minecraft.nbt.NBTTagCompound;
import slimeknights.tconstruct.library.tools.ToolNBT;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;
import stanhebben.zenscript.annotations.ZenSetter;

@ZenClass("mods.cc.IToolNBT")
@ZenRegister
@ModOnly("tconstruct")
public class IToolNBT extends ToolNBT {
    public int durability = super.durability;
    public int harvestLevel = super.harvestLevel;
    public float attack = super.attack;
    public float speed = super.speed;
    public float attackSpeedMod = super.attackSpeedMultiplier;
    public int mod = super.modifiers;
    private final NBTTagCompound parent;

    public IToolNBT(NBTTagCompound tag) {
        this.read(tag);
        this.parent = tag;
    }

    @ZenMethod
    public NBTTagCompound getTag() {
        return super.get();
    }

    @ZenGetter("attack")
    public float getAttack() {
        return super.attack;
    }

    @ZenSetter("attack")
    public void setAttack(float attack) {
        super.attack = attack;
    }

    @ZenGetter("attackSpeed")
    public float getAttackSpeed() {
        return super.attackSpeedMultiplier;
    }

    @ZenSetter("attackSpeed")
    public void setAttackSpeed(float attackSpeed) {
        super.attackSpeedMultiplier = attackSpeed;
    }

    @ZenGetter("speed")
    public float getSpeed() {
        return super.speed;
    }

    @ZenSetter("speed")
    public void setSpeed(float speed) {
        super.speed = speed;
    }

    @ZenGetter("durability")
    public int getDurability() {
        return super.durability;
    }

    @ZenSetter("durability")
    public void setDurability(int dur) {
        super.durability = dur;
    }

    @ZenGetter("harvestLevel")
    public int getHarvestLevel() {
        return super.harvestLevel;
    }

    @ZenSetter("harvestLevel")
    public void setHarvestLevel(int level) {
        super.harvestLevel = level;
    }

    @ZenGetter("modifiers")
    public int getMod() {
        return super.modifiers;
    }

    @ZenSetter("modifiers")
    public void setMod(int modifier) {
        super.modifiers = modifier;
    }

    public NBTTagCompound getParent() {
        return parent;
    }
}

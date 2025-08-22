package com.xifeng.cot_complement.events;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IPlayerEvent;
import crafttweaker.api.item.IItemStack;
import stanhebben.zenscript.annotations.ZenClass;
import stanhebben.zenscript.annotations.ZenGetter;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenClass("mods.cc.event.IBowShootEvent")
@ZenRegister
public interface IBowShootEvent extends IPlayerEvent {
    @ZenGetter("ammo")
    @ZenMethod
    IItemStack getAmmo();

    @ZenGetter("bow")
    @ZenMethod
    IItemStack getBow();

    @ZenGetter("useTime")
    @ZenMethod
    int getUseTime();

    @ZenGetter("projectileCount")
    @ZenMethod
    int getProjCount();

    @ZenGetter("baseInaccuracy")
    @ZenMethod
    float getBaseInaccuracy();

    @ZenGetter("bonusInaccuracy")
    @ZenMethod
    float getBonusInaccuracy();

    @ZenGetter("consumeAmmoPerProjectile")
    @ZenMethod
    boolean consumeAmmoPerProjectile();

    @ZenGetter("consumeDurabilityPerProjectile")
    @ZenMethod
    boolean consumeDurabilityPerProjectile();

    @ZenMethod
    void setCount(int count);

    @ZenMethod
    void setBonusInaccuracy(float inaccuracy);

    @ZenMethod
    void setConsumeAmmo(boolean consumeAmmo);

    @ZenMethod
    void setConsumeDurability(boolean consumeDurability);
}

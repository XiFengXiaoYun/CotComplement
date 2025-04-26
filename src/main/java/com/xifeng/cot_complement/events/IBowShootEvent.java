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
     IItemStack getAmmo();

    @ZenGetter("bow")
    IItemStack getBow();

    @ZenGetter("useTime")
    int getUseTime();

    @ZenGetter("projectileCount")
    int getProjCount();

    @ZenGetter("baseInaccuracy")
    float getBaseInaccuracy();

    @ZenGetter("bonusInaccuracy")
    float getBonusInaccuracy();

    @ZenGetter("consumeAmmoPerProjectile")
    boolean consumeAmmoPerProjectile();

    @ZenGetter("consumeDurabilityPerProjectile")
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

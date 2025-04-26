package com.xifeng.cot_complement.events;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.api.player.IPlayer;
import slimeknights.tconstruct.library.events.TinkerToolEvent;
import stanhebben.zenscript.annotations.ZenClass;

@ZenClass("mods.cc.event.onBowShootEvent")
@ZenRegister
public class OnBowShootEvent implements IBowShootEvent {
    private final TinkerToolEvent.OnBowShoot event;

    public OnBowShootEvent(TinkerToolEvent.OnBowShoot event) {
        this.event = event;
    }

    @Override
    public IItemStack getAmmo() {
        return CraftTweakerMC.getIItemStack(event.ammo);
    }

    @Override
    public IItemStack getBow() {
        return CraftTweakerMC.getIItemStack(event.itemStack);
    }

    @Override
    public IPlayer getPlayer() {
        return CraftTweakerMC.getIPlayer(event.entityPlayer);
    }

    @Override
    public int getUseTime() {
        return event.useTime;
    }

    @Override
    public int getProjCount() {
        return event.projectileCount;
    }

    @Override
    public float getBaseInaccuracy() {
        return event.getBaseInaccuracy();
    }

    @Override
    public float getBonusInaccuracy() {
        return event.bonusInaccuracy;
    }

    @Override
    public boolean consumeAmmoPerProjectile() {
        return event.consumeAmmoPerProjectile;
    }

    @Override
    public boolean consumeDurabilityPerProjectile() {
        return event.consumeDurabilityPerProjectile;
    }

    @Override
    public void setCount(int count) {
        event.setProjectileCount(count);
    }

    @Override
    public void setBonusInaccuracy(float inaccuracy) {
        event.setBonusInaccuracy(inaccuracy);
    }

    @Override
    public void setConsumeAmmo(boolean consumeAmmo) {
        event.consumeAmmoPerProjectile = consumeAmmo;
    }

    @Override
    public void setConsumeDurability(boolean consumeDurability) {
        event.consumeDurabilityPerProjectile = consumeDurability;
    }
}

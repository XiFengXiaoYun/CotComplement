package com.xifeng.cot_complement.utils;

import com.xifeng.cot_complement.traits.TicTraitRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.entity.IEntityArrow;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;

public class Functions {

    @ZenClass("mods.cc.traits.OnLaunch")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnLaunch {
        void handle(TicTraitRepresentation thisTrait, IEntityArrow projectileBase, IWorld world, IEntityLivingBase shooter);
    }

    @ZenClass("mods.cc.traits.OnProjectileUpdate")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnProjectileUpdate {
        void handle(TicTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack toolStack);
    }

    @ZenClass("mods.cc.traits.OnMovement")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnMovement {
        void handle(TicTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, double slowdown);
    }

    @ZenClass("mods.cc.traits.AfterHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterHit {
        void handle(TicTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack ammoStack, IEntityLivingBase shooter, IEntity target, double impactSpeed);
    }

}

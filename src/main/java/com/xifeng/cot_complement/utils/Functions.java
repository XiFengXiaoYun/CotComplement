package com.xifeng.cot_complement.utils;

import com.xifeng.cot_complement.traits.ProjTraitRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.data.IData;
import crafttweaker.api.enchantments.IEnchantmentDefinition;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.entity.IEntityArrow;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;

public class Functions {

    @ZenClass("mods.cc.traits.ApplyEffect")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyEffect {
        void handle(IData rootCompound, IData modifierTag);
    }

    @ZenClass("mods.cc.traits.OnLaunch")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnLaunch {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectileBase, IWorld world, IEntityLivingBase shooter);
    }

    @ZenClass("mods.cc.traits.OnProjectileUpdate")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnProjectileUpdate {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack toolStack);
    }

    @ZenClass("mods.cc.traits.OnMovement")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnMovement {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, double slowdown);
    }

    @ZenClass("mods.cc.traits.AfterProjHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterProjHit {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack ammoStack, IEntityLivingBase shooter, IEntity target, double impactSpeed);
    }


    @ZenClass("mods.cc.traits.ApplyTogetherProjTrait")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherProjTrait {
        boolean handle(ProjTraitRepresentation thisTrait, String otherTrait);
    }

    @ZenClass("mods.cc.traits.ApplyTogetherProjEnchantment")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherProjEnchantment {
        boolean handle(ProjTraitRepresentation thisTrait, IEnchantmentDefinition enchantmentDefinition);
    }

    @ZenClass("mods.cc.traits.ExtraProjInfo")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ExtraProjInfo {
        String[] handle(ProjTraitRepresentation thisTrait, IItemStack item, IData tool);
    }

}

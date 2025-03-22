package com.xifeng.cot_complement.utils;

import com.xifeng.cot_complement.traits.ProjTraitRepresentation;
import com.xifeng.cot_complement.traits.ToolTraitRepresentation;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.data.IData;
import crafttweaker.api.enchantments.IEnchantmentDefinition;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.entity.IEntityArrow;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.event.BlockBreakEvent;
import crafttweaker.api.event.BlockHarvestDropsEvent;
import crafttweaker.api.event.EntityLivingHurtEvent;
import crafttweaker.api.event.PlayerBreakSpeedEvent;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import stanhebben.zenscript.annotations.ZenClass;

public class Functions {

    @ZenClass("mods.tconstruct.traits.Update")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnUpdate {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IWorld world, IEntity entity, int itemSlot, boolean isSelected);
    }

    @ZenClass("mods.tconstruct.traits.MiningSpeed")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface MiningSpeed {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, PlayerBreakSpeedEvent event);
    }

    @ZenClass("mods.tconstruct.traits.BeforeBlockBreak")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface BeforeBlockBreak {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, BlockBreakEvent event);
    }

    @ZenClass("mods.tconstruct.traits.AfterBlockBreak")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterBlockBreak {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IWorld world, IBlockState blockState, IBlockPos pos, IEntityLivingBase miner, boolean wasEffective);
    }

    @ZenClass("mods.tconstruct.traits.BlockHarvestDrops")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface BlockHarvestDrops {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, BlockHarvestDropsEvent event);
    }

    @ZenClass("mods.tconstruct.traits.IsCriticalHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface IsCriticalHit {
        boolean handle(ToolTraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target);
    }

    @ZenClass("mods.tconstruct.traits.Damage")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface Damage {
        float handle(ToolTraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float originalDamage, float currentDamage, boolean isCritical);
    }
    @ZenClass("mods.tconstruct.traits.OnHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnHit {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damage, boolean isCritical);
    }

    @ZenClass("mods.tconstruct.traits.AfterHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterHit {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit);
    }

    @ZenClass("mods.tconstruct.traits.KnockBack")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface KnockBack {
        float handle(ToolTraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damage, float knockback, float newKnockback, boolean isCritical);
    }

    @ZenClass("mods.tconstruct.traits.OnBlock")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnBlock {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IPlayer attacker, EntityLivingHurtEvent event);
    }

    @ZenClass("mods.tconstruct.traits.OnToolDamage")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolDamage {
        int handle(ToolTraitRepresentation thisTrait, IItemStack tool, int damage, int newDamage, IEntityLivingBase entity);
    }


    @ZenClass("mods.tconstruct.traits.OnToolHeal")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolHeal {
        int handle(ToolTraitRepresentation thisTrait, IItemStack tool, int damage, int newDamage, IEntityLivingBase entity);
    }

    @ZenClass("mods.tconstruct.traits.OnToolRepair")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolRepair {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, int amount);
    }

    @ZenClass("mods.tconstruct.traits.OnPlayerHurt")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnPlayerHurt {
        void handle(ToolTraitRepresentation thisTrait, IItemStack tool, IPlayer player, IEntityLivingBase attacker, EntityLivingHurtEvent event);
    }

    @ZenClass("mods.tconstruct.traits.ApplyTogetherToolTrait")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherToolTrait {
        boolean handle(ToolTraitRepresentation thisTrait, String otherTrait);
    }

    @ZenClass("mods.tconstruct.traits.ApplyTogetherToolEnchantment")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherToolEnchantment {
        boolean handle(ToolTraitRepresentation thisTrait, IEnchantmentDefinition enchantmentDefinition);
    }

    @ZenClass("mods.tconstruct.traits.ExtraToolInfo")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ExtraToolInfo {
        String[] handle(ToolTraitRepresentation thisTrait, IItemStack item, IData tool);
    }

    @ZenClass("mods.tconstruct.traits.ApplyEffect")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyEffect {
        void handle(IData rootCompound, IData modifierTag);
    }

    @ZenClass("mods.tconstruct.traits.OnLaunch")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnLaunch {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectileBase, IWorld world, IEntityLivingBase shooter);
    }

    @ZenClass("mods.tconstruct.traits.OnProjectileUpdate")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnProjectileUpdate {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack toolStack);
    }

    @ZenClass("mods.tconstruct.traits.OnMovement")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnMovement {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, double slowdown);
    }

    @ZenClass("mods.tconstruct.traits.AfterProjHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterProjHit {
        void handle(ProjTraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack ammoStack, IEntityLivingBase shooter, IEntity target, double impactSpeed);
    }


    @ZenClass("mods.tconstruct.traits.ApplyTogetherProjTrait")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherProjTrait {
        boolean handle(ProjTraitRepresentation thisTrait, String otherTrait);
    }

    @ZenClass("mods.tconstruct.traits.ApplyTogetherProjEnchantment")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyTogetherProjEnchantment {
        boolean handle(ProjTraitRepresentation thisTrait, IEnchantmentDefinition enchantmentDefinition);
    }

    @ZenClass("mods.tconstruct.traits.ExtraProjInfo")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ExtraProjInfo {
        String[] handle(ProjTraitRepresentation thisTrait, IItemStack item, IData tool);
    }

}

package com.xifeng.cot_complement.utils;

import com.google.common.collect.Multimap;
import crafttweaker.annotations.ModOnly;
import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.block.IBlockState;
import crafttweaker.api.data.IData;
import crafttweaker.api.enchantments.IEnchantmentDefinition;
import crafttweaker.api.entity.IEntity;
import crafttweaker.api.entity.IEntityArrow;
import crafttweaker.api.entity.IEntityEquipmentSlot;
import crafttweaker.api.entity.IEntityLivingBase;
import crafttweaker.api.event.BlockBreakEvent;
import crafttweaker.api.event.BlockHarvestDropsEvent;
import crafttweaker.api.event.EntityLivingHurtEvent;
import crafttweaker.api.event.PlayerBreakSpeedEvent;
import crafttweaker.api.item.IItemStack;
import crafttweaker.api.player.IPlayer;
import crafttweaker.api.world.IBlockPos;
import crafttweaker.api.world.IWorld;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.nbt.NBTTagCompound;
import stanhebben.zenscript.annotations.ZenClass;

public class Function {


    @ZenClass("mods.cc.traits.OnLaunch")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnLaunch {
        void handle(TraitRepresentation thisTrait, IEntityArrow projectileBase, IWorld world, IEntityLivingBase shooter);
    }

    @ZenClass("mods.cc.traits.OnProjectileUpdate")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnProjectileUpdate {
        void handle(TraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack toolStack);
    }

    @ZenClass("mods.cc.traits.OnMovement")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnMovement {
        void handle(TraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, double slowdown);
    }

    @ZenClass("mods.cc.traits.AfterProjHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterProjHit {
        void handle(TraitRepresentation thisTrait, IEntityArrow projectile, IWorld world, IItemStack ammoStack, IEntityLivingBase shooter, IEntity target, double impactSpeed);
    }


    @ZenClass("mods.cc.traits.Update")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnUpdate {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IWorld world, IEntity entity, int itemSlot, boolean isSelected);
    }

    @ZenClass("mods.cc.traits.MiningSpeed")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface MiningSpeed {
        void handle(TraitRepresentation thisTrait, IItemStack tool, PlayerBreakSpeedEvent event);
    }

    @ZenClass("mods.cc.traits.BeforeBlockBreak")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface BeforeBlockBreak {
        void handle(TraitRepresentation thisTrait, IItemStack tool, BlockBreakEvent event);
    }

    @ZenClass("mods.cc.traits.AfterBlockBreak")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterBlockBreak {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IWorld world, IBlockState blockState, IBlockPos pos, IEntityLivingBase miner, boolean wasEffective);
    }

    @ZenClass("mods.cc.traits.BlockHarvestDrops")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface BlockHarvestDrops {
        void handle(TraitRepresentation thisTrait, IItemStack tool, BlockHarvestDropsEvent event);
    }

    @ZenClass("mods.cc.traits.IsCriticalHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface IsCriticalHit {
        boolean handle(TraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target);
    }

    @ZenClass("mods.cc.traits.Damage")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface Damage {
        float handle(TraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float originalDamage, float currentDamage, boolean isCritical);
    }

    @ZenClass("mods.cc.traits.OnHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnHit {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damage, boolean isCritical);
    }

    @ZenClass("mods.cc.traits.AfterHit")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface AfterHit {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damageDealt, boolean wasCritical, boolean wasHit);
    }

    @ZenClass("mods.cc.traits.KnockBack")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface KnockBack {
        float handle(TraitRepresentation thisTrait, IItemStack tool, IEntityLivingBase attacker, IEntityLivingBase target, float damage, float knockback, float newKnockback, boolean isCritical);
    }

    @ZenClass("mods.cc.traits.OnBlock")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnBlock {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IPlayer attacker, EntityLivingHurtEvent event);
    }

    @ZenClass("mods.cc.traits.OnToolDamage")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolDamage {
        int handle(TraitRepresentation thisTrait, IItemStack tool, int damage, int newDamage, IEntityLivingBase entity);
    }


    @ZenClass("mods.cc.traits.OnToolHeal")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolHeal {
        int handle(TraitRepresentation thisTrait, IItemStack tool, int damage, int newDamage, IEntityLivingBase entity);
    }

    @ZenClass("mods.cc.traits.OnToolRepair")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnToolRepair {
        void handle(TraitRepresentation thisTrait, IItemStack tool, int amount);
    }

    @ZenClass("mods.cc.traits.OnPlayerHurt")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface OnPlayerHurt {
        void handle(TraitRepresentation thisTrait, IItemStack tool, IPlayer player, IEntityLivingBase attacker, EntityLivingHurtEvent event);
    }

    @ZenClass("mods.cc.traits.CanApplyTogetherTrait")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface CanApplyTogetherTrait {
        boolean handle(TraitRepresentation thisTrait, String otherTrait);
    }

    @ZenClass("mods.cc.traits.CanApplyTogetherEnchantment")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface CanApplyTogetherEnchantment {
        boolean handle(TraitRepresentation thisTrait, IEnchantmentDefinition enchantmentDefinition);
    }

    @ZenClass("mods.cc.traits.ExtraInfo")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ExtraInfo {
        String[] handle(TraitRepresentation thisTrait, IItemStack item, IData tool);
    }

    @ZenClass("mods.cc.traits.ApplyToolEffect")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyToolEffect {
        void handle(TraitRepresentation thisTrait, NBTTagCompound rootCompound, NBTTagCompound modifierTag);
    }

    @ZenClass("mods.cc.traits.ApplyProjEffect")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface ApplyProjEffect {
        void handle(TraitRepresentation thisTrait, NBTTagCompound rootCompound, NBTTagCompound modifierTag);
    }

    @ZenClass("mods.cc.traits.GetAttributeModifiers")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface getAttributeModifiers {
        void handle(TraitRepresentation trait, IEntityEquipmentSlot slot, IItemStack item, Multimap<String, AttributeModifier> attributeMap);
    }

    @ZenClass("mods.cc.traits.onArrowNock")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface onArrowNock {
        void handle(TraitRepresentation trait, IItemStack bow, IEntityLivingBase helder, IWorld world);
    }

    @ZenClass("mods.cc.traits.onArrowLoose")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface onArrowLoose {
        void handle(TraitRepresentation trait, IItemStack bow, int charge, IEntityLivingBase helder, IWorld world);
    }

    @ZenClass("mods.cc.traits.calcArrowDamage")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface calcArrowDamage {
        float handle(TraitRepresentation trait, IItemStack bow, IItemStack arrow, IEntityLivingBase helder, IEntity target, IWorld world, float oldDamage, float newDamage);
    }

    @ZenClass("mods.cc.traits.onDrawingBow")
    @ZenRegister
    @ModOnly("tconstruct")
    public interface onDrawingBow {
        void handle(TraitRepresentation trait, IItemStack bow, IEntityLivingBase helder, IWorld world);
    }
}

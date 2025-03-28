package com.xifeng.cot_complement.projectile;

import com.xifeng.cot_complement.utils.Function;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.modifiers.ProjectileModifierTrait;
import slimeknights.tconstruct.library.traits.IProjectileTrait;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ProjTrait extends ProjectileModifierTrait implements IProjectileTrait {

    Function.OnLaunch onLaunch = null;
    Function.OnProjectileUpdate onProjectileUpdate = null;
    Function.OnMovement onMovement = null;
    Function.AfterProjHit afterProjHit = null;
    //Function.ApplyProjEffect applyEffect = null;
    String localizedName = null;
    String localizedDescription = null;
    boolean hidden = false;
    private final ProjTraitRepresentation thisTrait = new ProjTraitRepresentation(this);

    public ProjTrait(@Nonnull String identifier, int color, int maxLevel, int countPerLevel) {
        super(identifier, color, maxLevel, countPerLevel);

    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void onLaunch(EntityProjectileBase projectileBase, World world, @Nullable EntityLivingBase shooter) {
        if (onLaunch != null) {
            onLaunch.handle(thisTrait, CraftTweakerMC.getIEntityArrow(projectileBase), CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIEntityLivingBase(shooter));
        } else {
            super.onLaunch(projectileBase, world, shooter);
        }
    }

    @Override
    public void onProjectileUpdate(EntityProjectileBase projectile, World world, ItemStack toolStack) {
        if (onProjectileUpdate != null) {
            onProjectileUpdate.handle(thisTrait,CraftTweakerMC.getIEntityArrow(projectile), CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIItemStack(toolStack));
        } else {
            super.onProjectileUpdate(projectile, world, toolStack);
        }
    }

    @Override
    public void onMovement(EntityProjectileBase projectile, World world, double slowdown) {
        if (onMovement != null) {
            onMovement.handle(thisTrait, CraftTweakerMC.getIEntityArrow(projectile), CraftTweakerMC.getIWorld(world), slowdown);
        } else {
            super.onMovement(projectile, world, slowdown);
        }
    }

    @Override
    public void afterHit(EntityProjectileBase projectile, World world, ItemStack ammoStack, EntityLivingBase attacker, Entity target, double impactSpeed) {
        if (afterProjHit != null) {
            afterProjHit.handle(thisTrait, CraftTweakerMC.getIEntityArrow(projectile), CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIItemStack(ammoStack), CraftTweakerMC.getIEntityLivingBase(attacker), CraftTweakerMC.getIEntity(target), impactSpeed);
        } else {
            super.afterHit(projectile, world, ammoStack, attacker, target, impactSpeed);
        }
    }
/*
    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        if (applyEffect != null) {
            applyEffect.handle(thisTrait, NBTConverter.from(rootCompound,true), NBTConverter.from(modifierTag, true));
        } else {
            super.applyEffect(rootCompound, modifierTag);
        }
    }
*/
    @Override
    public String getLocalizedName() {
        if (localizedName != null) {
            return localizedName;
        }
        return super.getLocalizedName();
    }

    @Override
    public String getLocalizedDesc() {
        if (localizedDescription != null) {
            return localizedDescription;
        }
        return super.getLocalizedDesc();
    }

    public void addItem(RecipeMatch recipeMatch) {
        this.items.add(recipeMatch);
    }

    public void addRecipeMatch(RecipeMatch recipeMatch) {
        this.items.add(recipeMatch);
    }
}

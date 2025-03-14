package com.xifeng.cot_complement.traits;

import com.xifeng.cot_complement.utils.Functions;
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

    Functions.OnLaunch onLaunch = null;
    Functions.OnMovement onMovement = null;
    Functions.OnProjectileUpdate onProjectileUpdate = null;
    Functions.AfterHit afterHit = null;
    String localizedName = null;
    String localizedDescription = null;
    boolean hidden = false;
    private final TicTraitRepresentation thisTrait = new TicTraitRepresentation(this);

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
        if (afterHit != null) {
            afterHit.handle(thisTrait, CraftTweakerMC.getIEntityArrow(projectile), CraftTweakerMC.getIWorld(world), CraftTweakerMC.getIItemStack(ammoStack), CraftTweakerMC.getIEntityLivingBase(attacker), CraftTweakerMC.getIEntity(target), impactSpeed);
        } else {
            super.afterHit(projectile, world, ammoStack, attacker, target, impactSpeed);
        }
    }

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
    //public void  addMultiItem()
}

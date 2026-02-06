package com.xifeng.cot_complement.bow.cot;

import com.xifeng.cot_complement.bow.modifier.BowModifierTrait;
import com.xifeng.cot_complement.bow.trait.IBowTrait;
import com.xifeng.cot_complement.utils.Function;
import com.xifeng.cot_complement.utils.TraitRepresentation;
import crafttweaker.api.minecraft.CraftTweakerMC;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.mantle.util.RecipeMatch;

public class BowTrait extends BowModifierTrait implements IBowTrait {
    Function.onArrowNock onArrowNock = null;
    Function.onArrowLoose onArrowLoose = null;
    Function.onDrawingBow onDrawingBow = null;
    Function.calcArrowDamage calcArrowDamage = null;
    String localizedName = null;
    String localizedDescription = null;
    boolean hidden = false;
    private final TraitRepresentation thisTrait =  new TraitRepresentation(this);

    public BowTrait(String id, int color, int maxLevel, int countPerLevel) {
        super(id, color, maxLevel, countPerLevel);
    }

    @Override
    public boolean isHidden() {
        return hidden;
    }

    @Override
    public void onArrowNock(ItemStack bow, EntityLivingBase helder, World world) {
        if (onArrowNock != null) {
            onArrowNock.handle(thisTrait, CraftTweakerMC.getIItemStack(bow), CraftTweakerMC.getIEntityLivingBase(helder), CraftTweakerMC.getIWorld(world));
        } else  {
            super.onArrowNock(bow, helder, world);
        }
    }

    @Override
    public void onArrowLoose(ItemStack bow, int charge, EntityLivingBase helder, World world) {
        if (onArrowLoose != null) {
            onArrowLoose.handle(thisTrait, CraftTweakerMC.getIItemStack(bow), charge, CraftTweakerMC.getIEntityLivingBase(helder), CraftTweakerMC.getIWorld(world));
        } else  {
            super.onArrowLoose(bow, charge, helder, world);
        }
    }

    @Override
    public void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world) {
        if (onDrawingBow != null) {
            onDrawingBow.handle(thisTrait, CraftTweakerMC.getIItemStack(bow), CraftTweakerMC.getIEntityLivingBase(helder), CraftTweakerMC.getIWorld(world));
        }  else  {
            super.onDrawingBow(bow, helder, world);
        }
    }

    @Override
    public float calcArrowDamage(ItemStack bow, ItemStack arrow, EntityLivingBase helder, Entity target, World world, float oldDamage, float newDamage) {
        if (calcArrowDamage != null) {
            return calcArrowDamage.handle(thisTrait, CraftTweakerMC.getIItemStack(bow), CraftTweakerMC.getIItemStack(arrow), CraftTweakerMC.getIEntityLivingBase(helder), CraftTweakerMC.getIEntity(target), CraftTweakerMC.getIWorld(world), oldDamage, newDamage);
        }
        return super.calcArrowDamage(bow, arrow, helder, target, world, oldDamage, newDamage);
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

    public void addRecipeMatch(RecipeMatch recipeMatch) {
        this.items.add(recipeMatch);
    }
}

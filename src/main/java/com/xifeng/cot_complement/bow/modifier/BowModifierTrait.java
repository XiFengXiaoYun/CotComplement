package com.xifeng.cot_complement.bow.modifier;

import com.xifeng.cot_complement.bow.trait.IBowTrait;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;

public abstract class BowModifierTrait extends ModifierTrait implements IBowTrait {

    public BowModifierTrait(String identifier, int color, int maxLevel, int countPerLevel) {
        super(identifier, color, maxLevel, countPerLevel);
    }

    public BowModifierTrait(String identifier, int color) {
        super(identifier, color);
    }

    @Override
    public void onArrowNock(ItemStack bow, EntityLivingBase helder, World world) {

    }

    @Override
    public void onArrowLoose(ItemStack bow, int charge, EntityLivingBase helder, World world){

    }

    @Override
    public float calcArrowDamage(ItemStack bow, ItemStack arrow, int charge, EntityLivingBase helder, EntityLivingBase target, World world, float damage) {
        return damage;
    }

    @Override
    public void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world) {

    }
}

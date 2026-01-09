package com.xifeng.cot_complement.bow.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.AbstractTrait;

public abstract class AbstractBowTrait extends AbstractTrait implements IBowTrait {

    public AbstractBowTrait(String identifier, TextFormatting color) {
        super(identifier, color);
    }

    public AbstractBowTrait(String identifier, int color) {
        super(identifier, color);
    }

    @Override
    public void onArrowNock(ItemStack bow, EntityLivingBase helder, World world) {

    }

    @Override
    public void onArrowLoose(ItemStack bow, int charge, EntityLivingBase helder, World world){

    }

    @Override
    public float calcArrowDamage(ItemStack bow, ItemStack arrow, EntityLivingBase helder, Entity target, World world, float oldDamage, float newDamage) {
        return oldDamage;
    }

    @Override
    public void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world) {

    }
}

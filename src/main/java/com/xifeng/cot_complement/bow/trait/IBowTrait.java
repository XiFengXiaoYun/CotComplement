package com.xifeng.cot_complement.bow.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import slimeknights.tconstruct.library.traits.ITrait;

public interface IBowTrait extends ITrait {
    //Called when start using a bow
    void onArrowNock(ItemStack bow, EntityLivingBase helder, World world);
    //Called when stop using a bow
    void onArrowLoose(ItemStack bow, int charge, EntityLivingBase helder, World world);
    //Called to modify the arrow damage
    float calcArrowDamage(ItemStack bow, ItemStack arrow, EntityLivingBase helder, Entity target, World world, float oldDamage, float newDamage);
    //Called when continue using a bow
    void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world);
}

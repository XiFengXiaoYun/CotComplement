package com.xifeng.cot_complement.bow.trait;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class BowTraitTest extends AbstractBowTrait {
    public BowTraitTest() {
        super("test_bow_trait", TextFormatting.DARK_GRAY);
        this.addItem(Items.BOW);
    }

    @Override
    public void onArrowNock(ItemStack bow, EntityLivingBase helder, World world) {
        if(!world.isRemote) {
            helder.addPotionEffect(new PotionEffect(MobEffects.REGENERATION, 40, 0));
        }
    }

    @Override
    public void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world) {
        if(!world.isRemote) {
            helder.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 40, 1 ));
        }
    }

    @Override
    public float calcArrowDamage(ItemStack bow, ItemStack arrow, EntityLivingBase helder, Entity target, World world, float oldDamage, float newDamage) {
        if(!world.isRemote) {
            target.attackEntityFrom(DamageSource.causeMobDamage(helder), 1.0f);
        }
        return oldDamage - 1.0f;
    }
}

package com.xifeng.cot_complement.bow.trait;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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
            System.out.println("Bow starts to nock!");
            //System.out.println(bow.getDisplayName());
        }
    }

    @Override
    public void onDrawingBow(ItemStack bow, EntityLivingBase helder, World world) {
        if(!world.isRemote) {
            helder.addPotionEffect(new PotionEffect(MobEffects.ABSORPTION, 40, 1 ));
        }
    }
}

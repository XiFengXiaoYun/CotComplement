package com.xifeng.cot_complement.bow;

import com.xifeng.cot_complement.Tags;
import com.xifeng.cot_complement.bow.trait.IBowTrait;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.capability.projectile.TinkerProjectileHandler;
import slimeknights.tconstruct.library.entity.EntityProjectileBase;
import slimeknights.tconstruct.library.tools.ranged.BowCore;
import slimeknights.tconstruct.library.traits.ITrait;
import slimeknights.tconstruct.library.utils.TinkerUtil;
import slimeknights.tconstruct.library.utils.ToolHelper;

@Mod.EventBusSubscriber(modid = Tags.MOD_ID)
public class BowTraitEvents {
    private static boolean isBow(ItemStack bow) {
        return bow != null && bow.getItem() instanceof BowCore;
    }

    @SubscribeEvent
    public static void onArrowNock(ArrowNockEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        if(world.isRemote || player == null || event.isCanceled()) return;
        ItemStack bow = event.getBow();
        if(isBow(bow) && !ToolHelper.isBroken(bow)) {
            TinkerUtil.getTraitsOrdered(bow).forEach(
                    trait -> {
                        if (trait instanceof IBowTrait) {
                            ((IBowTrait) trait).onArrowNock(bow, player, world);
                        }
                    });
        }
    }

    @SubscribeEvent
    public static void onArrowLoose(ArrowLooseEvent event) {
        EntityPlayer player = event.getEntityPlayer();
        World world = event.getWorld();
        if(world.isRemote || player == null || event.isCanceled()) return;
        ItemStack bow = event.getBow();
        int charge = event.getCharge();
        if(isBow(bow) && !ToolHelper.isBroken(bow)) {
            TinkerUtil.getTraitsOrdered(bow).forEach(
                    trait -> {
                        if (trait instanceof IBowTrait) {
                            ((IBowTrait) trait).onArrowLoose(bow, charge, player, world);
                        }
                    });
        }
    }

    @SubscribeEvent
    public static void onArrowAttack(LivingHurtEvent event) {
        if(event.isCanceled() || event.getEntity().world.isRemote || !(event.getSource().getImmediateSource() instanceof EntityProjectileBase)) return;
        Entity entity = event.getSource().getTrueSource();
        Entity target = event.getEntity();
        if(entity instanceof EntityLivingBase) {
            EntityLivingBase livingBase = (EntityLivingBase) entity;
            EntityProjectileBase projectileBase = (EntityProjectileBase) event.getSource().getImmediateSource();
            TinkerProjectileHandler handler = projectileBase.tinkerProjectile;
            ItemStack bow = handler.getLaunchingStack();
            ItemStack arrow = handler.getItemStack();
            float amount = event.getAmount();
            System.out.printf("old amount is %f", amount);
            if(!ToolHelper.isBroken(bow)) {
                for(ITrait trait : TinkerUtil.getTraitsOrdered(bow))  {
                    if(trait instanceof IBowTrait) {
                        amount = ((IBowTrait) trait).calcArrowDamage(bow, arrow, livingBase, target, livingBase.world, amount, amount);
                    }
                }
                event.setAmount(amount);
                System.out.printf("new amount is %f", amount);
            }
        }
    }

    @SubscribeEvent
    public static void onDrawingBow(LivingEntityUseItemEvent.Tick event) {
        if(event.getEntityLiving().world.isRemote) return;
        ItemStack bow = event.getItem();
        if(isBow(bow) && !ToolHelper.isBroken(bow)) {
            TinkerUtil.getTraitsOrdered(bow).forEach(trait -> {
                if (trait instanceof IBowTrait) {
                    ((IBowTrait) trait).onDrawingBow(bow, event.getEntityLiving(), event.getEntityLiving().world);
                }
            });
        }
    }
}

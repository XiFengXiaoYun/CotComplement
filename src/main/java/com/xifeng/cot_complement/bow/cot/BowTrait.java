package com.xifeng.cot_complement.bow.cot;

import com.google.common.collect.Multimap;
import com.xifeng.cot_complement.bow.modifier.BowModifierTrait;
import com.xifeng.cot_complement.bow.trait.IBowTrait;
import com.xifeng.cot_complement.utils.Function;
import com.xifeng.cot_complement.utils.TraitRepresentation;
import crafttweaker.api.minecraft.CraftTweakerMC;
import crafttweaker.mc1120.data.NBTConverter;
import crafttweaker.mc1120.enchantments.MCEnchantmentDefinition;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import slimeknights.mantle.util.RecipeMatch;
import slimeknights.tconstruct.library.modifiers.IToolMod;

import javax.annotation.Nonnull;
import java.util.Arrays;
import java.util.List;

public class BowTrait extends BowModifierTrait implements IBowTrait {
    Function.onArrowNock onArrowNock = null;
    Function.onArrowLoose onArrowLoose = null;
    Function.onDrawingBow onDrawingBow = null;
    Function.calcArrowDamage calcArrowDamage = null;
    Function.CanApplyTogetherTrait canApplyTogetherTrait = null;
    Function.CanApplyTogetherEnchantment canApplyTogetherEnchantment = null;
    Function.ExtraInfo extraInfo = null;
    Function.ApplyToolEffect applyEffect = null;
    Function.getAttributeModifiers getAttributeModifiers = null;
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
    public boolean canApplyTogether(IToolMod otherModifier) {
        if (canApplyTogetherTrait != null) {
            return canApplyTogetherTrait.handle(thisTrait, otherModifier.getIdentifier());
        }
        return super.canApplyTogether(otherModifier);
    }

    @Override
    public boolean canApplyTogether(Enchantment enchantment) {
        if (canApplyTogetherEnchantment != null) {
            return canApplyTogetherEnchantment.handle(thisTrait, new MCEnchantmentDefinition(enchantment));
        }
        return super.canApplyTogether(enchantment);
    }

    @Override
    public List<String> getExtraInfo(ItemStack tool, NBTTagCompound modifierTag) {
        if (extraInfo != null) {
            return Arrays.asList(extraInfo.handle(thisTrait, CraftTweakerMC.getIItemStack(tool), NBTConverter.from(modifierTag, true)));
        }
        return super.getExtraInfo(tool, modifierTag);
    }

    @Override
    public void applyEffect(NBTTagCompound rootCompound, NBTTagCompound modifierTag) {
        if (applyEffect != null) {
            applyEffect.handle(thisTrait, rootCompound, modifierTag);
            super.applyEffect(rootCompound, modifierTag);
        } else {
            super.applyEffect(rootCompound, modifierTag);
        }
    }

    @Override
    public void getAttributeModifiers(@Nonnull EntityEquipmentSlot slot, ItemStack stack, Multimap<String, AttributeModifier> attributeMap) {
        if (getAttributeModifiers != null) {
            getAttributeModifiers.handle(thisTrait, CraftTweakerMC.getIEntityEquipmentSlot(slot), CraftTweakerMC.getIItemStack(stack), attributeMap);
        } else {
            super.getAttributeModifiers(slot, stack, attributeMap);
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

    public void addRecipeMatch(RecipeMatch recipeMatch) {
        this.items.add(recipeMatch);
    }
}

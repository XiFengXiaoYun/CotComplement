package com.xifeng.cot_complement.utils;

import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.modifiers.ModifierTrait;
import slimeknights.tconstruct.library.tinkering.Category;

import java.util.List;

public class Aspect {
    public static class SpecialAspect extends ModifierAspect.MultiAspect {
        public SpecialAspect(IModifier parent, int color, int maxLevel, int countPerLevel, int modifiersNeeded, boolean consumeOneSlot) {
            super(parent, color, maxLevel, countPerLevel, modifiersNeeded);
            if(consumeOneSlot) {
                this.freeModifierAspect = new ModifierAspect.FreeFirstModifierAspect(parent, modifiersNeeded);
            }
        }
    }

    public static ModifierAspect.CategoryAspect launcher = new ModifierAspect.CategoryAspect(Category.LAUNCHER);

    public static void handleAspect(ModifierTrait trait, List<ModifierAspect> aspects, int color, int maxLevel, int countPerLevel, int modifiersNeeded, boolean consumeOneSlot) {
        aspects.clear();
        if (maxLevel > 0 && countPerLevel > 0) {
            aspects.add(new Aspect.SpecialAspect(trait, color, maxLevel, countPerLevel, modifiersNeeded, consumeOneSlot));
        } else {
            if (maxLevel > 0) {
                aspects.add(new ModifierAspect.LevelAspect(trait, maxLevel));
            }
            if(consumeOneSlot) {
                aspects.add(new ModifierAspect.FreeFirstModifierAspect(trait, modifiersNeeded));
            } else {
                aspects.add(new ModifierAspect.FreeModifierAspect(modifiersNeeded));
            }
            aspects.add(new ModifierAspect.DataAspect(trait, color));
        }
    }
}

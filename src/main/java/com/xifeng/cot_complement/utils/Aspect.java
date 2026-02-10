package com.xifeng.cot_complement.utils;

import slimeknights.tconstruct.library.modifiers.IModifier;
import slimeknights.tconstruct.library.modifiers.ModifierAspect;
import slimeknights.tconstruct.library.tinkering.Category;

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
}

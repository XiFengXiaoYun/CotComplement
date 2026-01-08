package com.xifeng.cot_complement;

import com.xifeng.cot_complement.bow.trait.BowTraitTest;
import com.xifeng.cot_complement.events.EventManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import slimeknights.tconstruct.library.TinkerRegistry;

@Mod(modid = Tags.MOD_ID, name = Tags.MOD_NAME, version = Tags.VERSION)
public class cotComplement {

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        TinkerRegistry.addTrait(new BowTraitTest());
        MinecraftForge.EVENT_BUS.register(EventManager.EventHandler.class);
    }
}

package com.xifeng.cot_complement.events;

import crafttweaker.annotations.ZenRegister;
import crafttweaker.api.event.IEventHandle;
import crafttweaker.api.event.IEventManager;
import crafttweaker.util.EventList;
import crafttweaker.util.IEventHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import slimeknights.tconstruct.library.events.TinkerToolEvent;
import stanhebben.zenscript.annotations.ZenExpansion;
import stanhebben.zenscript.annotations.ZenMethod;

@ZenExpansion("crafttweaker.events.IEventManager")
@ZenRegister
public class EventManager {
    private static final EventList<OnBowShootEvent> eventList = new EventList<>();

    @ZenMethod
    public static IEventHandle onBowShoot(IEventManager manager,  IEventHandler<OnBowShootEvent> event) {
        return eventList.add(event);
    }

    public static final class EventHandler {
        @SubscribeEvent
        public static void onBowShoot(TinkerToolEvent.OnBowShoot evt) {
            if(eventList.hasHandlers()) {
                eventList.publish(new OnBowShootEvent(evt));
            }
        }
    }


}

package com.ambellic.ambellicportals.handlers;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.common.init.APItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CommonHandler {

    /* This cancels all fall damage when learning the Long Fall Boots*/
    @SubscribeEvent
    public static void onFall(LivingFallEvent event) {
        LivingEntity livingEntity = event.getEntityLiving();
        event.setCanceled(livingEntity.getItemStackFromSlot(EquipmentSlotType.FEET).getItem() == APItems.LONGFALL_BOOTS.get());
    }


}

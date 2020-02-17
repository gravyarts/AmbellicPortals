package com.ambellic.ambellicportals.init;

import com.ambellic.ambellicportals.AmbellicPortals;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
@ObjectHolder(AmbellicPortals.MOD_ID)
public class ItemInit
{
    public static final Item test_item = null;

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("test_item"));
    }
}

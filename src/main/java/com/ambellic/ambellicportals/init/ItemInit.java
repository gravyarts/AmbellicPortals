package com.ambellic.ambellicportals.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;


@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(AmbellicPortals.MOD_ID)
public class iteminit
{
    public static final Item moon_rock = null;


    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Item(new Item.Properties().group(ItemGroup.MISC)).setRegistryName("moon_rock"));
    }
}
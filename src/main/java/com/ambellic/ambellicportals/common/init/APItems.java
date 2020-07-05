package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.common.items.ArmorBaseItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ambellic.ambellicportals.AmbellicPortals.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class APItems {

    /* Create Items DeferredRegistry for Registering AmbellicPortals Items */
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AmbellicPortals.MOD_ID);

    public static final RegistryObject<Item> LONGFALL_BOOTS = ITEMS.register("long_fall_boots", () -> new ArmorBaseItem(EquipmentSlotType.FEET, new Item.Properties().group(APGroups.AP_ITEMS)));


    public static Item setUpItem(Item item){
        return item;
    }


    @SubscribeEvent
    public static void regBlockItems(RegistryEvent.Register<Item> e) {
        APBlocks.genBlockItems(APBlocks.BLOCKS.getEntries());
    }


}

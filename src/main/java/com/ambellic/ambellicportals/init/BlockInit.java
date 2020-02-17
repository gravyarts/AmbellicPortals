package com.ambellic.ambellicportals.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
@ObjectHolder(AmbellicPortals.MOD_ID)
public class BlockInit
{
    public static final Block test_block = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON)).setRegistryName("test_block"));
    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(test_block, new Item.Properties()).setRegistryName("test_block"));
    }
}

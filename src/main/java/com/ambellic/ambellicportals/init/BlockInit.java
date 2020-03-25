package com.ambellic.ambellicportals.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(AmbellicPortals.MOD_ID)
@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class blockinit
{
    public static final Block panel_single_lined = null;
    public static final Block panel_single_tile = null;
    public static final Block panel_lined_top = null;
    public static final Block panel_lined_bottom = null;
    public static final Block panel_lined_corner_tl = null;
    public static final Block panel_lined_corner_bl = null;
    public static final Block panel_lined_corner_tr = null;
    public static final Block panel_lined_corner_br = null;

    public static final Block portable_single = null;
    public static final Block portable_single_nodips = null;
    public static final Block portable_single_flat = null;
    public static final Block portable_top = null;
    public static final Block portable_bottom = null;
    public static final Block portable_nodips_top = null;
    public static final Block portable_nodips_bottom = null;
    public static final Block portable_flat_top = null;
    public static final Block portable_flat_bottom = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_single_lined"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_single_tile"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_top"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_bottom"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_corner_tl"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_corner_bl"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_corner_tr"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("panel_lined_corner_br"));

        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_single"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_single_nodips"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_single_flat"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_top"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_bottom"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_nodips_top"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_nodips_bottom"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_flat_top"));
        event.getRegistry().register(new Block(Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE)).setRegistryName("portable_flat_bottom"));

    }
    @SubscribeEvent
    public static void registerBlockItems(final RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(panel_single_lined, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_single_lined"));
        event.getRegistry().register(new BlockItem(panel_single_tile, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_single_tile"));
        event.getRegistry().register(new BlockItem(panel_lined_top, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_top"));
        event.getRegistry().register(new BlockItem(panel_lined_bottom, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_bottom"));
        event.getRegistry().register(new BlockItem(panel_lined_corner_tl, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_corner_tl"));
        event.getRegistry().register(new BlockItem(panel_lined_corner_bl, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_corner_bl"));
        event.getRegistry().register(new BlockItem(panel_lined_corner_tr, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_corner_tr"));
        event.getRegistry().register(new BlockItem(panel_lined_corner_br, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("panel_lined_corner_br"));

        event.getRegistry().register(new BlockItem(portable_single, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_single"));
        event.getRegistry().register(new BlockItem(portable_single_nodips, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_single_nodips"));
        event.getRegistry().register(new BlockItem(portable_single_flat, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_single_flat"));
        event.getRegistry().register(new BlockItem(portable_top, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_top"));
        event.getRegistry().register(new BlockItem(portable_bottom, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_bottom"));
        event.getRegistry().register(new BlockItem(portable_nodips_top, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_nodips_top"));
        event.getRegistry().register(new BlockItem(portable_nodips_bottom, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_nodips_bottom"));
        event.getRegistry().register(new BlockItem(portable_flat_top, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_flat_top"));
        event.getRegistry().register(new BlockItem(portable_flat_bottom, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)).setRegistryName("portable_flat_bottom"));

    }
}

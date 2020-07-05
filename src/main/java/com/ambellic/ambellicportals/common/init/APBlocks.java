package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.common.blocks.APBaseBlock;
import com.ambellic.ambellicportals.common.blocks.RadioBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Collection;

import static com.ambellic.ambellicportals.AmbellicPortals.MOD_ID;
import static com.ambellic.ambellicportals.common.init.APGroups.AP_BLOCKS;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class APBlocks {

    /* Create Blocks DeferredRegistry for Registering AmbellicPortals Blocks */
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MOD_ID);

    /* All blocks will be registered below this comment */

    /* At the time of writing, a lot of blocks share the same properties, so I've just made a varible for thos properties to make the class look cleaner */
    private static final Block.Properties oreProperties = Block.Properties.create(Material.ROCK).hardnessAndResistance(2f, 6f).sound(SoundType.STONE);

    public static final RegistryObject<Block> METEORITE_ORE = BLOCKS.register("meteorite_ore", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> FABRICATOR = BLOCKS.register("fabricator", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_SINGLE_LINED = BLOCKS.register("panel_single_lined", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_SINGLE_TILE = BLOCKS.register("panel_single_tile", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_TOP = BLOCKS.register("panel_lined_top", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_BOTTOM = BLOCKS.register("panel_lined_bottom", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_CORNER_TL = BLOCKS.register("panel_lined_corner_tl", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_CORNER_BL = BLOCKS.register("panel_lined_corner_bl", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_CORNER_TR = BLOCKS.register("panel_lined_corner_tr", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PANEL_LINED_CORNER_BR = BLOCKS.register("panel_lined_corner_br", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_SINGLE = BLOCKS.register("portable_single", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_SINGLE_NODIPS = BLOCKS.register("portable_single_nodips", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_SINGLE_FLAT = BLOCKS.register("portable_single_flat", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_TOP = BLOCKS.register("portable_top", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_BOTTOM = BLOCKS.register("portable_bottom", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_NODIPS_TOP = BLOCKS.register("portable_nodips_top", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_NODIPS_BOTTOM = BLOCKS.register("portable_nodips_bottom", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_FLAT_TOP = BLOCKS.register("portable_flat_top", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTABLE_FLAT_BOTTOM = BLOCKS.register("portable_flat_bottom", () -> new APBaseBlock(oreProperties));
    public static final RegistryObject<Block> PORTAL_RADIO = BLOCKS.register("portal_radio", () -> new RadioBlock(oreProperties));


    /* This method is used to minimize the amount of lines needed to create ItemBlocks for every registered block */
    public static void genBlockItems(Collection<RegistryObject<Block>> collection) {
        for (RegistryObject<Block> block : collection) {
            if (block.get() instanceof APBaseBlock) {
                APBaseBlock apBlock = (APBaseBlock) block.get();
                if (apBlock.hasItemBlock()) {
                    APItems.ITEMS.register(block.get().getRegistryName().getPath(), () -> APItems.setUpItem(new BlockItem(block.get(), new Item.Properties().group(AP_BLOCKS))));
                }
            }
        }
    }


}

package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class APTiles {

    /* Create TileEntity DeferredRegistry for Registering AmbellicPortals TilEntities */
    public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, AmbellicPortals.MOD_ID);


    /* Helper method for creating tiles and assigning blocks that they can work with, basically another method to decrease hassle */
    private static <T extends TileEntity> TileEntityType<T> registerTiles(Supplier<T> tile, Block... validBlock) {
        return TileEntityType.Builder.create(tile, validBlock).build(null);
    }

}

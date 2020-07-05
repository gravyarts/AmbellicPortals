package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.common.tiles.RadioTile;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class APTiles {

    /* Create TileEntity DeferredRegistry for Registering AmbellicPortals TilEntities */
    public static final DeferredRegister<TileEntityType<?>> TILES = new DeferredRegister<>(ForgeRegistries.TILE_ENTITIES, AmbellicPortals.MOD_ID);

    public static final RegistryObject<TileEntityType<RadioTile>> RADIO = TILES.register("radio", () -> TileEntityType.Builder.create(RadioTile::new, APBlocks.PORTAL_RADIO.get()).build(null));


}

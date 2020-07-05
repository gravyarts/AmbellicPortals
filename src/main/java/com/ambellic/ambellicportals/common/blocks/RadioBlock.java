package com.ambellic.ambellicportals.common.blocks;

import com.ambellic.ambellicportals.common.init.APTiles;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class RadioBlock extends APBaseBlock {

    public RadioBlock(Properties properties) {
        super(properties);
    }

    @Override
    public boolean isVariableOpacity() {
        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return APTiles.RADIO.get().create();
    }
}

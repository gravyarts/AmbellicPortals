package com.ambellic.ambellicportals.common.tiles;

import com.ambellic.ambellicportals.common.init.APSounds;
import com.ambellic.ambellicportals.common.init.APTiles;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.SoundCategory;

public class RadioTile extends TileEntity implements ITickableTileEntity {

    private int timer = 0;

    public RadioTile() {
        super(APTiles.RADIO.get());
    }

    @Override
    public void tick() {

        if (world != null && (timer % 880 == 0 || timer == 0)) {
            world.playSound(null, getPos(), APSounds.PORTAL_RADIO.get(), SoundCategory.BLOCKS, 0.3F, 1);
        }

        if (timer >= 880) {
            timer = 0;
        } else {
            timer++;
        }
    }
}

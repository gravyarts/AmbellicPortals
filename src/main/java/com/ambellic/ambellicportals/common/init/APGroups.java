package com.ambellic.ambellicportals.common.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class APGroups {

    public static ItemGroup AP_BLOCKS = new ItemGroup("ap_blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(APBlocks.PANEL_LINED_TOP.get());
        }
    };

    public static ItemGroup AP_ITEMS = new ItemGroup("ap_items") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.COMPASS);
        }
    };

}

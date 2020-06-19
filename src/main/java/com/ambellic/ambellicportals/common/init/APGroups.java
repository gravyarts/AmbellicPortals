package com.ambellic.ambellicportals.common.init;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class APGroups {

    public static ItemGroup AP_MAIN = new ItemGroup("ap_main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Items.COMPASS);
        }
    };

}

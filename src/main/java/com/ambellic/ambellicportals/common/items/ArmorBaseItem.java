package com.ambellic.ambellicportals.common.items;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.client.models.ArmorModels;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;

import javax.annotation.Nullable;

public class ArmorBaseItem extends ArmorItem {

    public ArmorBaseItem(EquipmentSlotType slot, Properties builder) {
        super(ArmorMaterial.CHAIN, slot, builder);
    }

    public ArmorBaseItem(IArmorMaterial materialIn, EquipmentSlotType slot, Properties builder) {
        super(materialIn, slot, builder);
    }

    @Nullable
    @Override
    public <A extends BipedModel<?>> A getArmorModel(LivingEntity entityLiving, ItemStack itemStack, EquipmentSlotType armorSlot, A _default) {
        Item item = itemStack.getItem();
        BipedModel armor = ArmorModels.get(item).getModel();
        return (A) armor;
    }

    @Nullable
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlotType slot, String type) {
        Item item = stack.getItem();
        return AmbellicPortals.MOD_ID + ":textures/entities/" + ArmorModels.get(item).getTexture() + ".png";
    }
}

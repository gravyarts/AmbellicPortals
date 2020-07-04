package com.ambellic.ambellicportals.client.models;

import com.ambellic.ambellicportals.common.init.APItems;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;

public class ArmorModels {

    private static HashMap<Item, ArmorData> MODELS = new HashMap<>();

    public static void init() {
        MODELS.put(APItems.LONGFALL_BOOTS.get(), new ArmorData("longfallboot", new LongFallBootsModel()));
    }

    public static ArmorData get(Item item) {
        return MODELS.get(item);
    }

    public static class ArmorData {

        private final BipedModel model;
        private final String texture;

        public ArmorData(String texture, BipedModel model){
            this.texture = texture;
            this.model = model;
        }

        public String getTexture() {
            return texture;
        }

        public BipedModel getModel() {
            return model;
        }
    }

}

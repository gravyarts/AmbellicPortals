package com.ambellic.ambellicportals.common.init;

import net.minecraft.entity.LivingEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;

public class APSource {

    public static BaseSource TURRET = new BaseSource("turret");

    public static class BaseSource extends DamageSource {

        private String message;

        public BaseSource(String damageTypeIn) {
            super(damageTypeIn);
            this.message = "ambellicportals.damagesrc." + damageTypeIn;
        }

        @Override
        public ITextComponent getDeathMessage(LivingEntity entity) {
            return new TranslationTextComponent(message, entity.getName());
        }
    }

}

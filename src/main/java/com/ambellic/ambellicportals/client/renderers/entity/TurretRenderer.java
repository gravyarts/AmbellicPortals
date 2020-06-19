package com.ambellic.ambellicportals.client.renderers.entity;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.client.models.entity.SentryTurretModel;
import com.ambellic.ambellicportals.common.entities.TurretEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class TurretRenderer extends LivingRenderer<TurretEntity, SentryTurretModel> implements IRenderFactory<TurretEntity> {

    public TurretRenderer() {
        super(Minecraft.getInstance().getRenderManager(), new SentryTurretModel(), 1);
    }

    @Override
    public ResourceLocation getEntityTexture(TurretEntity entity) {
        return new ResourceLocation(AmbellicPortals.MOD_ID, "textures/entities/turret.png");
    }

    @Override
    public EntityRenderer<? super TurretEntity> createRenderFor(EntityRendererManager manager) {
        return new TurretRenderer();
    }
}

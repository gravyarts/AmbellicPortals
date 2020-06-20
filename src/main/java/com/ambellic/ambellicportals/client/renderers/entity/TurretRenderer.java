package com.ambellic.ambellicportals.client.renderers.entity;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.client.models.entity.SentryTurretModel;
import com.ambellic.ambellicportals.common.entities.TurretEntity;
import com.ambellic.ambellicportals.util.EntityHelper;
import com.ambellic.ambellicportals.util.VisualHelper;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.*;
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
    public void render(TurretEntity entity, float entityYaw, float partialTicks, MatrixStack matrixStack, IRenderTypeBuffer bufferIn, int packedLightIn) {

        matrixStack.push();
        matrixStack.scale(1.5F,1.5F,1.5F);
        super.render(entity, entityYaw, partialTicks, matrixStack, bufferIn, packedLightIn);
        matrixStack.pop();

        /* Line of Sight laser */
        matrixStack.push();

        Vec3d vec1 = new Vec3d(0.1F, 0.06125F * 2F, 0.06125F * 3);
        Vec3d vec2 = vec1.add(0, 0, -9);
        vec1 = vec2.subtract(vec1);
        vec2 = vec2.subtract(vec2);
        vec1 = vec1.normalize();

        double x_ = vec2.x - vec1.x;
        double y_ = vec2.y - vec1.y;
        double z_ = vec2.z - vec1.z;
        double diff = MathHelper.sqrt(x_ * x_ + z_ * z_);
        float yaw = (float) (Math.atan2(z_, x_) * 180.0D / 3.141592653589793D) - 90.0F;
        float pitch = (float) -(Math.atan2(y_, diff) * 180.0D / 3.141592653589793D);

        matrixStack.translate(0,1,0);

        matrixStack.rotate(Vector3f.YP.rotation(-yaw));
        matrixStack.rotate(Vector3f.XP.rotation(pitch));

        RayTraceResult lookingAt = EntityHelper.getPosLookingAt(entity, 60);
        float length = 0;

        if (lookingAt != null && lookingAt.getType() == RayTraceResult.Type.BLOCK) {
            BlockRayTraceResult blockRayTraceResult = (BlockRayTraceResult) lookingAt;
            BlockPos lookingAtPos = blockRayTraceResult.getPos();
            length = (float) entity.getEyePosition(1).distanceTo(new Vec3d(lookingAtPos));
        }

        matrixStack.rotate(Vector3f.XP.rotationDegrees(90.0F));
        IVertexBuilder vertexBuilder = bufferIn.getBuffer(VisualHelper.RenderTypes.LASER);
        VisualHelper.drawGlowingLine(matrixStack.getLast().getMatrix(), vertexBuilder, length, 0.02F, 1,0,0, 0.3F, 15728640);
        matrixStack.pop();

    }

    @Override
    public EntityRenderer<? super TurretEntity> createRenderFor(EntityRendererManager manager) {
        return new TurretRenderer();
    }
}

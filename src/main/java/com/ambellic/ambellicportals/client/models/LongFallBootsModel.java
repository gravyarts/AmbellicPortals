package com.ambellic.ambellicportals.client.models;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.LivingEntity;

public class LongFallBootsModel extends PlayerModel<LivingEntity> {

    private final ModelRenderer armorRightBoot;
    private final ModelRenderer armorRightBrace;
    private final ModelRenderer armorLeftBoot;
    private final ModelRenderer armorLeftBrace;

    public LongFallBootsModel() {
        super(0, true);
        textureWidth = 24;
        textureHeight = 16;

        armorRightBoot = new ModelRenderer(this);
        armorRightBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        //      bipedRightLeg.addChild(armorRightBoot);
        armorRightBoot.setTextureOffset(0, 0).addBox(2.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, true);

        armorRightBrace = new ModelRenderer(this);
        armorRightBrace.setRotationPoint(0.0F, 12.0F, 2.0F);
        armorRightBoot.addChild(armorRightBrace);
        setRotationAngle(armorRightBrace, 0.0873F, 0.0F, 0.0F);
        armorRightBrace.setTextureOffset(17, 1).addBox(0.0F, -11.5F, 0.0F, 0.0F, 12.0F, 3.0F, 0.0F, false);

        armorLeftBoot = new ModelRenderer(this);
        armorLeftBoot.setRotationPoint(0.0F, 0.0F, 0.0F);
        //  bipedLeftLeg.addChild(armorLeftBoot);
        armorLeftBoot.setTextureOffset(0, 0).addBox(-6.0F, 0.0F, -2.0F, 4.0F, 12.0F, 4.0F, 0.5F, false);

        armorLeftBrace = new ModelRenderer(this);
        armorLeftBrace.setRotationPoint(0.0F, 12.0F, 2.0F);
        armorLeftBoot.addChild(armorLeftBrace);
        setRotationAngle(armorLeftBrace, 0.0873F, 0.0F, 0.0F);
        armorLeftBrace.setTextureOffset(17, 1).addBox(0.0F, -11.5F, 0.0F, 0.0F, 12.0F, 3.0F, 0.0F, true);

    }

    @Override
    public void setRotationAngles(LivingEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setRotationAngles(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void render(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        double distance = 4 * 0.06125 ;
        matrixStackIn.push();
        bipedLeftLeg.translateRotate(matrixStackIn);
        armorRightBrace.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        matrixStackIn.translate(-distance, 0, 0);
        armorRightBoot.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);
        matrixStackIn.pop();

        matrixStackIn.push();

        bipedRightLeg.translateRotate(matrixStackIn);
        armorLeftBrace.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        matrixStackIn.translate(distance, 0, 0);
        armorLeftBoot.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn);

        matrixStackIn.pop();
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}

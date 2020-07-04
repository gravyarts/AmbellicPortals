package com.ambellic.ambellicportals.client.models.entity;

import com.ambellic.ambellicportals.common.entities.TurretEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;

public class SentryTurretModel extends EntityModel<TurretEntity> {

    private final ModelRenderer bone;
    private final ModelRenderer body;
    private final ModelRenderer eye;
    private final ModelRenderer antenna;
    private final ModelRenderer rightflap;
    private final ModelRenderer leftflap;
    private final ModelRenderer rightleg;
    private final ModelRenderer leftleg;
    private final ModelRenderer backleg;

    public SentryTurretModel() {
        textureWidth = 56;
        textureHeight = 36;

        bone = new ModelRenderer(this);
        bone.setRotationPoint(0.0F, 16.25F, 0.0F);
        setRotationAngle(bone, 0.0349F, 0.0F, 0.0F);


        body = new ModelRenderer(this);
        body.setRotationPoint(0.0F, -7.0F, -0.5F);
        bone.addChild(body);
        setRotationAngle(body, 0.0873F, 0.0F, 0.0F);
        body.setTextureOffset(0, 0).addBox(-2.0F, -5.5F, -2.5F, 4.0F, 11.0F, 5.0F, 0.0F, false);

        eye = new ModelRenderer(this);
        eye.setRotationPoint(0.0F, 1.5F, -2.35F);
        body.addChild(eye);
        setRotationAngle(eye, 0.0F, 0.0F, 0.7854F);
        eye.setTextureOffset(41, 22).addBox(-0.5F, -0.5F, -0.005F, 1.0F, 1.0F, 0.0F, 0.15F, false);

        antenna = new ModelRenderer(this);
        antenna.setRotationPoint(-2.0F, -13.5F, -0.5F);
        bone.addChild(antenna);
        setRotationAngle(antenna, 0.0F, 0.7854F, 0.0F);
        antenna.setTextureOffset(37, 20).addBox(0.25F, -3.0F, -0.25F, 0.0F, 5.0F, 1.0F, 0.0F, false);

        rightflap = new ModelRenderer(this);
        rightflap.setRotationPoint(0.0F, -5.0F, 0.0F);
        bone.addChild(rightflap);
        rightflap.setTextureOffset(26, 18).addBox(-2.75F, -2.0F, -2.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);
        rightflap.setTextureOffset(20, 0).addBox(-3.0F, -5.0F, -3.0F, 1.0F, 11.0F, 5.0F, 0.0F, false);
        rightflap.setTextureOffset(37, 18).addBox(-2.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        leftflap = new ModelRenderer(this);
        leftflap.setRotationPoint(0.0F, -5.0F, 0.0F);
        bone.addChild(leftflap);
        leftflap.setTextureOffset(26, 25).addBox(0.75F, -2.0F, -2.25F, 2.0F, 4.0F, 2.0F, 0.0F, false);
        leftflap.setTextureOffset(33, 0).addBox(2.0F, -5.0F, -3.0F, 1.0F, 11.0F, 5.0F, 0.0F, false);
        leftflap.setTextureOffset(37, 19).addBox(0.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, false);

        rightleg = new ModelRenderer(this);
        rightleg.setRotationPoint(-1.0F, -1.5F, -2.5F);
        bone.addChild(rightleg);
        setRotationAngle(rightleg, -0.1745F, 0.4363F, 0.0F);
        rightleg.setTextureOffset(1, 18).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 10.0F, 4.0F, 0.0F, false);
        rightleg.setTextureOffset(37, 27).addBox(-1.0F, 0.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.25F, false);

        leftleg = new ModelRenderer(this);
        leftleg.setRotationPoint(1.0F, -1.5F, -2.5F);
        bone.addChild(leftleg);
        setRotationAngle(leftleg, -0.1745F, -0.4363F, 0.0F);
        leftleg.setTextureOffset(1, 18).addBox(0.0F, 0.0F, -4.0F, 1.0F, 10.0F, 4.0F, 0.0F, false);
        leftleg.setTextureOffset(37, 27).addBox(0.0F, 0.0F, -4.0F, 1.0F, 1.0F, 2.0F, 0.25F, false);

        backleg = new ModelRenderer(this);
        backleg.setRotationPoint(0.0F, -4.25F, 2.25F);
        bone.addChild(backleg);
        setRotationAngle(backleg, 0.1745F, 0.0F, 0.0F);
        backleg.setTextureOffset(13, 18).addBox(-0.5F, 0.0F, -0.75F, 1.0F, 13.0F, 4.0F, 0.0F, false);
        backleg.setTextureOffset(37, 31).addBox(-0.5F, 0.0F, 1.25F, 1.0F, 1.0F, 2.0F, 0.25F, false);    }

    @Override
    public void setRotationAngles(TurretEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        bone.render(matrixStack, buffer, packedLight, packedOverlay);
    }

    public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }

}
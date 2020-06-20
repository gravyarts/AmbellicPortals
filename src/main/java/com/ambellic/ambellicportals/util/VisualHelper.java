package com.ambellic.ambellicportals.util;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Matrix4f;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import org.lwjgl.opengl.GL11;

public class VisualHelper {

    /* Retrieve Minecrafts current Partial Render Ticks */
    public static float getPartialRenderTicks(){
        return Minecraft.getInstance().getRenderPartialTicks();
    }

    public static void drawLine(Matrix4f matrix, IVertexBuilder builder, float width, float length, float red, float green, float blue, float alpha, int combinedLightIn) {
        drawLine(matrix, builder, width, length, true, true, red, green, blue, alpha, combinedLightIn);
    }

    public static void drawLine(Matrix4f matrix, IVertexBuilder builder, float width, float length, boolean drawTop, boolean drawBottom, float red, float green, float blue, float alpha, int combinedLightIn) {
        renderFilledBox(matrix, builder, -width / 2F, 0, -width / 2F, width / 2F, length, width / 2F, red, green, blue, alpha, combinedLightIn);
    }

    public static void renderFilledBox(Matrix4f matrix, IVertexBuilder builder, AxisAlignedBB boundingBox, float red, float green, float blue, float alpha, int combinedLightIn) {
        renderFilledBox(matrix, builder, (float) boundingBox.minX, (float) boundingBox.minY, (float) boundingBox.minZ, (float) boundingBox.maxX, (float) boundingBox.maxY, (float) boundingBox.maxZ, red, green, blue, alpha, combinedLightIn);
    }

    public static void renderFilledBox(Matrix4f matrix, IVertexBuilder builder, float startX, float startY, float startZ, float endX, float endY, float endZ, float red, float green, float blue, float alpha, int combinedLightIn) {
        //down
        builder.pos(matrix, startX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();

        //up
        builder.pos(matrix, startX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();

        //east
        builder.pos(matrix, startX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();

        //west
        builder.pos(matrix, startX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();

        //south
        builder.pos(matrix, endX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, endX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();

        //north
        builder.pos(matrix, startX, startY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, startY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, endY, endZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
        builder.pos(matrix, startX, endY, startZ).color(red, green, blue, alpha).lightmap(combinedLightIn).endVertex();
    }

    public static void drawGlowingLine(Matrix4f matrix, IVertexBuilder builder, float length, float width, float red, float green, float blue, float alpha, int combinedLightIn) {
        AxisAlignedBB box = new AxisAlignedBB(-width / 2F, 0, -width / 2F, width / 2F, length, width / 2F);
        renderFilledBox(matrix, builder, box, 1F, 1F, 1F, alpha, combinedLightIn);

        for(int i = 0; i < 3; i++) {
            renderFilledBox(matrix, builder, box.grow(i * 0.5F * 0.0625F), red, green, blue, (1F / i / 2) * alpha, combinedLightIn);
        }
    }



    public static class RenderTypes extends RenderType {

        public RenderTypes(String name, VertexFormat vertexFormat, int drawMode, int bufferSize, boolean useDelegate, boolean needsSorting, Runnable setupTask, Runnable clearTask) {
            super(name, vertexFormat, drawMode, bufferSize, useDelegate, needsSorting, setupTask, clearTask);
        }

        public static final RenderType LASER = makeType(AmbellicPortals.MOD_ID + ":laser", DefaultVertexFormats.POSITION_COLOR_LIGHTMAP, GL11.GL_QUADS, 256, false, false, RenderType.State.getBuilder()
                .texture(RenderState.NO_TEXTURE)
                .cull(RenderState.CULL_ENABLED)
                .alpha(DEFAULT_ALPHA)
                .transparency(RenderState.LIGHTNING_TRANSPARENCY)
                .build(true));

        public static RenderType getGlowing(ResourceLocation locationIn) {
            RenderState.TextureState textureState = new RenderState.TextureState(locationIn, false, false);
            return makeType(AmbellicPortals.MOD_ID + ":glowing", DefaultVertexFormats.ENTITY, 7, 256, false, true, RenderType.State.getBuilder().transparency(TRANSLUCENT_TRANSPARENCY).alpha(DEFAULT_ALPHA).cull(CULL_DISABLED).overlay(OVERLAY_ENABLED).texture(textureState).fog(BLACK_FOG).build(false));
        }
    }



}

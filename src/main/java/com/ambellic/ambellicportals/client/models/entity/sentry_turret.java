// Made with Blockbench 3.5.4
// Exported for Minecraft version 1.15
// Paste this class into your mod and generate all required imports

public class custom_model extends EntityModel<Entity> {
	private final ModelRenderer bone;
	private final ModelRenderer antenna;
	private final ModelRenderer body;
	private final ModelRenderer leftflap;
	private final ModelRenderer rightflap;
	private final ModelRenderer backleg;
	private final ModelRenderer frontleftleg;
	private final ModelRenderer rightfrontleg;

	public custom_model() {
		textureWidth = 48;
		textureHeight = 48;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 23.0F, 0.0F);
		

		antenna = new ModelRenderer(this);
		antenna.setRotationPoint(-1.5F, -16.75F, 0.5F);
		bone.addChild(antenna);
		setRotationAngle(antenna, 0.0F, 0.6981F, 0.0F);
		antenna.setTextureOffset(14, 17).addBox(0.0F, -2.5F, -0.5F, 0.0F, 4.0F, 1.0F, 0.0F, false);

		body = new ModelRenderer(this);
		body.setRotationPoint(0.0F, -10.5F, 0.0F);
		bone.addChild(body);
		setRotationAngle(body, 0.0873F, 0.0F, 0.0F);
		body.setTextureOffset(0, 0).addBox(-1.5F, -5.5F, -2.0F, 3.0F, 10.0F, 4.0F, 0.0F, false);

		leftflap = new ModelRenderer(this);
		leftflap.setRotationPoint(0.0F, -10.0F, 0.0F);
		bone.addChild(leftflap);
		leftflap.setTextureOffset(8, 19).addBox(-3.25F, -0.25F, 0.75F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		leftflap.setTextureOffset(0, 17).addBox(-3.0F, -1.25F, -1.25F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		leftflap.setTextureOffset(28, 0).addBox(-4.0F, -4.0F, -2.0F, 1.0F, 9.0F, 4.0F, 0.0F, false);

		rightflap = new ModelRenderer(this);
		rightflap.setRotationPoint(-0.5F, -10.0F, 0.0F);
		bone.addChild(rightflap);
		rightflap.setTextureOffset(8, 17).addBox(1.75F, -0.25F, 0.75F, 2.0F, 1.0F, 0.0F, 0.0F, false);
		rightflap.setTextureOffset(0, 17).addBox(2.5F, -1.25F, -1.25F, 1.0F, 3.0F, 2.0F, 0.0F, false);
		rightflap.setTextureOffset(16, 0).addBox(3.5F, -4.0F, -2.0F, 1.0F, 9.0F, 4.0F, 0.0F, false);

		backleg = new ModelRenderer(this);
		backleg.setRotationPoint(0.0F, -7.0F, 1.8264F);
		bone.addChild(backleg);
		setRotationAngle(backleg, 0.1745F, 0.0F, 0.0F);
		backleg.setTextureOffset(12, 23).addBox(-0.5F, -0.5F, -1.8264F, 1.0F, 9.0F, 4.0F, 0.0F, false);
		backleg.setTextureOffset(20, 17).addBox(-0.5F, -0.5F, 1.1736F, 1.0F, 2.0F, 1.0F, 0.25F, false);

		frontleftleg = new ModelRenderer(this);
		frontleftleg.setRotationPoint(-0.25F, -6.0F, 0.0F);
		bone.addChild(frontleftleg);
		setRotationAngle(frontleftleg, -0.1745F, 0.4363F, 0.0F);
		frontleftleg.setTextureOffset(0, 24).addBox(-1.0F, 0.0F, -5.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
		frontleftleg.setTextureOffset(26, 17).addBox(-1.0F, 0.0F, -5.0F, 1.0F, 1.0F, 2.0F, 0.25F, false);

		rightfrontleg = new ModelRenderer(this);
		rightfrontleg.setRotationPoint(0.25F, -6.0F, 0.0F);
		bone.addChild(rightfrontleg);
		setRotationAngle(rightfrontleg, -0.1745F, -0.4363F, 0.0F);
		rightfrontleg.setTextureOffset(0, 24).addBox(0.0F, 0.0F, -5.0F, 1.0F, 8.0F, 4.0F, 0.0F, false);
		rightfrontleg.setTextureOffset(26, 17).addBox(0.0F, 0.0F, -5.0F, 1.0F, 1.0F, 2.0F, 0.25F, false);
	}

	@Override
	public void setRotationAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, IVertexBuilder buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		bone.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
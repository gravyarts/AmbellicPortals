package com.ambellic.ambellicportals.util;

import net.minecraft.entity.Entity;
import net.minecraft.util.Direction;
import net.minecraft.util.math.*;
import net.minecraft.util.math.shapes.VoxelShapes;

public class EntityHelper {

    public static RayTraceResult getPosLookingAt(Entity entity, double distance) {
        Vec3d lookVec = entity.getLookVec();
        for (int i = 0; i < distance * 2; i++) {
            float scale = i / 2F;
            Vec3d pos = entity.getPositionVector().add(0, entity.getEyeHeight(), 0).add(lookVec.scale(scale));
            if (entity.world.getBlockState(new BlockPos(pos)).getCollisionShape(entity.world, new BlockPos(pos)) != VoxelShapes.empty() && !entity.world.isAirBlock(new BlockPos(pos))) {
                return new BlockRayTraceResult(pos, Direction.getFacingFromVector(pos.x, pos.y, pos.z), new BlockPos(pos), false);
            } else {
                Vec3d min = pos.add(0.25F, 0.25F, 0.25F);
                Vec3d max = pos.add(-0.25F, -0.25F, -0.25F);
                for (Entity e : entity.world.getEntitiesWithinAABBExcludingEntity(entity, new AxisAlignedBB(min.x, min.y, min.z, max.x, max.y, max.z))) {
                    return new EntityRayTraceResult(e);
                }
            }
        }
        return null;
    }


}

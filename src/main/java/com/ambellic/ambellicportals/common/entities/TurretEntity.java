package com.ambellic.ambellicportals.common.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.world.World;

public class TurretEntity extends CreatureEntity {

    public TurretEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.95F * sizeIn.height;
    }


}

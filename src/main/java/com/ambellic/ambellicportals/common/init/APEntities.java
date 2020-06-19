package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import com.ambellic.ambellicportals.common.entities.TurretEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class APEntities {

    public static final DeferredRegister<EntityType<?>> ENTITIES = new DeferredRegister<>(ForgeRegistries.ENTITIES, AmbellicPortals.MOD_ID);


    public static RegistryObject<EntityType<TurretEntity>> SENTRY_TURRET = ENTITIES.register("sentry_turret", () -> registerNoSpawnerBase(TurretEntity::new, EntityClassification.AMBIENT, 0.6F, 1.95F, 128, 1, true, "sentry_turret"));



    // Creation stuff
    private static <T extends Entity> EntityType<T> registerFireResistMob(EntityType.IFactory<T> factory, IClientSpawner<T> client, EntityClassification classification, float width, float height, String name, boolean velocity) {
        return registerFireImmuneBase(factory, client, classification, width, height, 80, 3, velocity, name);
    }

    private static <T extends Entity> EntityType<T> registerStatic(EntityType.IFactory<T> factory, IClientSpawner<T> client, EntityClassification classification, float width, float height, String name) {
        return registerBase(factory, client, classification, width, height, 64, 40, false, name);
    }

    private static <T extends Entity> EntityType<T> registerMob(EntityType.IFactory<T> factory, IClientSpawner<T> client, EntityClassification classification, float width, float height, String name, boolean velocity) {
        return registerBase(factory, client, classification, width, height, 80, 3, velocity, name);
    }

    private static <T extends Entity> EntityType<T> registerNonSpawner(EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, boolean velocity, String name) {
        return registerNoSpawnerBase(factory, classification, width, height, 64, 40, velocity, name);
    }

    public interface IClientSpawner<T> {
        T spawn(World world);
    }


    // Entity Creation
    private static <T extends Entity> EntityType<T> registerNoSpawnerBase(EntityType.IFactory<T> factory, EntityClassification classification, float width, float height, int trackingRange, int updateFreq, boolean sendUpdate, String name) {
        ResourceLocation loc = new ResourceLocation(AmbellicPortals.MOD_ID, name);
        EntityType.Builder<T> builder = EntityType.Builder.create(factory, classification);
        builder.setShouldReceiveVelocityUpdates(sendUpdate);
        builder.setTrackingRange(trackingRange);
        builder.setUpdateInterval(updateFreq);
        builder.size(width, height);
        return builder.build(loc.toString());
    }

    private static <T extends Entity> EntityType<T> registerBase(EntityType.IFactory<T> factory, IClientSpawner<T> client, EntityClassification classification, float width, float height, int trackingRange, int updateFreq, boolean sendUpdate, String name) {
        ResourceLocation loc = new ResourceLocation(AmbellicPortals.MOD_ID, name);
        EntityType.Builder<T> builder = EntityType.Builder.create(factory, classification);
        builder.setShouldReceiveVelocityUpdates(sendUpdate);
        builder.setTrackingRange(trackingRange);
        builder.setUpdateInterval(updateFreq);
        builder.size(width, height);
        builder.setCustomClientFactory((spawnEntity, world) -> client.spawn(world));
        EntityType<T> type = builder.build(loc.toString());
        return type;
    }

    // Fire Resistant Entity Creation
    private static <T extends Entity> EntityType<T> registerFireImmuneBase(EntityType.IFactory<T> factory, IClientSpawner<T> client, EntityClassification classification, float width, float height, int trackingRange, int updateFreq, boolean sendUpdate, String name) {
        ResourceLocation loc = new ResourceLocation(AmbellicPortals.MOD_ID, name);
        EntityType.Builder<T> builder = EntityType.Builder.create(factory, classification);
        builder.setShouldReceiveVelocityUpdates(sendUpdate);
        builder.setTrackingRange(trackingRange);
        builder.setUpdateInterval(updateFreq);
        builder.immuneToFire();
        builder.size(width, height);
        builder.setCustomClientFactory((spawnEntity, world) -> client.spawn(world));
        EntityType<T> type = builder.build(loc.toString());
        return type;
    }

}

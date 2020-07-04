package com.ambellic.ambellicportals;

import com.ambellic.ambellicportals.client.models.ArmorModels;
import com.ambellic.ambellicportals.client.renderers.entity.TurretRenderer;
import com.ambellic.ambellicportals.common.init.*;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ambellicportals")
@Mod.EventBusSubscriber(modid = AmbellicPortals.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AmbellicPortals {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ambellicportals";
    public static AmbellicPortals instance;

    public AmbellicPortals() {
        FMLJavaModLoadingContext.get().getModEventBus().register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        instance = this;
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }


    private void doClientStuff(final FMLClientSetupEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(APEntities.SENTRY_TURRET.get(), new TurretRenderer());
        ArmorModels.init();
    }


    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onNewRegistries(RegistryEvent.NewRegistry e) {
        APBlocks.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        APItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        APTiles.TILES.register(FMLJavaModLoadingContext.get().getModEventBus());
        APSounds.SOUNDS.register(FMLJavaModLoadingContext.get().getModEventBus());
        APEntities.ENTITIES.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}

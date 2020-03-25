package com.ambellic.ambellicportals;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("ambellicportals")
public class AmbellicPortals
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "ambellicportals";
    public static AmbellicPortals instance;

    public AmbellicPortals()

    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        instance = this;

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) { }


    private void doClientStuff(final FMLClientSetupEvent event) { }


    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) { }


}

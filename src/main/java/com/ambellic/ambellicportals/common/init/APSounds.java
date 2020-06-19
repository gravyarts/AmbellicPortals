package com.ambellic.ambellicportals.common.init;

import com.ambellic.ambellicportals.AmbellicPortals;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static com.ambellic.ambellicportals.AmbellicPortals.MOD_ID;

@Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class APSounds {

    /* Create Sounds DeferredRegistry for Registering AmbellicPortals Sounds */
    public static final DeferredRegister<SoundEvent> SOUNDS = new DeferredRegister<>(ForgeRegistries.SOUND_EVENTS, AmbellicPortals.MOD_ID);

    //public static final RegistryObject<SoundEvent> EXAMPLE_SOUND = SOUNDS.register("example_sound", () -> setUpSound("example_sound"));

    /* This method is simply just for making the class look a bit neater */
    private static SoundEvent setUpSound(String soundName) {
        return new SoundEvent(new ResourceLocation(MOD_ID, soundName));
    }


}

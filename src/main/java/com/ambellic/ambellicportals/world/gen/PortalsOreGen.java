package com.ambellic.ambellicportals.world.gen;

import com.ambellic.ambellicportals.init.blockinit;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class PortalsOreGen
{
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES)
            {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE.configure(new CountRangeConfig
                        (1, 50, 5, 10));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig
                        (OreFeatureConfig.FillerBlockType.NATURAL_STONE, blockinit.moon_shards_ore.getDefaultState(), 15))
                        .withPlacement(customConfig));
            }
    }
}

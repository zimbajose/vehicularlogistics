package net.zimbajose.vehicularlogistics.world.feature;

import com.google.common.base.Suppliers;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.VehicularLogistics;
import net.zimbajose.vehicularlogistics.block.ModBlocks;

import java.util.List;
import java.util.function.Supplier;

public class ModConfiguredFeatures {
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES =
            DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, VehicularLogistics.MODID);

    public static final Supplier<List<OreConfiguration.TargetBlockState>> OVERWORLD_GREENSTONE_ORE = Suppliers.memoize(() ->List.of(
       OreConfiguration.target(OreFeatures.STONE_ORE_REPLACEABLES, ModBlocks.GREENSTONE_ORE.get().defaultBlockState()),
       OreConfiguration.target(OreFeatures.DEEPSLATE_ORE_REPLACEABLES,ModBlocks.GREENSTONE_ORE.get().defaultBlockState())
    ));

    public static final RegistryObject<ConfiguredFeature<?,?>> GREENSTONE_ORE = CONFIGURED_FEATURES.register("greenstone_ore",
            ()-> new ConfiguredFeature<>(Feature.ORE,new OreConfiguration(OVERWORLD_GREENSTONE_ORE.get(),9)));

    public static void register(IEventBus iEventBus){
        //CONFIGURED_FEATURES.register(iEventBus);
    }
}

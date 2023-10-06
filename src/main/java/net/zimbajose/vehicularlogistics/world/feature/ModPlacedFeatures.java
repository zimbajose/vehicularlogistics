package net.zimbajose.vehicularlogistics.world.feature;

import net.minecraft.core.Registry;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.VehicularLogistics;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES =
            DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, VehicularLogistics.MODID);

    public static final RegistryObject<PlacedFeature> GREENSTONE_ORE_PLACED = PLACED_FEATURES.register("greenstone_ore_placed",
            ()-> new PlacedFeature(ModConfiguredFeatures.GREENSTONE_ORE.getHolder().get(),
                    commonOrePlacement(3,
                            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80),VerticalAnchor.aboveBottom(40)))));

    public static void register(IEventBus iEventBus){
        //PLACED_FEATURES.register(iEventBus);
    }

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier2){
        return List.of(placementModifier, InSquarePlacement.spread(),placementModifier2, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int weight, PlacementModifier placementModifier){
        return orePlacement(CountPlacement.of(weight),placementModifier);
    }
    public static List<PlacementModifier> rareOrePlacement(int weight, PlacementModifier placementModifier){
        return orePlacement(RarityFilter.onAverageOnceEvery(weight),placementModifier);
    }

}

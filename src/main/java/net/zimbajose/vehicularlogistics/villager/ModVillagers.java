package net.zimbajose.vehicularlogistics.villager;

import com.google.common.collect.ImmutableSet;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.VehicularLogistics;
import net.zimbajose.vehicularlogistics.block.ModBlocks;

import java.lang.reflect.InvocationTargetException;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, VehicularLogistics.MODID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, VehicularLogistics.MODID);

    public static final RegistryObject<PoiType> ASPHALT_BLOCK_POI = POI_TYPES.register("asphalt_block_poi",
            ()-> new PoiType(ImmutableSet.copyOf(ModBlocks.ASPHALT_BLOCK.get().getStateDefinition().getPossibleStates()),1,1));

    public static final RegistryObject<VillagerProfession> MECHANIC = VILLAGER_PROFESSIONS.register("mechanic",
            ()-> new VillagerProfession("mechanic", x-> x.get() == ASPHALT_BLOCK_POI.get(),
                    x-> x.get() == ASPHALT_BLOCK_POI.get(),
                    ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.VILLAGER_WORK_ARMORER));

    public static void register(IEventBus eventBus){
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }

    public static void registerPOIs(){
        try{
            ObfuscationReflectionHelper.findMethod(PoiType.class,
                    "registerBlockStates",PoiType.class).invoke(null,ASPHALT_BLOCK_POI.get());
        }
        catch (InvocationTargetException | IllegalAccessException exception){
            exception.printStackTrace();
        }
    }

}


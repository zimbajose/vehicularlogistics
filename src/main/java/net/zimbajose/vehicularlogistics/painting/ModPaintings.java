package net.zimbajose.vehicularlogistics.painting;

import net.minecraft.world.entity.decoration.PaintingVariant;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.VehicularLogistics;

public class ModPaintings {
    public static final DeferredRegister<PaintingVariant> PAINTING_VARIANTS =
            DeferredRegister.create(ForgeRegistries.PAINTING_VARIANTS, VehicularLogistics.MODID);

    public static final RegistryObject<PaintingVariant> MCLAREN_F1 = PAINTING_VARIANTS.register("mclaren_f1",
            ()->
                new PaintingVariant(32,32));

    public static void register(IEventBus eventBus){
        PAINTING_VARIANTS.register(eventBus);
    }

}

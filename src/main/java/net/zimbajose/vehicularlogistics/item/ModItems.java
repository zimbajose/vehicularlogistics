package net.zimbajose.vehicularlogistics.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.block.ModBlocks;
import net.zimbajose.vehicularlogistics.item.custom.GpsItem;

import static net.zimbajose.vehicularlogistics.VehicularLogistics.MODID;
//This class is for the car parts, that can be added to a car
public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> cheap_clutch = ITEMS.register("cheap_clutch", ()-> new Item
            (new Item.Properties()
                    .stacksTo(8).tab(ModCreativeModeTabs.CAR_PARTS_TAB)));

    public static final RegistryObject<Item> GPS = ITEMS.register("gps",
            () -> new GpsItem(new Item.Properties().tab(ModCreativeModeTabs.CAR_PARTS_TAB)));

    public static final RegistryObject<Item> GREENSTONE = ITEMS.register("greenstone",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTabs.MATERIALS_TAB)));

    public static final RegistryObject<Item> GREENSTONE_SEEDS = ITEMS.register("greenstone_seeds",
            () -> new ItemNameBlockItem(ModBlocks.GREEN_STONE_CROP_BLOCK.get(),new Item.Properties().tab(ModCreativeModeTabs.MATERIALS_TAB)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}

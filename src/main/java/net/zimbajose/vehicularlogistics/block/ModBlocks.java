package net.zimbajose.vehicularlogistics.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zimbajose.vehicularlogistics.VehicularLogistics;
import net.zimbajose.vehicularlogistics.block.custom.HotTarBlock;
import net.zimbajose.vehicularlogistics.block.custom.crop.GreenStoneCropBlock;
import net.zimbajose.vehicularlogistics.block.custom.signal_light.SignalLampBlock;
import net.zimbajose.vehicularlogistics.item.ModCreativeModeTabs;
import net.zimbajose.vehicularlogistics.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, VehicularLogistics.MODID);

    public static final RegistryObject<Block> ASPHALT_BLOCK = registerBlock("asphalt_block",
            ()-> new Block(BlockBehaviour.
                    Properties.of(Material.STONE).
                    strength(0.5f).
                    requiresCorrectToolForDrops()),
            ModCreativeModeTabs.BUILD_BLOCKS_TAB);

    public static final RegistryObject<Block> HOT_TAR_BLOCK = registerBlock("hot_tar_block",
            () -> new HotTarBlock(BlockBehaviour.Properties.of(Material.SCULK)
                    .requiresCorrectToolForDrops()
                    .strength(0.35f)
                    .friction(0.8f)
                    ),
            ModCreativeModeTabs.BUILD_BLOCKS_TAB
            );

    public static final RegistryObject<Block> GREENSTONE_ORE = registerBlock("greenstone_ore_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()),
            ModCreativeModeTabs.BUILD_BLOCKS_TAB
            );

    //Adds the signal lamps blocks
    public static final RegistryObject<Block> SIGNAL_LAMP_BLOCK = registerBlock("signal_lamp_block",
            () -> new SignalLampBlock(BlockBehaviour.Properties.of(Material.GLASS)
                    .requiresCorrectToolForDrops()
                    .lightLevel(state -> state.getValue(SignalLampBlock.LIT) ? 15 : 0)
                    .strength(0.5f)
                    )

                    ,
            ModCreativeModeTabs.BUILD_BLOCKS_TAB
            );

    public static final RegistryObject<Block> GREEN_STONE_CROP_BLOCK = BLOCKS.register("greenstone_crop_block",
            () -> new GreenStoneCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab){
        RegistryObject<T> returnObj = BLOCKS.register(name,block);
        registerBlockItem(name,returnObj,tab);
        return returnObj;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,CreativeModeTab tab){
        return ModItems.ITEMS.register(name,
                ()-> new BlockItem(block.get(),new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus iEventBus){
        BLOCKS.register(iEventBus);
    }
}

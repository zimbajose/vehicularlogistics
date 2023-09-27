package net.zimbajose.vehicularlogistics.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.zimbajose.vehicularlogistics.block.ModBlocks;

public class ModCreativeModeTabs {
    public static final CreativeModeTab CAR_PARTS_TAB = new CreativeModeTab("carpartstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.cheap_clutch.get());
        }
    };
    public static final CreativeModeTab BUILD_BLOCKS_TAB = new CreativeModeTab("carblockstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModBlocks.ASPHALT_BLOCK.get());
        }
    };

    public static final CreativeModeTab MATERIALS_TAB = new CreativeModeTab("materialstab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.GREENSTONE.get());
        }
    };
}

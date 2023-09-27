package net.zimbajose.vehicularlogistics.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zimbajose.vehicularlogistics.VehicularLogistics;
import net.zimbajose.vehicularlogistics.block.ModBlocks;
import net.zimbajose.vehicularlogistics.item.ModItems;
import net.zimbajose.vehicularlogistics.villager.ModVillagers;

import java.util.List;

@Mod.EventBusSubscriber(modid = VehicularLogistics.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class EventHandler {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event){
        if(event.getType() == ModVillagers.MECHANIC.get()){

            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            trades.get(2).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 4),
                    new ItemStack(ModItems.cheap_clutch.get(),1),
                    2,12,0.02f
            ));

            trades.get(1).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(ModBlocks.ASPHALT_BLOCK.get(), 12),
               8,4,0.02f
            ));


            trades.get(1).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(ModItems.GREENSTONE.get(),8),
                    new ItemStack (Items.EMERALD,1),
                    5, 4, 0.02f
            ));

            trades.get(1).add((trader,rand)-> new MerchantOffer(
                    new ItemStack(Items.EMERALD,1),
                    new ItemStack(ModItems.GREENSTONE_SEEDS.get(),4),
                    2,6,0.02f
            ));

        }
    }

    @SubscribeEvent
    public static void pickupItem(EntityItemPickupEvent event){

    }
}

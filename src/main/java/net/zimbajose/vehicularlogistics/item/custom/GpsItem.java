package net.zimbajose.vehicularlogistics.item.custom;


import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class GpsItem extends Item {
    public GpsItem(Properties properties){
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if(!level.isClientSide()){
            //Sends player coordinates on chat
            double playerX = player.getX();
            double playerY = player.getY();
            double playerZ = player.getZ();
            String message = "This are your exact coordinates:\n" +
                    "X: "+playerX + "\n"+
                    "Y: "+playerY + "\n"+
                    "Z: "+playerZ;
            player.sendSystemMessage(Component.literal(message));
            //Sets cooldown
            player.getCooldowns().addCooldown(this,20);
        }
        return super.use(level, player, hand);
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.literal("Right click with this item in hand to display your current coordinates").withStyle(ChatFormatting.BLUE));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }
}

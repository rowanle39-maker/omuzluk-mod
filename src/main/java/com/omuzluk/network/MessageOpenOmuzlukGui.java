package com.omuzluk.network;

import com.omuzluk.OmuzlukMod;
import com.omuzluk.proxy.GuiHandlerOmuzluk;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageOpenOmuzlukGui implements IMessage {

    public MessageOpenOmuzlukGui() {
    }

    @Override
    public void fromBytes(ByteBuf buf) {
    }

    @Override
    public void toBytes(ByteBuf buf) {
    }

    public static class Handler implements IMessageHandler<MessageOpenOmuzlukGui, IMessage> {
        @Override
        public IMessage onMessage(MessageOpenOmuzlukGui message, MessageContext ctx) {
            EntityPlayerMP player = ctx.getServerHandler().player;
            player.getServerWorld().addScheduledTask(() ->
                    player.openGui(OmuzlukMod.instance, GuiHandlerOmuzluk.GUI_ID_OMUZLUK,
                            player.world, 0, 0, 0));
            return null;
        }
    }
}

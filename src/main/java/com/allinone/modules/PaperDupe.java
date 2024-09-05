package com.allinone.modules;

import it.unimi.dsi.fastutil.ints.Int2ObjectMaps;
import meteordevelopment.meteorclient.events.world.TickEvent;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.orbit.EventHandler;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.BookUpdateC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;

import java.util.List;
import java.util.Optional;

import com.allinone.Addon;

public class PaperDupe extends Module {

    public PaperDupe() {
        super(Addon.CATEGORY, "paper-dupe", "Paper 1.20.4-1.21.1, requires writable book. Relog before use");
    }

    @EventHandler
    private void onTick(TickEvent.Post event) {
        if (!(mc.player.getInventory().getMainHandStack().getItem() == Items.WRITABLE_BOOK)) {
            mc.player.sendMessage(Text.of("Please hold a writable book!"));
            toggle();
            return;
        }
        for (int i = 9; i < 44; i++) {
            if (36 + mc.player.getInventory().selectedSlot == i)
                continue;
            mc.player.networkHandler.sendPacket(new ClickSlotC2SPacket(
                    mc.player.currentScreenHandler.syncId,
                    mc.player.currentScreenHandler.getRevision(),
                    i,
                    1,
                    SlotActionType.THROW,
                    ItemStack.EMPTY,
                    Int2ObjectMaps.emptyMap()));
        }
        mc.player.networkHandler.sendPacket(new BookUpdateC2SPacket(
                mc.player.getInventory().selectedSlot, List.of(""),
                Optional.of("The quick brown fox jumps over the lazy dog")));
        toggle();
    }
}

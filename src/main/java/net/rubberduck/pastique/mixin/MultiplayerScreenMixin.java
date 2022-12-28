package net.rubberduck.pastique.mixin;

import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerInfo;
import net.rubberduck.pastique.Pastique;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MultiplayerScreen.class)
public class MultiplayerScreenMixin {
    @Inject(at = @At("TAIL"), method = "connect(Lnet/minecraft/client/network/ServerInfo;)V")
    private void connect (ServerInfo entry, CallbackInfo ci) {
        Pastique.LOGGER.info("Connected To A Server");
        Pastique.currentServer = entry;
    }
}

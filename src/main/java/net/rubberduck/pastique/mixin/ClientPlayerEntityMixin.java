package net.rubberduck.pastique.mixin;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.rubberduck.pastique.Pastique;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ClientPlayerEntityMixin {
    @Inject(at = @At("TAIL"), method = "onSpawnPacket()V")
    public void onSpawnPacket(EntitySpawnS2CPacket packet, CallbackInfo ci) {
        Pastique.playerSpawn(packet);
    }
}

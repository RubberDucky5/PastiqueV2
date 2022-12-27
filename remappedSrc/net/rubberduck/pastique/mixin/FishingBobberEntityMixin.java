package net.rubberduck.pastique.mixin;

import net.minecraft.entity.projectile.FishingBobberEntity;
import net.rubberduck.pastique.Pastique;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(FishingBobberEntity.class)
public class FishingBobberEntityMixin {
    @Shadow private boolean caughtFish;

    @Inject(at = @At("TAIL"), method = "tick()V")
    public void tick(CallbackInfo info){
        Pastique.caughtFish = caughtFish;
    }
}

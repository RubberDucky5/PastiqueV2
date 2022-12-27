package net.rubberduck.pastique.module;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.math.Vec3d;

public class CreativeFly extends Module{

    private int ticker = 0;
    float FALL_SPEED = -0.05f;

    public CreativeFly() {
        super("Creative Fly", "I am superman!!");
    }

    @Override
    public void tick(ClientWorld cw) {
        mc.player.getAbilities().allowFlying = true;

        if(cw == null) return;
        if(ticker % 40 == 0 && mc.player.getAbilities().flying){
            Vec3d currentVel = mc.player.getVelocity();
            mc.player.setVelocity(new Vec3d(currentVel.x, FALL_SPEED, currentVel.z));
        }

        ticker++;
    }

    @Override
    public void onDisable() {
        mc.player.getAbilities().allowFlying = false;
        mc.player.getAbilities().flying = false;
    }
}

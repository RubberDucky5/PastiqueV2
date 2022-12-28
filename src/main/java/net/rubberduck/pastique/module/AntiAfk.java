// This module does not currently work on aternos servers, which is why I wanted to make it :(

package net.rubberduck.pastique.module;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;

import java.util.Random;

public class AntiAfk extends Module {
    public int timer = 0;

    Random rand = new Random();
    public AntiAfk () {
        super("Anti-AFK", "Keeps you awake :)");
    }

    @Override
    public void tick (ClientWorld cw) {

        if(mc.player == null) return;

        if(timer < 20) mc.player.applyMovementInput(new Vec3d(1, 0, 0), 1.0f);
        else mc.player.applyMovementInput(new Vec3d(-1, 0, 0), 1.0f);
        mc.player.changeLookDirection(rand.nextDouble(720) - 360.0, rand.nextDouble(720) - 360.0);


        timer++;
        if(timer > 40) timer = 0;
    }
}

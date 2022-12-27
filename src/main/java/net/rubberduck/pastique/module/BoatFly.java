package net.rubberduck.pastique.module;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Vec3d;

public class BoatFly extends Module{

    private int ticker = 0;
    float FALL_SPEED = -0.05f;
    float VERTICAL_SPEED = 0.2f;

    public BoatFly() {
        super("Boat Fly", "It's a bird! It's a plane! It's a boat!");
    }

    @Override
    public void tick(ClientWorld cw) {
        if(cw == null) return;

        if(!mc.player.hasVehicle()) return;

        boolean jumpKey = mc.options.jumpKey.isPressed();
        Entity vehicle = mc.player.getVehicle();
        Vec3d currentVel = vehicle.getVelocity();

        if(jumpKey){
            vehicle.setVelocity(new Vec3d(currentVel.x, VERTICAL_SPEED, currentVel.z));
        }

        if(ticker % 40 == 0){
            vehicle.setVelocity(new Vec3d(currentVel.x, FALL_SPEED, currentVel.z));
        }

        ticker++;
    }

    @Override
    public void onEnable() {
    }

    @Override
    public void onDisable() {
    }
}

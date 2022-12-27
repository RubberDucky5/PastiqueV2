package net.rubberduck.pastique.module;

import net.fabricmc.loader.impl.lib.sat4j.core.Vec;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.Vec3d;
import net.rubberduck.pastique.Pastique;
import net.rubberduck.pastique.screen.setting.SettingTextWidget;

public class SpeedFly extends Module {
    public double DEFAULT_SPEED = 3d;
    public float FALL_SPEED = -0.05f;
    private int ticker;

    public SpeedFly () {
        super("Speed Fly", "Nyoooom!", 71);
    }

    @Override
    public void tick(ClientWorld cw) {
        if(mc.player == null) return;

        boolean leftKey = mc.options.leftKey.isPressed();
        boolean rightKey = mc.options.rightKey.isPressed();
        boolean forwardKey = mc.options.forwardKey.isPressed();
        boolean backKey = mc.options.backKey.isPressed();
        boolean jumpKey = mc.options.jumpKey.isPressed();
        boolean sneakKey = mc.options.sneakKey.isPressed();
        //mc.player.setNoGravity(true);

        Vec3d newVelocity = new Vec3d(0, 0, 0);
        Vec3d currentVelocity = mc.player.getVelocity();

        if(jumpKey) {
            if (leftKey) {
                newVelocity = newVelocity.add(mc.player.getRotationVector().rotateY(3.141592f));
                newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z).normalize().multiply(DEFAULT_SPEED);
            }
            if (rightKey) {
                newVelocity = newVelocity.add(mc.player.getRotationVector().rotateY(-3.141592f));
                newVelocity = new Vec3d(newVelocity.x, 0, newVelocity.z).normalize().multiply(DEFAULT_SPEED);
            }
            if (forwardKey)
                newVelocity = newVelocity.add(mc.player.getRotationVector().multiply(DEFAULT_SPEED));
            if (backKey)
                newVelocity = newVelocity.add(mc.player.getRotationVector().negate().multiply(DEFAULT_SPEED));

            if(ticker % 40 == 0){
                mc.player.setVelocity(new Vec3d(newVelocity.x, FALL_SPEED, newVelocity.z));
            }
            ticker++;

            mc.player.setVelocity(newVelocity);
        }

    }

    @Override
    public void onDisable() {
        //mc.player.setNoGravity(false);
    }
}

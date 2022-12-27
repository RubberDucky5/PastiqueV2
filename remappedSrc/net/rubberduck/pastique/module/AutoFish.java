package net.rubberduck.pastique.module;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Hand;
import net.rubberduck.pastique.Pastique;

public class AutoFish extends Module{
    private int ticker;
    private boolean toCast = false;
    public int TIME_BETWEEN_FISH = 5;

    public AutoFish () {
        super("Auto Fish", "Fishes for  you!");
    }

    @Override
    public void tick(ClientWorld cw) {
        if(mc.player == null) return;
        if(Pastique.caughtFish) {
            mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND);
            ticker = TIME_BETWEEN_FISH;
            toCast = true;
        }
        if(ticker <= 0 && toCast){
            mc.interactionManager.interactItem(mc.player, Hand.MAIN_HAND);
            toCast = false;
        }

        ticker --;
    }
}

package net.rubberduck.pastique.module;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.rubberduck.pastique.Pastique;

import javax.sound.midi.SysexMessage;

public class Fullbright extends Module {
    double prevGamma;

    public Fullbright () {
        super("Fullbright", "Makes you SEE");
    }

//    @Override
//    public void onEnable () {
//        prevGamma = mc.options.getGamma().getValue();
//        System.out.println(prevGamma);
//        mc.options.getGamma().setValue(10d);
//    }
//
//    @Override
//    public void onDisable () {
//        mc.options.getGamma().setValue(prevGamma);
//    }

    @Override
    public void tick (ClientWorld cw) {
        if(mc.player == null) return;
        mc.player.addStatusEffect(new StatusEffectInstance(StatusEffects.NIGHT_VISION, 4140, 1));
    }

    @Override
    public void onDisable () {
        mc.player.removeStatusEffect(StatusEffects.NIGHT_VISION);
    }
}

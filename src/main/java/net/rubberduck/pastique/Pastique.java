package net.rubberduck.pastique;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ServerInfo;
//import net.minecraft.network.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.text.Text;
import net.rubberduck.pastique.module.*;
import net.rubberduck.pastique.module.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.text.html.parser.Entity;

public class Pastique implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("PastiqueV2");
	protected static final MinecraftClient mc = MinecraftClient.getInstance();
	public static Module[] mods = new Module[8];

	public static boolean caughtFish = false;

	public static ServerInfo currentServer = null;

	@Override
	public void onInitialize() {
		LOGGER.info("PastiqueV2 Starting...");

		mods[0] = new AutoFish();
		mods[1] = new BoatFly();
		mods[2] = new CreativeFly();
		mods[3] = new SpeedFly();
		//mods[4] = new Xray();
		mods[4] = new Fullbright();
		mods[5] = new AutoFarm();
		mods[6] = new AntiAfk();
		mods[7] = new AutoReconnect();
	}

	public static Text getModEnabledText(Module mod) {
		return Text.of(mod.getName() + ( mod.isEnabled() ? " is enabled" : " is disabled"));
	}

	public static void playerSpawn(EntitySpawnS2CPacket packet) {
		for(int i = 0; i < mods.length; i++) {
			if (mods[i].isEnabled()) {
				mods[i].onSpawn(packet);
			}
		}
	}

//	public static void sendPacket(Packet packet){
//		mc.getNetworkHandler().sendPacket(packet);
//	}

	public static void tick() {
		for(int i = 0; i < mods.length; i++) {
			if (mods[i].isEnabled()) {
				mods[i].tick(mc.world);
			}
		}
	}

	public static void onKey(int key, int action){
		// This is release
		if(action != 0) return;

		for(int i = 0; i < mods.length; i++) {
			if (mods[i].keyCode == key) {
				mods[i].toggle();
			}
		}
	}

	public static void trigger(String event){
		for(int i = 0; i < mods.length; i++) {
			if (mods[i].isEnabled()) {
				mods[i].trigger(event);
			}
		}
	}
}

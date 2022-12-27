package net.rubberduck.pastique.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerSpawnS2CPacket;
import net.rubberduck.pastique.Pastique;
import net.rubberduck.pastique.screen.setting.EmptySetting;
import net.rubberduck.pastique.screen.setting.SettingToggleWidget;
import net.rubberduck.pastique.screen.setting.SettingWidget;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Arrays;

public class Module {
    protected static final MinecraftClient mc = MinecraftClient.getInstance();
    private final ArrayList<SettingWidget<?>> settings;
    private String name;
    private String desc;

    @Nullable
    public int keyCode;

    private boolean enabled = false;


    Module (String n, String description, @Nullable int key, SettingWidget<?>... settings) {
        name = n;
        desc = description;
        keyCode = key;
        this.settings = new ArrayList<>(Arrays.asList(settings));
    }
    //Depreciated
    Module (String n, String description, @Nullable int key) {
        this(n, description, key, new EmptySetting());
    }
    //Depreciated
    Module (String n, String description) {
        this(n, description, 808080, new EmptySetting());
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        if(this.enabled) {
            onEnable();
            return;
        }
        onDisable();
    }

    public void toggle() {
        if(this.enabled) {
            this.enabled = false;
            this.onDisable();
            return;
        }
        this.enabled = true;
        this.onEnable();
    }

    public void tick(ClientWorld cw) {

    }

    public void onSpawn (EntitySpawnS2CPacket packet){

    }

    public void onEnable () {
        // Pastique.LOGGER.info(this.name + " enabled!");
    }

    public void onDisable () {
        // Pastique.LOGGER.info(this.name + " disabled!");
    }

    public void onNewPlayer (PlayerEntity player) {
    }
}

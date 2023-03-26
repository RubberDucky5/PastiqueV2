package net.rubberduck.pastique.module;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ConnectScreen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.network.ServerAddress;
import net.rubberduck.pastique.Pastique;

public class AutoReconnect extends Module{
    public AutoReconnect () {
        super("Auto Reconnect", "Automatically Reconnects to a server if disconnected");
    }

    @Override
    public void trigger(String event) {
        if(event != "recon") return;
        if(Pastique.currentServer == null) return;
        ConnectScreen.connect(
                new MultiplayerScreen(new TitleScreen()),
                MinecraftClient.getInstance(),
                ServerAddress.parse(Pastique.currentServer.address),
                Pastique.currentServer);
    }
}

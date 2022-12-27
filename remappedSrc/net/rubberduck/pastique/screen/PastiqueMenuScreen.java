package net.rubberduck.pastique.screen;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.rubberduck.pastique.Pastique;
import net.rubberduck.pastique.module.Module;

public class PastiqueMenuScreen extends Screen {
    public PastiqueMenuScreen(Text title) {
        super(title);
    }

    @Override
    protected void init() {
        super.init();
        for(int i = 0; i < Pastique.mods.length; i++){
            Module mod = Pastique.mods[i];
            int y = this.height / 2 - 10 - (Pastique.mods.length * 25) / 2;
            y += i * 25;
            ButtonWidget button = new ButtonWidget(this.width / 2 - 100, y, 200, 20, Pastique.getModEnabledText(mod), b -> {
                mod.toggle();
                // Janky Ahh :(
                client.setScreen(new PastiqueMenuScreen(Text.of("Pastique Menu")));
            });
        }

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        GameMenuScreen.drawCenteredText(matrices, this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}

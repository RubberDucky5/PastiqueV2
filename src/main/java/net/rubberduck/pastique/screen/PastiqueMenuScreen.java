package net.rubberduck.pastique.screen;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.rubberduck.pastique.Pastique;
import net.rubberduck.pastique.module.Module;

import java.util.regex.Pattern;

public class PastiqueMenuScreen extends Screen {
    public PastiqueMenuScreen(Text title) {
        super(title);
    }

    @Override
    protected void init () {
        super.init();
        for(int i = 0; i < Pastique.mods.length; i++){
            Module mod = Pastique.mods[i];
            int y = this.height / 2 - 10 - (Pastique.mods.length * 25) / 2;
            y += i * 25;
            ButtonWidget button = ButtonWidget.builder(Pastique.getModEnabledText(mod), b -> {
                //Pastique.LOGGER.info((int) b.lastButton);
                mod.toggle();
                // Janky Ahh :(
                client.setScreen(new PastiqueMenuScreen(Text.of("Pastique Menu")));
            })
                    .tooltip(Tooltip.of(Text.of(mod.getDesc())))
                    .dimensions(this.width / 2 - 100, y, 200, 20)
                    .build();
            this.addDrawableChild(button);
        }

    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        GameMenuScreen.drawCenteredTextWithShadow(matrices, this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}

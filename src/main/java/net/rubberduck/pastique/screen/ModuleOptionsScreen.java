package net.rubberduck.pastique.screen;

import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.ControlsListWidget;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.KeybindTextContent;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableTextContent;
import net.rubberduck.pastique.module.Module;

public class ModuleOptionsScreen extends Screen {
    public Module mod = null;

    public ModuleOptionsScreen (Text title) {
        super(title);
    }
    public ModuleOptionsScreen (Text title, Module mod) {
        super(title);
        this.mod = mod;
    }

    protected void init() {
        super.init();

//        this.addDrawableChild(new ButtonWidget(this.width / 2 - 100, this.height / 2 - 10, 200, 20, Text.of(""), b -> {
//
//        }));
    }

    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta) {
        this.renderBackground(matrices);
        //aaaaaaa
        drawCenteredTextWithShadow(matrices, this.textRenderer, this.title, this.width / 2, 20, 0xFFFFFF);
        super.render(matrices, mouseX, mouseY, delta);
    }
}

package net.rubberduck.pastique.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.FatalErrorScreen;
import net.minecraft.client.gui.screen.GameMenuScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.LiteralTextContent;
import net.minecraft.text.Text;
import net.rubberduck.pastique.screen.PastiqueMenuScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameMenuScreen.class)
public class GameMenuScreenMixin extends Screen {
    GameMenuScreenMixin(Text text) { super(text); }

    @Inject(at = @At("HEAD"), method = "initWidgets")
    void initWidgets (CallbackInfo ci) {
        addDrawableChild(ButtonWidget.builder(Text.literal("Pastique"), b -> client.setScreen(new PastiqueMenuScreen(Text.of("Pastique Menu"))))
                .dimensions(10, 10, 50, 20).build());
        //addDrawableChild(new ButtonWidget(10, 10, 50, 20, Text.of("Pastique"), (button) -> {
        //   client.setScreen(new PastiqueMenuScreen(Text.of("Pastique Menu")));
        //}));
    }
}

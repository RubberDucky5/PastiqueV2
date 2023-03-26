package net.rubberduck.pastique.mixin;

import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClickableWidget.class)
public class ClickableWidgetMixin {
    int lastButton;


}

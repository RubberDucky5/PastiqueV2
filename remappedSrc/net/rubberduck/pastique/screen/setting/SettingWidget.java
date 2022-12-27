package net.rubberduck.pastique.screen.setting;

import net.minecraft.client.gui.Drawable;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.text.Text;

import java.awt.*;

public abstract class SettingWidget<T> {

    public String name;
    public String tooltip;

    private T state;

    public SettingWidget (String name, String tooltip) {
        this.name = name;
        this.tooltip = tooltip;
    }

    public Drawable draw (int x, int y) {
        return new ButtonWidget(x - 100, y - 10, 200, 20, Text.of(name), b-> {});
    }

    public T getState() {
        return state;
    }
}

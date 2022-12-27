package net.rubberduck.pastique.screen.setting;

import net.minecraft.client.gui.widget.ButtonWidget;
import org.w3c.dom.Text;

public class SettingToggleWidget extends SettingWidget {
    boolean defaultState;
    boolean state;
    public SettingToggleWidget (String name, String tooltip, boolean defaultState) {
        super(name, tooltip);
        this.defaultState = defaultState;
        this.state = defaultState;
    }
}

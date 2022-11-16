package dev.nano.azkar.intelliJ.plugin.settings.settingsInterface;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class PanelBuilder {

    private final JPanel panel;

    public PanelBuilder() {
        panel = new JPanel();
    }

    public PanelBuilder setBorder(final Border border) {
        panel.setBorder(border);
        return this;
    }

    public PanelBuilder setLayout(final LayoutManager layout) {
        panel.setLayout(layout);
        return this;
    }

    public PanelBuilder addComponent(final Component component) {
        panel.add(component);
        return this;
    }

    public PanelBuilder addComponent(final JComponent component, final Object constraints) {
        panel.add(component, constraints);
        return this;
    }

    public JPanel build() {
        return panel;
    }
}

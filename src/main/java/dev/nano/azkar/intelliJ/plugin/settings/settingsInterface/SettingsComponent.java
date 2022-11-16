package dev.nano.azkar.intelliJ.plugin.settings.settingsInterface;

import com.intellij.ui.components.JBLabel;
import com.intellij.util.ui.FormBuilder;
import lombok.extern.slf4j.Slf4j;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;

@Slf4j
public class SettingsComponent {

    private final JPanel mainPanel;
    private final JCheckBox basmalahOnStartIsActivateCheckBox;
    private final JCheckBox basmalahOnStartIsSoundActiveCheckBox;
    private final JSpinner notificationIntervalSpinner;
    private SpinnerNumberModel notificationIntervalSpinnerModel;

    {
        basmalahOnStartIsActivateCheckBox = new JCheckBox("Basmalah on start");
        basmalahOnStartIsSoundActiveCheckBox = new JCheckBox("Auto play sound of basmalah");
        notificationIntervalSpinner = new JSpinner();
    }

    public SettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addComponent(new PanelBuilder()
                        .setLayout(new MigLayout("fill"))
                        .addComponent(
                                new PanelBuilder()
                                        .setBorder(BorderFactory.createTitledBorder("Basmalah on start"))
                                        .setLayout(new MigLayout())
                                        .addComponent(basmalahOnStartIsActivateCheckBox, "span, grow")
                                        .addComponent(basmalahOnStartIsSoundActiveCheckBox)
                                        .build(),
                                "span, grow, wrap"
                        )
                        .addComponent(new JBLabel("Notifications interval"),
                                "gap unrelated")
                        .addComponent(notificationIntervalSpinner, "grow")
                        .addComponent(new JBLabel("Minutes"), "gap 1, wrap")
                        .build()
                )
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }
}

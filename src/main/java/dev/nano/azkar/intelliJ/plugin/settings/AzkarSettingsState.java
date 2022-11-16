package dev.nano.azkar.intelliJ.plugin.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.State;
import com.intellij.util.xmlb.XmlSerializerUtil;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.intellij.openapi.components.Storage;

@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@State(
        name = "dev.nano.azkar.intelliJ.plugin.settings.AzkarSettingsState",
        storages = {
                @Storage("azkar.xml")
        }
)
public class AzkarSettingsState implements PersistentStateComponent<AzkarSettingsState> {

    private BasmalahOnStart basmalahOnStart;
    private long timeIntervalBetweenNotifications;

    public static AzkarSettingsState getInstance() {
        return ApplicationManager.getApplication().getService(AzkarSettingsState.class);
    }

    @Override
    public @Nullable AzkarSettingsState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull AzkarSettingsState state) {
        XmlSerializerUtil.copyBean(state, this);
    }
}

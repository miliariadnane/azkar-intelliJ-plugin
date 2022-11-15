package dev.nano.azkar.intelliJ.plugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import org.jetbrains.annotations.NotNull;

public class AzkarStartupActivity implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        System.out.println("Hello World!");

        new Notification(
                "dev.nano.azkar.intelliJ.plugin.notificationGroup",
                "Azkar",
                "Hello World!",
                NotificationType.INFORMATION
        ).notify(project);
    }


}

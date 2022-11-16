package dev.nano.azkar.intelliJ.plugin;

import com.intellij.notification.Notification;
import com.intellij.notification.NotificationGroupManager;
import com.intellij.notification.NotificationType;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.startup.StartupActivity;
import dev.nano.azkar.intelliJ.plugin.dataSource.ReadData;
import dev.nano.azkar.intelliJ.plugin.dataSource.bean.Zikr;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.List;

public class AzkarStartupActivity implements StartupActivity {

    @Override
    public void runActivity(@NotNull Project project) {
        // System.out.println("Hello World!");

        /*
        new Notification(
                "dev.nano.azkar.intelliJ.plugin.notificationGroup",
                "Azkar",
                "Hello World!",
                NotificationType.INFORMATION
        ).notify(project);
        */

        try {
            List<Zikr> zikrList = ReadData.getAzkarFromJson();
            NotificationGroupManager.getInstance()
                    .getNotificationGroup("Basmalah On start")
                    // get first zikr from json files
                    .createNotification(
                            zikrList.get(0).getZikr(),
                            NotificationType.INFORMATION
                    ).notify(project);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }


}

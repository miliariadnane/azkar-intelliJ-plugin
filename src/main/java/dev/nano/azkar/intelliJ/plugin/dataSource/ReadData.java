package dev.nano.azkar.intelliJ.plugin.dataSource;

import dev.nano.azkar.intelliJ.plugin.dataSource.bean.Zikr;
import org.apache.commons.io.IOUtils;
import com.google.common.collect.ImmutableList;
import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
public class ReadData {

    public static ImmutableList<Zikr> getAzkarFromJson() throws IOException {
        InputStream inputStream = Resources.getResource("azkar.json").openStream();
        String json = IOUtils.toString(inputStream);
        Type listType = new TypeToken<ArrayList<Zikr>>() {
        }.getType();
        List<Zikr> zikrList = new Gson().fromJson(json, listType);
        return ImmutableList.copyOf(zikrList);
    }
}

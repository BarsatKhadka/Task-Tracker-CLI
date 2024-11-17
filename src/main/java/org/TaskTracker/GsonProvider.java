package org.TaskTracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.TaskTracker.DateTime.LocalDateTimeAdapter;

import java.time.LocalDateTime;

public class GsonProvider {
    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter.LocalDateTimeSerializer())
            .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeAdapter.LocalDateTimeSerializer())
            .setPrettyPrinting()
            .create();
    private GsonProvider() {}
    public static Gson getGson() {
        return gson;
    }
}

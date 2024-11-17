package org.TaskTracker;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonProvider {
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private GsonProvider() {}
    public static Gson getGson() {
        return gson;
    }
}

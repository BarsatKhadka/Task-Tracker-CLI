package org.TaskTracker;

import com.google.gson.Gson;

public class GsonProvider {
    private static final Gson gson = new Gson();
    private GsonProvider() {}
    public static Gson getGson() {
        return gson;
    }
}

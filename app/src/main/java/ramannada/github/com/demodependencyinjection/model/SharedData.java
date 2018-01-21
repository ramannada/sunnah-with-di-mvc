package ramannada.github.com.demodependencyinjection.model;

import android.content.SharedPreferences;

import com.google.gson.Gson;

/**
 * Created by ramannada on 1/17/2018.
 */

public class SharedData {
    private SharedPreferences sharedPreferences;
    private Gson gson;

    public SharedData(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
    }

    public void save(Object object, String key) {
        sharedPreferences.edit()
                .putString(key, gson.toJson(object))
                .apply();
    }

    public <T> T get(String key, Class<T> type) {
        String json = sharedPreferences.getString(key, null);
        if (json == null) {
            return null;
        }

        return gson.fromJson(json, type);
    }
}

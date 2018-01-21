package ramannada.github.com.demodependencyinjection.module;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.preference.PreferenceManager;
import android.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ramannada.github.com.demodependencyinjection.model.SharedData;
import ramannada.github.com.demodependencyinjection.model.VolleyManager;

/**
 * Created by ramannada on 1/17/2018.
 */

@Module
public class AppModule {
    private Context context;

    public AppModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return this.context;
    }

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    @Singleton
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    public RequestQueue provideRequestQueu() {
        return Volley.newRequestQueue(context);
    }

    @Provides
    @Singleton
    public LruCache<String, Bitmap> provideCache() {
        return new LruCache(20);
    }

    @Provides
    @Singleton
    public ImageLoader provideImageLoader(RequestQueue requestQueue, final LruCache<String, Bitmap> cache) {

        return new ImageLoader(requestQueue, new ImageLoader.ImageCache() {
            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url, bitmap);
            }
        });
    }

    @Provides
    @Singleton
    public SharedData provideSharedData(SharedPreferences sharedPreferences, Gson gson) {
        return new SharedData(sharedPreferences, gson);
    }


}

package ramannada.github.com.demodependencyinjection;

import android.app.Application;
import ramannada.github.com.demodependencyinjection.component.AppComponent;
import ramannada.github.com.demodependencyinjection.component.DaggerAppComponent;
import ramannada.github.com.demodependencyinjection.module.AppModule;

/**
 * Created by ramannada on 1/17/2018.
 */

public class App extends Application {
    private static App app;
    private AppComponent appComponent;



    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(getApplicationContext()))
                .build();

    }

    public static App app() {
        return app;
    }

    public AppComponent appComponent() {
        return appComponent;
    }
}

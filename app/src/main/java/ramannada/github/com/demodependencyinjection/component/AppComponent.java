package ramannada.github.com.demodependencyinjection.component;

import javax.inject.Singleton;
import dagger.Component;
import ramannada.github.com.demodependencyinjection.ui.main.MainActivity;
import ramannada.github.com.demodependencyinjection.module.AppModule;

/**
 * Created by ramannada on 1/17/2018.
 */

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    void inject(MainActivity activity);
}

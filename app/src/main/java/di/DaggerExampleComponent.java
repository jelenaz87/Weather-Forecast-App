package di;

import com.example.android.sunshine.sync.SunshineSyncTask;
import com.example.android.sunshine.ui_component.MainActivity;

import dagger.Component;

/**
 * Created by danko.misic on 12/18/17.
 */

@Component(modules = {DaggerExampleModule.class})
public interface DaggerExampleComponent {
    void inject(MainActivity mainActivity);
}

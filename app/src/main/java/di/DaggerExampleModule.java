package di;

import android.content.Context;

import com.example.android.sunshine.sync.SunshineNotifications;
import com.example.android.sunshine.ui_component.ForecastAdapter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danko.misic on 12/18/17.
 */
@Module
public class    DaggerExampleModule {

    private Context context;
    private ForecastAdapter.ForecastAdapterOnClickHandler clickHandler;

    public DaggerExampleModule(Context context,ForecastAdapter.ForecastAdapterOnClickHandler clickHandler) {
        this.context = context;
        this.clickHandler =clickHandler;
    }

    @Provides
    Context provideContex(){
        return this.context;
    }

    @Provides
    ForecastAdapter.ForecastAdapterOnClickHandler provideOnClickHnadler(){
        return this.clickHandler;
    }

    @Provides
    ForecastAdapter provideForecastAdapter(Context context,ForecastAdapter.ForecastAdapterOnClickHandler clickHandler){
        return new ForecastAdapter(context, clickHandler);
    }

}

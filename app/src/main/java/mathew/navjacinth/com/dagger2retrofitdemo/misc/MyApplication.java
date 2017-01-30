package mathew.navjacinth.com.dagger2retrofitdemo.misc;

import android.app.Application;

import mathew.navjacinth.com.dagger2retrofitdemo.dagger.component.DaggerRetrofitComponent;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.component.RetrofitComponent;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.module.RetrofitModule;

/**
 * Created by Navjacinth Mathew on 1/29/2017.
 */

public class MyApplication extends Application {

    RetrofitComponent retrofitComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitComponent = DaggerRetrofitComponent.builder()
                .retrofitModule(new RetrofitModule())
                .build();
    }

    public RetrofitComponent getRetrofitComponent() {
        return retrofitComponent;
    }
}

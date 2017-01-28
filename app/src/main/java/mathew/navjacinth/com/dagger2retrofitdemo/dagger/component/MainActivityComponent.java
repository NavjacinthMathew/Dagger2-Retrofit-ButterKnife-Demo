package mathew.navjacinth.com.dagger2retrofitdemo.dagger.component;

import dagger.Component;
import mathew.navjacinth.com.dagger2retrofitdemo.activity.MainActivity;
import mathew.navjacinth.com.dagger2retrofitdemo.dagger.module.RetrofitModule;

/**
 * Created by Navjacinth Mathew on 01/28/2017.
 */

@Component(modules = {RetrofitModule.class})
public interface MainActivityComponent {
    void injectMainActivity(MainActivity mainActivity);
}

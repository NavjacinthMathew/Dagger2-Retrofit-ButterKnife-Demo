package mathew.navjacinth.com.dagger2retrofitdemo.dagger.module;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Navjacinth Mathew on 01/28/2017.
 */

@Module
public class RetrofitModule {

    @Provides
    public Gson providesGson() {
        return new Gson();
    }

    @Provides
    public Retrofit providesRetrofit(Gson mGson) {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(mGson))
                .baseUrl("http://nmathew.pe.hu/json/")
                .build();
    }
}

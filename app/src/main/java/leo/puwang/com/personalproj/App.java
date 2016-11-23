package leo.puwang.com.personalproj;

import android.app.Application;

import java.util.List;

import leo.puwang.com.personalproj.bean.RecommendedBean;
import leo.puwang.com.personalproj.call.RecommendSer;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Leo on 2016/11/22.
 */

public class App extends Application{

    private static String BASE_URL = "http://morguo.com";
    private static Retrofit mRetrofit;

    @Override
    public void onCreate() {
        super.onCreate();


    }

    public static Retrofit initRetrofit() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return mRetrofit;
    }


}

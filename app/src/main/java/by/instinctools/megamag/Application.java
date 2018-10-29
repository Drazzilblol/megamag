package by.instinctools.megamag;

import android.content.Context;

<<<<<<< HEAD
=======
import java.util.concurrent.TimeUnit;

>>>>>>> fc0a876543683defe7bda470fbbed39851e1060a
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import by.instinctools.megamag.common.SharedPrefs;
import by.instinctools.megamag.common.api.MegamagApi;
import by.instinctools.megamag.common.converters.HtmlConverterFactory;
import okhttp3.OkHttpClient;
<<<<<<< HEAD
=======

>>>>>>> fc0a876543683defe7bda470fbbed39851e1060a
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.BuildConfig;
import timber.log.Timber;

public class Application extends android.app.Application {

    private static final int TIMEOUT = 10000;
    private static Context context;

    private static MegamagApi megamagApi;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
        SharedPrefs.initSharedPrefs(this);

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(TIMEOUT, TimeUnit.SECONDS).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(new HtmlConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();

        megamagApi = retrofit.create(MegamagApi.class);
    }

    public static Context getAppContext() {
        return context;
    }

    public static MegamagApi getApi() {
        return megamagApi;
    }

    public static MegamagApi getApiGson() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        return retrofit.create(MegamagApi.class);
    }
}

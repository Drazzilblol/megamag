package by.instinctools.megamag;

import android.content.Context;

import by.instinctools.megamag.common.SharedPrefs;
import by.instinctools.megamag.common.api.MegamagApi;
import by.instinctools.megamag.common.converters.HtmlConverterFactory;
import by.instinctools.megamag.data.auth.CoocInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import timber.log.Timber;

public class Application extends android.app.Application {

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
                .addInterceptor(new CoocInterceptor())
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://kinoteatr.megamag.by/")
                .client(client)
                .addConverterFactory(new HtmlConverterFactory())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        megamagApi = retrofit.create(MegamagApi.class);
    }

    public static Context getAppContext() {
        return context;
    }

    public static MegamagApi getApi() {
        return megamagApi;
    }
}

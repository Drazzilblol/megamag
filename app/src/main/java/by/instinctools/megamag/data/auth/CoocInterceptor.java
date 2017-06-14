package by.instinctools.megamag.data.auth;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class CoocInterceptor
        implements Interceptor {

    @Override
    public Response intercept(Chain chain)
            throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request r = new Request.Builder()
                .url("http://kinoteatr.megamag.by/index.php")
                .build();

        Response response1 = client.newCall(r).execute();

        Request request = chain.request();

        request = request.newBuilder()
                .addHeader("Cookie", response1.networkResponse().headers("Set-Cookie").get(0))
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
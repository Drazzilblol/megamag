package by.instinctools.megamag.common.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MegamagApi {

    @GET("/index.php")
    Call<ResponseBody> getData();

    @GET("/howto_pay.php")
    Call<ResponseBody> getHowToPayInfo();

    @GET("/howto_rules.php")
    Call<ResponseBody> getRulesInfo();
}

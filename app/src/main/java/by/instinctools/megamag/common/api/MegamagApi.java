package by.instinctools.megamag.common.api;

import org.jsoup.nodes.Document;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface MegamagApi {

    @GET("/index.php")
    Call<Document> getData();

    @GET("/howto_pay.php")
    Call<Document> getHowToPayInfo();

    @GET("/howto_rules.php")
    Call<Document> getRulesInfo();
}

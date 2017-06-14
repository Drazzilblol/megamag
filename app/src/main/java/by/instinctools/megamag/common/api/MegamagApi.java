package by.instinctools.megamag.common.api;

import org.jsoup.nodes.Document;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MegamagApi {

    @GET("/index.php")
    Observable<Document> getData();

    @GET("/howto_pay.php")
    Observable<Document> getHowToPayInfo();

    @GET("/howto_rules.php")
    Observable<Document> getRulesInfo();

    @FormUrlEncoded
    @POST("/login.php?action=process_new")
    Observable<ResponseBody> login(@Field("username") String username, @Field("password") String password);
}

package by.instinctools.megamag.common.api;


import org.jsoup.nodes.Document;

import by.instinctools.megamag.common.api.pojo.PageResponse;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
<<<<<<< HEAD
import retrofit2.http.POST;
=======
import retrofit2.http.Query;
import retrofit2.http.POST;

>>>>>>> fc0a876543683defe7bda470fbbed39851e1060a

public interface MegamagApi {

    @GET("/index.php")
    Observable<Document> getData();

    @GET("/howto_pay.php")
    Observable<Document> getHowToPayInfo();

    @GET("/howto_rules.php")
    Observable<Document> getRulesInfo();

<<<<<<< HEAD
=======
    @GET("/newsdesk_info.php")
    Observable<Document> getDetails(@Query("newsdesk_id") String id);

>>>>>>> fc0a876543683defe7bda470fbbed39851e1060a
    @POST("/includes/backend/newsdesk_sticky.back.php?rand=0.8525914567838275&JsHttpRequest=0-xml")
    Observable<PageResponse> getPage(@Body String page);
}

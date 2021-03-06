package by.instinctools.megamag.common.api;

import org.jsoup.nodes.Document;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface MegamagApi {

    @GET("/index.php")
    Observable<Document> getData();

    @GET("/howto_pay.php")
    Observable<Document> getHowToPayInfo();

    @GET("/howto_rules.php")
    Observable<Document> getRulesInfo();
}

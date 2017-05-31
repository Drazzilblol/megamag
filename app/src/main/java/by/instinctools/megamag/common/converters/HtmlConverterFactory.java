package by.instinctools.megamag.common.converters;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class HtmlConverterFactory extends Converter.Factory {

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        return HtmlConverter.INSTANCE;
    }

    private final static class HtmlConverter implements Converter<ResponseBody, Document> {
        static final HtmlConverter INSTANCE = new HtmlConverter();

        @Override
        public Document convert(ResponseBody value) throws IOException {
            return Jsoup.parse(value.string());
        }
    }
}

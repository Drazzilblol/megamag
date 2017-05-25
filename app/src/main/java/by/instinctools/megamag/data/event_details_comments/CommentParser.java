package by.instinctools.megamag.data.event_details_comments;

import android.support.annotation.NonNull;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

class CommentParser {

    private static final String COMMENTS_SELECTOR = "reviews_content";
    private static final String AVATAR_SELECTOR = "src";

    static List<EventCommentData> parseComments(@NonNull Document document) {
        List<EventCommentData> commentList = new ArrayList<>();

        Elements comments = document.getElementById(COMMENTS_SELECTOR).child(0).children();

        for (Element comment : comments) {
            Element textField = comment.child(1)
                    .child(0)
                    .child(0);
            EventCommentData.Builder builder = EventCommentData.builder();

            String text = textField.child(1)
                    .text();
            builder.text(text);

            String userName = textField.child(0)
                    .child(0)
                    .text();
            builder.userName(userName);

            String avatarUrl = comment.child(0)
                    .child(0)
                    .absUrl(AVATAR_SELECTOR);
            builder.avatarUrl(avatarUrl);

            commentList.add(builder.build());
        }

        return commentList;
    }
}

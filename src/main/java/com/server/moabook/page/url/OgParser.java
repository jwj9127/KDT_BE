package com.server.moabook.page.url;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class OgParser {

    public static OgMeta parse(String url) {
        try {
            Document doc = Jsoup.connect(url)
                    .timeout(5000)
                    .get();

            String ogTitle = "";
            Element metaOgTitle = doc.selectFirst("meta[property=og:title]");
            if (metaOgTitle != null) {
                ogTitle = metaOgTitle.attr("content");
            }

            String ogImage = "";
            Element metaOgImage = doc.selectFirst("meta[property=og:image]");
            if (metaOgImage != null) {
                ogImage = metaOgImage.attr("content");
            }

            return new OgMeta(ogTitle, ogImage);

        } catch (Exception e) {
            // 파싱 실패 시, 일단 빈 데이터로 반환 or 예외 처리
            return new OgMeta("", "");
        }
    }
}

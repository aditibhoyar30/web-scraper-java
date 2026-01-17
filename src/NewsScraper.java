import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class NewsScraper {

    public static void main(String[] args) {

        String url = "https://news.ycombinator.com/";

        try {
            Document doc = Jsoup.connect(url)
                    .userAgent("Mozilla/5.0")
                    .timeout(10000)
                    .get();

            System.out.println("Top News Headlines:\n");

            Elements headlines = doc.select("span.titleline > a");

            int count = 0;
            for (Element headline : headlines) {
                System.out.println("• " + headline.text());
                count++;
                if (count == 10) break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


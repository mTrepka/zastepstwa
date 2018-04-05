import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mario on 2017-04-01.
 */
public class Repository {

    public static List<String> getUrlChildrens() {
        List<String> list = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect("http://zswolbrom.pl/www/").get();
            Elements array = doc.getElementsByClass("list-title");
            for (Element a : array) {
                Elements elementBuffor = a.getElementsByTag("a");
                list.add(elementBuffor.attr("href"));
            }
            list.remove(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static String getUrlParent() {
        return "http://zswolbrom.pl/www";
    }

    public static List<String> getValues() {
        List<String> list = new ArrayList<String>();
        try {
            Document doc = Jsoup.connect("http://zswolbrom.pl/www/").get();
            Elements array = doc.getElementsByClass("list-title");
            for (Element a : array) {
                list.add(a.text());
            }
            list.remove(0);
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public static List<String> getTables() {
        List<String> list = new ArrayList<String>();
        try {
            List<String> url = Repository.getUrlChildrens();
            for(String urlCh : url){
                Document doc = Jsoup.connect(Repository.getUrlParent()+urlCh).get();
                list.add(doc.getElementsByClass("MsoTableGrid").toString());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
}

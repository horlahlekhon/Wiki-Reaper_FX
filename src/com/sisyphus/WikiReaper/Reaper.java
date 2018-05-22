package sisyphus.WikiReaper;

import javafx.fxml.FXML;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @Author Olalekan Adebari ( nee Sisyphus )
 **/
public class Reaper {
    //"https://www.google.com.ng/search?dcr=0&source=hp&ei=5-cIWuZ30cCwB7aUhrAN&q="
  //"https://www.google.com/?gws_rd=ssl"
    private static  final String GOOGLE_SEARCH_URL = "https://www.google.com.ng/search?dcr=0&source=hp&ei=5-cIWuZ30cCwB7aUhrAN&q=";
    private static final String USER_AGENT = "\"Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.121 Safari/535.20";
    private static final String WIKI_API= "https://en.wikipedia.org/w/api.php?format=json&action=query&prop=extracts&exintro=&explaintext=&titles=";
    // private static  String searchvalue = "";
    private static  final String ENCODING ="utf-8";

    public static String getTitle(String searchValue)throws UnsupportedEncodingException {

        searchValue = searchValue + " wikipedia";
        String siteLinkByTag;

        Document doc = null;
        try {
            doc = Jsoup.connect( GOOGLE_SEARCH_URL + URLEncoder.encode(searchValue,ENCODING)).userAgent(USER_AGENT).ignoreHttpErrors(true).get();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("url incorrect");
        }
        siteLinkByTag = doc.getElementsByTag("cite").get(0).text();

        return siteLinkByTag;
    }

    public static String connectArticleTitleToAPI(String linkToAticle) throws UnsupportedEncodingException{

        String result = null;

        String searchWithAPI = WIKI_API + URLEncoder.encode(linkToAticle.replaceAll("https://en.wikipedia.org/wiki/", ""),ENCODING);

        try {
            HttpURLConnection httpConn = (HttpURLConnection) new URL(searchWithAPI).openConnection();
            httpConn.addRequestProperty("userAgent",USER_AGENT);

            BufferedReader br = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

            //join the buffer together into a single string ; thhe buffer comes in bytes array
            String response = br.lines().collect(Collectors.joining());

            result = response.split("\"extract\":\"")[1];
        }catch (MalformedURLException e){
            e.printStackTrace();
            System.out.println("the URL is not formed properly");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception");
        }

        return result;
    }

    public static String editWithRegex(String result){
        String formatedResult = null;


        return formatedResult;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        System.out.println("enter title");
    String searchQuery = sc.nextLine();
        try {
            System.out.println("wiki page URL of inputed search  "+getTitle(searchQuery));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        try {
            System.out.println(connectArticleTitleToAPI(getTitle(searchQuery)));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

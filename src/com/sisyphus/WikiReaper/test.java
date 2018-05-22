package sisyphus.WikiReaper;

/**
 * @Author Olalekan Adebari ( nee Sisyphus )
 **/
//import com.sisyphus.WikiReaper.Reaper.*;

import java.io.UnsupportedEncodingException;
import java.util.Scanner;

import static sisyphus.WikiReaper.Reaper.connectArticleTitleToAPI;
import static sisyphus.WikiReaper.Reaper.getTitle;


public class test {

    public static void main(String[] args) {
        Reaper rp = new Reaper();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println(connectArticleTitleToAPI(getTitle(sc.nextLine())));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}

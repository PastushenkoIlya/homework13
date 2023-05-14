package homework13;

import com.google.gson.Gson;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) throws IOException {
        String baseUrl = "https://jsonplaceholder.typicode.com";
        String response = Jsoup
                .connect(baseUrl+"/users")
                .requestBody(new Gson().toJson(Map.of(
                        "id", "10",
                        "name", "Test User"
                )))
                .method(Connection.Method.PUT)
                .ignoreContentType(true)
                .ignoreHttpErrors(true)
                .headers(Map.of(
                        "Content-type", "application/json; character=UTF-8"
                ))
                .execute()
                .body();
        System.out.println(response);

        //part 4
//        String getUrl = "https://jsonplaceholder.typicode.com/users";
//        String response = Jsoup
//                .connect(getUrl)
//                .ignoreContentType(true)
//                .execute()
//                .body();
//        System.out.println(response);

    }

}

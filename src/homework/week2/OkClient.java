package homework.week2;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author ：zhang
 * @title ：TODO
 * @date ：created in 2021/07/06
 */
public class OkClient {
    static OkHttpClient client = new OkHttpClient();

    public static void main(String[] args) throws IOException {
        String result = run("http://localhost:8801/");
        System.out.printf("OKResult.response:%s\n", result);
    }

    private static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

}

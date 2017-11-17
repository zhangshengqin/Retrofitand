package test.baway.com.a2.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 额头发 on 2017/11/5.
 */

public class MyModel {
    public void doGet(String url, final MyModelInfo myModelInfo) {
        OkHttpClient client = new OkHttpClient();
        Request build = new Request.Builder()
                .url(url)
                .build();
        client.newCall(build).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                myModelInfo.failError("失败了！！！");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                myModelInfo.showSuccess(response.body().string());
            }
        });
    }
}

package cc.hailer.zhaoyan.androidokhttpdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import DataBean.WeatherData;
import Utils.HttpEntity;
import client.MessengerActivity;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends Activity {

    private Button bt_sendRequest;
    private Button bt_nextequest;
    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView(){
        tv_result = (TextView) this.findViewById(R.id.tv_result);
        bt_nextequest = (Button) this.findViewById(R.id.bt_nextequest);
        bt_nextequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessengerActivity.class);
                startActivity(intent);
            }
        });


        bt_sendRequest = (Button) this.findViewById(R.id.bt_sendRequest);
        bt_sendRequest.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                HttpEntity entity = new HttpEntity(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        Log.e("ERROR", "Network Error!");
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.i("RESPONSE", "Network Response!");
                        ResponseBody responseBody = response.body();
                        final String result = responseBody.string();
                        WeatherData data = new Gson().fromJson(result, WeatherData.class);
                        Log.i("Object", "data="+data.toString());

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                tv_result.setText(result);
                            }
                        });
                    }
                });
                entity.request();

            }
        });
    }
}

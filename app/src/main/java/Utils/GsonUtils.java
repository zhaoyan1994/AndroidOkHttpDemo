package Utils;

import com.google.gson.Gson;

import DataBean.BaseData;
import DataBean.WeatherData;

/**
 * Created by 2FZ on 2018/8/13.
 */

public class GsonUtils {


    public static Object jsonToObject(String json, Class<BaseData> classOfT){
        Gson gson = new Gson();
        return gson.fromJson(json, classOfT);
    }

}

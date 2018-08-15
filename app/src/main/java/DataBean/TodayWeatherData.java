package DataBean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by 2FZ on 2018/8/14.
 */

public class TodayWeatherData extends BaseData implements Parcelable {

    private String shidu;
    private float pm25;
    private float pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private BaseWeatherData yesterday;
    private BaseWeatherData[] forecast;


    public TodayWeatherData(){
        this.dataId = 2;
    }

    public String getShidu() {
        return shidu;
    }

    public void setShidu(String shidu) {
        this.shidu = shidu;
    }

    public float getPm25() {
        return pm25;
    }

    public void setPm25(float pm25) {
        this.pm25 = pm25;
    }

    public float getPm10() {
        return pm10;
    }

    public void setPm10(float pm10) {
        this.pm10 = pm10;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public BaseWeatherData getYesterday() {
        return yesterday;
    }

    public void setYesterday(BaseWeatherData yesterday) {
        this.yesterday = yesterday;
    }

    public BaseWeatherData[] getForecast() {
        return forecast;
    }

    public void setForecast(BaseWeatherData[] forecast) {
        this.forecast = forecast;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.shidu);
        dest.writeFloat(this.pm25);
        dest.writeFloat(this.pm10);
        dest.writeString(this.quality);
        dest.writeString(this.wendu);
        dest.writeString(this.ganmao);
        dest.writeParcelable(this.yesterday,flags);
        dest.writeParcelableArray(this.forecast,flags);

    }

    public static final Parcelable.Creator<TodayWeatherData> CREATOR = new Parcelable.Creator<TodayWeatherData>(){

        @Override
        public TodayWeatherData createFromParcel(Parcel source) {
            return new TodayWeatherData(source);
        }

        @Override
        public TodayWeatherData[] newArray(int size) {
            return new TodayWeatherData[size];
        }
    };

    private TodayWeatherData(Parcel source){
        this.shidu = source.readString();
        this.pm25 = source.readFloat();
        this.pm10 = source.readFloat();
        this.quality = source.readString();
        this.wendu = source.readString();
        this.ganmao = source.readString();
        this.yesterday = source.readParcelable(BaseWeatherData.class.getClassLoader());

        Parcelable[] parcelables = source.readParcelableArray(BaseWeatherData.class.getClassLoader());
        if (parcelables != null) {
            this.forecast = Arrays.copyOf(parcelables, parcelables.length, BaseWeatherData[].class);
        }
    }
}

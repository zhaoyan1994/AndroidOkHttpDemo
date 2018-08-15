package DataBean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 2FZ on 2018/8/14.
 */

public class BaseWeatherData extends BaseData implements Parcelable {

    private String date;
    private String sunrise;
    private String high;
    private String low;
    private String sunset;
    private float aqi;
    private String fx;
    private String fl;
    private String type;
    private String notice;


    public BaseWeatherData(){
        this.dataId = 3;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public float getAqi() {
        return aqi;
    }

    public void setAqi(float aqi) {
        this.aqi = aqi;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.sunrise);
        dest.writeString(this.high);
        dest.writeString(this.low);
        dest.writeString(this.sunset);
        dest.writeFloat(this.aqi);
        dest.writeString(this.fx);
        dest.writeString(this.fl);
        dest.writeString(this.type);
        dest.writeString(this.notice);
    }


    public static final Parcelable.Creator<BaseWeatherData> CREATOR = new Parcelable.Creator<BaseWeatherData>(){
        @Override
        public BaseWeatherData createFromParcel(Parcel source) {
            return new BaseWeatherData(source);
        }

        @Override
        public BaseWeatherData[] newArray(int size) {
            return new BaseWeatherData[size];
        }
    };

    private BaseWeatherData(Parcel in){
        this.date = in.readString();
        this.sunrise = in.readString();
        this.high = in.readString();
        this.low = in.readString();
        this.sunset = in.readString();
        this.aqi = in.readFloat();
        this.fx = in.readString();
        this.fl = in.readString();
        this.type = in.readString();
        this.notice = in.readString();
    }

}

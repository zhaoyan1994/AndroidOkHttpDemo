package DataBean;

import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by 2FZ on 2018/8/13.
 */

public class WeatherData extends BaseData implements Parcelable{

    private String date;
    private String message;
    private int status;
    private String city;
    private int count;
    private TodayWeatherData data;

    public WeatherData(){
         this.dataId = 1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TodayWeatherData getData() {
        return data;
    }

    public void setData(TodayWeatherData data) {
        this.data = data;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.date);
        dest.writeString(this.message);
        dest.writeInt(this.status);
        dest.writeString(this.city);
        dest.writeInt(this.count);
        dest.writeParcelable(this.data,flags);
    }

    public static final Parcelable.Creator<WeatherData> CREATOR = new Parcelable.Creator<WeatherData>(){
        @Override
        public WeatherData createFromParcel(Parcel source) {
            return new WeatherData(source);
        }

        @Override
        public WeatherData[] newArray(int size) {
            return new WeatherData[size];
        }
    };

    private WeatherData(Parcel in){
        this.date = in.readString();
        this.message = in.readString();
        this.status = in.readInt();
        this.city = in.readString();
        this.count = in.readInt();
        this.data = in.readParcelable(TodayWeatherData.class.getClassLoader());
    }
}

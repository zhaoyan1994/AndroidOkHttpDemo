package service;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

/**
 * Created by 2FZ on 2018/8/21.
 */

public class MessengerService extends Service{

    private static final String TAG = "MessengerService";

    private final Messenger emailService = new Messenger(new MessengerHandler());

    private static class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 1:
                    String text = ((Bundle)msg.getData()).getString("msg");
                    Log.e(TAG,"MSG="+text);

                    Messenger client = msg.replyTo;

                    Message reply = new Message();
                    reply.what = 2;
                    Bundle bundle = new Bundle();
                    bundle.putString("reply","你好，来信已收到！");
                    reply.setData(bundle);

                    try {
                        client.send(reply);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    break;
                default:
                    super.handleMessage(msg);
            }

        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return emailService.getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}

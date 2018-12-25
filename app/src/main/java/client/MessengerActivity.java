package client;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;

import cc.hailer.zhaoyan.androidokhttpdemo.R;
import service.MessengerService;

/**
 * Created by 2FZ on 2018/8/21.
 */

public class MessengerActivity extends Activity {

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Messenger mService = new Messenger(service);

            Message msg = new Message();
            msg.what = 1;
            msg.replyTo = emailClient;
            Bundle data = new Bundle();
            data.putString("msg","你好！");
            msg.setData(data);

            try{
                mService.send(msg);
            }catch (RemoteException e){
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);

        Intent intent = new Intent(MessengerActivity.this, MessengerService.class);
        bindService(intent,mConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(mConnection);
    }


    private final Messenger emailClient = new Messenger(new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch(msg.what){
                case 2:
                    Log.e("A","getReply="+msg.getData().getString("reply"));
                    break;
            }
        }
    });
}

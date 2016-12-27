package com.example.ahmed.phonecall_detector;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

/**
 * Created by ahmed on 26/12/16.
 */

public class MyReceiver extends BroadcastReceiver {

    Context myContext ;

    @Override
    public void onReceive(Context context, Intent intent) {

        myContext =context;
/*
        Intent intent1 = new Intent(context,MainActivity.class);
        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent1);
*/

        TelephonyManager tel = (TelephonyManager) context.getSystemService(context.TELEPHONY_SERVICE);


        PhoneListenter  listenter = new PhoneListenter();

        tel.listen(listenter , PhoneStateListener.LISTEN_CALL_STATE);


    }


    class PhoneListenter extends PhoneStateListener{


        public void onCallStateChanged(int state, String incomingNumber) {


            if (state==0){

                Toast.makeText(myContext,"Number = " + incomingNumber ,Toast.LENGTH_SHORT).show();
            }
        }
    }
}

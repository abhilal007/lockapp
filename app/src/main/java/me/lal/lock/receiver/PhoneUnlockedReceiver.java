package me.lal.lock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import me.lal.lawnchair.Launcher;
import me.lal.lawnchair.Launcher;
import me.lal.lock.activity.LockActivity;

import static me.lal.lawnchair.Launcher.TAG;

public class PhoneUnlockedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_USER_PRESENT)){
            Log.d(Launcher.TAG, "Phone unlocked");
            if (Launcher.isLocked()) {
                Intent i = new Intent(context, LockActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP); //처음 실행작업 / 앱을 실행한 채 전원을 누르면 쌓이는 것을 방지
                context.startActivity(i);
            }
        }
        else if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)){
            Log.d(Launcher.TAG, "Phone locked");
        }
    }
}

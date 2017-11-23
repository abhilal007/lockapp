package me.lal.lock.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.widget.Toast;

import me.lal.lock.activity.LockActivity;
import me.lal.lock.activity.LockActivity;

public class ScreenReceiver extends BroadcastReceiver{
	
	TelephonyManager tm;
	private boolean isPhoneIdle = true;

	@Override
	public void onReceive(Context context, Intent intent) {
		
		Toast.makeText(context, "Broadcast Receiver!", Toast.LENGTH_SHORT).show();
		
		if (intent != null && intent.getAction().equals(Intent.ACTION_USER_PRESENT)) {
			
			tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			if (tm != null)
				tm.listen(phoneListener, PhoneStateListener.LISTEN_CALL_STATE);
			
			if(isPhoneIdle) {
				Intent i = new Intent(context, LockActivity.class);
				i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP); //처음 실행작업 / 앱을 실행한 채 전원을 누르면 쌓이는 것을 방지 
				context.startActivity(i);
			}
		}
	}
	
	private PhoneStateListener phoneListener = new PhoneStateListener() {
		public void onCallStateChanged(int state, String incomingNumber) {
			switch (state) {
			case TelephonyManager.CALL_STATE_IDLE : //일반상태
				isPhoneIdle = true;
				break;
				
			case TelephonyManager.CALL_STATE_RINGING : //울리는 중
				isPhoneIdle = false;
				break;
				
			case TelephonyManager.CALL_STATE_OFFHOOK : //통화중
				isPhoneIdle = false;
				break;
			}
		}
	};
}

package me.lal.lawnchair.preferences

import android.content.Context
import android.preference.SwitchPreference
import android.util.AttributeSet
import me.lal.lawnchair.R
import me.lal.lawnchair.overlay.ILauncherClient

class GoogleNowPreference(context: Context, attrs: AttributeSet) : SwitchPreference(context, attrs) {

    private val enabledState = ILauncherClient.getEnabledState(context)

    init {
        isEnabled = enabledState == ILauncherClient.ENABLED
        if (!isEnabled) {
            if (enabledState and ILauncherClient.DISABLED_NO_PROXY_APP != 0)
                setSummary(R.string.lawnfeed_not_found)
            if (enabledState and ILauncherClient.DISABLED_NO_GOOGLE_APP != 0)
                setSummary(R.string.google_app_not_found)
        }
    }
}
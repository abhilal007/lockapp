package me.lal.lawnchair.overlay

import android.content.Context
import me.lal.lawnchair.BuildConfig
import me.lal.lawnchair.Launcher
import me.lal.lawnchair.util.PackageManagerHelper

interface ILauncherClient {

    fun onStart()
    fun onStop()
    fun onPause()
    fun onResume()
    fun onDestroy()
    fun onAttachedToWindow()
    fun onDetachedFromWindow()
    fun remove()
    fun openOverlay(animate: Boolean)
    fun hideOverlay(animate: Boolean)
    fun startMove()
    fun endMove()
    fun updateMove(progress: Float)

    val isConnected: Boolean

    companion object {

        fun create(launcher: me.lal.lawnchair.Launcher): ILauncherClient = if (BuildConfig.ENABLE_LAWNFEED)
            LawnfeedClient(launcher)
        else
            LauncherClientImpl(launcher, true)

        const val GOOGLE_APP_PACKAGE = "com.google.android.googlequicksearchbox"

        const val ENABLED = 0
        const val DISABLED_NO_GOOGLE_APP = 1
        const val DISABLED_NO_PROXY_APP = 2

        fun getEnabledState(context: Context): Int {
            var state = ENABLED
            if (!me.lal.lawnchair.util.PackageManagerHelper.isAppEnabled(context.packageManager, GOOGLE_APP_PACKAGE, 0))
                state = state or DISABLED_NO_GOOGLE_APP
            if (BuildConfig.ENABLE_LAWNFEED &&
                    !me.lal.lawnchair.util.PackageManagerHelper.isAppEnabled(context.packageManager, LawnfeedClient.PROXY_PACKAGE, 0))
                state = state or DISABLED_NO_PROXY_APP
            return state
        }
    }
}
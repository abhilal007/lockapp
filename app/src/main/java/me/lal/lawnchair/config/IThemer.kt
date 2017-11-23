package me.lal.lawnchair.config

import android.content.Context
import me.lal.lawnchair.allapps.theme.IAllAppsThemer
import me.lal.lawnchair.popup.theme.IPopupThemer

interface IThemer {

    fun allAppsTheme(context: Context): IAllAppsThemer
    fun popupTheme(context: Context): IPopupThemer
}
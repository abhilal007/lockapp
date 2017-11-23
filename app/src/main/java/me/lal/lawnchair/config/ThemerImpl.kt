package me.lal.lawnchair.config

import android.content.Context
import me.lal.lawnchair.Utilities
import me.lal.lawnchair.allapps.theme.AllAppsBaseTheme
import me.lal.lawnchair.allapps.theme.AllAppsVerticalTheme
import me.lal.lawnchair.allapps.theme.IAllAppsThemer
import me.lal.lawnchair.popup.theme.IPopupThemer
import me.lal.lawnchair.popup.theme.PopupBaseTheme
import me.lal.lawnchair.popup.theme.PopupCardTheme

open class ThemerImpl : IThemer {

    var allAppsTheme: IAllAppsThemer? = null
    var popupTheme: IPopupThemer? = null

    override fun allAppsTheme(context: Context): IAllAppsThemer {
        val useVerticalLayout = me.lal.lawnchair.Utilities.getPrefs(context).verticalDrawerLayout
        if (allAppsTheme == null ||
                (useVerticalLayout && allAppsTheme !is AllAppsVerticalTheme) ||
                (!useVerticalLayout && allAppsTheme is AllAppsVerticalTheme))
            allAppsTheme = if (useVerticalLayout) AllAppsVerticalTheme(context) else AllAppsBaseTheme(context)
        return allAppsTheme!!
    }

    override fun popupTheme(context: Context): IPopupThemer {
        val useCardTheme = me.lal.lawnchair.Utilities.getPrefs(context).popupCardTheme
        if (popupTheme == null ||
                (useCardTheme && popupTheme !is PopupCardTheme) ||
                (!useCardTheme && popupTheme !is PopupBaseTheme)) {
            popupTheme = if (useCardTheme) PopupCardTheme() else PopupBaseTheme()
        }
        return popupTheme!!
    }
}
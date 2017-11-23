package me.lal.lawnchair.allapps.theme

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import me.lal.lawnchair.R
import me.lal.lawnchair.Utilities
import me.lal.lawnchair.blur.BlurWallpaperProvider
import me.lal.lawnchair.config.FeatureFlags
import me.lal.lawnchair.dynamicui.ExtractedColors

open class AllAppsBaseTheme(val context: Context) : IAllAppsThemer {
    override val backgroundColor = me.lal.lawnchair.Utilities
            .resolveAttributeData(FeatureFlags.applyDarkTheme(context, FeatureFlags.DARK_ALLAPPS), R.attr.allAppsContainerColor)
    override val backgroundColorBlur = me.lal.lawnchair.Utilities
            .resolveAttributeData(FeatureFlags.applyDarkTheme(context, FeatureFlags.DARK_BLUR), R.attr.allAppsContainerColorBlur)

    override fun iconTextColor(backgroundAlpha: Int): Int {
        if (Utilities.getPrefs(context).useCustomAllAppsTextColor) {
            return me.lal.lawnchair.Utilities.getPrefs(context).allAppsLabelColor
        } else if (FeatureFlags.useDarkTheme(FeatureFlags.DARK_ALLAPPS)) {
            return Color.WHITE
        } else if (backgroundAlpha < 128 && !BlurWallpaperProvider.isEnabled(BlurWallpaperProvider.BLUR_ALLAPPS) || backgroundAlpha < 50) {
            return Color.WHITE
        } else {
            return ContextCompat.getColor(context, R.color.quantum_panel_text_color)
        }
    }

    override val iconTextLines = 1
    override val searchTextColor = 0
    override val searchBarHintTextColor = me.lal.lawnchair.Utilities.getDynamicAccent(context)
    override val fastScrollerHandleColor = me.lal.lawnchair.Utilities.getDynamicAccent(context)
    override val fastScrollerPopupTintColor: Int
        get() {
            if (me.lal.lawnchair.Utilities.getPrefs(context).enableDynamicUi) {
                val tint = me.lal.lawnchair.Utilities.getDynamicAccent(context)
                if (tint != -1) {
                    return tint
                }
            }
            return 0
        }
    override val fastScrollerPopupTextColor: Int
        get() {
            var color = Color.WHITE
            if (me.lal.lawnchair.Utilities.getPrefs(context).enableDynamicUi) {
                val tint = me.lal.lawnchair.Utilities.getDynamicAccent(context)
                if (tint != -1) {
                    color = me.lal.lawnchair.Utilities.getColor(context, me.lal.lawnchair.dynamicui.ExtractedColors.VIBRANT_FOREGROUND_INDEX, Color.WHITE)
                }
            }
            return color
        }

    override val iconLayout = R.layout.all_apps_icon
    override fun numIconPerRow(default: Int) = default
    override fun iconHeight(default: Int) = default

}
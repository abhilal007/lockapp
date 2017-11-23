package me.lal.lawnchair.pixelify

import android.content.res.Resources
import android.graphics.drawable.Drawable
import me.lal.lawnchair.Utilities
import me.lal.lawnchair.graphics.IconShapeOverride
import me.lal.lawnchair.util.DrawableUtils
import me.lal.lawnchair.util.drawableInflater
import me.lal.lawnchair.util.overrideSdk

class AdaptiveIconProvider {

    companion object {

        const val TAG = "AdaptiveIconProvider"

        fun getDrawableForDensity(res: Resources, id: Int, density: Int, shapeInfo: IconShapeOverride.ShapeInfo): Drawable {
            var drawable: Drawable? = null
            if (shapeInfo.useRoundIcon && !me.lal.lawnchair.Utilities.ATLEAST_OREO) {
                // Backport for < O
                res.overrideSdk(26) {
                    drawable = try {
                        res.getDrawableForDensity(id, density)
                    } catch (e: Resources.NotFoundException) {
                        val drawableInflater = res.drawableInflater
                        val parser = res.getXml(id)
                        DrawableUtils.inflateFromXml(drawableInflater, parser)
                    }
                }
            } else if (!shapeInfo.useRoundIcon && me.lal.lawnchair.Utilities.ATLEAST_OREO) {
                // Force non-rounded icons on O
                res.overrideSdk(25) {
                    drawable = res.getDrawableForDensity(id, density)
                }
            } else {
                drawable = res.getDrawableForDensity(id, density)
            }
            return drawable!!
        }
    }
}
package me.lal.lawnchair.popup

import android.animation.Animator
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import me.lal.lawnchair.R
import me.lal.lawnchair.Utilities
import me.lal.lawnchair.anim.PillHeightRevealOutlineProvider

class MainItemView(context: Context, attrs: AttributeSet?, defStyle: Int) : me.lal.lawnchair.popup.PopupItemView(context, attrs, defStyle) {

    constructor(context: Context) : this(context, null, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    lateinit var itemContainer: LinearLayout

    override fun onFinishInflate() {
        super.onFinishInflate()
        itemContainer = findViewById(R.id.popup_items)
    }

    override fun getArrowColor(isArrowAttachedToBottom: Boolean): Int {
        return me.lal.lawnchair.Utilities.resolveAttributeData(context, R.attr.appPopupBgColor)
    }

    override fun addView(child: View?) {
        if (child is me.lal.lawnchair.popup.PopupItemView)
            itemContainer.addView(child)
        else
            super.addView(child)
    }

    override fun removeAllViews() {
        itemContainer.removeAllViews()
    }

    fun animateHeightRemoval(heightToRemove: Int, reverse: Boolean): Animator {
        val newHeight = height - heightToRemove
        return me.lal.lawnchair.anim.PillHeightRevealOutlineProvider(mPillRect,
                backgroundRadius, newHeight, reverse).createRevealAnimator(this, true, false, true)
    }
}
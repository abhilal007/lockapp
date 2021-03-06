/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.lal.lawnchair.anim;

import android.graphics.Rect;

import me.lal.lawnchair.util.PillRevealOutlineProvider;
import me.lal.lawnchair.util.PillRevealOutlineProvider;
import me.lal.lawnchair.util.PillRevealOutlineProvider;
import me.lal.lawnchair.util.PillRevealOutlineProvider;

/**
 * Extension of {@link PillRevealOutlineProvider} which only changes the height of the pill.
 * For now, we assume the height is added/removed from the bottom.
 */
public class PillHeightRevealOutlineProvider extends PillRevealOutlineProvider {

    private final int mNewHeight;
    private final boolean mReverse;

    public PillHeightRevealOutlineProvider(Rect pillRect, float radius, int newHeight) {
        this(pillRect, radius, newHeight, false);
    }

    public PillHeightRevealOutlineProvider(Rect pillRect, float radius, int newHeight, boolean reverse) {
        super(0, 0, pillRect, radius);
        mOutline.set(pillRect);
        mNewHeight = newHeight;
        mReverse = reverse;
    }

    @Override
    public void setProgress(float progress) {
        mOutline.top = 0;
        int heightDifference = mPillRect.height() - mNewHeight;
        if (mReverse)
            mOutline.top = (int) (mPillRect.top + heightDifference * (1 - progress));
        else
            mOutline.bottom = (int) (mPillRect.bottom - heightDifference * (1 - progress));
    }
}
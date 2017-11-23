-keep,allowshrinking,allowoptimization class me.lal.lawnchair.** {
  *;
}

-keep class me.lal.lawnchair.BaseRecyclerViewFastScrollBar {
  public void setThumbWidth(int);
  public int getThumbWidth();
  public void setTrackWidth(int);
  public int getTrackWidth();
}

-keep class me.lal.lawnchair.BaseRecyclerViewFastScrollPopup {
  public void setAlpha(float);
  public float getAlpha();
}

-keep class me.lal.lawnchair.ButtonDropTarget {
  public int getTextColor();
}

-keep class me.lal.lawnchair.CellLayout {
  public float getBackgroundAlpha();
  public void setBackgroundAlpha(float);
}

-keep class me.lal.lawnchair.CellLayout$LayoutParams {
  public void setWidth(int);
  public int getWidth();
  public void setHeight(int);
  public int getHeight();
  public void setX(int);
  public int getX();
  public void setY(int);
  public int getY();
}

-keep class me.lal.lawnchair.dragndrop.DragLayer$LayoutParams {
  public void setWidth(int);
  public int getWidth();
  public void setHeight(int);
  public int getHeight();
  public void setX(int);
  public int getX();
  public void setY(int);
  public int getY();
}

-keep class me.lal.lawnchair.FastBitmapDrawable {
  public void setDesaturation(float);
  public float getDesaturation();
  public void setBrightness(float);
  public float getBrightness();
}

-keep class me.lal.lawnchair.PreloadIconDrawable {
  public float getAnimationProgress();
  public void setAnimationProgress(float);
}

-keep class me.lal.lawnchair.pageindicators.CaretDrawable {
  public float getCaretProgress();
  public void setCaretProgress(float);
}

-keep class me.lal.lawnchair.Workspace {
  public float getBackgroundAlpha();
  public void setBackgroundAlpha(float);
}

-keep class com.google.android.libraries.launcherclient.* {
  *;
}

-dontwarn javax.**
-dontwarn org.codehaus.mojo.animal_sniffer.**

-keep class me.lal.lawnchair.DeferredHandler {
 *;
}

# Proguard will strip new callbacks in LauncherApps.Callback from
# WrappedCallback if compiled against an older SDK. Don't let this happen.
-keep class me.lal.lawnchair.compat.** {
  *;
}

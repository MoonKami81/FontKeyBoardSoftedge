package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

import android.content.ComponentName;
import android.content.Context;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import java.util.Arrays;
import java.util.List;

public final class FontSet {
    public static final FontSet INSTANCE = new FontSet();

    private FontSet() {
    }

    public final boolean isThisKeyboardSetAsDefaultIME(Context context) {
        String string = Settings.Secure.getString(context.getContentResolver(), "default_input_method");
        String packageName = context.getPackageName();
        Log.e("keyboard", string + " : " + packageName);
        return isThisKeyboardSetAsDefaultIME(string, packageName);
    }

    public final boolean isThisKeyboardSetAsDefaultIME(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        ComponentName unflattenFromString = ComponentName.unflattenFromString(str);
        if (unflattenFromString != null) {
            return unflattenFromString.getPackageName().equals(str2);
        }
        throw new NullPointerException(unflattenFromString.getClassName());
    }

    public final boolean isThisKeyboardEnabled(Context context) {
        return isThisKeyboardEnabled(Settings.Secure.getString(context.getContentResolver(), "enabled_input_methods"), context.getPackageName());
    }

    private final boolean isThisKeyboardEnabled(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        List asList = Arrays.asList(str.toString().split(":"));
        if (asList != null) {
            Object[] array = asList.toArray(new String[0]);
            if (array != null) {
                for (String str3 : (String[]) array) {
                    ComponentName unflattenFromString = ComponentName.unflattenFromString(str3);
                    if (unflattenFromString != null && unflattenFromString.getPackageName().equals(str2)) {
                        return true;
                    }
                }
                return false;
            }
            throw new ClassCastException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        throw new ClassCastException("null cannot be cast to non-null type java.util.Collection<T>");
    }
}

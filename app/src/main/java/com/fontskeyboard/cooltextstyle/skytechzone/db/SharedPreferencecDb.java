package com.fontskeyboard.cooltextstyle.skytechzone.db;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.Date;

public final class SharedPreferencecDb {

    private final SharedPreferences prefs;

    public SharedPreferencecDb(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.fontskeyboard.fonts.PREFERENCE_FILE_KEY", 0);
        if (sharedPreferences != null) {
            this.prefs = sharedPreferences;
            return;
        }
        throw new NullPointerException(sharedPreferences.toString());
    }

    public final int getCurrentFontIndex() {
        return this.prefs.getInt("current_font", 0);
    }

    public final void setCurrentFontIndex(int i) {
        this.prefs.edit().putInt("current_font", i).apply();
    }

    public final void setCurrentEmojiArray(int i) {
        this.prefs.edit().putInt("current_enoji", i).apply();
    }

    public final int getCurrentEmojiArray() {
        return this.prefs.getInt("current_enoji", 0);
    }

    public final int getUsedKeyboardCount() {
        return this.prefs.getInt("used_keyboard", 0);
    }

    public final void setUsedKeyboardCount(int i) {
        this.prefs.edit().putInt("used_keyboard", i).apply();
    }


    public final Date getLastUsedDate() {
        return new Date(this.prefs.getLong("last_used_date", -1));
    }

    public final void setLastUsedDate(Date date) {
        this.prefs.edit().putLong("last_used_date", date.getTime()).apply();
    }

    public final void setLanguage(String str, int i) {
        this.prefs.edit().putString("lang", str).putInt("pos", i).apply();
    }

    public final String getLanguage() {
        this.prefs.getInt("pos", 0);
        return this.prefs.getString("lang", "eng");
    }

    public final Integer getLanguagepos() {
        return Integer.valueOf(this.prefs.getInt("pos", 0));
    }

    public final void isKeyboardChanged(boolean z) {
        this.prefs.edit().putBoolean("isKeyboardChanged", z).apply();
    }

    public final boolean getisKeyboardChanged() {
        return this.prefs.getBoolean("isKeyboardChanged", false);
    }

    public final void isKeyboardunlocked(boolean z) {
        this.prefs.edit().putBoolean("isKeyboardunlocked", z).apply();
    }

    public final boolean getisKeyboardunlocked() {
        return this.prefs.getBoolean("isKeyboardunlocked", false);
    }

    public static void setTerms(boolean value, Context context) {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(context).edit();
        edit.putBoolean("terms", value);
        edit.apply();
    }

    public static boolean getTerms(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context).getBoolean("terms", false);
    }
}

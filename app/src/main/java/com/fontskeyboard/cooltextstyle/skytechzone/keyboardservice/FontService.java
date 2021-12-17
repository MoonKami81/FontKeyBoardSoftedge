package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

import android.content.Context;
import android.os.Build;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani1;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani2;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani4;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani7;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani8;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Aani9;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.ChorasFilled;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.ChorasOutline;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Comic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Emoji;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Emoji7;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_1;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_10;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_11;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_2;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_3;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_4;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_5;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_6;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_7;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_8;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Font_9;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.FoodEmoji;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.FoodEmoji2;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.GolFilled;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.GolOutline;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Gothic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.GothicBold;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Manga;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.NanaCaps;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.ObjectEmoji;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Outline;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Sadu;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SansBold;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SansBoldItalic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SansItalic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Script;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.ScriptBold;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SerifBold;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SerifBoldItalic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SerifItalic;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SpecialSymbols;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.SpecialSymbols2;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Streebug;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda2;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda3;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda4;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda5;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Thobda6;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Typewriter;
import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.UperthiNiche;
import com.fontskeyboard.cooltextstyle.skytechzone.db.SharedPreferencecDb;

import java.util.Arrays;

public final class FontService {
    private static final FontListner[] AKSHARO_ORDER_EMOJI = {new Thobda6(), new Thobda5(), new Thobda4(), new Thobda3(), new Thobda(), new Thobda2(), new SpecialSymbols(), new SpecialSymbols2(), new Emoji7(), new ObjectEmoji(), new FoodEmoji(), new FoodEmoji2(), new Emoji()};
    private static final FontListner[] AKSHARO_ORDER_OVER_OR_O = {new Sadu(), new Script(), new ScriptBold(), new Outline(), new Typewriter(), new UperthiNiche(), new NanaCaps(), new GolOutline(), new GolFilled(), new ChorasOutline(), new ChorasFilled(), new Comic(), new SerifBold(), new SerifItalic(), new SerifBoldItalic(), new SansBold(), new SansItalic(), new SansBoldItalic(), new Gothic(), new GothicBold(), new Aani1(), new Font_1(), new Font_2(), new Font_3(), new Font_4()};
    private static final FontListner[] AKSHARO_ORDER_UNDER_O = {new Sadu(), new NanaCaps(), new UperthiNiche(), new Comic(), new GolOutline(), new GolFilled(), new ChorasOutline(), new ChorasFilled(), new Streebug(), new Manga(), new Aani1(), new Aani2(), new Aani4(), new Aani7(), new Aani8(), new Aani9(), new Font_2(), new Font_3(), new Font_4(), new Font_5(), new Font_6(), new Font_7(), new Font_8(), new Font_9(), new Font_10(), new Font_11(), new Thobda6(), new Thobda5(), new Thobda4(), new SpecialSymbols(), new SpecialSymbols2(), new Emoji7(), new ObjectEmoji(), new FoodEmoji(), new FoodEmoji2(), new Emoji(), new Thobda(), new Thobda2()};
    public static final FontService INSTANCE = new FontService();
    public static String MY_PREFS_NAME = "StylishFont";
    private static Context context;
    private static int currentFontIndex;
    private static SharedPreferencecDb sharedPreference;
    int val;
    int val2;

    private FontService() {
    }

    public final Context getContext() {
        return context;
    }

    public final void setContext(Context context2) {
        if (context2 != null) {
            sharedPreference = new SharedPreferencecDb(context2);
        }
    }

    public final FontListner getInitialFont() {
        SharedPreferencecDb sharedPreferencecDb = sharedPreference;
        if (sharedPreferencecDb != null) {
            int max = Math.max(Math.min(sharedPreferencecDb.getCurrentFontIndex(), getFontOrderEmoji().length - 1), 0);
            currentFontIndex = max;
            return getFontOrderEmoji()[max];
        }
        throw new NullPointerException("sharedPreference");
    }

    public final FontListner getCurrentFont() {
        return getFontOrderEmoji()[Math.max(Math.min(currentFontIndex, getFontOrderEmoji().length - 1), 0)];
    }

    public final void setCurrentFont(FontListner fontListner) {
        int indexOf = indexOf(getFontOrderEmoji(), fontListner);
        currentFontIndex = indexOf;
        SharedPreferencecDb sharedPreferencecDb = sharedPreference;
        if (sharedPreferencecDb != null) {
            sharedPreferencecDb.setCurrentFontIndex(indexOf);
            return;
        }
        throw new NullPointerException("sharedPreference");
    }

    public final FontListner[] getFontOrderUnderO() {
        return AKSHARO_ORDER_UNDER_O;
    }

    public final FontListner[] getFontOrderOverOrO() {
        return AKSHARO_ORDER_OVER_OR_O;
    }

    public final FontListner[] getFontOrder() {
        if (Build.VERSION.SDK_INT >= 26) {
            return AKSHARO_ORDER_OVER_OR_O;
        }
        return AKSHARO_ORDER_UNDER_O;
    }

    public final FontListner[] getFontOrderEmoji() {
        SharedPreferencecDb sharedPreferencecDb = sharedPreference;
        if (sharedPreferencecDb != null) {
            this.val = sharedPreferencecDb.getCurrentEmojiArray();
        }
        return AKSHARO_ORDER_UNDER_O;
    }

    public final void nextFont() {
        currentFontIndex = (currentFontIndex + 1) % getFontOrder().length;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        return Arrays.asList(tArr).indexOf(t);
    }
}

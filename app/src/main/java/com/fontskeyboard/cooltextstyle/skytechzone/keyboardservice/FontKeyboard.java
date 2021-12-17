package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.inputmethodservice.Keyboard;

public final class FontKeyboard extends Keyboard {
    public static final Companion Companion = new Companion();
    public static final int KEYCODE_LANGUAGE_SWITCH = -101;

    public static final class Companion {
        public final int getKEYCODE_LANGUAGE_SWITCH() {
            return FontKeyboard.KEYCODE_LANGUAGE_SWITCH;
        }

        private Companion() {
        }
    }

    public FontKeyboard(Context context, int i) {
        super(context, i);
    }

    public Key createKeyFromXml(Resources resources, Row row, int i, int i2, XmlResourceParser xmlResourceParser) {
        return super.createKeyFromXml(resources, row, i, i2, xmlResourceParser);
    }
}

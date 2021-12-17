package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

public interface FontListner {
    float getExtraPaddingDownFactor();

    CharSequence[] getLowercase();

    String getName();

    float getSizeFactorButton();

    float getSizeFactorKeys();

    CharSequence[] getUppercase();

    boolean isUpsideDown();

    CharSequence letter(int i, boolean z);

    public static final class DefaultImpls {
        public static float getExtraPaddingDownFactor(FontListner fontListner) {
            return 0.0f;
        }

        public static float getSizeFactorButton(FontListner fontListner) {
            return 1.0f;
        }

        public static float getSizeFactorKeys(FontListner fontListner) {
            return 1.0f;
        }

        public static boolean isUpsideDown(FontListner fontListner) {
            return false;
        }

        public static CharSequence letter(FontListner fontListner, int i, boolean z) {
            int i2 = i - 97;
            if (i2 < 0 || i2 > 25) {
                return null;
            }
            if (z) {
                return fontListner.getUppercase()[i2];
            }
            return fontListner.getLowercase()[i2];
        }
    }
}

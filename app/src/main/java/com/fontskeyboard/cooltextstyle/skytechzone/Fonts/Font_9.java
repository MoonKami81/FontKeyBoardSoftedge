package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Font_9 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"Λ", "Ϧ", "ㄈ", "Ð", "Ɛ", "F", "Ɠ", "н", "ɪ", "ﾌ", "Қ", "Ł", "௱", "Л", "Ø", "þ", "Ҩ", "尺", "ら", "Ť", "Ц", "Ɣ", "Ɯ", "χ", "Ϥ", "Ẕ"};
    }

    @Override 
    public String getName() {
        return "ΛϦㄈ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"Λ", "Ϧ", "ㄈ", "Ð", "Ɛ", "F", "Ɠ", "н", "ɪ", "ﾌ", "Қ", "Ł", "௱", "Л", "Ø", "þ", "Ҩ", "尺", "ら", "Ť", "Ц", "Ɣ", "Ɯ", "χ", "Ϥ", "Ẕ"};
    }

    @Override 
    public float getExtraPaddingDownFactor() {
        return DefaultImpls.getExtraPaddingDownFactor(this);
    }

    @Override 
    public float getSizeFactorButton() {
        return DefaultImpls.getSizeFactorButton(this);
    }

    @Override 
    public float getSizeFactorKeys() {
        return DefaultImpls.getSizeFactorKeys(this);
    }

    @Override 
    public boolean isUpsideDown() {
        return DefaultImpls.isUpsideDown(this);
    }

    @Override 
    public CharSequence letter(int i, boolean z) {
        return DefaultImpls.letter(this, i, z);
    }
}

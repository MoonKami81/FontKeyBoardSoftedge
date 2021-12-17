package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Font_10 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ค", "๖", "¢", "໓", "ē", "f", "ງ", "h", "i", "ว", "k", "l", "๓", "ຖ", "໐", "p", "๑", "r", "Ş", "t", "น", "ง", "ຟ", "x", "ฯ", "ຊ"};
    }

    @Override 
    public String getName() {
        return "ค๖¢";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ค", "๖", "¢", "໓", "ē", "f", "ງ", "h", "i", "ว", "k", "l", "๓", "ຖ", "໐", "p", "๑", "r", "Ş", "t", "น", "ง", "ຟ", "x", "ฯ", "ຊ"};
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

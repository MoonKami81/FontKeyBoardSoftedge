package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Aani2 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ǟ", "ɮ", "ƈ", "ɖ", "ɛ", "ʄ", "ɢ", "ɦ", "ɨ", "ʝ", "ӄ", "ʟ", "ʍ", "ռ", "օ", "ք", "զ", "ʀ", "ֆ", "ȶ", "ʊ", "ʋ", "ա", "Ӽ", "ʏ", "ʐ"};
    }

    @Override 
    public String getName() {
        return "ǟɮƈ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ǟ", "ɮ", "ƈ", "ɖ", "ɛ", "ʄ", "ɢ", "ɦ", "ɨ", "ʝ", "ӄ", "ʟ", "ʍ", "ռ", "օ", "ք", "զ", "ʀ", "ֆ", "ȶ", "ʊ", "ʋ", "ա", "Ӽ", "ʏ", "ʐ"};
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

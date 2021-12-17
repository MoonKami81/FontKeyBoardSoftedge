package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;


import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Comic implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ᗩ", "ᗷ", "ᑕ", "ᗪ", "ᗴ", "ᖴ", "ᘜ", "ᕼ", "I", "ᒍ", "K", "ᒪ", "ᗰ", "ᑎ", "O", "ᑭ", "ᑫ", "ᖇ", "Տ", "t", "ᑌ", "ᐯ", "ᗯ", "᙭", "Y", "ᘔ"};
    }

    @Override 
    public String getName() {
        return "ᗩᗷᑕ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ᗩ", "ᗷ", "ᑕ", "ᗪ", "ᗴ", "ᖴ", "ᘜ", "ᕼ", "I", "ᒍ", "K", "ᒪ", "ᗰ", "ᑎ", "O", "ᑭ", "ᑫ", "ᖇ", "Տ","T", "ᑌ", "ᐯ", "ᗯ", "᙭", "Y", "ᘔ"};
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

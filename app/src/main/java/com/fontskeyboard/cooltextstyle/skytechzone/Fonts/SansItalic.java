package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class SansItalic implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"𝘢", "𝘣", "𝘤", "𝘥", "𝘦", "𝘧", "𝘨", "𝘩", "𝘪", "𝘫", "𝘬", "𝘭", "𝘮", "𝘯", "𝘰", "𝘱", "𝘲", "𝘳", "𝘴", "𝘵", "𝘶", "𝘷", "𝘸", "𝘹", "𝘺", "𝘻"};
    }

    @Override 
    public String getName() {
        return "𝘈𝘉𝘊";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"𝘈", "𝘉", "𝘊", "𝘋", "𝘌", "𝘍", "𝘎", "𝘏", "𝘐", "𝘑", "𝘒", "𝘓", "𝘔", "𝘕", "𝘖", "𝘗", "𝘘", "𝘙", "𝘚", "𝘛", "𝘜", "𝘝", "𝘞", "𝘟", "𝘠", "𝘡"};
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

package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Sans implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"𝖺", "𝖻", "𝖼", "𝖽", "𝖾", "𝖿", "𝗀", "𝗁", "𝗂", "𝗃", "𝗄", "𝗅", "𝗆", "𝗇", "𝗈", "𝗉", "𝗊", "𝗋", "𝗌", "𝗍", "𝗎", "𝗏", "𝗐", "𝗑", "𝗒", "𝗓"};
    }

    @Override 
    public String getName() {
        return "𝖲𝖺𝗇𝗌";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"𝖠", "𝖡", "𝖢", "𝖣", "𝖤", "𝖥", "𝖦", "𝖧", "𝖨", "𝖩", "𝖪", "𝖫", "𝖬", "𝖭", "𝖮", "𝖯", "𝖰", "𝖱", "𝖲", "𝖳", "𝖴", "𝖵", "𝖶", "𝖷", "𝖸", "𝖹"};
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

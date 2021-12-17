package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Aani1 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"", "Ᏸ", "ፈ", "Ꮄ", "Ꮛ", "Ꭶ", "Ꮆ", "Ꮒ", "Ꭵ", "Ꮰ", "Ꮶ", "Ꮭ", "Ꮇ", "Ꮑ", "Ꭷ", "Ꭾ", "Ꭴ", "Ꮢ", "Ꮥ", "Ꮦ", "Ꮼ", "Ꮙ", "Ꮗ", "ጀ", "Ꭹ", "ፚ"};
    }

    @Override 
    public String getName() {
        return "ᏗᏰፈ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"Ꮧ", "Ᏸ", "ፈ", "Ꮄ", "Ꮛ", "Ꭶ", "Ꮆ", "Ꮒ", "Ꭵ", "Ꮰ", "Ꮶ", "Ꮭ", "Ꮇ", "Ꮑ", "Ꭷ", "Ꭾ", "Ꭴ", "Ꮢ", "Ꮥ", "Ꮦ", "Ꮼ", "Ꮙ", "Ꮗ", "ጀ", "Ꭹ", "ፚ"};
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

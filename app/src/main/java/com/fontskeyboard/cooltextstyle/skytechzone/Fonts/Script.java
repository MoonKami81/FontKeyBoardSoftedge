package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Script implements FontListner {
    @Override 
    public float getExtraPaddingDownFactor() {
        return 0.8f;
    }

    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"𝒶", "𝒷", "𝒸", "𝒹", "ℯ", "𝒻", "ℊ", "𝒽", "𝒾", "𝒿", "𝓀", "𝓁", "𝓂", "𝓃", "ℴ", "𝓅", "𝓆", "𝓇", "𝓈", "𝓉", "𝓊", "𝓋", "𝓌", "𝓍", "𝓎", "𝓏"};
    }

    @Override 
    public String getName() {
        return "𝒶𝒷𝒸";
    }

    @Override 
    public float getSizeFactorButton() {
        return 1.45f;
    }

    @Override 
    public float getSizeFactorKeys() {
        return 1.15f;
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"𝒜", "ℬ", "𝒞", "𝒟", "ℰ", "ℱ", "𝒢", "ℋ", "ℐ", "𝒥", "𝒦", "ℒ", "ℳ", "𝒩", "𝒪", "𝒫", "𝒬", "ℛ", "𝒮", "𝒯", "𝒰", "𝒱", "𝒲", "𝒳", "𝒴", "𝒵"};
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

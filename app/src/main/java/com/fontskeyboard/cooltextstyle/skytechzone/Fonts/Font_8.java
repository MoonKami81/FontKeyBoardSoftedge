package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Font_8 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ꋫ", "ꃃ", "ꏸ", "ꁕ", "ꍟ", "ꄘ", "ꁍ", "ꑛ", "ꂑ", "ꀭ", "ꀗ", "꒒", "ꁒ", "ꁹ", "ꆂ", "ꉣ", "ꁸ", "꒓", "ꌚ", "꓅", "ꐇ", "ꏝ", "ꅐ", "ꇓ", "ꐟ", "ꁴ"};
    }

    @Override 
    public String getName() {
        return "ꋫꃃꏸ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ꋫ", "ꃃ", "ꏸ", "ꁕ", "ꍟ", "ꄘ", "ꁍ", "ꑛ", "ꂑ", "ꀭ", "ꀗ", "꒒", "ꁒ", "ꁹ", "ꆂ", "ꉣ", "ꁸ", "꒓", "ꌚ", "꓅", "ꐇ", "ꏝ", "ꅐ", "ꇓ", "ꐟ", "ꁴ"};
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

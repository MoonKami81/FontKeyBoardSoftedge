package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Streebug implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"ꍏ", "ꌃ", "ꏳ", "ꀷ", "ꏂ", "ꎇ", "ꁅ", "ꀍ", "ꀤ", "꒻", "ꀘ", "꒒", "ꎭ", "ꈤ", "ꂦ", "ᖘ", "ꆰ", "ꋪ", "ꌚ", "꓄", "ꀎ", "꒦", "ꅐ", "ꉧ", "ꌩ", "ꁴ"};
    }

    @Override 
    public String getName() {
        return "ꍏꌃꏳ";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"ꍏ", "ꌃ", "ꏳ", "ꀷ", "ꏂ", "ꎇ", "ꁅ", "ꀍ", "ꀤ", "꒻", "ꀘ", "꒒", "ꎭ", "ꈤ", "ꂦ", "ᖘ", "ꆰ", "ꋪ", "ꌚ", "꓄", "ꀎ", "꒦", "ꅐ", "ꉧ", "ꌩ", "ꁴ"};
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

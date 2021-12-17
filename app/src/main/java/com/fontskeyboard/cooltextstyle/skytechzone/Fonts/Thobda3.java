package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Thobda3 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"♕", "␈", "𐂃", "𐂂", "𓀬", "𓆈", "𓃗", "𓃱", "𓀡", "𓀿", "𓅷", "𓆏", "𓃰", "𓄁", "𓃠", "𓅿", "𓃟", "𓂻", "♔", "𓆙", "𓃒", "𐂊", "𓂉", "⚣", "ଈ", "𖠌"};
    }

    @Override 
    public String getName() {
        return "♕␈𐂃";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"♕", "␈", "𐂃", "𐂂", "𓀬", "𓆈", "𓃗", "𓃱", "𓀡", "𓀿", "𓅷", "𓆏", "𓃰", "𓄁", "𓃠", "𓅿", "𓃟", "𓂻", "♔", "𓆙", "𓃒", "𐂊", "𓂉", "⚣", "ଈ", "𖠌"};
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
    public boolean isUpsideDown() {
        return DefaultImpls.isUpsideDown(this);
    }

    @Override 
    public CharSequence letter(int i, boolean z) {
        return DefaultImpls.letter(this, i, z);
    }
}

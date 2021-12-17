package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Thobda2 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"☼", "᯽", "✫", "۞", "𖣔", "⍟", "𖣘", "𓇽", "Ꙭ", "𖦹", "❁", "᯾", "𒊹", "✪", "⁂", "⌘", "᪥", "𖧷", "𖦹", "߷", "༄", "✰", "✯", "☆", "༆", "★"};
    }

    @Override 
    public String getName() {
        return "☼᯽✫";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"☼", "᯽", "✫", "۞", "𖣔", "⍟", "𖣘", "𓇽", "Ꙭ", "𖦹", "❁", "᯾", "𒊹", "✪", "⁂", "⌘", "᪥", "𖧷", "𖦹", "߷", "༄", "✰", "✯", "☆", "༆", "★"};
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

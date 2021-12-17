package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Thobda implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"♡", "⌫", "☏", "❥", "☾", "ఌ", "ꨄ", "𖨆", "シ", "ᴥ", "☹", "☻", "𓁹", "𓂀", "㋛", "ت", "𓂸", "☽", "❦", "♫", "✞", "𓆉", "𓂺", "✔", "➪", "𑁍"};
    }

    @Override 
    public String getName() {
        return "♡⌫☏";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"♡", "⌫", "☏", "❥", "☾", "ఌ", "ꨄ", "𖨆", "シ", "ᴥ", "☹", "☻", "𓁹", "𓂀", "㋛", "ت", "𓂸", "☽", "❦", "♫", "✞", "𓆉", "𓂺", "✔", "➪", "𑁍"};
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

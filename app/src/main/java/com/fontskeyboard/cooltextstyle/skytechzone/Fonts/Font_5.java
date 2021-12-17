package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Font_5 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"A̶̷̲̅", "B̶̷̲̅", "C̶̷̲̅", "D̶̷̲̅", "E̶̷̲̅", "F̶̷̲̅", "G̶̷̲̅", "H̶̷̲̅", "I̶̷̲̅", "J̶̷̲̅", "K̶̷̲̅", "L̶̷̲̅", "M̶̷̲̅", "N̶̷̲̅", "O̶̷̲̅", "P̶̷̲̅", "Q̶̷̲̅", "R̶̷̲̅", "S̶̷̲̅", "T̶̷̲̅", "U̶̷̲̅", "V̶̷̲̅", "W̶̷̲̅", "X̶̷̲̅", "Y̶̷̲̅", "Z̶̷̲̅"};
    }

    @Override 
    public String getName() {
        return "A̶̷̲̅B̶̷̲̅C̶̷̲̅";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"A̶̷̲̅", "B̶̷̲̅", "C̶̷̲̅", "D̶̷̲̅", "E̶̷̲̅", "F̶̷̲̅", "G̶̷̲̅", "H̶̷̲̅", "I̶̷̲̅", "J̶̷̲̅", "K̶̷̲̅", "L̶̷̲̅", "M̶̷̲̅", "N̶̷̲̅", "O̶̷̲̅", "P̶̷̲̅", "Q̶̷̲̅", "R̶̷̲̅", "S̶̷̲̅", "T̶̷̲̅", "U̶̷̲̅", "V̶̷̲̅", "W̶̷̲̅", "X̶̷̲̅", "Y̶̷̲̅", "Z̶̷̲̅"};
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

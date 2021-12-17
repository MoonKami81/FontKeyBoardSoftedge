package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class SpecialSymbols2 implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "🔟", "💯", "⚪", "⚫", "✪", "🔴", "🔵", "✅", "☑", "❌", "❎", "©", "®", "📶", "📳", "📴", "⭕"};
    }

    @Override 
    public String getName() {
        return "1️⃣2️⃣3️⃣";
    }

    @Override 
    public float getSizeFactorKeys() {
        return 0.95f;
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"1️⃣", "2️⃣", "3️⃣", "4️⃣", "5️⃣", "6️⃣", "7️⃣", "8️⃣", "9️⃣", "🔟", "💯", "⚪", "⚫", "✪", "🔴", "🔵", "✅", "☑", "❌", "❎", "©", "®", "📶", "📳", "📴", "⭕"};
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

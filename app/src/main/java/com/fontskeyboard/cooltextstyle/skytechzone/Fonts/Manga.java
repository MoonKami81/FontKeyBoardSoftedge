package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Manga implements FontListner {
    @Override 
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"卂", "乃", "匚", "ᗪ", "乇", "千", "ᘜ", "卄", "|", "ﾌ", "Ҝ", "ㄥ", "爪", "几", "ㄖ", "卩", "Ҩ", "尺", "丂", "ㄒ", "ㄩ", "ᐯ", "山", "乂", "ㄚ", "乙"};
    }

    @Override 
    public String getName() {
        return "卂乃匚";
    }

    @Override 
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"卂", "乃", "匚", "ᗪ", "乇", "千", "ᘜ", "卄", "|", "ﾌ", "Ҝ", "ㄥ", "爪", "几", "ㄖ", "卩", "Ҩ", "尺", "丂", "ㄒ", "ㄩ", "ᐯ", "山", "乂", "ㄚ", "乙"};
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

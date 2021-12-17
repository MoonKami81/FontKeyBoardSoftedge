package com.fontskeyboard.cooltextstyle.skytechzone.Fonts;

import com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice.FontListner;

public final class Font_11 implements FontListner {
    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public CharSequence[] getLowercase() {
        return new CharSequence[]{"≋a≋", "≋b≋", "≋c≋", "≋d≋", "≋e≋", "≋f≋", "≋g≋", "≋h≋", "≋i≋", "≋j≋", "≋k≋", "≋l≋", "≋m≋", "≋n≋", "≋o≋", "≋p≋", "≋q≋", "≋r≋", "≋s≋", "≋t≋", "≋u≋", "≋v≋", "≋w≋", "≋x≋", "≋y≋", "≋z≋"};
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public String getName() {
        return "≋A≋ ≋B≋ ≋C≋";
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public CharSequence[] getUppercase() {
        return new CharSequence[]{"≋A≋", "≋B≋", "≋C≋", "≋D≋", "≋E≋", "≋F≋", "≋G≋", "≋H≋", "≋I≋", "≋J≋", "≋K≋", "≋L≋", "≋M≋", "≋N≋", "≋O≋", "≋P≋", "≋Q≋", "≋R≋", "≋S≋", "≋T≋", "≋U≋", "≋V≋", "≋W≋", "≋X≋", "≋Y≋", "≋Z≋"};
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public float getExtraPaddingDownFactor() {
        return DefaultImpls.getExtraPaddingDownFactor(this);
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public float getSizeFactorButton() {
        return DefaultImpls.getSizeFactorButton(this);
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public float getSizeFactorKeys() {
        return DefaultImpls.getSizeFactorKeys(this);
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public boolean isUpsideDown() {
        return DefaultImpls.isUpsideDown(this);
    }

    @Override // com.vvaani.fontkeyboard.yp.FontInter
    public CharSequence letter(int i, boolean z) {
        return DefaultImpls.letter(this, i, z);
    }
}

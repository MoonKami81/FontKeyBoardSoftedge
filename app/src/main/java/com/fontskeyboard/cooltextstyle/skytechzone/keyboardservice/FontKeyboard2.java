package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.util.AttributeSet;
import java.util.List;

public final class FontKeyboard2 extends KeyboardView {
    public FontKeyboard2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public FontKeyboard2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void onDraw(Canvas canvas) {
        Keyboard keyboard = getKeyboard();
        Paint paint = new Paint();
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setAntiAlias(true);
        float f = getResources().getDisplayMetrics().scaledDensity * 22.0f;
        paint.setColor(Color.parseColor("#252525"));
        paint.setTypeface(Typeface.DEFAULT);
        List<Keyboard.Key> keys = keyboard.getKeys();
        super.onDraw(canvas);
        for (Keyboard.Key key : keys) {
            CharSequence letter = FontService.INSTANCE.getCurrentFont().letter(key.codes[0], isShifted());
            boolean isUpsideDown = FontService.INSTANCE.getCurrentFont().isUpsideDown();
            if (key.label != null) {
                if (key.label.equals("?")) {
                    key.codes = isUpsideDown ? new int[]{191} : new int[]{63};
                } else if (key.label.equals("¿")) {
                    key.codes = isUpsideDown ? new int[]{63} : new int[]{191};
                } else if (key.label.equals(".")) {
                    key.codes = isUpsideDown ? new int[]{729} : new int[]{46};
                } else if (key.label.equals("˙")) {
                    key.codes = isUpsideDown ? new int[]{46} : new int[]{729};
                } else if (key.label.equals(",")) {
                    key.codes = isUpsideDown ? new int[]{39} : new int[]{44};
                } else if (key.label.equals("'")) {
                    key.codes = isUpsideDown ? new int[]{44} : new int[]{39};
                } else if (key.label.equals("!")) {
                    key.codes = isUpsideDown ? new int[]{161} : new int[]{33};
                } else if (key.label.equals("¡")) {
                    key.codes = isUpsideDown ? new int[]{33} : new int[]{161};
                } else if (key.label.equals("\"")) {
                    key.codes = isUpsideDown ? new int[]{8222} : new int[]{34};
                }
            }
            if (letter != null) {
                key.text = letter.toString();
                String charSequence = letter.toString();
                if (FontService.INSTANCE.getCurrentFont().isUpsideDown()) {
                    charSequence = String.valueOf((char) key.codes[0]);
                }
                paint.setTextSize(FontService.INSTANCE.getCurrentFont().getSizeFactorKeys() * f);
                if (canvas != null) {
                    canvas.drawText(charSequence, ((float) key.x) + (((float) key.width) / 2.0f), ((float) key.y) + (((float) key.height) / 2.0f) + ((paint.getTextSize() - paint.descent()) / 2.0f), paint);
                }
            }
        }
    }
}

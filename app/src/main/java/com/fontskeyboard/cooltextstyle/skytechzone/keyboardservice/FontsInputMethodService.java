package com.fontskeyboard.cooltextstyle.skytechzone.keyboardservice;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Display;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListPopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;


import com.fontskeyboard.cooltextstyle.skytechzone.Fonts.Sadu;
import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.SpinnerAdapterCustom;
import com.fontskeyboard.cooltextstyle.skytechzone.db.SharedPreferencecDb;
import com.fontskeyboard.cooltextstyle.skytechzone.db.DataStore;



import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

public final class FontsInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener {
    public static String MY_PREFS_NAME = "StylishFont";
    public static int val;
    FontKeyboard2 aksharoNuMalkhu;
    public FontKeyboard aksharonuKeyboard;
    private Keyboard arabKeyboard;
    int backcheck = 0;
    Button button6;
    private boolean capsLockOn;
    private Button changeKeyboardNotificationButton;
    public RelativeLayout changeKeyboardOverlay;
    private RelativeLayout container;
    private Keyboard currentKeyboard;
    public ArrayList<Pair<FontListner, Button>> fontButtons = new ArrayList<>();
    private Keyboard gujaratiKeyboard;
    private Keyboard hindiKeyboard;
    private HorizontalScrollView horizontalScrollView;
    private InputMethodManager inputMethodManager;
    ImageView iv_back;
    public FontKeyboard2 keyboardView;
    String language;
    private long lastShiftTime;
    LinearLayout linearLayout;
    DataStore nanoSangrahalay;
    public FontKeyboard normalfontsKeyboard;
    private Button rateNowButton;
    private ConstraintLayout rateOverlay;
    private Button remindMeLaterButton;
    RelativeLayout rl_emoji;
    RelativeLayout rl_first;
    RelativeLayout rl_font;
    RelativeLayout rl_second;
    private Button shareButton;
    public SharedPreferencecDb sharedPreferenceAapnar;
    Spinner spinner;
    private Keyboard symbolsKeyboard;
    private Keyboard symbolsShiftedKeyboard;
    int textfontVal;
    private String wordSeparators;

    private final boolean hasSoftBottomButtons() {
        return false;
    }

    public void onPress(int i) {
    }

    public void onRelease(int i) {
    }

    public void swipeDown() {
    }

    public void swipeLeft() {
    }

    public void swipeRight() {
    }

    public void swipeUp() {
    }

    public static final RelativeLayout access$getChangeKeyboardOverlay$p(FontsInputMethodService fontsInputMethodService) {
        RelativeLayout relativeLayout = fontsInputMethodService.changeKeyboardOverlay;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        throw new ExceptionInInitializerError("changeKeyboardOverlay");
    }

    public static final SharedPreferencecDb access$getSharedPreferenceProvider$p(FontsInputMethodService fontsInputMethodService) {
        SharedPreferencecDb sharedPreferencecDb = fontsInputMethodService.sharedPreferenceAapnar;
        if (sharedPreferencecDb != null) {
            return sharedPreferencecDb;
        }
        throw new ExceptionInInitializerError("sharedPreferenceProvider");
    }

    public final ConstraintLayout getRateOverlay() {
        return this.rateOverlay;
    }

    public final void setRateOverlay(ConstraintLayout constraintLayout) {
        this.rateOverlay = constraintLayout;
    }

    public final ArrayList<Pair<FontListner, Button>> getFontButtons() {
        return this.fontButtons;
    }

    public final void setFontButtons(ArrayList<Pair<FontListner, Button>> arrayList) {
        this.fontButtons = arrayList;
    }

    public void onCreate() {
        Log.d("test", "onCreate");
        FontService.INSTANCE.setContext(this);
        this.wordSeparators = getResources().getString(R.string.word_separators);
        this.sharedPreferenceAapnar = new SharedPreferencecDb(this);
        Object systemService = getSystemService(Context.INPUT_METHOD_SERVICE);
        if (systemService != null) {
            this.inputMethodManager = (InputMethodManager) systemService;
            super.onCreate();
            return;
        }
        throw new ClassCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
    }

    public void onConfigurationChanged(Configuration configuration) {
        Log.d("test", "onConfigurationChanged");
        super.onConfigurationChanged(configuration);
    }

    public final void showChangeKeyboardNotificationOverlayView() {
        RelativeLayout relativeLayout = this.container;
        if (relativeLayout != null) {
            relativeLayout.getClass();
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.keyboard_switch_notification_overlay);
            this.changeKeyboardOverlay = relativeLayout2;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
                this.changeKeyboardOverlay.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View view) {
                        view.setVisibility(4);
                    }
                });
                Button button = (Button) this.changeKeyboardOverlay.findViewById(R.id.keyboard_switch_notification_button);
                this.changeKeyboardNotificationButton = button;
                if (button != null) {
                    button.setOnClickListener(new View.OnClickListener() {


                        public void onClick(View view) {
                            FontsInputMethodService.access$getChangeKeyboardOverlay$p(FontsInputMethodService.this).setVisibility(4);
                        }
                    });
                    return;
                }
                throw new ExceptionInInitializerError("changeKeyboardOverlay");
            }
            throw new ExceptionInInitializerError("changeKeyboardOverlay");
        }
    }

    public final void showChangeKeyboardOverlayView() {
        RelativeLayout relativeLayout = this.container;
        if (relativeLayout != null) {
            relativeLayout.getClass();
            RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.keyboard_switch_overlay);
            this.changeKeyboardOverlay = relativeLayout2;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(0);
                RelativeLayout relativeLayout3 = this.changeKeyboardOverlay;
                if (relativeLayout3 != null) {
                    relativeLayout3.setOnClickListener(new View.OnClickListener() {
                        /* class com.vvaani.fontkeyboard.yp.FontInputMethodService.AnonymousClass3 */

                        public void onClick(View view) {
                            view.setVisibility(4);
                        }
                    });
                    return;
                }
                throw new ExceptionInInitializerError("changeKeyboardOverlay");
            }
            throw new ExceptionInInitializerError("changeKeyboardOverlay");
        }
    }

    public final Button getRateNowButton() {
        return this.rateNowButton;
    }

    public final void setRateNowButton(Button button) {
        this.rateNowButton = button;
    }

    public final Button getRemindMeLaterButton() {
        return this.remindMeLaterButton;
    }

    public final void setRemindMeLaterButton(Button button) {
        this.remindMeLaterButton = button;
    }

    private final void initalizeKeyboard() {
        Log.d("test", "initalizeKeyboard");
        Log.d("test", "initalizeKeyboard == null");
        View inflate = getLayoutInflater().inflate(R.layout.style_container, (ViewGroup) null);
        if (inflate != null) {
            RelativeLayout relativeLayout = (RelativeLayout) inflate;
            this.container = relativeLayout;
            this.spinner = (Spinner) relativeLayout.findViewById(R.id.sp_language);
            final int intValue = this.sharedPreferenceAapnar.getLanguagepos().intValue();
            this.spinner.setSelection(intValue);
            this.spinner.post(new Runnable() {


                public void run() {
                    FontsInputMethodService.this.spinner.setSelection(intValue);
                }
            });
            try {
                Field declaredField = Spinner.class.getDeclaredField("mPopup");
                declaredField.setAccessible(true);
                ((ListPopupWindow) declaredField.get(this.spinner)).setHeight(500);
            } catch (ClassCastException | IllegalAccessException | NoClassDefFoundError | NoSuchFieldException unused) {
            }
            this.spinner.setAdapter( new SpinnerAdapterCustom(this, R.layout.custom_spinner, new String[]{"English", "Japanese", "Russian", "Thai", "Chinese", "Gujarati", "Arabic", "Urdu", "Hindi"}));
            this.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }

                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                    if (i == 0) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("eng", 0);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_layout);
                        FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                        fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.aksharonuKeyboard);
                    } else if (i == 1) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("jap", 1);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_jap_layout);
                        FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                        fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.aksharonuKeyboard);
                    } else if (i == 2) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("rus", 2);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_russian_layout);
                        FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                        fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.aksharonuKeyboard);
                    } else if (i == 3) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("thai", 3);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_thai_layout);
                        FontsInputMethodService fontsInputMethodService4 = FontsInputMethodService.this;
                        fontsInputMethodService4.setCurrentKeyboard(fontsInputMethodService4.aksharonuKeyboard);
                    } else if (i == 4) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("chi", 4);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_chinese_layout);
                        FontsInputMethodService fontsInputMethodService5 = FontsInputMethodService.this;
                        fontsInputMethodService5.setCurrentKeyboard(fontsInputMethodService5.aksharonuKeyboard);
                    } else if (i == 5) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("guj", 5);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_gujarati_layout);
                        FontsInputMethodService fontsInputMethodService6 = FontsInputMethodService.this;
                        fontsInputMethodService6.setCurrentKeyboard(fontsInputMethodService6.aksharonuKeyboard);
                    } else if (i == 6) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("arab", 6);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_arb_layout);
                        FontsInputMethodService fontsInputMethodService7 = FontsInputMethodService.this;
                        fontsInputMethodService7.setCurrentKeyboard(fontsInputMethodService7.aksharonuKeyboard);
                    } else if (i == 7) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("urdu", 7);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_urdu_layout);
                        FontsInputMethodService fontsInputMethodService8 = FontsInputMethodService.this;
                        fontsInputMethodService8.setCurrentKeyboard(fontsInputMethodService8.aksharonuKeyboard);
                    } else if (i == 8) {
                        FontsInputMethodService.this.sharedPreferenceAapnar.setLanguage("hindi", 8);
                        FontsInputMethodService.this.aksharonuKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_hindi_layout);
                        FontsInputMethodService fontsInputMethodService9 = FontsInputMethodService.this;
                        fontsInputMethodService9.setCurrentKeyboard(fontsInputMethodService9.aksharonuKeyboard);
                    }
                }
            });
            relativeLayout.getClass();
            this.keyboardView = (FontKeyboard2) relativeLayout.findViewById(R.id.keyboard_view);
            this.iv_back = (ImageView) relativeLayout.findViewById(R.id.iv_back);
            this.rl_second = (RelativeLayout) relativeLayout.findViewById(R.id.rl_second);
            this.rl_first = (RelativeLayout) relativeLayout.findViewById(R.id.rl_first);
            this.rl_font = (RelativeLayout) relativeLayout.findViewById(R.id.rl_font);
            this.rl_emoji = (RelativeLayout) relativeLayout.findViewById(R.id.rl_emoji);
            FontKeyboard2 fontKeyboard2 = this.keyboardView;
            this.aksharoNuMalkhu = fontKeyboard2;
            if (fontKeyboard2 != null) {
                fontKeyboard2.setOnKeyboardActionListener(this);
            }
            FontKeyboard2 fontKeyboard22 = this.keyboardView;
            if (fontKeyboard22 != null) {
                fontKeyboard22.setPreviewEnabled(false);
            }
            this.iv_back.setOnClickListener(new View.OnClickListener() {


                public void onClick(View view) {
                    if (FontsInputMethodService.this.rl_second.getVisibility() == 0) {
                        FontsInputMethodService.this.rl_second.setVisibility(8);
                        FontsInputMethodService.this.rl_first.setVisibility(0);
                        if (FontsInputMethodService.this.backcheck == 1) {
                            FontsInputMethodService.this.backcheck = 0;
                            int currentFontIndex = FontsInputMethodService.this.sharedPreferenceAapnar.getCurrentFontIndex();
                            if (currentFontIndex > 25) {
                                FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(currentFontIndex);
                            } else {
                                FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(1);
                            }
                            FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(FontsInputMethodService.this.sharedPreferenceAapnar.getCurrentEmojiArray());
                            FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                            fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.normalfontsKeyboard);
                            if (FontService.INSTANCE.getInitialFont() instanceof Sadu) {
                                FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                                fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.aksharonuKeyboard);
                            } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                                FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                                fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                            } else {
                                FontsInputMethodService fontsInputMethodService4 = FontsInputMethodService.this;
                                fontsInputMethodService4.setCurrentKeyboard(fontsInputMethodService4.normalfontsKeyboard);
                            }
                        } else {
                            if (FontsInputMethodService.this.sharedPreferenceAapnar.getCurrentFontIndex() < 25) {
                                FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(FontsInputMethodService.this.sharedPreferenceAapnar.getCurrentEmojiArray());
                            } else {
                                FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(1);
                            }
                            if (FontService.INSTANCE.getInitialFont() instanceof Sadu) {
                                FontsInputMethodService fontsInputMethodService5 = FontsInputMethodService.this;
                                fontsInputMethodService5.setCurrentKeyboard(fontsInputMethodService5.aksharonuKeyboard);
                            } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                                FontsInputMethodService fontsInputMethodService6 = FontsInputMethodService.this;
                                fontsInputMethodService6.setCurrentKeyboard(fontsInputMethodService6.normalfontsKeyboard);
                            } else {
                                FontsInputMethodService fontsInputMethodService7 = FontsInputMethodService.this;
                                fontsInputMethodService7.setCurrentKeyboard(fontsInputMethodService7.normalfontsKeyboard);
                            }
                        }
                        FontsInputMethodService.this.selectFont(FontService.INSTANCE.getInitialFont(), true);
                    }
                }
            });
            this.rl_font.setOnClickListener(new View.OnClickListener() {


                public void onClick(View view) {
                    FontsInputMethodService.this.rl_first.setVisibility(8);
                    FontsInputMethodService.this.rl_second.setVisibility(0);
                    FontsInputMethodService.this.fontButtons.clear();
                    FontsInputMethodService.this.fontButtons.removeAll(FontsInputMethodService.this.fontButtons);
                    FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(FontsInputMethodService.this.sharedPreferenceAapnar.getCurrentEmojiArray());
                    FontsInputMethodService.this.linearLayout = (LinearLayout) FontsInputMethodService.this.container.findViewById(R.id.fonts_tabs_linear_layout);
                    FontsInputMethodService.this.linearLayout.removeAllViews();
                    FontListner[] fontOrderEmoji = FontService.INSTANCE.getFontOrderEmoji();
                    for (final FontListner fontListner : fontOrderEmoji) {
                        View inflate = LayoutInflater.from(FontsInputMethodService.this.getApplicationContext()).inflate(R.layout.style_lay_button, (ViewGroup) null);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.ispro);
                        FontsInputMethodService.this.button6 = (Button) inflate.findViewById(R.id.btn_font);
                        FontsInputMethodService.this.button6.setAllCaps(false);
                        int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, FontsInputMethodService.this.getResources().getDisplayMetrics());
                        FontsInputMethodService.this.button6.setPadding(applyDimension, 0, applyDimension, (int) (((float) applyDimension) * fontListner.getExtraPaddingDownFactor()));
                        FontsInputMethodService.this.button6.setTextSize(2, fontListner.getSizeFactorButton() * 16.0f);
                        String name = fontListner.getName();
                        if (name.equals("🄰🄱🄲")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("😉😴🤣")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("😥😮🤐")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("😀😁😂")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("♕␈𐂃")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("♡⌫☏")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("☼᯽✫")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🏧🚮🚰")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("1️⃣2️⃣3️⃣")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("👶🏻👮🏻‍♀👦🏻")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🔇🔔🎵")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🍇🍈🍉")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🍔🍟🍕")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("💪🏻👈🏻☝")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🄰🄱🄲")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ABC")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ABC")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ɐqɔ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ᗩᗷᑕ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ⒶⒷⒸ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🅐🅑🅒")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🅰🅱🅲")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ᏗᏰፈ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("卂乃匚")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ǟɮƈ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ค๖¢")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("₳฿₵")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("【A】【B】【C】")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("『A』『B』『C』")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("₳฿₵")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("A♥B♥C♥")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("A̶B̶C̶")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("A̶̷̲̅B̶̷̲̅C̶̷̲̅")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("A҉B҉C҉")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("Ⱥβ↻")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ꋫꃃꏸ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ΛϦㄈ")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("ค๖¢")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        }
                        FontsInputMethodService.this.button6.setText(fontListner.getName());
                        FontsInputMethodService.this.button6.setOnClickListener(new View.OnClickListener() {


                            public void onClick(View view) {
                                view.setSelected(true);
                                if (fontListner instanceof Sadu) {
                                    FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                                    fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.aksharonuKeyboard);
                                } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                                    FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                                    fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.normalfontsKeyboard);
                                } else {
                                    FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                                    fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                                }
                                FontsInputMethodService.this.selectFont(fontListner, true);
                                if (FontsInputMethodService.this.keyboardView != null) {
                                    FontsInputMethodService.this.keyboardView.invalidateAllKeys();
                                }
                                new SharedPreferencecDb(FontsInputMethodService.this.getApplicationContext()).setCurrentEmojiArray(FontService.indexOf(FontService.INSTANCE.getFontOrderEmoji(), fontListner));
                            }
                        });
                        FontsInputMethodService.this.fontButtons.add(new Pair<>(fontListner, FontsInputMethodService.this.button6));
                        FontsInputMethodService.this.linearLayout.addView(inflate);
                    }
                    if (FontService.INSTANCE.getInitialFont() instanceof Sadu) {
                        FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                        fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.aksharonuKeyboard);
                    } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                        FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                        fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.normalfontsKeyboard);
                    } else {
                        FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                        fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                    }
                    FontsInputMethodService.this.selectFont(FontService.INSTANCE.getInitialFont(), false);
                }
            });
            this.rl_emoji.setOnClickListener(new View.OnClickListener() {


                public void onClick(View view) {
                    FontsInputMethodService.this.backcheck = 1;
                    FontsInputMethodService.this.rl_first.setVisibility(8);
                    FontsInputMethodService.this.rl_second.setVisibility(0);
                    FontsInputMethodService.this.fontButtons.clear();
                    FontsInputMethodService.this.fontButtons.removeAll(FontsInputMethodService.this.fontButtons);
                    FontsInputMethodService.this.normalfontsKeyboard = new FontKeyboard(FontsInputMethodService.this.getApplicationContext(), R.layout.style_keyboard_layout);
                    FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                    fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.normalfontsKeyboard);
                    FontsInputMethodService.this.linearLayout = (LinearLayout) FontsInputMethodService.this.container.findViewById(R.id.fonts_tabs_linear_layout);
                    FontsInputMethodService.this.linearLayout.removeAllViews();
                    FontsInputMethodService.this.sharedPreferenceAapnar.setCurrentFontIndex(25);
                    FontListner[] fontOrderEmoji = FontService.INSTANCE.getFontOrderEmoji();
                    for (final FontListner fontListner : fontOrderEmoji) {
                        View inflate = LayoutInflater.from(FontsInputMethodService.this.getApplicationContext()).inflate(R.layout.style_lay_button, (ViewGroup) null);
                        ImageView imageView = (ImageView) inflate.findViewById(R.id.ispro);
                        FontsInputMethodService.this.button6 = (Button) inflate.findViewById(R.id.btn_font);
                        FontsInputMethodService.this.button6.setAllCaps(false);
                        int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, FontsInputMethodService.this.getResources().getDisplayMetrics());
                        FontsInputMethodService.this.button6.setPadding(applyDimension, 0, applyDimension, (int) (((float) applyDimension) * fontListner.getExtraPaddingDownFactor()));
                        FontsInputMethodService.this.button6.setTextSize(2, fontListner.getSizeFactorButton() * 16.0f);
                        String name = fontListner.getName();
                        if (name.equals("🄰🄱🄲")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ABC")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ꍏꌃꏳ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ABC")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ɐqɔ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ᗩᗷᑕ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ⒶⒷⒸ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🅐🅑🅒")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("🅰🅱🅲")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ᏗᏰፈ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("卂乃匚")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ǟɮƈ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ค๖¢")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("₳฿₵")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("【A】【B】【C】")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("『A』『B』『C』")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("₳฿₵")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("A♥B♥C♥")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("A̶B̶C̶")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("A̶̷̲̅B̶̷̲̅C̶̷̲̅")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("A҉B҉C҉")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("Ⱥβ↻")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ꋫꃃꏸ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ΛϦㄈ")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("ค๖¢")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        } else if (name.equals("😉😴🤣")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("😥😮🤐")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("😀😁😂")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("♕␈𐂃")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("♡⌫☏")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("☼᯽✫")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🏧🚮🚰")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("1️⃣2️⃣3️⃣")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("👶🏻👮🏻‍♀👦🏻")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🔇🔔🎵")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🍇🍈🍉")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("🍔🍟🍕")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("💪🏻👈🏻☝")) {
                            FontsInputMethodService.this.button6.setVisibility(0);
                        } else if (name.equals("Default")) {
                            FontsInputMethodService.this.button6.setVisibility(8);
                        }
                        FontsInputMethodService.this.button6.setText(fontListner.getName());
                        FontsInputMethodService.this.button6.setOnClickListener(new View.OnClickListener() {


                            public void onClick(View view) {
                                view.setSelected(true);
                                if (fontListner instanceof Sadu) {
                                    FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                                    fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.aksharonuKeyboard);
                                } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                                    FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                                    fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.normalfontsKeyboard);
                                } else {
                                    FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                                    fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                                }
                                fontListner.toString();
                                FontsInputMethodService.this.selectFont(fontListner, true);
                                if (FontsInputMethodService.this.keyboardView != null) {
                                    FontsInputMethodService.this.keyboardView.invalidateAllKeys();
                                }
                            }
                        });
                        FontsInputMethodService.this.fontButtons.add(new Pair<>(fontListner, FontsInputMethodService.this.button6));
                        FontsInputMethodService.this.linearLayout.addView(inflate);
                    }
                    if (FontService.INSTANCE.getInitialFont() instanceof Sadu) {
                        FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                        fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.normalfontsKeyboard);
                    } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                        FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                        fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                    } else {
                        FontsInputMethodService fontsInputMethodService4 = FontsInputMethodService.this;
                        fontsInputMethodService4.setCurrentKeyboard(fontsInputMethodService4.normalfontsKeyboard);
                    }
                    FontsInputMethodService.this.selectFont(FontService.INSTANCE.getInitialFont(), false);
                }
            });
            RelativeLayout relativeLayout2 = this.container;
            relativeLayout2.getClass();
            View findViewById = relativeLayout2.findViewById(R.id.fonts_tabs_linear_layout);
            if (findViewById != null) {
                LinearLayout linearLayout2 = (LinearLayout) findViewById;
                RelativeLayout relativeLayout3 = this.container;
                relativeLayout3.getClass();
                this.horizontalScrollView = (HorizontalScrollView) relativeLayout3.findViewById(R.id.horizontal_scroll_view);
                this.nanoSangrahalay = new DataStore(getApplicationContext());
                Button button = new Button(getApplicationContext());
                this.shareButton = button;
                button.setAllCaps(false);
                Button button2 = this.shareButton;
                button2.getClass();
                button2.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.btnclr)));
                Button button3 = this.shareButton;
                button3.getClass();
                button3.setLayoutParams(new WindowManager.LayoutParams(-1, -1));
                Button button4 = this.shareButton;
                button4.getClass();
                button4.setTextSize(2, 16.0f);
                setShareButtonBehavior();
                Button button5 = this.shareButton;
                button5.getClass();
                linearLayout2.addView(button5);
                new Button(getApplicationContext()).getTextSize();
                FontListner[] fontOrderEmoji = FontService.INSTANCE.getFontOrderEmoji();
                for (final FontListner fontListner : fontOrderEmoji) {
                    View inflate2 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.style_lay_button, (ViewGroup) null);
                    ImageView imageView = (ImageView) inflate2.findViewById(R.id.ispro);
                    Button button7 = (Button) inflate2.findViewById(R.id.btn_font);
                    this.button6 = button7;
                    button7.setAllCaps(false);
                    int applyDimension = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
                    this.button6.setPadding(applyDimension, 0, applyDimension, (int) (((float) applyDimension) * fontListner.getExtraPaddingDownFactor()));
                    this.button6.setTextSize(2, fontListner.getSizeFactorButton() * 16.0f);
                    fontListner.getName();
                    this.button6.setText(fontListner.getName());
                    this.button6.setOnClickListener(new View.OnClickListener() {
                        /* class com.vvaani.fontkeyboard.yp.FontInputMethodService.AnonymousClass9 */

                        public void onClick(View view) {
                            view.setSelected(true);
                            if (fontListner instanceof Sadu) {
                                FontsInputMethodService fontsInputMethodService = FontsInputMethodService.this;
                                fontsInputMethodService.setCurrentKeyboard(fontsInputMethodService.aksharonuKeyboard);
                            } else if (FontsInputMethodService.this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                                FontsInputMethodService fontsInputMethodService2 = FontsInputMethodService.this;
                                fontsInputMethodService2.setCurrentKeyboard(fontsInputMethodService2.aksharonuKeyboard);
                            } else {
                                FontsInputMethodService fontsInputMethodService3 = FontsInputMethodService.this;
                                fontsInputMethodService3.setCurrentKeyboard(fontsInputMethodService3.normalfontsKeyboard);
                            }
                            FontsInputMethodService.this.selectFont(fontListner, true);
                            if (FontsInputMethodService.this.keyboardView != null) {
                                FontsInputMethodService.this.keyboardView.invalidateAllKeys();
                            }
                        }
                    });
                    this.fontButtons.add(new Pair<>(fontListner, this.button6));
                    linearLayout2.addView(inflate2);
                }
                if (FontService.INSTANCE.getInitialFont() instanceof Sadu) {
                    setCurrentKeyboard(this.aksharonuKeyboard);
                } else if (this.sharedPreferenceAapnar.getLanguage().equals("eng")) {
                    setCurrentKeyboard(this.aksharonuKeyboard);
                } else {
                    setCurrentKeyboard(this.normalfontsKeyboard);
                }
                selectFont(FontService.INSTANCE.getInitialFont(), false);
                return;
            }
            throw new ClassCastException("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new ClassCastException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }

    public void onInitializeInterface() {
        super.onInitializeInterface();
        Log.d("test", "onInitializeInterface " + this.sharedPreferenceAapnar.getLanguage());
        this.symbolsKeyboard = new Keyboard(this, R.layout.style_symbols);
        this.gujaratiKeyboard = new Keyboard(this, R.layout.style_gujrati_symbols);
        this.arabKeyboard = new Keyboard(this, R.layout.style_arabic_symbols);
        this.hindiKeyboard = new Keyboard(this, R.layout.style_hindi_symbols);
        this.symbolsShiftedKeyboard = new Keyboard(this, R.layout.style_symbols_shift);
    }

    public View onCreateInputView() {
        Log.d("test", "onCreateInputView");
        this.language = this.sharedPreferenceAapnar.getLanguage();
        int intValue = this.sharedPreferenceAapnar.getLanguagepos().intValue();
        this.language.hashCode();
        if (intValue == 0) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 1) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_jap_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 2) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_russian_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 3) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_thai_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 4) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_chinese_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 5) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_gujarati_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 6) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_arb_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 7) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_urdu_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        } else if (intValue == 8) {
            this.aksharonuKeyboard = new FontKeyboard(this, R.layout.style_keyboard_hindi_layout);
            this.normalfontsKeyboard = new FontKeyboard(this, R.layout.style_keyboard_layout);
        }
        initalizeKeyboard();
        RelativeLayout relativeLayout = this.container;
        relativeLayout.getClass();
        return relativeLayout;
    }

    private final void setShareButtonBehavior() {
        if (this.shareButton != null) {
            if (getCurrentInputEditorInfo().packageName.equals("com.instagram.android")) {
                Button button = this.shareButton;
                if (button != null) {
                    button.setText("@fonts");
                }
                Button button2 = this.shareButton;
                if (button2 != null) {
                    button2.setOnClickListener(new View.OnClickListener() {


                        public void onClick(View view) {
                            FontsInputMethodService.this.getCurrentInputConnection().commitText("@fonts", 1);
                        }
                    });
                    return;
                }
                return;
            }
            Button button3 = this.shareButton;
            if (button3 != null) {
                button3.setText("Share App");
                button3.setVisibility(8);
            }
            Button button4 = this.shareButton;
            if (button4 != null) {
                button4.setTextColor(getResources().getColor(R.color.colorKeyText));
            }
            Button button5 = this.shareButton;
            if (button5 != null) {
                button5.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View view) {
                        InputConnection currentInputConnection = FontsInputMethodService.this.getCurrentInputConnection();
                        currentInputConnection.commitText("share" + FontsInputMethodService.this.getPackageName(), 1);
                    }
                });
            }
        }
    }

    public final void selectFont(FontListner fontListner, boolean z) {
        Iterator<Pair<FontListner, Button>> it = this.fontButtons.iterator();
        while (it.hasNext()) {
            Pair<FontListner, Button> next = it.next();
            if (next.first.equals(fontListner)) {
                next.second.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorKeySelected)));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyTextSelected));
                HorizontalScrollView horizontalScrollView2 = this.horizontalScrollView;
                if (horizontalScrollView2 == null) {
                    throw new ExceptionInInitializerError("horizontalScrollView");
                } else if (horizontalScrollView2.getScrollX() <= next.second.getLeft() && this.horizontalScrollView.getScrollX() + this.horizontalScrollView.getWidth() < next.second.getRight()) {
                    if (z) {
                        next.second.getRight();
                    } else {
                        next.second.getRight();
                    }
                }
            } else {
                next.second.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.btnclr)));
                next.second.setTextColor(getResources().getColor(R.color.colorKeyText));
            }
        }
        FontService.INSTANCE.setCurrentFont(fontListner);
    }

    public void onStartInput(EditorInfo editorInfo, boolean z) {
        super.onStartInput(editorInfo, z);
        Log.d("test", "onStartInput");
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferencecDb sharedPreferencecDb = this.sharedPreferenceAapnar;
        sharedPreferencecDb.getClass();
        if (currentTimeMillis - sharedPreferencecDb.getLastUsedDate().getTime() > 7000 && this.container != null) {
            this.sharedPreferenceAapnar.setLastUsedDate(new Date(System.currentTimeMillis()));
            SharedPreferencecDb sharedPreferencecDb2 = this.sharedPreferenceAapnar;
            sharedPreferencecDb2.setUsedKeyboardCount(sharedPreferencecDb2.getUsedKeyboardCount() + 1);
        }
        if (this.sharedPreferenceAapnar.getisKeyboardChanged()) {
            this.sharedPreferenceAapnar.setCurrentFontIndex(0);
            setInputView(onCreateInputView());
            this.sharedPreferenceAapnar.isKeyboardunlocked(false);
            this.sharedPreferenceAapnar.isKeyboardChanged(false);
        }
        setShareButtonBehavior();
        if (editorInfo != null) {
            int i = editorInfo.inputType & 15;
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        this.currentKeyboard = this.symbolsKeyboard;
                    } else if (i != 4) {
                        this.currentKeyboard = this.aksharonuKeyboard;
                        updateShiftKeyState(editorInfo);
                    }
                }
                this.currentKeyboard = this.symbolsKeyboard;
            } else {
                this.currentKeyboard = this.aksharonuKeyboard;
                updateShiftKeyState(editorInfo);
            }
            updateShiftKeyState(editorInfo);
        }
    }

    public void onKey(int i, int[] iArr) {
        FontKeyboard fontKeyboard;
        FontKeyboard fontKeyboard2;
        FontKeyboard fontKeyboard3;
        FontKeyboard fontKeyboard4;
        InputConnection currentInputConnection = getCurrentInputConnection();
        this.language = this.sharedPreferenceAapnar.getLanguage();
        if (currentInputConnection != null) {
            Log.d("test", "onKey " + i);
            if (i == -5) {
                handleBackspace();
            } else if (i == -1) {
                handleShift();
            } else if (i == -4) {
                currentInputConnection.sendKeyEvent(new KeyEvent(0, 66));
            } else if (i == FontKeyboard.Companion.getKEYCODE_LANGUAGE_SWITCH()) {
                handleLanguageSwitch();
            } else if (i == -2) {
                Keyboard keyboard = null;
                if (this.language.equals("guj")) {
                    FontKeyboard2 fontKeyboard22 = this.keyboardView;
                    if (fontKeyboard22 != null) {
                        keyboard = fontKeyboard22.getKeyboard();
                    }
                    if (keyboard == null || (!(keyboard == this.gujaratiKeyboard || keyboard == this.symbolsShiftedKeyboard) || (fontKeyboard4 = this.aksharonuKeyboard) == null)) {
                        Keyboard keyboard2 = this.gujaratiKeyboard;
                        if (keyboard2 != null) {
                            keyboard2.setShifted(false);
                            setCurrentKeyboard(this.gujaratiKeyboard);
                            return;
                        }
                        return;
                    }
                    fontKeyboard4.getClass();
                    setCurrentKeyboard(fontKeyboard4);
                } else if (this.language.equals("arab")) {
                    FontKeyboard2 fontKeyboard23 = this.keyboardView;
                    if (fontKeyboard23 != null) {
                        keyboard = fontKeyboard23.getKeyboard();
                    }
                    if (keyboard == null || (!(keyboard == this.arabKeyboard || keyboard == this.symbolsShiftedKeyboard) || (fontKeyboard3 = this.aksharonuKeyboard) == null)) {
                        Keyboard keyboard3 = this.arabKeyboard;
                        if (keyboard3 != null) {
                            keyboard3.setShifted(false);
                            setCurrentKeyboard(this.arabKeyboard);
                            return;
                        }
                        return;
                    }
                    fontKeyboard3.getClass();
                    setCurrentKeyboard(fontKeyboard3);
                } else if (this.language.equals("hindi")) {
                    FontKeyboard2 fontKeyboard24 = this.keyboardView;
                    if (fontKeyboard24 != null) {
                        keyboard = fontKeyboard24.getKeyboard();
                    }
                    if (keyboard == null || (!(keyboard == this.hindiKeyboard || keyboard == this.symbolsShiftedKeyboard) || (fontKeyboard2 = this.aksharonuKeyboard) == null)) {
                        Keyboard keyboard4 = this.hindiKeyboard;
                        if (keyboard4 != null) {
                            keyboard4.setShifted(false);
                            setCurrentKeyboard(this.hindiKeyboard);
                            return;
                        }
                        return;
                    }
                    fontKeyboard2.getClass();
                    setCurrentKeyboard(fontKeyboard2);
                } else {
                    FontKeyboard2 fontKeyboard25 = this.keyboardView;
                    if (fontKeyboard25 != null) {
                        keyboard = fontKeyboard25.getKeyboard();
                    }
                    if (keyboard == null || (!(keyboard == this.symbolsKeyboard || keyboard == this.symbolsShiftedKeyboard) || (fontKeyboard = this.aksharonuKeyboard) == null)) {
                        Keyboard keyboard5 = this.symbolsKeyboard;
                        if (keyboard5 != null) {
                            keyboard5.setShifted(false);
                            setCurrentKeyboard(this.symbolsKeyboard);
                            return;
                        }
                        return;
                    }
                    fontKeyboard.getClass();
                    setCurrentKeyboard(fontKeyboard);
                }
            } else if (i == 10) {
                keyDownUp(66);
            } else {
                if (this.capsLockOn || this.keyboardView.getKeyboard().isShifted()) {
                    currentInputConnection.commitText(String.valueOf((char) i).toUpperCase(), 1);
                } else {
                    currentInputConnection.commitText(String.valueOf((char) i), 1);
                }
                if (this.keyboardView.getKeyboard() == this.aksharonuKeyboard) {
                    updateShiftKeyState(getCurrentInputEditorInfo());
                    this.keyboardView.invalidateAllKeys();
                }
                if (FontService.INSTANCE.getCurrentFont().isUpsideDown()) {
                    currentInputConnection.sendKeyEvent(new KeyEvent(0, 21));
                    currentInputConnection.sendKeyEvent(new KeyEvent(1, 21));
                }
                if (isWordSeparator(i)) {
                    updateShiftKeyState(getCurrentInputEditorInfo());
                }
            }
        }
    }

    public void onText(CharSequence charSequence) {
        InputConnection currentInputConnection = getCurrentInputConnection();
        if (currentInputConnection != null) {
            currentInputConnection.commitText(charSequence, 1);
            if (FontService.INSTANCE.getCurrentFont().isUpsideDown()) {
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, 21));
                getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, 21));
            }
            updateShiftKeyState(getCurrentInputEditorInfo());
        }
    }

    public final void setCurrentKeyboard(Keyboard keyboard) {
        this.currentKeyboard = keyboard;
        FontKeyboard2 fontKeyboard2 = this.keyboardView;
        if (fontKeyboard2 != null) {
            fontKeyboard2.setKeyboard(keyboard);
        }
    }

    private final void handleLanguageSwitch() {
        if (Build.VERSION.SDK_INT < 28 || !shouldOfferSwitchingToNextInputMethod()) {
            InputMethodManager inputMethodManager2 = this.inputMethodManager;
            if (inputMethodManager2 == null) {
                throw new ExceptionInInitializerError("inputMethodManager");
            } else if (inputMethodManager2.shouldOfferSwitchingToNextInputMethod(getToken())) {
                this.inputMethodManager.switchToNextInputMethod(getToken(), false);
            } else if (hasNavigationKeyboardSwitchButton()) {
                showChangeKeyboardOverlayView();
            } else {
                showChangeKeyboardNotificationOverlayView();
            }
        } else {
            switchToNextInputMethod(false);
        }
    }

    private final IBinder getToken() {
        Window window;
        Dialog window2 = getWindow();
        if (window2 == null || (window = window2.getWindow()) == null) {
            return null;
        }
        return window.getAttributes().token;
    }

    private final void handleBackspace() {
        if (FontService.INSTANCE.getCurrentFont().isUpsideDown()) {
            getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, 22));
            getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, 22));
        }
        keyDownUp(67);
        updateShiftKeyState(getCurrentInputEditorInfo());
    }

    private final void keyDownUp(int i) {
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(0, i));
        getCurrentInputConnection().sendKeyEvent(new KeyEvent(1, i));
    }

    public final boolean isWordSeparator(int i) {
        String str = this.wordSeparators;
        if (str != null) {
            return str.contains(String.valueOf((char) i));
        }
        throw new ExceptionInInitializerError("wordSeparators");
    }

    public final boolean hasNavigationKeyboardSwitchButton() {
        Object systemService = getSystemService("window");
        if (!(systemService instanceof WindowManager)) {
            return true;
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        int i3 = displayMetrics2.heightPixels;
        if (i2 - displayMetrics2.widthPixels > 125 || i - i3 > 125) {
            return true;
        }
        return false;
    }

    private final void updateShiftKeyState(EditorInfo editorInfo) {
        FontKeyboard fontKeyboard;
        FontKeyboard2 fontKeyboard2;
        if (editorInfo != null && (fontKeyboard = this.normalfontsKeyboard) != null && (fontKeyboard2 = this.keyboardView) != null) {
            boolean z = true;
            if (fontKeyboard == (fontKeyboard2 != null ? fontKeyboard2.getKeyboard() : null)) {
                int cursorCapsMode = (getCurrentInputEditorInfo() == null || getCurrentInputEditorInfo().inputType == 0) ? 0 : getCurrentInputConnection().getCursorCapsMode(editorInfo.inputType);
                FontKeyboard fontKeyboard3 = this.normalfontsKeyboard;
                if (fontKeyboard3 != null) {
                    if (!this.capsLockOn && cursorCapsMode == 0) {
                        z = false;
                    }
                    fontKeyboard3.setShifted(z);
                }
            } else if (this.keyboardView.getKeyboard() == this.aksharonuKeyboard) {
                int cursorCapsMode2 = (getCurrentInputEditorInfo() == null || getCurrentInputEditorInfo().inputType == 0) ? 0 : getCurrentInputConnection().getCursorCapsMode(editorInfo.inputType);
                FontKeyboard fontKeyboard4 = this.aksharonuKeyboard;
                if (fontKeyboard4 != null) {
                    if (!this.capsLockOn && cursorCapsMode2 == 0) {
                        z = false;
                    }
                    fontKeyboard4.setShifted(z);
                }
            }
        }
    }

    private final void handleShift() {
        if (this.normalfontsKeyboard != null && this.symbolsKeyboard != null && this.symbolsShiftedKeyboard != null) {
            FontKeyboard2 fontKeyboard2 = this.keyboardView;
            Keyboard keyboard = null;
            boolean z = false;
            if ((fontKeyboard2 != null ? fontKeyboard2.getKeyboard() : null) == this.normalfontsKeyboard) {
                checkToggleCapsLock();
                FontKeyboard2 fontKeyboard22 = this.keyboardView;
                if (fontKeyboard22 != null) {
                    if (this.capsLockOn || fontKeyboard22 == null || !fontKeyboard22.isShifted()) {
                        z = true;
                    }
                    this.keyboardView.setShifted(z);
                    return;
                }
                return;
            }
            FontKeyboard2 fontKeyboard23 = this.keyboardView;
            if (fontKeyboard23 != null) {
                keyboard = fontKeyboard23.getKeyboard();
            }
            if (keyboard == this.aksharonuKeyboard) {
                checkToggleCapsLock();
                FontKeyboard2 fontKeyboard24 = this.keyboardView;
                if (fontKeyboard24 != null) {
                    if (this.capsLockOn || fontKeyboard24 == null || !fontKeyboard24.isShifted()) {
                        z = true;
                    }
                    this.keyboardView.setShifted(z);
                    return;
                }
                return;
            }
            Keyboard keyboard2 = this.currentKeyboard;
            Keyboard keyboard3 = this.symbolsKeyboard;
            if (keyboard2 == keyboard3) {
                if (keyboard3 != null) {
                    keyboard3.setShifted(true);
                }
                Keyboard keyboard4 = this.symbolsShiftedKeyboard;
                keyboard4.getClass();
                setCurrentKeyboard(keyboard4);
                Keyboard keyboard5 = this.symbolsShiftedKeyboard;
                if (keyboard5 != null) {
                    keyboard5.setShifted(true);
                }
            } else if (keyboard2 == this.symbolsShiftedKeyboard) {
                if (keyboard3 != null) {
                    keyboard3.setShifted(false);
                }
                Keyboard keyboard6 = this.symbolsKeyboard;
                keyboard6.getClass();
                setCurrentKeyboard(keyboard6);
                Keyboard keyboard7 = this.symbolsShiftedKeyboard;
                if (keyboard7 != null) {
                    keyboard7.setShifted(false);
                }
            }
        }
    }

    private final void checkToggleCapsLock() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.lastShiftTime + 400 > currentTimeMillis || this.capsLockOn) {
            this.capsLockOn = !this.capsLockOn;
            this.lastShiftTime = 0;
            return;
        }
        this.lastShiftTime = currentTimeMillis;
    }
}

package com.fontskeyboard.cooltextstyle.skytechzone.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.fontskeyboard.cooltextstyle.skytechzone.R;
import com.fontskeyboard.cooltextstyle.skytechzone.db.SharedPreferencecDb;


public class KeyboardLang extends RecyclerView.Adapter<KeyboardLang.MyLanguageclass> {
    public int[] arrData = {R.drawable.eng_key1, R.drawable.japa_key1, R.drawable.russian_key1, R.drawable.thai_key1, R.drawable.chinese_key1,  R.drawable.arabic_key1, R.drawable.urdu_key1, R.drawable.hindi_key1};
    public String[] arrLanguage = {"English", "Japanese", "Russian", "Thai", "Chinese", "Arabic", "Urdu", "Hindi"};

    Context context;

    SharedPreferencecDb sharedPreferenceAapnar;

    public KeyboardLang(Context context2) {
        this.context = context2;

        this.sharedPreferenceAapnar = new SharedPreferencecDb(context2);
    }

    @Override
    public MyLanguageclass onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new MyLanguageclass(LayoutInflater.from(this.context).inflate(R.layout.language_select, viewGroup, false));
    }

    public void onBindViewHolder(final MyLanguageclass myLanguageclass, int i) {



        myLanguageclass.iv_langu.setImageResource(arrData[i]);
        myLanguageclass.tv_language.setText(this.arrLanguage[i]);
        myLanguageclass.rv_lan.setTag(Integer.valueOf(i));
        this.sharedPreferenceAapnar.getLanguage();
        if (this.sharedPreferenceAapnar.getLanguagepos().intValue() == i) {
            myLanguageclass.rl_selected.setVisibility(0);
        } else {
            myLanguageclass.rl_selected.setVisibility(8);
        }
        myLanguageclass.rv_lan.setOnClickListener(new View.OnClickListener() {


            public void onClick(View view) {
                int intValue = ((Integer) view.getTag()).intValue();
                if (intValue == 0) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("eng", 0);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 1) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("jap", 1);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 2) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("rus", 2);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 3) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("thai", 3);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 4) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("chi", 4);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 6) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("arab", 5);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 7) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("urdu", 6);
                    myLanguageclass.rl_selected.setVisibility(0);
                } else if (intValue == 8) {
                    KeyboardLang.this.sharedPreferenceAapnar.setLanguage("hindi", 7);
                    myLanguageclass.rl_selected.setVisibility(0);
                }
                KeyboardLang.this.sharedPreferenceAapnar.isKeyboardChanged(true);
                KeyboardLang.this.notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.arrData.length;
    }

    public class MyLanguageclass extends RecyclerView.ViewHolder {
        ImageView iv_langu;
        RelativeLayout rl_selected;
        CardView rv_lan;
        TextView tv_language;

        public MyLanguageclass(View view) {
            super(view);
            this.rv_lan = (CardView) view.findViewById(R.id.rv_lan);
            this.rl_selected = (RelativeLayout) view.findViewById(R.id.rl_selected);
            this.tv_language = (TextView) view.findViewById(R.id.tv_language);
            this.iv_langu = (ImageView) view.findViewById(R.id.iv_langu);
        }
    }
}

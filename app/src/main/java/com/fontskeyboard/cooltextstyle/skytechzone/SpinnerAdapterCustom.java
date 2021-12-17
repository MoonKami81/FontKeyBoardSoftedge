package com.fontskeyboard.cooltextstyle.skytechzone;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.fontskeyboard.cooltextstyle.skytechzone.R;

public class SpinnerAdapterCustom extends ArrayAdapter<String> {
    private String[] objects;

    public SpinnerAdapterCustom(Context context, int i, String[] strArr) {
        super(context, i, strArr);
        this.objects = strArr;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        return getCustomView(i, view, viewGroup);
    }

    private View getCustomView(int i, View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.custom_spinner, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_spinnervalue)).setText(this.objects[i]);
        return inflate;
    }
}

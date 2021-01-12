package com.example.daumobile;

import com.github.mikephil.charting.formatter.ValueFormatter;

import java.util.ArrayList;

class ValueFormatSimple extends ValueFormatter {
    ArrayList<String> mValues;

    public ValueFormatSimple(ArrayList<String> values) {
        mValues = values;
    }

    @Override
    public String getFormattedValue(float value) {
        return mValues.get((int) value);
    }
}

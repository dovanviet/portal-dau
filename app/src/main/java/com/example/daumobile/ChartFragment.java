package com.example.daumobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.daumobile.Constant.Constants;
import com.example.daumobile.Controller.PointModify;
import com.example.daumobile.Model.Chart;
import com.example.daumobile.Model.Point;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmConfiguration;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class ChartFragment extends Fragment {
    private Realm mRealmPoint;
    private BarChart mBarbar;
    private LineChart mLinechart;
    private PointModify instancePoint;
    private ArrayList<Chart> listChart;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chart, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        initialization();
//        config();
//        getData();
//        drawChart();
    }

//    private void initialization() {
//        mapp();
//
//        listChart = new ArrayList<>();
//    }
//
//    private void mapp() {
//        mBarbar = getActivity().findViewById(R.id.bar_chart);
//        mLinechart = getActivity().findViewById(R.id.line_chart);
//    }
//
//    private void config() {
//        configRealm();
//    }
//
//    private void configRealm() {
//        Realm.init(getActivity());
//        RealmConfiguration configPoint = new RealmConfiguration.Builder().name(Constants.KEY_TABLE_NAME_POINT)
//                .schemaVersion(1)
//                .build();
//
//        mRealmPoint = Realm.getInstance(configPoint);
//        instancePoint = PointModify.getInstance(mRealmPoint);
//    }
//
//    private void getData() {
//        long hoc_ky_max = instancePoint.queryHocKyMax();
//        for (int i = 1; i <= hoc_ky_max; i++) {
//            long tong_tin_chi_hoc_ky = 0, tong_diem_hoc_ky = 0;
//            int diem_a = 0, diem_b = 0, diem_c = 0, diem_d = 0, diem_f = 0;
//            int tin_chi_rot_hoc_ky = 0;
//            double diem_trung_binh_hoc_ky = 0.0;
//            int hoc_ky = i;
//
//            ArrayList<Point> listPoint = instancePoint.queryAllData_ArrayList(i);
//
//            for (Point point : listPoint) {
//                int diem_lan_1 = point.getDiemLan1();
//                int diem_lan_2 = point.getDiemLan2();
//                int tin_chi = point.getStc();
//
//                tong_tin_chi_hoc_ky += tin_chi;
//
//                int diem_max = Math.max(diem_lan_1, diem_lan_2);
//                tong_diem_hoc_ky += (diem_max * tin_chi);
//                switch (diem_max) {
//                    case 4:
//                        diem_a++;
//                        break;
//                    case 3:
//                        diem_b++;
//                        break;
//                    case 2:
//                        diem_c++;
//                        break;
//                    case 1:
//                        diem_d++;
//                        break;
//                    default:
//                        diem_f++;
//                        tin_chi_rot_hoc_ky += tin_chi;
//                        break;
//                }
//            }
//
//            diem_trung_binh_hoc_ky = tong_diem_hoc_ky / (tong_tin_chi_hoc_ky * 1.0);
//            diem_trung_binh_hoc_ky = Math.round(diem_trung_binh_hoc_ky * 100.0) / 100.0;    // làm tròn số
//            listChart.add(makeChart(diem_trung_binh_hoc_ky, tin_chi_rot_hoc_ky, tong_tin_chi_hoc_ky, hoc_ky, diem_a, diem_b, diem_c, diem_d, diem_f));
//        }
//
//    }
//
//    private void drawChart() {
//        drawBarChart();
//        drawLineChart();
//    }
//
//    private void drawLineChart() {
//        // config
//        mLinechart.setPinchZoom(false);
//        mLinechart.setDrawGridBackground(true);
//        mLinechart.getDescription().setEnabled(false);
//        mLinechart.setScaleEnabled(false);
//        mLinechart.getXAxis().setPosition(XAxis.XAxisPosition.BOTTOM);
//        mLinechart.getXAxis().setTextSize(12f);
//
//        // add data
//        ArrayList<Entry> entries = new ArrayList<>();
//        ArrayList<String> labels = new ArrayList<>();// label
//        int idx = 0;
//        for (Chart chart : listChart) {
//            labels.add("HK " + (idx + 1));
//            entries.add(new Entry(idx++, (float) chart.getDiem_trung_binh()));
//        }
//
//        LineDataSet dataSet = new LineDataSet(entries, "CPA");
//        dataSet.setCircleColors(ColorTemplate.COLORFUL_COLORS);
//        dataSet.setColor(ContextCompat.getColor(getContext(), R.color.DeepPink));
//        dataSet.setValueTextColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryDark));
//
//        // Controlling X axis
//        ValueFormatter xAxisFormatter = new ValueFormatSimple(labels);
//        XAxis xAxis = mLinechart.getXAxis();
//        xAxis.setValueFormatter(xAxisFormatter);
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setLabelCount(labels.size(), true);
//
//        YAxis yAxisRight = mLinechart.getAxisRight();
//        yAxisRight.setValueFormatter(xAxisFormatter);
//        yAxisRight.setEnabled(false);
//        yAxisRight.setCenterAxisLabels(true);
//        yAxisRight.setLabelCount(labels.size(), true);
//
//
//        // Setting Data
//        LineData data = new LineData(dataSet);
//        mLinechart.setData(data);
//        mLinechart.animateX(1000);
//        //refresh
//        mLinechart.invalidate();
//        mLinechart.setMaxVisibleValueCount(10);
//
//    }
//
//    private void drawBarChart() {
//        // config
//        mBarbar.setDrawBarShadow(false);
//        mBarbar.setPinchZoom(false);
//        mBarbar.setDrawGridBackground(true);
//        mBarbar.animateY(1000);
//        mBarbar.getDescription().setEnabled(false);
//        mBarbar.setScaleEnabled(false);
//
//        int tong_diem_a = 0, tong_diem_b = 0, tong_diem_c = 0, tong_diem_d = 0, tong_diem_f = 0;
//        int _maxRow = 0;
//        for (Chart chart : listChart) {
//            tong_diem_a += chart.getDem_diem_a();
//            tong_diem_b += chart.getDem_diem_b();
//            tong_diem_c += chart.getDem_diem_c();
//            tong_diem_d += chart.getDem_diem_d();
//            tong_diem_f += chart.getDem_diem_f();
//        }
//        _maxRow = Math.max(tong_diem_a, tong_diem_b);
//        _maxRow = Math.max(_maxRow, tong_diem_c);
//        _maxRow = Math.max(_maxRow, tong_diem_d);
//        _maxRow = Math.max(_maxRow, tong_diem_f);
//
//        // add data to map
//        String[] mark = {"A", "B", "C", "D", "F"};
//        Map<String, Integer> map = new HashMap<>();
//        map.put(mark[0], tong_diem_a);
//        map.put(mark[1], tong_diem_b);
//        map.put(mark[2], tong_diem_c);
//        map.put(mark[3], tong_diem_d);
//        map.put(mark[4], tong_diem_f);
//
//        ArrayList<BarEntry> entriesBar = new ArrayList<>();
//        ArrayList<String> labels = new ArrayList<>();// label
//
//        // add value bar
//        int count = 0;
//        for (String diem : mark) {
//            labels.add(diem);
//            entriesBar.add(new BarEntry(count++, map.get(diem).floatValue()));
//        }
//
//        // set bar
//        BarDataSet barDataSet = new BarDataSet(entriesBar, "Số tín chỉ");
//        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
//
//        // set description value
//        ValueFormatter xAxisFormatter = new ValueFormatSimple(labels);
//        XAxis xAxis = mBarbar.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
//        xAxis.setValueFormatter(xAxisFormatter);
//
//        // set data
//        BarData data = new BarData(barDataSet);
//        mBarbar.setData(data);
//        mBarbar.setFitBars(true);
//        mBarbar.setMaxVisibleValueCount(_maxRow);
//    }
//
//    public Chart makeChart(double diem_trung_binh, int tin_chi_rot, long tin_chi, int hoc_ky, int diem_a, int diem_b, int diem_c, int diem_d, int diem_f) {
//        return new Chart(diem_trung_binh, tin_chi_rot, tin_chi, hoc_ky, diem_a, diem_b, diem_c, diem_d, diem_f);
//    }

}

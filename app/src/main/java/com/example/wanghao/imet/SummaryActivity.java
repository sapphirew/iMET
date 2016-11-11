package com.example.wanghao.imet;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.GridLabelRenderer;
import com.jjoe64.graphview.LegendRenderer;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

public class SummaryActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        GraphView graph = (GraphView) findViewById(R.id.graph);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter() {
            @Override
            public String formatLabel(double value, boolean isValueX) {
                if (isValueX) {
                    // show normal x values
                    return "Oct " + super.formatLabel(value + 5, isValueX);
                } else {
                    // show currency for y values
                    return super.formatLabel(value + 10, isValueX);
                }
            }
        });

        LineGraphSeries<DataPoint> series = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, -5),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        LineGraphSeries<DataPoint> series2 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 4),
                new DataPoint(1, 1),
                new DataPoint(2, 2),
                new DataPoint(3, 5),
                new DataPoint(4, 8)
        });
        graph.addSeries(series2);

        LineGraphSeries<DataPoint> series3 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 4),
                new DataPoint(2, 6),
                new DataPoint(3, 9),
                new DataPoint(4, 7)
        });
        graph.addSeries(series3);

        LineGraphSeries<DataPoint> series4 = new LineGraphSeries<DataPoint>(new DataPoint[] {
                new DataPoint(0, 8),
                new DataPoint(1, 2),
                new DataPoint(2, 4),
                new DataPoint(3, 6),
                new DataPoint(4, 5)
        });
        graph.addSeries(series4);

        graph.addSeries(series);
        series.setTitle("Mood");
        series2.setTitle("Energy");
        series3.setTitle("Anxiety");
        series4.setTitle("Worry");
        series2.setColor(Color.GREEN);
        series3.setColor(Color.RED);
        series4.setColor(Color.MAGENTA);
        series.setThickness(10);
        series2.setThickness(10);
        series3.setThickness(10);
        series4.setThickness(10);
        graph.getLegendRenderer().setVisible(true);
        graph.getLegendRenderer().setAlign(LegendRenderer.LegendAlign.BOTTOM);

        graph.getGridLabelRenderer().setGridStyle(GridLabelRenderer.GridStyle.BOTH);
    }
}

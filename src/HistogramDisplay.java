import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import javax.swing.*;
import java.awt.*;

public class HistogramDisplay extends ApplicationFrame {
    private final Histogram<String> histogram;

    public HistogramDisplay(Histogram<String> histogram) {
        super("HISTOGRAMA");
        this.histogram = histogram;
        setContentPane(createPanel());
        pack();
    }

    public void execute() {
        setVisible(true);
    }

    private JPanel createPanel() {
        ChartPanel chartPanel = new ChartPanel(createChart(createDataset()));
        chartPanel.setPreferredSize(new Dimension(500, 400));
        chartPanel.getChart().getCategoryPlot().getRangeAxis().setLowerBound(600000);
        return chartPanel;
    }

    private JFreeChart createChart(DefaultCategoryDataset dataset) {
        return ChartFactory.createBarChart("Histograma JFreeChart", "Vuelos por días de la semana",
                "Nº de vuelos", dataset, PlotOrientation.HORIZONTAL, false, false,
                rootPaneCheckingEnabled);
    }

    private DefaultCategoryDataset createDataset() {
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        dataSet.addValue(histogram.get("MONDAY"), "", "MONDAY");
        dataSet.addValue(histogram.get("TUESDAY"), "", "TUESDAY");
        dataSet.addValue(histogram.get("WEDNESDAY"), "", "WEDNESDAY");
        dataSet.addValue(histogram.get("THURSDAY"), "", "THURSDAY");
        dataSet.addValue(histogram.get("FRIDAY"), "", "FRIDAY");
        dataSet.addValue(histogram.get("SATURDAY"), "", "SATURDAY");
        dataSet.addValue(histogram.get("SUNDAY"), "", "SUNDAY");
        return dataSet;
    }


}


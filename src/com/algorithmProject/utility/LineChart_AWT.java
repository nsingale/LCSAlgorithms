package com.algorithmProject.utility;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

public class LineChart_AWT extends ApplicationFrame {
	public LineChart_AWT(String applicationTitle, DefaultCategoryDataset dataset) {
		super(applicationTitle);
		JFreeChart lineChart = ChartFactory.createLineChart(
				"Time Complexity Analysis of DP LCS", "Input size",
				"Execution time(ms)", dataset, PlotOrientation.VERTICAL, true,
				true, false);

		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

		setContentPane(chartPanel);
	}

	// private DefaultCategoryDataset createDataset() {
	// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	// dataset.addValue(15, "schools", "1970");
	// dataset.addValue(30, "schools", "1980");
	// dataset.addValue(60, "schools", "1990");
	// dataset.addValue(120, "schools", "2000");
	// dataset.addValue(240, "schools", "2010");
	// dataset.addValue(300, "schools", "2014");
	// return dataset;
	// }

	public static void main(String[] args) {
		// LineChart_AWT chart = new LineChart_AWT(
		// "School Vs Years" ,
		// "Numer of Schools vs years");
		//
		// chart.pack( );
		// RefineryUtilities.centerFrameOnScreen( chart );
		// chart.setVisible( true );
	}
}
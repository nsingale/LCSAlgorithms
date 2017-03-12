package com.algorithmProject.main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.apache.commons.lang.RandomStringUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RefineryUtilities;

import com.algorithmProject.algorithms.LCSDynamicProgramming;
import com.algorithmProject.utility.LineChart_AWT;

public class Main {
	static long executionTime = 0;
	static int rowCount = 0;
	static DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	static Object columnNames[] = { "Input Size", "Execution Time" };
	static Object rowData[][] = new Object[10][10];

	public static void main(String[] args) {
		Main m = new Main();
		
		//Writer writer = null;

		// Declaring buffered writer object to write to file.

		int i = 10, j = 0;
		j = (int) Math.ceil((2 / 3) * i);
		while (i <= 16000) {
			i += 1000;
			j = (i / 3) * 2;
			m.computeTimeComplexity(i, j);

		}
		
		JTable table = new JTable(rowData, columnNames);
		TableModel model = table.getModel();

//		try (BufferedWriter bw = new BufferedWriter(new FileWriter(
//				"D:/CSSemester2/Intro to Big Data/Project Data/Output.txt",
//				true))) {
//			for (i = 0; i < table.getColumnCount(); i++) {
//				bw.write(table.getColumnName(i));
//				bw.write("\t");
//				//bw.newLine();
//			}
//			// Writing each line.
//			for (int row = 0; row < model.getRowCount(); row++) {
//				bw.newLine();
//				for (int column = 0; column < model.getColumnCount(); column++) {
//					// Create your File Writer
//					bw.write(String.valueOf(model.getValueAt(row, column)));
//					bw.write("\t");
//					bw.write("\t");
//					bw.write("\t");
//					
//				}
//
//				bw.flush();
//			}
//		} catch (IOException ex) {
//		}
		LineChart_AWT chart = new LineChart_AWT("Input size vs Execution time",
				dataset);
		chart.pack();
		RefineryUtilities.centerFrameOnScreen(chart);
		chart.setVisible(true);
	}

	public void computeTimeComplexity(int m, int n) {
		long time1 = System.currentTimeMillis();
		String inputToRandom = "abcdefghijlkmn";

		char[] inputToRandomChar;
		inputToRandomChar = inputToRandom.toCharArray();
		String temp1 = RandomStringUtils.random(m, inputToRandomChar);
		String temp2 = RandomStringUtils.random(n, inputToRandomChar);
		// System.out.println(temp1 + "///" + temp2);
		LCSDynamicProgramming lcs = new LCSDynamicProgramming();
		char X[];
		char Y[];
		X = temp1.toCharArray();
		Y = temp2.toCharArray();
//		System.out
//				.println("--------------------------------------------------------");
//		System.out.println("Length of first string is: " + m
//				+ "| Length of second string is: " + n);
//		System.out.println("Length of LCS is: " + lcs.computeLCS(X, Y));

		long time2 = System.currentTimeMillis();
		long timeTaken = time2 - time1;
		if (timeTaken > executionTime) {
			executionTime = timeTaken;
		}
		String str = executionTime + "|" + m + "\n";
		Writer writer = null;

		rowData[rowCount][0] = m;
		rowData[rowCount][1] = executionTime;

		// Declaring buffered writer object to write to file.
		// try (BufferedWriter bw = new BufferedWriter(new FileWriter(
		// "D:/CSSemester2/Intro to Big Data/Project Data/Output.txt",
		// true))) {
		// // Writing each line.
		// bw.write(str);
		// bw.newLine();
		// bw.flush();
		// } catch (IOException ex) {
		// }
		// DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		dataset.addValue(executionTime, "Time Complexity", String.valueOf(m));
		// dataset.add
//		System.out.println("Time taken: " + executionTime + "ms");
//		System.out
//				.println("--------------------------------------------------------");
		// setContentPane( chartPanel );
		rowCount++;

	}

}

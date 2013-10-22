package statistik;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class StackedBarChart extends JFrame{

	private static final long serialVersionUID = 7426201173118789649L;
	private String[] bezeichnungenXAchse;

	public StackedBarChart(String title, String[] bezeichnungenXAchse, String[] bezeichnungenYAchse, double[][] werteErstYDannX)  {
		super(title);
		this.setBackground(Color.RED);
		this.bezeichnungenXAchse=bezeichnungenXAchse;

		try {
			List<ChartObject> chartObjectList = new ArrayList<ChartObject>();
			for(int i=0; i<bezeichnungenXAchse.length; i++){
				ChartObject chartObject = new ChartObject(werteErstYDannX[i],
						bezeichnungenXAchse[i]);
				chartObjectList.add(chartObject);
			}

			final CategoryDataset dataset = createDataset(bezeichnungenXAchse, bezeichnungenYAchse, werteErstYDannX);
			final JFreeChart chart = createChart(dataset);
			final ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(900, 800));
			this.add(chartPanel);

		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}

	/**
	 * This method takes the List of ChartObjects as a parameter and creates
	 * three objects needed by the createCategoryDataset method of the
	 * DatasetUtilities class. The createCategoryDataset method needs 3
	 * parameters. The first and second ones are Comparable[] and the third one
	 * is a double[][]. Since we created RowKey and ColumnKey objects to
	 * implement Comparable interface, we use those objects to create the first
	 * two parameters. The actual read/write values are used to populate a two
	 * dimensional double[][].
	 * 
	 * @param chartObjectList
	 * @return
	 */
	private CategoryDataset createDataset(String[] bezeichnungenXAchse, String[] bezeichnungenYAchse, double[][] werteErstYDannX) {
//		int chartObjectListSize = chartObjectList.size();
//		// This is the Comparable[] that is used as the first
//		// parameter to the createCategoryDataset method
//		// These values show up as the legend on the X-axis
		RowKey[] operations = new RowKey[bezeichnungenXAchse.length];
		for (int i=0; i<bezeichnungenXAchse.length; i++){
			operations[i] = new RowKey(bezeichnungenXAchse[i]);
		}
		
		ColumnKey[] timeStampArray = new ColumnKey[bezeichnungenYAchse.length];
		for (int i=0; i<bezeichnungenYAchse.length; i++){
			timeStampArray[i] = new ColumnKey(bezeichnungenYAchse[i]);
		}
//
//		// This is the Comparable[] that is used as the second
//		// parameter to the createCategoryDataset method
//		ColumnKey[] timeStampArray = new ColumnKey[chartObjectListSize];
//
//		// These two double[] are used to populate a two
//		// dimensional double[][] that is used as the
//		// third parameter to the createCategoryDataset method
//		double[][] alleWerte = new double[anzahl][chartObjectListSize];
//		double[] readTimes = new double[chartObjectListSize];
//		double[] writeTimes = new double[chartObjectListSize];
//		double[] dritteSache = new double[chartObjectListSize];
//
//		// In this loop, the arrays are populated
//		for (int i = 0; i < chartObjectListSize; i++) {
//			timeStampArray[i] = new ColumnKey(chartObjectList.get(i)
//					.getTimeDetails());
//			for(int x=0; x<anzahl; x++){
//				alleWerte[i][x] = chartObjectList.get(i).getArray()[x];
//			}
////			readTimes[i] = chartObjectList.get(i).getReadTime();
////			writeTimes[i] = chartObjectList.get(i).getWriteTime();
////			dritteSache[i] = chartObjectList.get(i).getArbeitsgruppe3();
//		}
//
//		// Populate the two dimensional double[][] using the
//		// two double[] created above
//		double[][] data = new double[][] { readTimes, writeTimes, dritteSache };

		// Invoke the createCategoryDataset method by passing
		// the three required parameters
		return DatasetUtilities.createCategoryDataset(operations,
				timeStampArray, werteErstYDannX);
	}

	private JFreeChart createChart(final CategoryDataset dataset) {
		// Use the dataset created in the above method and get the
		// JFreeChartObject.
		// The PlotOrienation can be set to HORIZONTAL or VERTICAL.
		// The tooltip is shown if the second last boolean is
		// set to true. This tooltip shows the deails when the
		// cursor is hovered over a particular bar in the chart
		final JFreeChart chart = ChartFactory.createStackedBarChart(
				"Balkendiagramm", "Gruppen", "Anzahl", dataset,
				PlotOrientation.HORIZONTAL, true, true, false);

		chart.setBackgroundPaint(new Color(255, 250, 240));

		// Set colors etc. here
		CategoryPlot plot = chart.getCategoryPlot();
		
		//Alt:
		//plot.getRenderer().setSeriesPaint(0, new Color(128, 0, 0));
		//plot.getRenderer().setSeriesPaint(1, new Color(0, 0, 255));
		
		//Die CustomRenderer Klasse wählt nun die Farbe
		CategoryItemRenderer renderer = new CustomRenderer(bezeichnungenXAchse.length); 
		plot.setRenderer(renderer);
		
		return chart;

	}

}

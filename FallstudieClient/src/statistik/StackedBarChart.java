package statistik;

import gui.Hauptseite;

import java.awt.Color;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class StackedBarChart extends JFrame {

	private static final long serialVersionUID = 7426201173118789649L;
	private String[] bezeichnungenXAchse;

	// Erstellt eine JFreeChart und zeigt diesen in dem JFrame an.
	public StackedBarChart(String title, String[] bezeichnungenXAchse,
			String[] bezeichnungenYAchse, double[][] werteErstYDannX) {
		super(title);
		this.setBackground(Color.RED);
		this.bezeichnungenXAchse = bezeichnungenXAchse;
		this.setIconImage(Toolkit.getDefaultToolkit().getImage(
				Hauptseite.class.getResource("/gui/images/LogoFinal.png")));

		// Hier wird das Balkendiagramm erstellt.
		final CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
				bezeichnungenXAchse, bezeichnungenYAchse, werteErstYDannX);
		final JFreeChart chart = createChart(dataset);
		final ChartPanel chartPanel = new ChartPanel(chart);
		JScrollPane scroll = new JScrollPane(chartPanel);
		this.getContentPane().add(scroll);
	}

	// Erstellt den JFreeChart und gibt diesen zurück.
	private JFreeChart createChart(final CategoryDataset dataset) {
		final JFreeChart chart = ChartFactory.createStackedBarChart(
				"Balkendiagramm", "Gruppen", "Anzahl", dataset,
				PlotOrientation.HORIZONTAL, true, true, false);

		chart.setBackgroundPaint(new Color(255, 250, 240));

		// Den CategoryPlot benötigt man zum anpassen der Farben und
		// Eigenschaften des Charts.
		CategoryPlot plot = chart.getCategoryPlot();

		// Die CustomRenderer Klasse wählt nun die Farbe
		CategoryItemRenderer renderer = new CustomRenderer(
				bezeichnungenXAchse.length);
		plot.setRenderer(renderer);

		return chart;

	}

}

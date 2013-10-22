package statistik;

import org.jfree.chart.renderer.category.BarRenderer;
import java.awt.Color;
import java.awt.Paint;

class CustomRenderer extends BarRenderer {
	private Paint[] colors;

	public CustomRenderer() {
		this.colors = new Paint[] { Color.orange, Color.cyan, Color.black};
		
		setSeriesPaint(0, Color.orange);
		setSeriesPaint(1, Color.cyan);
	}

	public Paint getItemPaint(final int row, final int column) {
		// Edit: Anfangs Column statt Row. Da war allerdings nur nach den
		// Gruppen die Farbe differenziert.
		return (this.colors[row % this.colors.length]);
	}
}
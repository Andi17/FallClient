package statistik;

public class ChartObject {

	private double[] arbeitsgruppe1;
	private double arbeitsgruppe2;
	private double arbeitsgruppe3;
	private String bezeichnung;

	public ChartObject(double[] bla, String t) {
		this.arbeitsgruppe1 = bla;
		this.bezeichnung = t;
	}

	public double[] getArray() {
		return arbeitsgruppe1;
	}

	public void setWerte(double werte[]) {
		this.arbeitsgruppe1 = werte;
	}

	public double getWriteTime() {
		return arbeitsgruppe2;
	}

	public void setWriteTime(double writeTime) {
		this.arbeitsgruppe2 = writeTime;
	}

	public String getTimeDetails() {
		return bezeichnung;
	}

	public void setTimeDetails(String timeDetails) {
		this.bezeichnung = timeDetails;
	}

	public double getArbeitsgruppe3() {
		return arbeitsgruppe3;
	}

	public void setArbeitsgruppe3(double arbeitsgruppe3) {
		this.arbeitsgruppe3 = arbeitsgruppe3;
	}
}
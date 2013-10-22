package tools;

public class SonderzeichenTest {

	//Test ob Sonderzeichen innerhalb eines Strings existieren:
	public boolean test(String s)
	{
		//TRUE : Sonderzeichen sind vorhanden.
		if(s.contains("°")
		|| s.contains("^")
		|| s.contains("!")
		|| s.contains("\"")
		|| s.contains("²")
		|| s.contains("§")
		|| s.contains("³")
		|| s.contains("$")
		|| s.contains("%")
		|| s.contains("&")
		|| s.contains("/")
		|| s.contains("{")
		|| s.contains("(")
		|| s.contains("{")
		|| s.contains("[")
		|| s.contains(")")
		|| s.contains("]")
		|| s.contains("=")
		|| s.contains("}")
		|| s.contains("?")
		|| s.contains("\\")
		|| s.contains("´")
		|| s.contains("`")
		|| s.contains("*")
		|| s.contains("+")
		|| s.contains("~")
		|| s.contains("#")
		|| s.contains("'")
		|| s.contains(">")
		|| s.contains("<")
		|| s.contains("|")
		|| s.contains(",")
		|| s.contains(";")
		|| s.contains(".")
		|| s.contains(":")
		|| s.contains("-")
		|| s.contains("_")
		)
		{
			return true;
		}
		else
		{
			//FALSE: Sonderzeichen sind NICHT vorhanden.
			return false;
		}
	}
}

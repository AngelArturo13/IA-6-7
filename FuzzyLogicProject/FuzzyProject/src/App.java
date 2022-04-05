import net.sourceforge.jFuzzyLogic.*;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Variable;

public class App {
    private static FIS fis;
    // private static JDialogFis dialogoFIS;
    // private static JFuzzyChart chart;
    public static void main(String[] args) throws Exception {
        String file = "/home/arturo/Documents/FuzzyLogicProject/FuzzyProject/src/blackjack.fcl";
        fis =FIS.load(file,true);
        if (fis == null) { // Error while loading?
			System.err.println("Can't load file: '" + file + "'");
			return;
		}
    }
}

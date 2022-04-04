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


		// Show ruleset
		FunctionBlock functionBlock = fis.getFunctionBlock(null);
		JFuzzyChart.get().chart(functionBlock);

		// Set inputs
		functionBlock.setVariable("Hand", 17);
		functionBlock.setVariable("Dealer Hand", 7);

		// Evaluate 
		functionBlock.evaluate();

		// Show output variable's chart
		Variable action = functionBlock.getVariable("Action");
		JFuzzyChart.get().chart(action, action.getDefuzzifier(), true);
		Gpr.debug("poor[hand]: " + functionBlock.getVariable("hand").getMembership("poor"));

		// Print ruleSet
		System.out.println(functionBlock);
		System.out.println("action:" + functionBlock.getVariable("action").getValue());
	
    }
}

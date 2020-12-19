package charbosses;

import automaton.EasyInfoDisplayPanel;
import automaton.FunctionHelper;
import automaton.cards.AbstractBronzeCard;
import com.megacrit.cardcrawl.cards.AbstractCard;

public class BossMechanicDisplayPanel extends EasyInfoDisplayPanel {

    public static String mechanicName;
    public static String mechanicDesc = "NORENDER";

    private static int X = 1550;
    private static int Y = 570;
    private static int WIDTH = 275;

    public BossMechanicDisplayPanel() {
        super(X, Y, WIDTH);
    } // NOTE: X, Y, Width are all multipled by settings.scale on constructor, so use values like this.

    @Override
    public String getTitle() {
        return mechanicName;
    }

    @Override
    public String getDescription() {
        return mechanicDesc;
    }

    public static void resetBossPanel(){
        mechanicDesc = "NORENDER";
    }
}

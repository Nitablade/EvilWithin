package collector.cards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.actions.common.RemoveAllBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

import static collector.CollectorMod.makeID;
import static collector.util.Wiz.atb;

public class IllTakeThat extends AbstractCollectorCard {
    public final static String ID = makeID(IllTakeThat.class.getSimpleName());
    // intellij stuff attack, enemy, uncommon, 10, 3, , , , 

    public IllTakeThat() {
        super(ID, 1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);
        baseDamage = 10;
        baseMagicNumber = magicNumber = 10;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (m.currentBlock > 0) {
            int toSteal = Math.min(magicNumber, m.currentBlock);
            atb(new AbstractGameAction() {
                @Override
                public void update() {
                    isDone = true;
                    m.loseBlock(toSteal);
                }
            });
            atb(new GainBlockAction(p, toSteal));
        }
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }

    public void upp() {
        upgradeDamage(4);
        upgradeMagicNumber(4);
    }
}
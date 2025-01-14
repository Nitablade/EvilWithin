package collector.cards.collectibles;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.DexterityPower;
import com.megacrit.cardcrawl.powers.StrengthPower;

import static collector.CollectorMod.makeID;
import static collector.util.Wiz.applyToSelf;

public class DefaultCollectibleCard extends AbstractCollectibleCard {
    public final static String ID = makeID(DefaultCollectibleCard.class.getSimpleName());
    // intellij stuff power, self, uncommon, , , , , 1, 1

    public DefaultCollectibleCard() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new StrengthPower(p, magicNumber));
        applyToSelf(new DexterityPower(p, magicNumber));
    }

    public void upp() {
        upgradeMagicNumber(1);
    }
}
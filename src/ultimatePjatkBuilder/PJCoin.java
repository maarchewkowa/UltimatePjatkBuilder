package ultimatePjatkBuilder;

import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Locale;

public class PJCoin {
    private final BigInteger amount;

    public PJCoin(BigInteger value) {
        amount = value;
    }

    public PJCoin pow(int power) {
        return new PJCoin(amount.pow(power));
    }

    public static PJCoin valueOf(long value) {
        return new PJCoin(BigInteger.valueOf(value));
    }

    public PJCoin add(PJCoin value) {
        return new PJCoin(amount.add(value.amount));
    }

    public PJCoin subtract(PJCoin value) {
        return new PJCoin(amount.subtract(value.amount));
    }

    public int compareTo(PJCoin value) {
        return amount.compareTo(value.amount);
    }

    @Override
    public String toString() {
        return NumberFormat.getNumberInstance(Locale.forLanguageTag("PL")).format(amount) + "PJC";
    }
}
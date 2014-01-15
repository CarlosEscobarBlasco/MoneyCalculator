package prueba1mc.persistance;

import java.util.Date;
import prueba1mc.model.Currency;
import prueba1mc.model.ExchangeRate;

public interface ExchangeRateLoader {

    public ExchangeRate load(Date date, Currency from, Currency to);

    public ExchangeRate load(Currency from, Currency to);
}

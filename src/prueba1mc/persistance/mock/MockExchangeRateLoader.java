package prueba1mc.persistance.mock;

import java.util.Date;
import prueba1mc.model.Number;
import prueba1mc.model.Currency;
import prueba1mc.model.ExchangeRate;
import prueba1mc.persistance.ExchangeRateLoader;

public class MockExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        return new ExchangeRate(date, from, to, new Number(4, 9));
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return load(new Date(), from, to);
    }
}

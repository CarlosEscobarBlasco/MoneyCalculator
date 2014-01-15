package prueba1mc.ui.console;

import prueba1mc.model.Currency;
import prueba1mc.ui.CurrencyViewer;

public class ConsoleCurrencyViewer implements CurrencyViewer {

    @Override
    public void show(Currency currency) {
        System.out.println(currency.getSymbol());
    }
}

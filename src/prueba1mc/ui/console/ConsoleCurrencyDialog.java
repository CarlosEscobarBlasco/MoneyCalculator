package prueba1mc.ui.console;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.ui.CurrencyDialog;

public class ConsoleCurrencyDialog implements CurrencyDialog {

    private Currency currency;

    @Override
    public void execute() {
        currency = readCurrency();
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    private Currency readCurrency() {
        Currency[] currencies;
        while (true) {
            System.out.println("Introduce Divisa");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                currencies = CurrencySet.getInstance().search(reader.readLine());
                if (check(currencies)) {
                    currency = currencies[0];
                    return currency;
                }
            } catch (Exception e) {
            }

        }
    }

    private boolean check(Currency[] currencies) {
        while (true) {
            if (currencies.length > 1) {
                System.out.println("Hay varias opciones, selecciona una");
                for (int i = 0; i < currencies.length; i++) {
                    System.out.println(currencies[i].getName() + " " + currencies[i].getCode() + " " + currencies[i].getSymbol());
                }
                return false;
            } else if (currencies.length == 1) {
                return true;
            } else {
                System.out.println("Divisa Erronea");
                return false;
            }
        }
    }
}
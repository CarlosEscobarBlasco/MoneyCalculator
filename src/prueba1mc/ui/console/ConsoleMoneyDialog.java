package prueba1mc.ui.console;

import java.io.BufferedReader;
import prueba1mc.model.Number;
import java.io.InputStreamReader;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.model.Money;
import prueba1mc.ui.CurrencyDialog;
import prueba1mc.ui.MoneyDialog;

public class ConsoleMoneyDialog implements MoneyDialog {

    private Money money;

    @Override
    public Money getMoney() {
        return money;
    }

    @Override
    public void execute() {
        money = new Money(readAmount(), readCurrency());
    }

    private Number readAmount() {
        while (true) {
            System.out.println("Introduce una cantidad de dinero");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                return new Number(Integer.parseInt(reader.readLine()), 1);
            } catch (Exception e) {
                System.out.println("Cantidad de dinero no valida!");
            }
        }
    }

    private Currency readCurrency() {
        CurrencyDialog dialog = new ConsoleCurrencyDialog();
        dialog.execute();
        return dialog.getCurrency();
    }
}

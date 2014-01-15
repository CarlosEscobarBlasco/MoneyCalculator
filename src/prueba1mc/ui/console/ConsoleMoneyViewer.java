package prueba1mc.ui.console;

import prueba1mc.model.Money;
import prueba1mc.ui.MoneyViewer;

public class ConsoleMoneyViewer implements MoneyViewer {

    private Money money;

    @Override
    public void setMoney(Money money) {
        this.money = money;
        System.out.println(money);
    }
}

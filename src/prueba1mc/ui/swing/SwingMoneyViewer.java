package prueba1mc.ui.swing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import prueba1mc.model.Money;
import prueba1mc.ui.MoneyViewer;

public class SwingMoneyViewer extends JPanel implements MoneyViewer {

    private final JLabel resultado;
    private Money money;

    public SwingMoneyViewer() {
        this.setLayout(new FlowLayout());
        resultado = new JLabel("0");
    }

    public void show() {
        this.add(createLabel());
    }

    private JLabel createLabel() {
        resultado.setText(money == null ? "0" : money.toString());
        return resultado;
    }

    @Override
    public void setMoney(Money money) {
        this.money = money;
        this.show();
    }
}

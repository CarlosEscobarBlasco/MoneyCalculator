package prueba1mc.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import prueba1mc.model.Currency;
import prueba1mc.model.CurrencySet;
import prueba1mc.ui.CurrencyDialog;

public class SwingCurrencyDialog extends JPanel implements CurrencyDialog {

    private Currency currency;

    @Override
    public void execute() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createComboCurrency());
    }

    @Override
    public Currency getCurrency() {
        return currency;
    }

    private JComboBox createComboCurrency() {
        Object[] array = CurrencySet.getInstance().toArray();
        final JComboBox comboBox = new JComboBox(array);
        currency = CurrencySet.getInstance().search(array[0].toString())[0];
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String currencyName = comboBox.getSelectedItem().toString();
                currency = CurrencySet.getInstance().search(currencyName)[0];
            }
        });
        return comboBox;
    }
}

    /*private JPanel createDialogPanel(CurrencySet set) {
        JPanel panel = new JPanel();
        panel.add(createMoneyDialog(set));
        return panel;
    }

    public static JComboBox createMoneyDialog(final CurrencySet set) {
        Object[] array = new Object[set.toArray().length + 1];
        Object[] array2 = set.toArray();
        array[0] = "Seleccione una Divisa";
        for (int i = 1; i < array.length; i++) {
            array[i] = array2[i - 1];
        }
        final JComboBox combo = new JComboBox(array);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String currencyName = combo.getSelectedItem().toString();
                moneyCurrency = set.search(currencyName)[0];
            }
        });
        return combo;
    }

    public static JComboBox createCurrencyDialog(final CurrencySet set) {
        Object[] array = new Object[set.toArray().length + 1];
        Object[] array2 = set.toArray();
        array[0] = "Seleccione la Divisa Destino";
        for (int i = 1; i < array.length; i++) {
            array[i] = array2[i - 1];
        }
        final JComboBox combo = new JComboBox(array);
        combo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String currencyName = combo.getSelectedItem().toString();
                destinyCurrency = set.search(currencyName)[0];
            }
        });
        return combo;
    }

    @Override
    public void execute(CurrencySet set) {
        SwingMoneyDialog.getPanel().add(createCurrencyDialog(set));
    }

    @Override
    public Currency getCurrency() {
        return moneyCurrency;
    }

    public void executeMoneyPanel(CurrencySet set) {
        this.add(createDialogPanel(set));
    }

    private JPanel createPanel(CurrencySet set) {
        this.add(createMoneyDialog(set));
        return this;*/
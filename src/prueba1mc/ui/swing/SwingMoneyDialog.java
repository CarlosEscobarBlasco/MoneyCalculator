package prueba1mc.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import prueba1mc.model.Number;
import prueba1mc.model.Money;
import prueba1mc.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private Money money;
    private Number amount;
    private SwingCurrencyDialog currencyDialog = new SwingCurrencyDialog();

    @Override
    public void execute() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.add(createJTextField());
        this.add(createJLabel());
        this.add(createCurrencyDialog());
    }

    @Override
    public Money getMoney() {
        return new Money(amount, currencyDialog.getCurrency());
    }

    private JTextField createJTextField() {
        final JTextField field = new JTextField(10);
        amount = new Number(0, 1);
        field.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = new Number(Double.parseDouble(field.getText()), 1);
            }
        });
        return field;
    }

    private JLabel createJLabel() {
        JLabel label = new JLabel("From: ");
        return label;
    }

    private JPanel createCurrencyDialog() {
        currencyDialog = new SwingCurrencyDialog();
        currencyDialog.execute();
        return currencyDialog;
    }
}

    /*@Override
    public void execute(CurrencySet set) {
        createComponents(set);
    }

    @Override
    public Money getMoney() {
        return money;
    }

    private void createComponents(CurrencySet set) {
        this.add(createButtonsPanel(), BorderLayout.SOUTH);
        this.add(createDialogPanel(set));
    }

    private JPanel createButtonsPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(createCalculateButton());
        buttonPanel.add(createExitButton());
        return buttonPanel;
    }

    private JButton createCalculateButton() {
        final JButton button = new JButton();
        button.setText("Calculate");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("Calculando...");
                amount = new Number(Integer.parseInt(textField.getText()), 1);
                currency = currencyDialog.getCurrency();
                money = new Money(amount, currency);
                System.out.println(money);
            }
        });
        return button;
    }

    private JButton createExitButton() {
        final JButton button = new JButton("Exit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        return button;
    }

    private JPanel createDialogPanel(CurrencySet set) {
        panel.add(createAmountDialog());
        panel.add(SwingCurrencyDialog.createMoneyDialog(set));
        return panel;
    }

    private JTextField createAmountDialog() {
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                amount = new Number(Integer.parseInt(textField.getText()), 1);
            }
        });
        return textField;
    }

    private SwingCurrencyDialog createMoneyDialog(CurrencySet set) {
        currencyDialog.executeMoneyPanel(set);
        return currencyDialog;
    }*/
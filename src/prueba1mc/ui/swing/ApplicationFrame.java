package prueba1mc.ui.swing;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import prueba1mc.model.Currency;
import prueba1mc.model.Money;
import prueba1mc.ui.DateDialog;

public class ApplicationFrame extends JFrame {

    private final ActionListenerFactory actionListenerFactory;
    private SwingCurrencyDialog currencyDialog;
    private SwingMoneyViewer moneyViewer;
    private SwingMoneyDialog moneyDialog;
    private DateDialog dateDialog;
    private Money money;
    private Currency currency;
    private Date date;

    public Money getMoney() {
        return money;
    }

    public Currency getCurrency() {
        return currency;
    }

    public Date getDate() {
        return date;
    }

    public SwingCurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public SwingMoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public DateDialog getDateDialog() {
        return dateDialog;
    }

    public SwingMoneyViewer getMoneyViewer() {
        return moneyViewer;
    }

    public ApplicationFrame(ActionListenerFactory actionListenerFactory) {
        this.actionListenerFactory = actionListenerFactory;
        this.setTitle("Money Calculator");
        this.createComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createComponents() {
        this.add(createPanel(), BorderLayout.NORTH);
        this.add(createDatePanel(), BorderLayout.CENTER);
        this.add(createButtonsPanel(), BorderLayout.SOUTH);
        this.add(createResultPanel(), BorderLayout.EAST);
    }

    private JPanel createPanel() {
        JPanel panel = new JPanel();
        panel.add(createMoneyPanel(), BorderLayout.WEST);
        panel.add(createJLabel());
        panel.add(createCurrencyPanel(), BorderLayout.EAST);
        return panel;
    }

    private JPanel createMoneyPanel() {
        moneyDialog = new SwingMoneyDialog();
        moneyDialog.execute();
        return moneyDialog;
    }

    private JPanel createCurrencyPanel() {
        currencyDialog = new SwingCurrencyDialog();
        currencyDialog.execute();
        return currencyDialog;
    }

    private JLabel createJLabel() {
        JLabel label = new JLabel("To:");
        return label;
    }

    private JPanel createButtonsPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(actionListenerFactory.create("calculate"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(actionListenerFactory.create("exit"));
        return button;
    }

    private JPanel createDatePanel() {
        dateDialog = new DateDialog();
        return dateDialog.execute();
    }

    private JPanel createResultPanel() {
        SwingMoneyViewer panel = new SwingMoneyViewer();
        panel.add(new JLabel("Result: "));
        moneyViewer = panel;
        moneyViewer.show();
        return moneyViewer;
    }
}
package prueba1mc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import prueba1mc.control.CalculateCommand;
import prueba1mc.control.Command;
import prueba1mc.persistance.CurrencySetLoader;
import prueba1mc.persistance.mock.MockCurrencySetLoader;
import prueba1mc.persistance.mock.MockExchangeRateLoader;
import prueba1mc.ui.swing.ActionListenerFactory;
import prueba1mc.ui.swing.ApplicationFrame;

public class Application {
    
    
//    public static void main(String[] args) {
////        FileExchangeRateLoader loader = new FileExchangeRateLoader();
////        loader.load(new Date(3800, 2, 2), new Currency("Dolar Americano","Eur","$"), new Currency("Eur","Efur","$e"));
//        //loader.readFile();
//    }
   
    private Map<String, Command> commands;

    public static void main(String[] args) {
        new Application().execute();
    }

    private void execute() {
        loadCurrencySet();
        createCommands(createFrame());
    }

    private ApplicationFrame createFrame() {
        ApplicationFrame frame = new ApplicationFrame(createActionListenerFactory());
        return frame;
    }

    private ActionListenerFactory createActionListenerFactory() {
        return new ActionListenerFactory() {
            @Override
            public ActionListener create(final String name) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        commands.get(name).execute();
                    }
                };
            }
        };
    }

    private void createCommands(ApplicationFrame frame) {
        commands = new HashMap<>();
        commands.put("calculate", new CalculateCommand(new MockExchangeRateLoader(), frame.getMoneyDialog(), frame.getCurrencyDialog(), frame.getDateDialog(), frame.getMoneyViewer()));
        commands.put("exit", new Command() {
            @Override
            public void execute() {
                System.exit(0);
            }
        });
    }

    private void loadCurrencySet() {
        CurrencySetLoader loader = new MockCurrencySetLoader();
        loader.load();
    }
}

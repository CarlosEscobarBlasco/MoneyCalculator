package prueba1mc.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DateDialog extends JPanel {

    private String day;
    private String month;
    private String year;
    private Date date;

    public Date getDate() {
        date = new Date(Integer.parseInt(year) - 1900, Integer.parseInt(month) - 1, Integer.parseInt(day));
        return date;
    }

    public JPanel execute() {
        JPanel panel = new JPanel();
        panel.add(createLabel());
        panel.add(createDayBox());
        panel.add(createMonthBox());
        panel.add(createYearBox());
        return panel;
    }

    private JComboBox createYearBox() {
        String[] years = new String[new Date().getYear() + 1];
        for (int i = new Date().getYear()+1900; i >= 1900 ; i--) {
            years[-1*(i-1900-114)] = Integer.toString(i);
        }
        final JComboBox box = new JComboBox(years);
        year = years[0];
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                year = box.getSelectedItem().toString();
            }
        });
        return box;
    }

    private JComboBox createMonthBox() {
        String[] months = new String[12];
        for (int i = 1; i <= 12; i++) {
            months[i - 1] = Integer.toString(i);
        }
        final JComboBox box = new JComboBox(months);
        month = months[0];
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                month = box.getSelectedItem().toString();
            }
        });
        return box;
    }

    private JComboBox createDayBox() {
        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) {
            days[i - 1] = Integer.toString(i);
        }
        final JComboBox box = new JComboBox(days);
        day = days[0];
        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                day = box.getSelectedItem().toString();
            }
        });
        return box;
    }

    private JLabel createLabel() {
        JLabel label = new JLabel("Date: ");
        return label;
    }
}

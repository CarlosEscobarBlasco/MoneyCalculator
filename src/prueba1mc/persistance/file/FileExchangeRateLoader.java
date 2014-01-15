package prueba1mc.persistance.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import prueba1mc.model.Currency;
import prueba1mc.model.ExchangeRate;
import prueba1mc.persistance.ExchangeRateLoader;

public class FileExchangeRateLoader implements ExchangeRateLoader {

    @Override
    public ExchangeRate load(Date date, Currency from, Currency to) {
        String token = date.getDay() +""+ date.getMonth() +""+ (date.getYear()-1900) + from.getName() + to.getName() + "";
        System.out.println(token);
        return null;
    }

    @Override
    public ExchangeRate load(Currency from, Currency to) {
        return load(new Date(), from, to);
    }

    public void readFile(String token) {
        File archivo = new File("C:\\Users\\Carlos\\Desktop\\prueba.txt");
        FileReader fr = null;
        try {
            fr = new FileReader(archivo);
        } catch (FileNotFoundException ex) {
        }
        BufferedReader br = new BufferedReader(fr);
        String linea = null;
        try {
            while ((linea = br.readLine()) != null) {
                //quitar espacios
                //quitar
                System.out.println(linea);
            }
        } catch (IOException ex) {
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException ex) {
            }
        }
    }
}

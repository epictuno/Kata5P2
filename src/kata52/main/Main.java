package kata52.main;

import kata52.view.HistogramDisplay;
import kata52.model.Histogram;
import java.util.List;
import kata52.model.Mail;
import kata52.view.MailHistogramBuilder;
import kata52.view.MailListReaderBD;

/**
 *
 * @author tanay
 */
public class Main {
    static List<Mail> ListaMail;
    static Histogram builder;
    static HistogramDisplay histoDisplay;
    public static void main(String[] args) {
        ListaMail=new MailListReaderBD().read("Kata5.db","direcc_email","direccion");
        builder=new MailHistogramBuilder().build(ListaMail);
        histoDisplay=new HistogramDisplay("Histogram...",builder);
        histoDisplay.execute();
        }
    }

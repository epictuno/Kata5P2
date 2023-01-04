/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kata52.view;

import java.util.List;
import kata52.model.Histogram;
import kata52.model.Mail;

/**
 *
 * @author tanay
 */
public class MailHistogramBuilder {
    public Histogram<String> build(List<Mail> ListaMail){
        Histogram<String> histogram= new Histogram<>();
        for (Mail mail: ListaMail) {
            histogram.increment(mail.getDomain());
        }
        return histogram;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;
import java.io.FileNotFoundException;
import kata5.view.HistogramDisplay;
import kata5.view.MailBuilder;
import kata5.model.Histogram;
import kata5.model.Mail;
import java.sql.*;
import java.util.List;
/**
 *
 * @author gabri
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException {
        String fileName= new String("email.txt");
        List<Mail>mailList=MailListReader.read(fileName);
        Histogram<String>mailHistogram=MailBuilder.build(mailList);
        
        HistogramDisplay histogramDisplay = new HistogramDisplay("HISTOGRAM", mailHistogram);
        histogramDisplay.execute();
        
        
    }
    
}

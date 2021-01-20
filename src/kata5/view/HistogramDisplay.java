/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5.view;

import java.awt.Container;
import kata5.model.Histogram;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author gabri
 */
public class HistogramDisplay extends ApplicationFrame{

    private final Histogram<String> mailHistogram;
    
    public HistogramDisplay(String title, Histogram<String> mailHistogram) {
        super(title);
        this.mailHistogram=mailHistogram;
        this.setContentPane(createPanel());
        this.pack();
    }

    public void execute() {
        setVisible(true);
    }

    private Container createPanel() {
    ChartPanel chartPanel = new ChartPanel(createChart(createDataSet()));
    return chartPanel;
    }
    

    private JFreeChart createChart(DefaultCategoryDataset createDataSet) {
        JFreeChart chart = ChartFactory.createBarChart("JFree Chart Histogram",
                                                        "email domains",
                                                        "nº emails",
                                                        createDataSet,
                                                        PlotOrientation.VERTICAL,
                                                        false,
                                                        false,
                                                        rootPaneCheckingEnabled);
         
        return chart;    
    }
    
    private DefaultCategoryDataset createDataSet(){
        DefaultCategoryDataset dataSet= new DefaultCategoryDataset();
        int cuenta=0;
        for (String key : mailHistogram.keySet()){
            if(mailHistogram.get(key)>1){
                dataSet.addValue(mailHistogram.get(key),"",key);
            }else{
                cuenta++;
            }
            dataSet.addValue(cuenta, "", "others");
        }
        
        return dataSet;
    }
    
}

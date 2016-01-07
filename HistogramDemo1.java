// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 



import java.awt.Dimension;
import java.io.IOException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.statistics.HistogramDataset;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class HistogramDemo1 extends JFrame
{
	public static ListOfItems Ln;
	public static float[] Lf;
	public static int n  ;
        public HistogramDemo1(String s,ListOfItems L)
        {
                super(s);
                Ln=L ;
                JPanel jpanel = createDemoPanel();
                jpanel.setPreferredSize(new Dimension(500, 270));
                setDefaultCloseOperation(ApplicationFrame.HIDE_ON_CLOSE);
                setContentPane(jpanel);
                
        }
        public HistogramDemo1(String s,float[] L,int N)
        {
                super(s);
                Lf=L ;
                n=N;
                JPanel jpanel = createDemoPanel(L);
                jpanel.setPreferredSize(new Dimension(500, 270));
                setDefaultCloseOperation(ApplicationFrame.HIDE_ON_CLOSE);

                setContentPane(jpanel);
        }
        private static IntervalXYDataset createDataset()
        {
        	 HistogramDataset histogramdataset = new HistogramDataset();
             double ad[] =new double[Ln.getContent().size()];
             
             for (int j = 0; j < Ln.getContent().size(); j++){
                     ad[j] = Ln.getContent().get(j).getLargeur();
                     System.out.println( ad[j]) ;
             }
             histogramdataset.addSeries("Histogramme du largeur", ad, 50, 0, 1);
             return histogramdataset;
        }
        private static IntervalXYDataset createDataset(float[] L)
        {
        	 HistogramDataset histogramdataset = new HistogramDataset();
             double ad[] =new double[Lf.length];
             
             for (int j = 0; j < Lf.length; j++){
                     ad[j] =(double) Lf[j];
                     System.out.println( ad[j]) ;
             }
             histogramdataset.addSeries("histogramme des réalisations de NFL(Ln)",ad, 50, 0, n);
             return histogramdataset;
        }

        private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
        {
                JFreeChart jfreechart = ChartFactory.createHistogram("Histogramme ", "", "", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
                XYPlot xyplot = (XYPlot)jfreechart.getPlot();
                xyplot.setForegroundAlpha(0.85F);
                XYBarRenderer xybarrenderer = (XYBarRenderer)xyplot.getRenderer();
                xybarrenderer.setDrawBarOutline(false);
                return jfreechart;
        }

        public static JPanel createDemoPanel()
        {
                JFreeChart jfreechart = createChart(createDataset());
                return new ChartPanel(jfreechart);
        }
        public static JPanel createDemoPanel(float[] L)
        {
                JFreeChart jfreechart = createChart(createDataset(L));
                return new ChartPanel(jfreechart);
        }

        
}
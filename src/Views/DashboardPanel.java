/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicScrollBarUI;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author juan
 */
public class DashboardPanel extends JPanel {

    public DashboardPanel() {
        initComponents();
        this.containerInfo.setVisible(false);

        //loadselectors
        //LoadSelections();
    }

    private void initComponents() {
        Title = new JLabel("Dashboard");
        Title.setForeground(new Color(111, 207, 151));
        Title.setFont(new Font("Arial", Font.BOLD, 32));
        Title.setBorder(BorderFactory.createEmptyBorder(20, 50, 0, 0));

        Background = new JLabel();
        Image backgrounLogo = new ImageIcon(getClass().getResource("/images/Background1.png"))
                .getImage()
                .getScaledInstance(1240, 800, Image.SCALE_SMOOTH);
        Background.setIcon(new ImageIcon(backgrounLogo));
        Background.setBorder(null);
        Background.setBounds(0, 0, 1240, 800);

        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout(0, 0));
        contentPanel.setBounds(0, 0, 1240, 760);
        contentPanel.setOpaque(false);

        container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.PAGE_AXIS));
        container.setOpaque(false);

        //container for total
        containerTotal = new JPanel();
        containerTotal.setLayout(new BoxLayout(containerTotal, BoxLayout.LINE_AXIS));
        containerTotal.setAlignmentX(0.5f);
        containerTotal.setAlignmentY(0.5f);
        containerTotal.setBackground(new Color(242, 242, 242));
        containerTotal.setSize(new Dimension(900, 100));
        containerTotal.setMinimumSize(new Dimension(900, 100));
        containerTotal.setMaximumSize(new Dimension(900, 100));

        JLabel label1 = new JLabel("COUNT POINTS");
        label1.setFont(new Font("Arial", Font.BOLD, 16));
        label1.setForeground(Color.black);
        label1.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label1.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label2 = new JLabel("TWO WHEELS");
        label2.setFont(new Font("Arial", Font.BOLD, 16));
        label2.setForeground(Color.black);
        label2.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label2.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label3 = new JLabel("FOUR WHEELS");
        label3.setFont(new Font("Arial", Font.BOLD, 16));
        label3.setForeground(Color.black);
        label3.setBorder(BorderFactory.createEmptyBorder(15, 0, 0, 0));
        label3.setHorizontalAlignment(SwingConstants.CENTER);

        countLabel = new JLabel();
        countLabel.setFont(new Font("Arial", Font.BOLD, 30));
        countLabel.setForeground(new Color(111, 207, 151));
        countLabel.setHorizontalAlignment(SwingConstants.CENTER);
        countLabel.setText("0");

        twoLabel = new JLabel();
        twoLabel.setFont(new Font("Arial", Font.BOLD, 30));
        twoLabel.setForeground(new Color(111, 207, 151));
        twoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        twoLabel.setText("0");

        fourLabel = new JLabel();
        fourLabel.setFont(new Font("Arial", Font.BOLD, 30));
        fourLabel.setForeground(new Color(111, 207, 151));
        fourLabel.setHorizontalAlignment(SwingConstants.CENTER);
        fourLabel.setText("0");

        //container1
        JPanel container1 = new JPanel(new BorderLayout(0, 0));
        container1.add(label1, BorderLayout.NORTH);
        container1.add(countLabel, BorderLayout.CENTER);
        container1.setOpaque(false);

        //container2
        JPanel container2 = new JPanel(new BorderLayout(0, 0));
        container2.add(label2, BorderLayout.NORTH);
        container2.add(twoLabel, BorderLayout.CENTER);
        container2.setOpaque(false);

        //container3
        JPanel container3 = new JPanel(new BorderLayout(0, 0));
        container3.add(label3, BorderLayout.NORTH);
        container3.add(fourLabel, BorderLayout.CENTER);
        container3.setOpaque(false);

        containerTotal.add(container1);
        containerTotal.add(container2);
        containerTotal.add(container3);

        //container Selectors
        containerSelectors = new JPanel();
        containerSelectors.setLayout(new BoxLayout(containerSelectors, BoxLayout.LINE_AXIS));
        containerSelectors.setSize(new Dimension(900, 40));
        containerSelectors.setMinimumSize(new Dimension(900, 40));
        containerSelectors.setMaximumSize(new Dimension(900, 40));
        containerSelectors.setOpaque(false);

        Object[] list = new Object[]{"Road name"};
        countPointBox = new JComboBox();
        countPointBox.setModel(new DefaultComboBoxModel(list));
        countPointBox.setBorder(null);
        countPointBox.setFont(new Font("Arial", Font.PLAIN, 16));
        countPointBox.setSize(new Dimension(450, 40));
        countPointBox.setPreferredSize(new Dimension(450, 40));
        countPointBox.setMinimumSize(new Dimension(450, 40));
        countPointBox.setMaximumSize(new Dimension(450, 40));

        countPointBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSelect(e);
            }
        });

        Object[] list1 = new Object[]{"Year"};
        yearBox = new JComboBox();
        yearBox.setModel(new DefaultComboBoxModel(list1));
        yearBox.setBorder(null);
        yearBox.setFont(new Font("Arial", Font.PLAIN, 16));
        yearBox.setSize(new Dimension(100, 40));
        yearBox.setMinimumSize(new Dimension(100, 40));
        yearBox.setPreferredSize(new Dimension(100, 40));
        yearBox.setMaximumSize(new Dimension(100, 40));

        yearBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onSelect(e);
            }
        });

        containerSelectors.add(countPointBox);
        containerSelectors.add(Box.createHorizontalGlue());
        containerSelectors.add(yearBox);

        //container information and charts
        containerInfo = new JPanel();
        containerInfo.setLayout(new BoxLayout(containerInfo, BoxLayout.PAGE_AXIS));
        containerInfo.setOpaque(false);

        //container count details.
        containerDetails = new JPanel();
        containerDetails.setLayout(new BoxLayout(containerDetails, BoxLayout.LINE_AXIS));
        containerDetails.setSize(new Dimension(850, 150));
        containerDetails.setMinimumSize(new Dimension(850, 150));
        containerDetails.setMaximumSize(new Dimension(850, 150));
        containerDetails.setBackground(new Color(242, 242, 242));
        containerDetails.setAlignmentX(0.5f);
        containerDetails.setAlignmentY(0.5f);

        JPanel boxPanel1 = new JPanel();
        boxPanel1.setLayout(new BorderLayout(0, 0));
        boxPanel1.setOpaque(false);

        JPanel boxLabels = new JPanel();
        boxLabels.setLayout(new GridLayout(0, 2));
        boxLabels.setOpaque(false);
        boxLabels.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        //tags
        JLabel SiteTag = new JLabel("SITE:", SwingConstants.LEFT);
        SiteTag.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel NameTag = new JLabel("ROAD NAME:", SwingConstants.LEFT);
        NameTag.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel TypeTag = new JLabel("ROAD TYPE:", SwingConstants.LEFT);
        TypeTag.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel LatTag = new JLabel("LATITUDE:", SwingConstants.LEFT);
        LatTag.setFont(new Font("Arial", Font.BOLD, 14));

        JLabel LongTag = new JLabel("SITE:", SwingConstants.LEFT);
        LongTag.setFont(new Font("Arial", Font.BOLD, 14));

        //labels to be modified;
        SiteLabel = new JLabel();
        SiteLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        SiteLabel.setText("Site");

        NameLabel = new JLabel();
        NameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        NameLabel.setText("Road name");

        TypeLabel = new JLabel();
        TypeLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        TypeLabel.setText("Road type");

        LatLabel = new JLabel();
        LatLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        LatLabel.setText("-12.12324");

        LongLabel = new JLabel();
        LongLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        LongLabel.setText("123.12332");

        boxLabels.add(SiteTag);
        boxLabels.add(SiteLabel);
        boxLabels.add(NameTag);
        boxLabels.add(NameLabel);
        boxLabels.add(TypeTag);
        boxLabels.add(TypeLabel);
        boxLabels.add(LatTag);
        boxLabels.add(LatLabel);
        boxLabels.add(LongTag);
        boxLabels.add(LongLabel);

        boxPanel1.add(boxLabels);

        JPanel boxPanel2 = new JPanel();
        boxPanel2.setLayout(new BorderLayout(0, 0));
        boxPanel2.setOpaque(false);

        JLabel mapLabel = new JLabel("", SwingConstants.CENTER);
        Image img = new ImageIcon(getClass()
                .getResource("/images/Map.png"))
                .getImage()
                .getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        mapLabel.setIcon(new ImageIcon(img));

        boxPanel2.add(mapLabel);

        containerDetails.add(boxPanel1);
        containerDetails.add(boxPanel2);

        //create Titles;
        Image dot = new ImageIcon(getClass()
                .getResource("/images/Dot.png"))
                .getImage()
                .getScaledInstance(16, 16, Image.SCALE_SMOOTH);

        JLabel Title1 = new JLabel("Number vehicles by type.");
        Title1.setFont(new Font("Arial", Font.BOLD, 14));
        Title1.setIcon(new ImageIcon(dot));
        Title1.setSize(new Dimension(850, 20));
        Title1.setMinimumSize(new Dimension(850, 20));
        Title1.setMaximumSize(new Dimension(850, 20));
        Title1.setAlignmentX(0.5f);

        JLabel Title2 = new JLabel("Annual traffic by vehicle type by direction of Travel.");
        Title2.setFont(new Font("Arial", Font.BOLD, 14));
        Title2.setIcon(new ImageIcon(dot));
        Title2.setSize(new Dimension(850, 20));
        Title2.setMinimumSize(new Dimension(850, 20));
        Title2.setMaximumSize(new Dimension(850, 20));
        Title2.setAlignmentX(0.5f);

        JLabel Title3 = new JLabel("Annual traffic by vehicle type by time interval.");
        Title3.setFont(new Font("Arial", Font.BOLD, 14));
        Title3.setIcon(new ImageIcon(dot));
        Title3.setSize(new Dimension(850, 20));
        Title3.setMinimumSize(new Dimension(850, 20));
        Title3.setMaximumSize(new Dimension(850, 20));
        Title3.setAlignmentX(0.5f);

        //chart Ui;
        barChart = createBarPanel();
        directionBar = createBarDirection();
        lineChart = createLineChart();

        ChartPanel chartPanel1 = new ChartPanel(barChart);
        chartPanel1.setSize(new Dimension(800, 500));
        chartPanel1.setMinimumSize(new Dimension(800, 500));
        chartPanel1.setMaximumSize(new Dimension(800, 500));

        ChartPanel chartPanel2 = new ChartPanel(directionBar);
        chartPanel2.setSize(new Dimension(800, 500));
        chartPanel2.setMinimumSize(new Dimension(800, 500));
        chartPanel2.setMaximumSize(new Dimension(800, 500));

        ChartPanel chartPanel3 = new ChartPanel(lineChart);
        chartPanel3.setSize(new Dimension(800, 500));
        chartPanel3.setMinimumSize(new Dimension(800, 500));
        chartPanel3.setMaximumSize(new Dimension(800, 500));

        containerInfo.add(containerDetails);
        containerInfo.add(Box.createVerticalStrut(20));
        containerInfo.add(Title1);
        containerInfo.add(Box.createVerticalStrut(10));
        containerInfo.add(chartPanel1);
        containerInfo.add(Box.createVerticalStrut(20));
        containerInfo.add(Title2);
        containerInfo.add(Box.createVerticalStrut(10));
        containerInfo.add(chartPanel2);
        containerInfo.add(Box.createVerticalStrut(20));
        containerInfo.add(Title3);
        containerInfo.add(Box.createVerticalStrut(10));
        containerInfo.add(chartPanel3);
        containerInfo.add(Box.createVerticalStrut(30));

        scrollPanel = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setSize(new Dimension(1000, 300));
        scrollPanel.setMaximumSize(new Dimension(1000, 300));
        scrollPanel.setMinimumSize(new Dimension(1000, 300));
        scrollPanel.setAlignmentX(0.5f);
        scrollPanel.setAlignmentY(0.5f);
        scrollPanel.setOpaque(false);
        scrollPanel.setViewportView(containerInfo);
        scrollPanel.setBorder(null);
        scrollPanel.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.trackColor = Color.white;
                this.thumbColor = new Color(111, 207, 151);
            }
        });
        scrollPanel.getVerticalScrollBar().setOpaque(false);

        container.add(Box.createVerticalStrut(50));
        container.add(containerTotal);
        container.add(Box.createVerticalStrut(30));
        container.add(containerSelectors);
        container.add(Box.createVerticalStrut(15));
        container.add(scrollPanel);

        contentPanel.add(Title, BorderLayout.NORTH);
        contentPanel.add(container, BorderLayout.CENTER);
        add(contentPanel);
        add(Background);

        setLayout(null);
    }

    private void onSelect(ActionEvent e) {

        String countPoint = (String) this.countPointBox.getSelectedItem();
        String year = (String) this.yearBox.getSelectedItem();

        System.out.println("countPoint: " + countPoint);
        System.out.println("Year:" + year);

        //Hide the cointainer
        this.containerInfo.setVisible(false);

        //run
        // LoadCountDetails(countPoint);
        //LoadCountbyType (countPoint, year);
        // LoadCountbyDirection(countPoint, year); 
        // LoadCountByIntervals(countPoint, year);
        // show contaienr
        this.containerInfo.setVisible(true);
    }

    private JFreeChart createBarPanel() {
        String x = "Count";
        String y = "Vehicles";

        //create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0.5, "Pedal Cycles", "");
        dataset.addValue(1, "Car & Taxis", "");

        dataset.addValue(1, "Bus & Couches", "");
        dataset.addValue(2, "LGV", "");

        //create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                y,
                x,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());

        //setColorBars
        renderer.setSeriesPaint(0, new Color(242, 153, 74));
        renderer.setSeriesPaint(1, new Color(39, 174, 96));
        renderer.setSeriesPaint(2, new Color(242, 201, 76));
        renderer.setSeriesPaint(3, new Color(45, 156, 219));

        //242,201,76
        //setbackground
        plot.setBackgroundPaint(Color.WHITE);
        return chart;

    }

    private JFreeChart createBarDirection() {
        String x = "Count";
        String y = "Direction";

        //create dataset
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(0.5, "North", "");
        dataset.addValue(1, "South", "");

        dataset.addValue(1, "East", "");
        dataset.addValue(2, "West", "");

        //create chart
        JFreeChart chart = ChartFactory.createBarChart(
                "",
                y,
                x,
                dataset,
                PlotOrientation.VERTICAL,
                true, true, false);

        CategoryPlot plot = chart.getCategoryPlot();
        BarRenderer renderer = (BarRenderer) plot.getRenderer();
        renderer.setBarPainter(new StandardBarPainter());

        //setColorBars
        renderer.setSeriesPaint(0, new Color(242, 153, 74));
        renderer.setSeriesPaint(1, new Color(39, 174, 96));
        renderer.setSeriesPaint(2, new Color(242, 201, 76));
        renderer.setSeriesPaint(3, new Color(45, 156, 219));

        //242,201,76
        //setbackground
        plot.setBackgroundPaint(Color.WHITE);
        return chart;

    }

    private JFreeChart createLineChart() {

        String x = "Time interval";
        String y = "Count";

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.addValue(1, "Pedal Cycles", "7");
        dataset.addValue(15, "Pedal Cycles", "8");
        dataset.addValue(3, "Pedal Cycles", "9");
        dataset.addValue(5, "Pedal Cycles", "10");

        dataset.addValue(1, "Car & Taxis", "7");
        dataset.addValue(2, "Car & Taxis", "8");
        dataset.addValue(3, "Car & Taxis", "9");
        dataset.addValue(1, "Car & Taxis", "10");

        dataset.addValue(4, "Bus & Couches", "7");
        dataset.addValue(3, "Bus & Couches", "8");
        dataset.addValue(8, "Bus & Couches", "9");
        dataset.addValue(14, "Bus & Couches", "10");

        dataset.addValue(4, "LGV", "7");
        dataset.addValue(7, "LGV", "8");
        dataset.addValue(1, "LGV", "9");
        dataset.addValue(9, "LGV", "10");

        JFreeChart chart = ChartFactory.createLineChart(
                "",
                x,
                y,
                dataset);

        CategoryPlot plot = chart.getCategoryPlot();
        LineAndShapeRenderer renderer = new LineAndShapeRenderer(true, true);
        renderer.setSeriesShapesVisible(0, true);
        plot.setRenderer(renderer);

        //setColorLine
        renderer.setSeriesPaint(0, new Color(242, 153, 74));
        renderer.setSeriesPaint(1, new Color(39, 174, 96));
        renderer.setSeriesPaint(2, new Color(242, 201, 76));
        renderer.setSeriesPaint(3, new Color(45, 156, 219));

        //setStroke
        renderer.setSeriesStroke(0, new BasicStroke(3.0f));
        renderer.setSeriesStroke(1, new BasicStroke(3.0f));
        renderer.setSeriesStroke(2, new BasicStroke(3.0f));
        renderer.setSeriesStroke(3, new BasicStroke(3.0f));

        //set background
        plot.setBackgroundPaint(Color.WHITE);

        return chart;

    }

    //load  totalCounts
    private void loadCounts() {
        //attributes
        Integer totalCountPoints = 0;
        Integer totalTwoWheels = 0;
        Integer totalFourWheels = 0;

        /*
        run query database : retrieve 
        total COUNT POINTS
        TOTAL tWO wheels 
        TOTAL FOUR WHEELS
         */
        //UPDATE LABELS
        this.countLabel.setText(totalCountPoints.toString());
        this.twoLabel.setText(totalTwoWheels.toString());
        this.fourLabel.setText(totalFourWheels.toString());
    }

    //load  list controlpoints
    private void LoadSelections() {
        Object[] ControlPoints = null;
        Object[] years = null;

        //query to get the lists
        //year descendent
        //count ascendent
        //if everything is ok
        if (ControlPoints != null && years != null) {
            this.countPointBox.setModel(new DefaultComboBoxModel(ControlPoints));
            this.yearBox.setModel(new DefaultComboBoxModel(years));

        } else //if not we can select nothing
        {
            this.countPointBox.setEnabled(false);
            this.yearBox.setEnabled(false);
        }

    }

    //load  countPoint details
    private void loadCountDetails(String CountPoint) {
        //cast parameters 
        String point = CountPoint;

        //variables required
        String site = "";
        String roadName = "";
        String roadType = "";

        Double lat = 0.0;
        Double lng = 0.0;

        //run query
        
        //display data.
        this.SiteLabel.setText(site);
        this.NameLabel.setText(roadName);
        this.TypeLabel.setText(roadType);
        this.LatLabel.setText(Double.toString(lat));
        this.LongLabel.setText(Double.toString(lng));
    }

    //load  vehicles by type
    
    private void LoadCountbyType(String CountPoint, String Year)
    {
        //cast 
        String point= CountPoint;
        Integer year = Integer.parseInt(Year, 10);
        
        //create dataset
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        
        //retrieve data from database
        
        
        //add data to dataset.
        //dataSet.addValue("count", "carType", "");
        
        this.barChart.getCategoryPlot().setDataset(dataSet);
        
        
        
    }
    //load  vehicles by direction
    
    private void LoadCountbyDirection(String CountPoint, String Year)
    {
        //cast 
        String point= CountPoint;
        Integer year = Integer.parseInt(Year, 10);
        
        //create dataset
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        
        //retrieve data from database
        
        
        //add data to dataset.
        //dataSet.addValue("count", "Direction", "");
        
        //set dataset
        this.directionBar.getCategoryPlot().setDataset(dataSet);
        
    }
    
    //load  vehicles by time interval
    private void LoadCountbyIntervals (String CountPoint, String Year)
    {
        //cast 
        String point= CountPoint;
        Integer year = Integer.parseInt(Year, 10);
        
        //create dataset
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        
        //retrieve data from database
        
        
        //add data to dataset.
        //dataSet.addValue("count", "carType", "timeInterval");
        
        this.lineChart.getCategoryPlot().setDataset(dataSet);
        
    } 
    
    
    private JLabel Background;
    private JPanel contentPanel;
    private JLabel Title;
    private JPanel container;

    //containers:
    private JPanel containerTotal;
    private JPanel containerSelectors;
    private JPanel containerInfo;
    private JPanel containerDetails;

    private JScrollPane scrollPanel;

    //data to display
    private JLabel countLabel;
    private JLabel twoLabel;
    private JLabel fourLabel;

    //choises
    private JComboBox countPointBox;
    private JComboBox yearBox;

    private JLabel SiteLabel;
    private JLabel NameLabel;
    private JLabel TypeLabel;
    private JLabel LatLabel;
    private JLabel LongLabel;

    
    private  JFreeChart barChart;
    private JFreeChart directionBar;
    private  JFreeChart lineChart;

}

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DeliveryLocationDensityReport extends JFrame {
    private JComboBox<Integer> monthCombo, yearCombo;
    private JTable reportTable;
    
    public DeliveryLocationDensityReport() {
        setTitle("Delivery Location Density Report");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.GRAY);
        main.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel header = new JLabel("Delivery Location Density Report", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setOpaque(true);
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        main.add(header, BorderLayout.NORTH);
        
        JPanel controls = new JPanel(new FlowLayout());
        controls.setBackground(Color.LIGHT_GRAY);
        controls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        controls.add(new JLabel("Month:"));
        monthCombo = new JComboBox<>(new Integer[]{1,2,3,4,5,6,7,8,9,10,11,12});
        monthCombo.setBackground(Color.WHITE);
        controls.add(monthCombo);
        
        controls.add(new JLabel("Year:"));
        yearCombo = new JComboBox<>(new Integer[]{2023, 2024, 2025});
        yearCombo.setSelectedItem(2024);
        yearCombo.setBackground(Color.WHITE);
        controls.add(yearCombo);
        
        JButton generateBtn = new JButton("Generate Report");
        generateBtn.setBackground(Color.WHITE);
        generateBtn.setFont(new Font("Arial", Font.BOLD, 14));
        generateBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        generateBtn.addActionListener(e -> generateReport());
        controls.add(generateBtn);
        
        main.add(controls, BorderLayout.NORTH);
        
        String[] columns = {"Location", "Completed Deliveries", "Month", "Year", "Rank"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        reportTable = new JTable(model);
        reportTable.setBackground(Color.WHITE);
        reportTable.setGridColor(Color.BLACK);
        main.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        
        add(main);
        setVisible(true);
    }
    
    private void generateReport() {
        int month = (int) monthCombo.getSelectedItem();
        int year = (int) yearCombo.getSelectedItem();
        
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        model.setRowCount(0);
        
        
        model.addRow(new Object[]{"Sta. Ana branch", 25, "January", 2024, 1});
        model.addRow(new Object[]{"Malate branch", 18, "January", 2024, 2});
        model.addRow(new Object[]{"Pasay branch", 15, "January", 2024, 3});
        model.addRow(new Object[]{"Antipolo branch", 12, "January", 2024, 4});
        model.addRow(new Object[]{"Gen. Trias branch", 8, "January", 2024, 5});
        
    }
}
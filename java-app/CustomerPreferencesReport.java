import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class CustomerPreferencesReport extends JFrame {
    private JTable reportTable;
    
    public CustomerPreferencesReport() {
        setTitle("Customer Preferences Report");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JPanel main = new JPanel(new BorderLayout());
        main.setBackground(Color.GRAY);
        main.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        
        JLabel header = new JLabel("Customer Preferences Report", SwingConstants.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        header.setOpaque(true);
        header.setBackground(Color.WHITE);
        header.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        main.add(header, BorderLayout.NORTH);
        
        JPanel controls = new JPanel(new FlowLayout());
        controls.setBackground(Color.LIGHT_GRAY);
        controls.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        JButton generateBtn = new JButton("Generate Report");
        generateBtn.setBackground(Color.WHITE);
        generateBtn.setFont(new Font("Arial", Font.BOLD, 14));
        generateBtn.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        generateBtn.addActionListener(e -> generateReport());
        controls.add(generateBtn);
        
        main.add(controls, BorderLayout.NORTH);
        
        String[] columns = {"Customer ID", "First Name", "Last Name", "Delivery Count", "Pickup Count", "Preferred Method"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        reportTable = new JTable(model);
        reportTable.setBackground(Color.WHITE);
        reportTable.setGridColor(Color.BLACK);
        main.add(new JScrollPane(reportTable), BorderLayout.CENTER);
        
        add(main);
        setVisible(true);
    }
    
    private void generateReport() {
        DefaultTableModel model = (DefaultTableModel) reportTable.getModel();
        model.setRowCount(0);
        
        
        model.addRow(new Object[]{1000000001, "Juan", "Dela Cruz", 3, 2, "Delivery"});
        model.addRow(new Object[]{1000000002, "Maria", "Santos", 1, 5, "Pickup"});
        model.addRow(new Object[]{1000000003, "Pedro", "Reyes", 4, 1, "Delivery"});
        model.addRow(new Object[]{1000000004, "Ana", "Garcia", 2, 4, "Pickup"});
        model.addRow(new Object[]{1000000005, "Jose", "Bautista", 3, 3, "Delivery"});
    }
}

package view;

import database.DB_Druid;
import entity.Address;
import org.springframework.jdbc.core.JdbcTemplate;
import service.Utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

//维护表格
public class Main extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private JTextField aTextField;
    private JTextField bTextField;
    private JTextField cTextField;
    private JTextField dTextField;

    public Main() {
        super();
        setTitle("liushi通讯录 - 三层 C/S 架构");
        setBounds(100, 100, 500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] columnNames = {"联系人ID", "联系人", "居住地址", "电话号码"};

        JdbcTemplate jdbcTemplate = new JdbcTemplate(DB_Druid.getDataSource());
        List<Address> all = Utils.findAll(jdbcTemplate);
        String[] strArray = new String[all.size()];
        ArrayList[] arrayLists = new ArrayList[all.size()];
        for (int i = 0; i < all.size(); i++) {
            strArray[i] = all.get(i).toString();
        }
        for (int i = 0; i < strArray.length; i++) {
            String[] arr = strArray[i].split("\\s+");
            ArrayList<String> arrayList = new ArrayList();
            for (String ss : arr) {
                arrayList.add(ss);
                System.out.println(ss);
            }
            arrayLists[i] = arrayList;
        }

        String[][] tableVales = {
                {arrayLists[0].get(0).toString(),arrayLists[0].get(1).toString(),arrayLists[0].get(2).toString(),arrayLists[0].get(3).toString()},
                {arrayLists[1].get(0).toString(),arrayLists[1].get(1).toString(),arrayLists[1].get(2).toString(),arrayLists[1].get(3).toString()}
        };

        tableModel = new DefaultTableModel(tableVales, columnNames);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);  //单选
        table.addMouseListener(new MouseAdapter() {    //鼠标事件
            @Override
            public void mouseClicked(MouseEvent e) {
                int selectedRow = table.getSelectedRow();
                Object oa = tableModel.getValueAt(selectedRow, 0);
                Object ob = tableModel.getValueAt(selectedRow, 1);
                aTextField.setText(oa.toString());
                bTextField.setText(ob.toString());
            }
        });
        scrollPane.setViewportView(table);
        final JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.SOUTH);
        panel.add(new JLabel("A: "));
        aTextField = new JTextField("A4", 10);
        panel.add(aTextField);
        panel.add(new JLabel("B: "));
        bTextField = new JTextField("B4", 10);
        panel.add(bTextField);
        final JButton addButton = new JButton("添加联系人");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String[] rowValues = {aTextField.getText(), bTextField.getText()};
                tableModel.addRow(rowValues);
                int rowCount = table.getRowCount() + 1;
                aTextField.setText("A" + rowCount);
                bTextField.setText("B" + rowCount);
                Address address = new Address();
                Utils.update(address,jdbcTemplate);
            }
        });
        panel.add(addButton);

        final JButton updateButton = new JButton("修改联系人");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    tableModel.setValueAt(aTextField.getText(), selectedRow, 0);
                    tableModel.setValueAt(bTextField.getText(), selectedRow, 1);
                    Address address = new Address();
                    Utils.update(address,jdbcTemplate);
                }
            }
        });
        panel.add(updateButton);

        final JButton delButton = new JButton("删除联系人");
        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1)
                {
                    tableModel.removeRow(selectedRow);
                }
                Utils.delete(selectedRow,jdbcTemplate);
            }
        });
        panel.add(delButton);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Main main = new Main();
        main.setVisible(true);
    }
}
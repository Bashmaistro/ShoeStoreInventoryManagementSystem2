package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

public class DatabaseViewer extends JFrame {
    private JTable table1;
    private JPanel panel1;
    JScrollPane sp=new JScrollPane(panel1,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    private JTextField empid;
    private JTextField bdate;
    private JTextField address;
    private JTextField telephone;
    private JTabbedPane tabbedPane1;
    private JTextField gender;
    private JTextField stat;
    private JTextField mname;
    private JTextField lname;
    private JTextField tsalary;
    private JTextField SN;
    private JTextField fname;
    private JButton saveButton;
    private JTextField datein;
    private JTable table2;
    private JTable Stockusedtable;
    private JTextField StockUsedFrom;
    private JTextField StockUsedTo;
    private JTable StockInTAble;
    private JTextField StockintextFrom;
    private JTextField StockInTo;
    private JButton stockInButton;
    private JButton stockUsedButton;
    private JTable Paymenttable;
    private JTextField paymentFrom;
    private JTextField paymentto;
    private JButton paymentButton;
    private JScrollPane StockInTable;
    private JTable supplierdelivery;
    private JComboBox comboBox1;
    private JButton showButton;
    private JButton resetButton;
    private JTextField Tbrand;
    private JTextField tSize;
    private JTextField Ttype;
    private JTextField Tgender;
    private JTextField Tqty;
    private JTextField Tcolor;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton stockInButton1;
    private JButton stockOutButton;
    private JTable table3;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JButton showButton1;
    private JButton showAllButton;
    private JButton resetButton1;
    private JPasswordField LoginEmpSSN;
    private JButton logInButton;
    private JTextField Loginempid;
    private JTextField TpersonName;
    private JTextField TpersonSSN;
    private JTextField tPersonGender;
    private JTextField TpersonPhone;
    private JTextField tpersonLname;
    private JTextField tPersonAddress;
    private JTextField tpersonDate;
    private JButton postButton;
    private JTextField tpayment;
    private JTextField tPaymentDate;
    private JTextField TPaymentprice;
    private JTextField tcustomerid;
    private JTextField temployeeid;
    private JButton resetButton2;
    private JButton resetButton3;
    private JButton resetButton4;
    private JTable QuerryTable;
    private JButton showButton2;
    private JButton showButton3;
    private JButton showButton4;
    private JButton showButton5;
    private JButton button1;
    private JComboBox comboBox5;
    private JComboBox comboBox6;
    private JButton showButton6;
    private JButton resetTableButton;

    private boolean check;

    DefaultTableModel modelQuerry = new DefaultTableModel();
    Object[] columnQuerry = {"Shoe Brand", "Shoe Size","Total Quantity"," ", " "," "," "};
    Object[] rowQuerry = new Object[7];
    DefaultTableModel modelshoe = new DefaultTableModel();
    Object[] columnshoe = {"Shoe ID", "Shoe Brand","Shoe Size","Shoe Type","Shoe Color", "Shoe Gender","Shoe Price","Shoe Quantity"};
    Object[] rowshoe = new Object[8];

    DefaultTableModel modelsupp = new DefaultTableModel();
    Object[] columnsupp = {"Supplier ID", "Employee ID","Delivery Date","Delivery Time" , "Supplier Address"};
    Object[] rowsupp = new Object[5];
    DefaultTableModel modelpay = new DefaultTableModel();
    Object[] columnpay = {"Customer Name", "Customer Lastname","Customer SSN","Payment Date" , "Payment Amaount" , "Payment Id", "Employee ID"};
    Object[] rowpay = new Object[7];

    DefaultTableModel modelStckin = new DefaultTableModel();
    Object[] columnStckin = {"ID","Shoe Brand","Shoe Size" , "Stock In Qty" , "Stock In Date" };
    Object[] rowStckin = new Object[5];

    DefaultTableModel modelStckUsed= new DefaultTableModel();
    Object[] columnStckused = {"ID","Shoe Brand","Shoe Size" , "Stock Used Qty" , "Stock Used Date" };
    Object[] rowStckused = new Object[5];


    DefaultTableModel model = new DefaultTableModel();
    Object[] column = {"ID","SSN","FName" , "MName" , "LName" ,"Bdate", "DatesIn", "Address" , "Telephone" , "Gender","Status","Salary"};
    Object[] row = new Object[12];

    DefaultTableModel personmodel = new DefaultTableModel();
    Object[] columnP = {"ID","SSN","FName" , "MName" , "LName" ,"Bdate",  "Address" , "Telephone" , "Gender"};
    Object[] rowP = new Object[9];
    public DatabaseViewer(){


        check = false;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100,100,450,450);
        add(sp);
        ConnectandList();
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   long id,ssn,Telephone;
                   float salary;
                   String Fname,Mname,Lname,Adress,Gender,Status;
                   Date Bdate,DatesIn;
                   id= Long.parseLong(empid.getText());
                   ssn= Long.parseLong(SN.getText());
                   Telephone = Long.parseLong(telephone.getText());
                   salary = Float.parseFloat(tsalary.getText());
                   Fname= fname.getText();
                   Mname=mname.getText();
                   Lname=lname.getText();
                   Adress=address.getText();
                   Gender = gender.getText();
                   Status =stat.getText();
                   Bdate= Date.valueOf(bdate.getText());
                   DatesIn = Date.valueOf(datein.getText());

                   String empSql = "INSERT INTO employee (emp_id,SSN,emp_salary,emp_status, emp_datein)"+
                           "VALUES ('"+id+"','"+ssn+"','"+salary+"','"+Status+"','"+DatesIn+"')";
                   String personSql = "INSERT INTO person (SSN,person_Fname,person_Mname,person_Lname,person_Bdate,person_Adress,telephone,person_Gender)" +
                           "VALUES('"+ssn+"','"+Fname+"','"+Mname+"','"+Lname+"','"+Bdate+"','"+Adress+"','"+Telephone+"','"+Gender+"')";
                   String telephoneSql = "INSERT INTO telephonenumber (SSN,telephone)" +
                           "VALUES('"+ssn+"','"+Telephone+"')";



                   DatabaseConnection.insert(empSql);
                   DatabaseConnection.insert(personSql);
                   DatabaseConnection.insert(telephoneSql);


            }
        });
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql ="SELECT * FROM shoe;";
                flyteredShoe(sql);

            }
        });

        //Shoe
        showButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT * FROM shoe WHERE 1=1";

                if (comboBox2.getSelectedItem() != "Empty") {
                    sql += " AND shoe_brand = '" + comboBox2.getSelectedItem() + "'";
                }

                if (comboBox3.getSelectedItem() != "Empty") {
                    sql += " AND shoe_size = '" + comboBox3.getSelectedItem() + "'";
                }

                if (comboBox4.getSelectedItem() != "Empty") {
                    sql += " AND shoe_type = '" + comboBox4.getSelectedItem() + "'";
                }

                flyteredShoe(sql);

            }
        });





        stockInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date From,To;
                From = Date.valueOf(StockintextFrom.getText());
                To = Date.valueOf(StockInTo.getText());

                String sql = "SELECT s.*, sh.*\n" +
                        "FROM stockin s\n" +
                        "INNER JOIN shoe sh ON s.shoe_id = sh.shoe_id\n" +
                        "WHERE s.stckin_date BETWEEN '"+To+"' AND '"+From+"';";
                DateList(sql);
            }
        });
        stockUsedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date From,To;
                From = Date.valueOf(StockUsedFrom.getText());
                To = Date.valueOf(StockUsedTo.getText());

                String sql = "SELECT s.*, sh.*\n" +
                        "FROM stockused s\n" +
                        "INNER JOIN shoe sh ON s.shoe_id = sh.shoe_id\n" +
                        "WHERE s.stckused_date BETWEEN '"+To+"' AND '"+From+"';";
                DateListUsed(sql);

            }
        });
        paymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Date From,To;
                From = Date.valueOf(paymentFrom.getText());
                To = Date.valueOf(paymentto.getText());
                String sql1 = "SELECT p.*, e.*, c.*, pay.*\n" +
                        "FROM payment pay\n" +
                        "INNER JOIN employee e ON pay.emp_id = e.emp_id\n" +
                        "INNER JOIN customer c ON pay.cust_id = c.cust_id\n" +
                        "INNER JOIN person p ON c.SSN = p.SSN\n" +
                        "WHERE pay.payment_date BETWEEN '"+To+"' AND '"+From+"';";



                DateListPay(sql1);
            }
        });
        showButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String str="SELECT s.*, d.*\n" +
                        "FROM supplier s\n" +
                        "INNER JOIN delivery d ON s.supplier_id = d.supplier_id\n" +
                        "WHERE s.supplier_name IN ( '"+comboBox1.getSelectedItem()+"');";

                SuppList(str);


            }
        });
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelsupp.setRowCount(0);
            }
        });

        resetButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelshoe.setRowCount(0);
            }
        });
        

        //Stockin Register
        stockInButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String brand, color, type, gender;
                Long shoeid, id, emp_id;
                Date date;
                int qty, size;

                brand = Tbrand.getText();
                color = Tcolor.getText();
                type = Ttype.getText();
                gender = Tgender.getText();
                shoeid = Long.valueOf(textField3.getText());
                id = Long.valueOf(textField2.getText());
                date = Date.valueOf(textField1.getText());
                qty = Integer.parseInt(Tqty.getText());
                size = Integer.parseInt(tSize.getText());
                emp_id = Long.valueOf(Loginempid.getText());
                System.out.println(check);

                if(check){
                    String checkSql = "SELECT * FROM shoe WHERE shoe_brand = '"+brand+"' AND shoe_color = '"+color+"' AND shoe_type = '"+type+"' AND shoe_size = '"+size+"' AND shoe_gender = '"+gender+"';";
                    ResultSet rs = DatabaseConnection.listed(checkSql);

                    try {
                        if (rs.next()) {
                            int newQty = rs.getInt("shoe_qty") + qty;
                            String updateSql = "UPDATE shoe SET shoe_qty = '"+newQty+"' WHERE shoe_brand = '"+brand+"' AND shoe_color = '"+color+"' AND shoe_size = '"+size+"' AND shoe_gender = '"+gender+"';";
                            DatabaseConnection.insert(updateSql);
                            JOptionPane.showMessageDialog(null, "Quantity Updated.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            String checkId = "SELECT * FROM shoe";
                            ResultSet rsID = DatabaseConnection.listed(checkId);
                            boolean idExists = false;

                            while (rsID.next()) {
                                if (rsID.getLong("shoe_id") == shoeid) {
                                    shoeid = shoeid + 1000000;
                                    idExists = true;
                                    break;
                                }
                            }

                            float min = 500.0f;
                            float max = 5000.0f;
                            Random random = new Random();
                            float randomFloat = min + random.nextFloat() * (max - min);

                            String shoeSql = "INSERT INTO shoe (shoe_id,shoe_brand,shoe_qty,shoe_color,shoe_size,shoe_cost,shoe_type,shoe_gender)"+
                                    "VALUES ('"+shoeid+"','"+brand+"','"+qty+"','"+color+"','"+size+"','"+randomFloat+"','"+type+"','"+gender+"')";

                            DatabaseConnection.insert(shoeSql);
                            JOptionPane.showMessageDialog(null, "New Shoe Added", "Info", JOptionPane.INFORMATION_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    String stockin = "INSERT INTO stockin (stckin_date,stckin_id,stckin_qty,emp_id,shoe_id)" +
                            "VALUES ('"+date+"','"+id+"','"+qty+"','"+emp_id+"','"+shoeid+"')";
                    DatabaseConnection.insert(stockin);


                }else{
                    JOptionPane.showMessageDialog(null, "Log In First!!", "Error", JOptionPane.ERROR_MESSAGE);
                }


            }
        });

        stockOutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String brand, color, type, gender;
                Long shoeid, id, emp_id;
                Date date;
                int qty, size;

                brand = Tbrand.getText();
                color = Tcolor.getText();
                type = Ttype.getText();
                gender = Tgender.getText();
                shoeid = Long.valueOf(textField3.getText());
                id = Long.valueOf(textField2.getText());
                date = Date.valueOf(textField1.getText());
                qty = Integer.parseInt(Tqty.getText());
                size = Integer.parseInt(tSize.getText());
                emp_id = Long.valueOf(Loginempid.getText());
                System.out.println(check);

                if(check){
                    String checkSql = "SELECT * FROM shoe WHERE shoe_brand = '"+brand+"' AND shoe_color = '"+color+"' AND shoe_type = '"+type+"' AND shoe_size = '"+size+"' AND shoe_gender = '"+gender+"';";
                    ResultSet rs = DatabaseConnection.listed(checkSql);

                    try {
                        if (rs.next()) {
                            int newQty = rs.getInt("shoe_qty") - qty;
                            if (newQty < 0){
                                JOptionPane.showMessageDialog(null, "The Number of Shoes Cannot Go Negative", "Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            } else if (newQty == 0) {
                                String deleteSql = "DELETE FROM shoe WHERE shoe_id = " + shoeid ;
                                DatabaseConnection.insert(deleteSql);
                                JOptionPane.showMessageDialog(null, "Shoe Deleted", "Info", JOptionPane.INFORMATION_MESSAGE);
                            }else {

                                String updateSql = "UPDATE shoe SET shoe_qty = '"+newQty+"' WHERE shoe_brand = '"+brand+"' AND shoe_color = '"+color+"' AND shoe_size = '"+size+"' AND shoe_gender = '"+gender+"';";
                                DatabaseConnection.insert(updateSql);
                                JOptionPane.showMessageDialog(null, "Quantity Updated.", "Info", JOptionPane.INFORMATION_MESSAGE);

                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "No Such Shoes", "Error", JOptionPane.ERROR_MESSAGE);
                            return;
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }

                    String stockused = "INSERT INTO stockused (stckused_date,stckused_id,stckused_qty,emp_id,shoe_id)" +
                            "VALUES ('"+date+"','"+id+"','"+qty+"','"+emp_id+"','"+shoeid+"')";
                    DatabaseConnection.insert(stockused);


                }else{
                    JOptionPane.showMessageDialog(null, "Log In First!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        //tpayment;tPaymentDate;TPaymentprice;TpersonName;TpersonSSN;tPersonGender;TpersonPhone;tpersonLname;tPersonAddress;tpersonDate;
        postButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long paymentid,SSN,phone,empId,custId;
                Date paymentDate,personBdate;
                String personName,personGender,personLname,personAddress;
                Float price;
                paymentid = Long.parseLong(tpayment.getText());
                SSN = Long.parseLong(TpersonSSN.getText());
                phone = Long.parseLong(TpersonPhone.getText());
                paymentDate = Date.valueOf(tPaymentDate.getText());
                personBdate = Date.valueOf(tPaymentDate.getText());
                personName = TpersonName.getText();
                personLname = tpersonLname.getText();
                personGender = tPersonGender.getText();
                personAddress = tPersonAddress.getText();
                price = Float.valueOf(TPaymentprice.getText());
                empId = Long.parseLong(temployeeid.getText());
                custId = Long.parseLong(tcustomerid.getText());

                String personSql ="INSERT INTO person (SSN,person_Fname,person_Lname,person_Bdate,person_Adress,telephone,person_Gender)"  +
                                                   "VALUES('"+SSN+"','"+personName+"','"+personLname+"','"+personBdate+"','"+personAddress+"','"+phone+"','"+personGender+"');";
                String customerSql = "INSERT INTO customer (cust_id,SSN)"  +
                        "VALUES('"+custId+"','"+SSN+"');";

                String paymentSql ="INSERT INTO payment (payment_id,payment_date,payment_amt,cust_id,emp_id)"  +
                        "VALUES('"+paymentid+"','"+paymentDate+"','"+price+"','"+custId+"','"+empId+"');";

                DatabaseConnection.insert(personSql);
                DatabaseConnection.insert(customerSql);
                DatabaseConnection.insert(paymentSql);
                JOptionPane.showMessageDialog(null, "Payment Added.", "Info", JOptionPane.INFORMATION_MESSAGE);


            }
        });
        resetButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelStckin.setRowCount(0);
            }
        });

        resetButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelStckUsed.setRowCount(0);
            }
        });
        resetButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelpay.setRowCount(0);
            }
        });
        showButton2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sql = "SELECT s.shoe_brand, s.shoe_size, SUM(si.stckin_qty) AS total_quantity\n" +
                        "FROM shoe s\n" +
                        "INNER JOIN stockin si ON s.shoe_id = si.shoe_id\n" +
                        "WHERE si.stckin_date >= DATE_SUB(CURDATE(), INTERVAL 3 MONTH)\n" +
                        "GROUP BY s.shoe_brand, s.shoe_size\n" +
                        "ORDER BY total_quantity DESC;";

                DatabaseConnection.connection();
                ResultSet rs = DatabaseConnection.listed(sql);
                modelQuerry.setColumnIdentifiers(columnQuerry);
                try {
                    while (rs.next()) {

                        rowQuerry[0] = rs.getString("shoe_brand");
                        rowQuerry[1] = rs.getString("shoe_size");
                        rowQuerry[2] = rs.getString("total_quantity");


                        modelQuerry.addRow(rowQuerry);
                    }
                    QuerryTable.setModel(modelQuerry);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }



            }
        });
        showButton3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String sqlQuery = "SELECT AVG(payment_amt) AS average_purchase_amount FROM payment WHERE payment_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";
                ResultSet rs = DatabaseConnection.listed(sqlQuery);
                try {
                    if (rs.next()) {
                        double averagePurchaseAmount = rs.getDouble("average_purchase_amount");
                        JOptionPane.showMessageDialog(null, averagePurchaseAmount, "Info", JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }




            }
        });
        showButton4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sqlQuery = "SELECT s.shoe_brand, s.shoe_size, s.shoe_qty\n" +
                        "FROM shoe s\n" +
                        "LEFT JOIN stockin si ON s.shoe_id = si.shoe_id\n" +
                        "WHERE si.stckin_id IS NULL OR si.stckin_date < DATE_SUB(CURDATE(), INTERVAL 3 MONTH)\n" +
                        "ORDER BY s.shoe_size;";

                DatabaseConnection.connection();
                ResultSet rs = DatabaseConnection.listed(sqlQuery);
                modelQuerry.setColumnIdentifiers(columnQuerry);
                try {
                    while (rs.next()) {

                        rowQuerry[0] = rs.getString("shoe_brand");
                        rowQuerry[1] = rs.getString("shoe_size");
                        rowQuerry[2] = rs.getString("shoe_qty");


                        modelQuerry.addRow(rowQuerry);
                    }
                    QuerryTable.setModel(modelQuerry);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }
            }
        });
        showButton5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql ="SELECT s.shoe_brand , SUM(si.stckused_qty * s.shoe_cost) AS revenue\n" +
                        "FROM shoe s\n" +
                        "JOIN stockused si ON s.shoe_id = si.shoe_id\n" +
                        "WHERE si.stckused_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH)\n" +
                        "GROUP BY s.shoe_brand\n" +
                        "ORDER BY revenue DESC;";

                DatabaseConnection.connection();
                ResultSet rs = DatabaseConnection.listed(sql);
                modelQuerry.setColumnIdentifiers(columnQuerry);
                try {
                    while (rs.next()) {

                        rowQuerry[0] = rs.getString("shoe_brand");
                        rowQuerry[1] = rs.getString("revenue");

                        modelQuerry.addRow(rowQuerry);
                    }
                    QuerryTable.setModel(modelQuerry);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }
            }
        });
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT p.person_Fname, p.person_Lname, e.emp_id\n" +
                        "FROM employee e\n" +
                        "JOIN person p ON e.ssn = p.ssn\n" +
                        "JOIN stockused su ON e.emp_id = su.emp_id\n" +
                        "JOIN shoe s ON su.shoe_id = s.shoe_id\n" +
                        "WHERE s.shoe_brand = '"+comboBox5.getSelectedItem()+"'\n" +
                        "  AND su.stckused_date >= DATE_SUB(CURDATE(), INTERVAL 1 MONTH);";

                DatabaseConnection.connection();
                ResultSet rs = DatabaseConnection.listed(sql);
                modelQuerry.setColumnIdentifiers(columnQuerry);
                try {
                    while (rs.next()) {

                        rowQuerry[0] = rs.getString("person_Fname");
                        rowQuerry[1] = rs.getString("person_Lname");
                        rowQuerry[2] = rs.getString("emp_id");


                        modelQuerry.addRow(rowQuerry);
                    }
                    QuerryTable.setModel(modelQuerry);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }
            }




        });

        showButton6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sql = "SELECT *\n" +
                        "FROM shoe\n" +
                        "WHERE shoe_cost > "+comboBox6.getSelectedItem()+";";

                DatabaseConnection.connection();
                ResultSet rs = DatabaseConnection.listed(sql);
                modelQuerry.setColumnIdentifiers(columnQuerry);
                try {
                    while (rs.next()) {

                        rowQuerry[0] = rs.getString("shoe_brand");
                        rowQuerry[1] = rs.getString("shoe_color");
                        rowQuerry[2] = rs.getString("shoe_cost");
                        rowQuerry[3] = rs.getString("shoe_type");
                        rowQuerry[4] = rs.getString("shoe_id");


                        modelQuerry.addRow(rowQuerry);
                    }
                    QuerryTable.setModel(modelQuerry);
                } catch (SQLException s) {
                    throw new RuntimeException(s);
                }



            }
        });
        resetTableButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modelQuerry.setRowCount(0);
            }
        });
    }
    void flyteredShoe(String sql){

        DatabaseConnection.connection();
        ResultSet rs = DatabaseConnection.listed(sql);
        modelshoe.setColumnIdentifiers(columnshoe);
        try {
            while (rs.next()) {
                //"Shoe ID", "Shoe Brand","Shoe Size","Shoe Type","Shoe Color", "Shoe Gender","Shoe Price","Shoe Quantity"
                rowshoe[0] = rs.getString("shoe_id");
                rowshoe[1] = rs.getString("shoe_brand");
                rowshoe[2] = rs.getString("shoe_size");
                rowshoe[3] = rs.getString("shoe_type");
                rowshoe[4] = rs.getString("shoe_color");
                rowshoe[5] = rs.getString("shoe_gender");
                rowshoe[6] = rs.getString("shoe_cost");
                rowshoe[7] = rs.getString("shoe_qty");

                modelshoe.addRow(rowshoe);
            }
            table3.setModel(modelshoe);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void SuppList(String sql){
        DatabaseConnection.connection();
        ResultSet rs = DatabaseConnection.listed(sql);
        modelsupp.setColumnIdentifiers(columnsupp);
        try {
            while (rs.next()) {
          //"Supplier ID", "Who Takes Delivery","Delivery Date","Delivery Time" , "Supplier Address"
                rowsupp[0] = rs.getString("supplier_id");
                rowsupp[1] = rs.getString("emp_id");
                rowsupp[2] = rs.getString("delivery_date");
                rowsupp[3] = rs.getString("delivery_time");
                rowsupp[4] = rs.getString("supplier_adress");
                modelsupp.addRow(rowsupp);
            }
            supplierdelivery.setModel(modelsupp);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    void DateListPay(String csql1){
        DatabaseConnection.connection();
        ResultSet rs = DatabaseConnection.listed(csql1);
        modelpay.setColumnIdentifiers(columnpay);



        try {
            while (rs.next()) {

                rowpay[0] = rs.getString("person_Fname");
                rowpay[1] = rs.getString("person_Lname");
                rowpay[2] = rs.getString("SSN");
                rowpay[3] = rs.getString("payment_date");
                rowpay[4] = rs.getString("payment_amt");
                rowpay[5] = rs.getString("payment_id");
                rowpay[6] = rs.getString("cust_id");
                modelpay.addRow(rowpay);
            }
            Paymenttable.setModel(modelpay);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    void DateListUsed(String sql){

        DatabaseConnection.connection();
        ResultSet rs = DatabaseConnection.listed(sql);
        modelStckUsed.setColumnIdentifiers(columnStckused);

        try {
            while (rs.next()){
                rowStckused[0] = rs.getString("stckused_id");
                rowStckused[1] = rs.getString("shoe_brand");
                rowStckused[2] = rs.getString("shoe_size");
                rowStckused[3] = rs.getString("stckused_qty");
                rowStckused[4] = rs.getString("stckused_date");
                modelStckUsed.addRow(rowStckused);
            }
            Stockusedtable.setModel(modelStckUsed);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    void DateList(String sql){

        DatabaseConnection.connection();
        ResultSet rs = DatabaseConnection.listed(sql);
        modelStckin.setColumnIdentifiers(columnStckin);

        try {
            while (rs.next()){
                rowStckin[0] = rs.getString("stckin_id");
                rowStckin[1] = rs.getString("shoe_brand");
                rowStckin[2] = rs.getString("shoe_size");
                rowStckin[3] = rs.getString("stckin_qty");
                rowStckin[4] = rs.getString("stckin_date");
                modelStckin.addRow(rowStckin);
            }
            StockInTAble.setModel(modelStckin);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    void ConnectandList(){
        //Employee
        DatabaseConnection.connection();
        String listSql = "SELECT * FROM employee INNER JOIN person ON employee.SSN = person.SSN";
        ResultSet rs = DatabaseConnection.listed(listSql);
        model.setColumnIdentifiers(column);


            try {
                while (rs.next()){
                    row[0] = rs.getString("emp_id");
                    row[1] = rs.getString("SSN");
                    row[2] = rs.getString("person_Fname");
                    row[3] = rs.getString("person_Mname");
                    row[4] = rs.getString("person_Lname");
                    row[5] = rs.getString("person_Bdate");
                    row[6] = rs.getString("emp_datein");
                    row[7] = rs.getString("person_adress");
                    row[8] = rs.getString("telephone");
                    row[9] = rs.getString("person_Gender");
                    row[10] = rs.getString("emp_status");
                    row[11] = rs.getString("emp_salary");
                   model.addRow(row);
                }
                table1.setModel(model);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


            //Customer
           String listSqlP = "SELECT * FROM customer INNER JOIN person ON customer.SSN = person.SSN";
           ResultSet rsP = DatabaseConnection.listed(listSqlP);
           personmodel.setColumnIdentifiers(columnP);

           try {
            while (rsP.next()){
                rowP[0] = rsP.getString("cust_id");
                rowP[1] = rsP.getString("SSN");
                rowP[2] = rsP.getString("person_Fname");
                rowP[3] = rsP.getString("person_Mname");
                rowP[4] = rsP.getString("person_Lname");
                rowP[5] = rsP.getString("person_Bdate");
                rowP[6] = rsP.getString("person_adress");
                rowP[7] = rsP.getString("telephone");
                rowP[8] = rsP.getString("person_Gender");

                personmodel.addRow(rowP);
            }
            table2.setModel(personmodel);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }






    }
}

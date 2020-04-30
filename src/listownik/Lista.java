package listownik;

import java.awt.Color;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.*;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import static javax.swing.SwingUtilities.isRightMouseButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Lista extends javax.swing.JFrame {

    public Lista() {
        initComponents();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
                this.setResizable(false);
        try {
            BufferedReader reader = new BufferedReader(new FileReader("baza/kolejka.txt"));
            String tresc;
            while ((tresc = reader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(tresc, " ");
                String gender = token.nextToken();
                String pokoj = token.nextToken();
                String pacjent = token.nextToken();
                String data_poczatku = token.nextToken();
                String data_konca = token.nextToken();
                String kod = token.nextToken();
             if(!data_konca.equals("10.10.2999"))
               {  
                StringTokenizer token2 = new StringTokenizer(data_poczatku, ".");
               int dzienP =Integer.parseInt(token2.nextToken());
               int miesiacP =Integer.parseInt(token2.nextToken());
               int rokP =Integer.parseInt(token2.nextToken());
               GregorianCalendar cal;
                cal = new GregorianCalendar(rokP,miesiacP-1,dzienP);
                Date data_p = cal.getTime();
                
                int index;
                
                 StringTokenizer token3 = new StringTokenizer(data_konca, ".");
               int dzienK =Integer.parseInt(token3.nextToken());
               int miesiacK =Integer.parseInt(token3.nextToken());
               int rokK =Integer.parseInt(token3.nextToken());
               GregorianCalendar cal2;
                cal2 = new GregorianCalendar(rokK,miesiacK-1,dzienK);
                Date data_k = cal2.getTime();
                
                Calendar nowCal = Calendar.getInstance();
                Date now = nowCal.getTime();
                nowCal.add(Calendar.MONTH,2);
                Date nowAdd = nowCal.getTime();
                
                
               if(data_k.compareTo(now)==-1)
               {
                  index = 5;
               }
               else if (data_p.compareTo(nowAdd)==1 )
               {
                   index = 1;
               }
               else if (data_k.compareTo(now)==1 && data_p.compareTo(now)==-1)
               {
                   index = 4;
               }
               else
               {
                   int x = Integer.parseInt(token.nextToken());
                   if(x!=3)
                   {
                       index = 1;
                   }
                   else
                   {
                    index=x;
                   }
               }
                Lista.add(new KolejkaObj(gender, pokoj, pacjent, data_poczatku, data_konca, kod,index));
            }}
            
            sortByDate(Lista);
            
             DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                DefaultTableModel model2 = (DefaultTableModel) jTable2.getModel();
                DefaultTableModel model3 = (DefaultTableModel) jTable5.getModel();
                DefaultTableModel model4 = (DefaultTableModel) jTable6.getModel();
                DefaultTableModel model9 = (DefaultTableModel) jTable9.getModel();
                DefaultTableModel model10 = (DefaultTableModel) jTable10.getModel();
             for(KolejkaObj element : Lista)
                {
                    String genderr = element.getRodzaj();
                switch (genderr) {
                    case "M.Stabilny":
                             model.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                        break;
                    case "M.Pilny":
                        model2.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                        break;
                    case "K.Stabilna":
                        model3.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                        break;
                    case "K.Pilna":
                        model4.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                        break;
                    case "K.Niepelnosprawna":
                        model9.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                         break;   
                    case "M.Niepelnosprawny":
                        model10.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),element.getPacjent(),element.getKod(),element.getData_poczatku(),element.getData_konca(),element.getIndex()});
                         break;           
                }}
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        jTable1.setDefaultRenderer(Object.class,new Renderer());
        jTable2.setDefaultRenderer(Object.class,new Renderer());
        jTable5.setDefaultRenderer(Object.class,new Renderer());
        jTable6.setDefaultRenderer(Object.class,new Renderer());
        jTable9.setDefaultRenderer(Object.class,new Renderer());
        jTable10.setDefaultRenderer(Object.class,new Renderer());
        popupMenu(this);
        
        
         DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable5.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable6.getModel();
        DefaultTableModel model9 = (DefaultTableModel) jTable9.getModel();
        DefaultTableModel model10 = (DefaultTableModel) jTable10.getModel();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable1.scrollRectToVisible(jTable1.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable2.getRowCount(); i++) {
             int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable2.scrollRectToVisible(jTable2.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable5.getRowCount(); i++) {
              int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable5.scrollRectToVisible(jTable5.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable6.getRowCount(); i++) {
  int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable6.scrollRectToVisible(jTable6.getCellRect(i, 0, true));

            }           
        }
          for (int i = 0; i < jTable9.getRowCount(); i++) {
             int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable9.scrollRectToVisible(jTable9.getCellRect(i, 0, true));

            }
            
        }
            for (int i = 0; i < jTable10.getRowCount(); i++) {
             int x= (int) model.getValueAt(i,6);
            if (x==4) {
                jTable10.scrollRectToVisible(jTable10.getCellRect(i, 0, true));

            }
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        TF2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        zapiszButton = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable()
        {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }

        };
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable5 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};
            jLabel5 = new javax.swing.JLabel();
            jButton6 = new javax.swing.JButton();
            jScrollPane6 = new javax.swing.JScrollPane();
            jTable6 = new javax.swing.JTable(){
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return false;
                }};
                jLabel3 = new javax.swing.JLabel();
                jButton7 = new javax.swing.JButton();
                jScrollPane2 = new javax.swing.JScrollPane();
                jTable2 = new javax.swing.JTable()
                {
                    public boolean isCellEditable(int rowIndex, int colIndex) {
                        return false;
                    }
                }
                ;
                jLabel4 = new javax.swing.JLabel();
                jButton3 = new javax.swing.JButton();
                jScrollPane9 = new javax.swing.JScrollPane();
                jTable9 = new javax.swing.JTable(){
                    public boolean isCellEditable(int rowIndex, int colIndex) {
                        return false;
                    }};
                    jScrollPane10 = new javax.swing.JScrollPane();
                    jTable10 = new javax.swing.JTable(){
                        public boolean isCellEditable(int rowIndex, int colIndex) {
                            return false;
                        }};
                        jButton9 = new javax.swing.JButton();
                        jLabel16 = new javax.swing.JLabel();
                        jButton10 = new javax.swing.JButton();
                        jLabel17 = new javax.swing.JLabel();

                        jTable3.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu"
                            }
                        ));
                        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable3MouseClicked(evt);
                            }
                        });
                        jTable3.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable3KeyPressed(evt);
                            }
                        });
                        jScrollPane3.setViewportView(jTable3);
                        if (jTable3.getColumnModel().getColumnCount() > 0) {
                            jTable3.getColumnModel().getColumn(0).setPreferredWidth(90);
                            jTable3.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable3.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable3.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable3.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable3.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable3.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable3.getColumnModel().getColumn(3).setMaxWidth(70);
                        }

                        jButton4.setText("Zapisz w pliku");
                        jButton4.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                            }
                        });

                        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
                        setTitle("Lista pacjentów");
                        setBackground(new java.awt.Color(255, 255, 255));
                        setFocusable(false);
                        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
                        setLocationByPlatform(true);
                        setResizable(false);
                        setSize(new java.awt.Dimension(1197, 671));
                        addWindowListener(new java.awt.event.WindowAdapter() {
                            public void windowClosing(java.awt.event.WindowEvent evt) {
                                formWindowClosing(evt);
                            }
                        });

                        TF2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
                        TF2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
                        TF2.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                TF2ActionPerformed(evt);
                            }
                        });
                        TF2.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                TF2KeyTyped(evt);
                            }
                        });

                        jButton1.setText("Szukaj");
                        jButton1.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                            }
                        });

                        jLabel1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
                        jLabel1.setText("Numer pacjenta:");

                        zapiszButton.setText("Zapisz zmiany");
                        zapiszButton.setMargin(new java.awt.Insets(6, 14, 6, 14));
                        zapiszButton.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                zapiszButtonActionPerformed(evt);
                            }
                        });

                        jButton5.setText("<< Powrót ");
                        jButton5.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                            }
                        });

                        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

                        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""}));

                        jLabel6.setText("Rodzaj ");

                        jLabel7.setText("Łóżko");

                        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "M.Stabilny", "M.Pilny", "K.Stabilna", "K.Pilna","M.Niepelnosprawny","K.Niepelnosprawna" }));
                        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jComboBox2ActionPerformed(evt);
                            }
                        });

                        jLabel8.setText("Pacjent");

                        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                jTextField1KeyTyped(evt);
                            }
                        });

                        jLabel9.setText("Kod");

                        jTextField2.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jTextField2ActionPerformed(evt);
                            }
                        });
                        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyTyped(java.awt.event.KeyEvent evt) {
                                jTextField2KeyTyped(evt);
                            }
                        });

                        jLabel10.setText("Data przyjęcia");

                        jButton8.setText("Dodaj");
                        jButton8.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton8ActionPerformed(evt);
                            }
                        });

                        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                        jPanel1.setLayout(jPanel1Layout);
                        jPanel1Layout.setHorizontalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
                        );
                        jPanel1Layout.setVerticalGroup(
                            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        );

                        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

                        jLabel11.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
                        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
                        jLabel11.setText("5 - rehabilitacja zakończona");

                        jLabel12.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
                        jLabel12.setForeground(new java.awt.Color(102, 255, 153));
                        jLabel12.setText("4 - rehabilitacja trwa");

                        jLabel14.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
                        jLabel14.setForeground(new java.awt.Color(0, 153, 255));
                        jLabel14.setText("3 - pacjent powiadomiony");

                        jLabel15.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
                        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
                        jLabel15.setText("1 - pacjent nie powiadomiony");

                        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
                        jPanel2.setLayout(jPanel2Layout);
                        jPanel2Layout.setHorizontalGroup(
                            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        );
                        jPanel2Layout.setVerticalGroup(
                            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );

                        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));
                        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

                        jPanel3.setBackground(new java.awt.Color(213, 213, 213));
                        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
                        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
                        jPanel3.setPreferredSize(new java.awt.Dimension(1216, 1200));

                        jTable1.setAutoCreateRowSorter(true);
                        jTable1.setBackground(new java.awt.Color(51, 51, 51));
                        jTable1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0))));
                        jTable1.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable1.setColumnSelectionAllowed(false);
                        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                        jTable1.setRowHeight(35);
                        jTable1.setRowMargin(2);
                        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
                        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jScrollPane1.setViewportView(jTable1);
                        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable1MouseClicked(evt);
                            }
                        });
                        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable1KeyPressed(evt);
                            }
                        });
                        if (jTable1.getColumnModel().getColumnCount() > 0) {
                            jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
                            jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable1.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable1.getColumnModel().getColumn(6).setMaxWidth(30);
                        }
                        jScrollPane1.setViewportView(jTable1);
                        if (jTable1.getColumnModel().getColumnCount() > 0) {
                            jTable1.getColumnModel().getColumn(0).setPreferredWidth(120);
                            jTable1.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable1.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable1.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable1.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable1.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable1.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable1.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable1.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable1.getColumnModel().getColumn(6).setMaxWidth(30);
                        }
                        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

                        jLabel2.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel2.setText("Mężczyźni stabilni");

                        jButton2.setText("Zapisz w pliku");
                        jButton2.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                            }
                        });

                        jScrollPane5.setMaximumSize(new java.awt.Dimension(32767, 332));
                        jScrollPane5.setMinimumSize(new java.awt.Dimension(22, 332));
                        jScrollPane5.setPreferredSize(new java.awt.Dimension(453, 331));

                        jTable5.setBackground(new java.awt.Color(51, 51, 51));
                        jTable5.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jTable5.setRowHeight(35);
                        jTable5.setRowMargin(2);
                        jTable5.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable5.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable5MouseClicked(evt);
                            }
                        });
                        jTable5.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable5KeyPressed(evt);
                            }
                        });
                        jScrollPane5.setViewportView(jTable5);
                        if (jTable5.getColumnModel().getColumnCount() > 0) {
                            jTable5.getColumnModel().getColumn(0).setPreferredWidth(90);
                            jTable5.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable5.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable5.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable5.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable5.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable5.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable5.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable5.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable5.getColumnModel().getColumn(6).setMaxWidth(30);
                        }

                        jLabel5.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel5.setText("Kobiety stabilne");

                        jButton6.setText("Zapisz w pliku");
                        jButton6.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton6ActionPerformed(evt);
                            }
                        });

                        jTable6.setBackground(new java.awt.Color(51, 51, 51));
                        jTable6.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jTable6.setRowHeight(35);
                        jTable6.setRowMargin(2);
                        jTable6.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable6.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable6MouseClicked(evt);
                            }
                        });
                        jTable6.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable6KeyPressed(evt);
                            }
                        });
                        jScrollPane6.setViewportView(jTable6);
                        if (jTable6.getColumnModel().getColumnCount() > 0) {
                            jTable6.getColumnModel().getColumn(0).setPreferredWidth(90);
                            jTable6.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable6.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable6.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable6.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable6.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable6.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable6.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable6.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable6.getColumnModel().getColumn(6).setMaxWidth(30);
                        }

                        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel3.setText("Kobiety pilne");

                        jButton7.setText("Zapisz w pliku");
                        jButton7.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton7ActionPerformed(evt);
                            }
                        });

                        jTable2.setBackground(new java.awt.Color(51, 51, 51));
                        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jTable2.setRowHeight(35);
                        jTable2.setRowMargin(2);
                        jTable2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable2MouseClicked(evt);
                            }
                        });
                        jTable2.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable2KeyPressed(evt);
                            }
                        });
                        jScrollPane2.setViewportView(jTable2);
                        if (jTable2.getColumnModel().getColumnCount() > 0) {
                            jTable2.getColumnModel().getColumn(0).setPreferredWidth(90);
                            jTable2.getColumnModel().getColumn(0).setMaxWidth(90);
                            jTable2.getColumnModel().getColumn(1).setPreferredWidth(50);
                            jTable2.getColumnModel().getColumn(1).setMaxWidth(50);
                            jTable2.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable2.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable2.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable2.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable2.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable2.getColumnModel().getColumn(6).setMaxWidth(30);
                        }

                        jLabel4.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel4.setText("Mężczyźni pilni");

                        jButton3.setText("Zapisz w pliku");
                        jButton3.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                            }
                        });

                        jTable9.setBackground(new java.awt.Color(51, 51, 51));
                        jTable9.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jTable9.setRowHeight(30);
                        jTable9.setRowMargin(2);
                        jTable9.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable9.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable9MouseClicked(evt);
                            }
                        });
                        jTable9.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable9KeyPressed(evt);
                            }
                        });
                        jScrollPane9.setViewportView(jTable9);
                        if (jTable9.getColumnModel().getColumnCount() > 0) {
                            jTable9.getColumnModel().getColumn(0).setPreferredWidth(120);
                            jTable9.getColumnModel().getColumn(0).setMaxWidth(120);
                            jTable9.getColumnModel().getColumn(1).setPreferredWidth(70);
                            jTable9.getColumnModel().getColumn(1).setMaxWidth(70);
                            jTable9.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable9.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable9.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable9.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable9.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable9.getColumnModel().getColumn(6).setMaxWidth(30);
                        }

                        jTable10.setBackground(new java.awt.Color(51, 51, 51));
                        jTable10.setModel(new javax.swing.table.DefaultTableModel(
                            new Object [][] {

                            },
                            new String [] {
                                "Rodzaj ", "Łóżko", "Pacjent", "Kod", "Data przyjęcia", "Data wypisu", "index"
                            }
                        ));
                        jTable10.setRowHeight(30);
                        jTable10.setRowMargin(2);
                        jTable10.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                        jTable10.addMouseListener(new java.awt.event.MouseAdapter() {
                            public void mouseClicked(java.awt.event.MouseEvent evt) {
                                jTable10MouseClicked(evt);
                            }
                        });
                        jTable10.addKeyListener(new java.awt.event.KeyAdapter() {
                            public void keyPressed(java.awt.event.KeyEvent evt) {
                                jTable10KeyPressed(evt);
                            }
                        });
                        jScrollPane10.setViewportView(jTable10);
                        if (jTable10.getColumnModel().getColumnCount() > 0) {
                            jTable10.getColumnModel().getColumn(0).setPreferredWidth(120);
                            jTable10.getColumnModel().getColumn(0).setMaxWidth(120);
                            jTable10.getColumnModel().getColumn(1).setPreferredWidth(70);
                            jTable10.getColumnModel().getColumn(1).setMaxWidth(70);
                            jTable10.getColumnModel().getColumn(2).setPreferredWidth(110);
                            jTable10.getColumnModel().getColumn(2).setMaxWidth(110);
                            jTable10.getColumnModel().getColumn(3).setMinWidth(70);
                            jTable10.getColumnModel().getColumn(3).setMaxWidth(70);
                            jTable10.getColumnModel().getColumn(6).setPreferredWidth(30);
                            jTable10.getColumnModel().getColumn(6).setMaxWidth(30);
                        }

                        jButton9.setText("Zapisz w pliku");
                        jButton9.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton9ActionPerformed(evt);
                            }
                        });

                        jLabel16.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel16.setText("Kobiety niepełnosprawne");

                        jButton10.setText("Zapisz w pliku");
                        jButton10.addActionListener(new java.awt.event.ActionListener() {
                            public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton10ActionPerformed(evt);
                            }
                        });

                        jLabel17.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
                        jLabel17.setText("Mężczyźni niepełnosprawni");

                        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
                        jPanel3.setLayout(jPanel3Layout);
                        jPanel3Layout.setHorizontalGroup(
                            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton2))
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton6))
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton9))
                                    .addComponent(jScrollPane1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 118, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel3Layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(jButton3))
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGap(21, 21, 21))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton7)
                                            .addContainerGap()))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addComponent(jLabel17)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButton10))
                                            .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(20, 20, 20))))
                        );
                        jPanel3Layout.setVerticalGroup(
                            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jButton2))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel4)
                                        .addComponent(jButton3)))
                                .addGap(31, 31, 31)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(jButton6)
                                    .addComponent(jLabel3)
                                    .addComponent(jButton7))
                                .addGap(56, 56, 56)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel17)
                                        .addComponent(jButton10))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel16)
                                        .addComponent(jButton9)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        );

                        jScrollPane4.setViewportView(jPanel3);

                        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                        getContentPane().setLayout(layout);
                        layout.setHorizontalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap(26, Short.MAX_VALUE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 1334, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(444, 444, 444)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(TF2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())
                        );
                        layout.setVerticalGroup(
                            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGap(30, 30, 30))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TF2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1)
                                    .addComponent(jLabel1)
                                    .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        );

                        jScrollPane4.getVerticalScrollBar().setUnitIncrement(16);

                        pack();
                    }// </editor-fold>//GEN-END:initComponents
    private void sortByDate(List <KolejkaObj> list)
    {
       for(int i=1;i<list.size();i++)
        {
            for(int j=0;j<list.size()-i;j++)
            {
            String dataP = list.get(j).getData_poczatku();
            StringTokenizer token = new StringTokenizer(dataP, ".");
            int dzien = Integer.parseInt(token.nextToken());
            int miesiac = Integer.parseInt(token.nextToken());
            int rok = Integer.parseInt(token.nextToken());
            GregorianCalendar cal = new GregorianCalendar(rok, miesiac - 1, dzien);
            Date datap = cal.getTime();
            String dataP2 = list.get(j+1).getData_poczatku();
            StringTokenizer token2 = new StringTokenizer(dataP2, ".");
            int dzien2 = Integer.parseInt(token2.nextToken());
            int miesiac2 = Integer.parseInt(token2.nextToken());
            int rok2 = Integer.parseInt(token2.nextToken());
            GregorianCalendar cal2 = new GregorianCalendar(rok2, miesiac2 - 1, dzien2);
            Date datap2 = cal2.getTime();
           if(datap.compareTo(datap2)==1)
           {

               Collections.swap(list, j, j+1);
              
           }
           
            }
        }
      
       
    }
  private void sortByDate(KolejkaObj[] list)
    {
       for(int i=1;i<list.length;i++)
        {
            for(int j=0;j<list.length-i;j++)
            {
            String dataP = list[j].getData_poczatku();
            StringTokenizer token = new StringTokenizer(dataP, ".");
            int dzien = Integer.parseInt(token.nextToken());
            int miesiac = Integer.parseInt(token.nextToken());
            int rok = Integer.parseInt(token.nextToken());
            GregorianCalendar cal = new GregorianCalendar(rok, miesiac - 1, dzien);
            Date datap = cal.getTime();
            String dataP2 = list[j+1].getData_poczatku();
            StringTokenizer token2 = new StringTokenizer(dataP2, ".");
            int dzien2 = Integer.parseInt(token2.nextToken());
            int miesiac2 = Integer.parseInt(token2.nextToken());
            int rok2 = Integer.parseInt(token2.nextToken());
            GregorianCalendar cal2 = new GregorianCalendar(rok2, miesiac2 - 1, dzien2);
            Date datap2 = cal2.getTime();
           if(datap.compareTo(datap2)==1)
           {

             KolejkaObj temp = list[j];
             list[j]=list[j+1];
             list[j+1]=temp;
              
           }
           
            }
        }
      
       
    }

    private void TF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF2ActionPerformed

    private void TF2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF2KeyTyped
        String x = TF2.getText();
        int y = x.length();

        if (!jestLiczba(evt.getKeyChar())) {
            evt.consume();
        }

        if (y == 11) {
            evt.consume();
        }

    }//GEN-LAST:event_TF2KeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        for (int i = 0; i < jTable1.getRowCount(); i++) {
            jTable1.removeRowSelectionInterval(i, i);
        }
        String pacjent = TF2.getText();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        DefaultTableModel model1 = (DefaultTableModel) jTable2.getModel();
        DefaultTableModel model2 = (DefaultTableModel) jTable5.getModel();
        DefaultTableModel model3 = (DefaultTableModel) jTable6.getModel();
        DefaultTableModel model9 = (DefaultTableModel) jTable9.getModel();
        DefaultTableModel model10 = (DefaultTableModel) jTable10.getModel();

        for (int i = 0; i < jTable1.getRowCount(); i++) {
            String x = (String) model.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable1.addRowSelectionInterval(i, i);
                jTable1.scrollRectToVisible(jTable1.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable2.getRowCount(); i++) {
            String x = (String) model1.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable2.addRowSelectionInterval(i, i);
                jTable2.scrollRectToVisible(jTable2.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable5.getRowCount(); i++) {
            String x = (String) model2.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable5.addRowSelectionInterval(i, i);
                jTable5.scrollRectToVisible(jTable5.getCellRect(i, 0, true));

            }
        }
        for (int i = 0; i < jTable6.getRowCount(); i++) {
            String x = (String) model3.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable6.addRowSelectionInterval(i, i);
                jTable6.scrollRectToVisible(jTable6.getCellRect(i, 0, true));

            }
            
        }
          for (int i = 0; i < jTable9.getRowCount(); i++) {
            String x = (String) model9.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable9.addRowSelectionInterval(i, i);
                jTable9.scrollRectToVisible(jTable9.getCellRect(i, 0, true));

            }
            
        }
            for (int i = 0; i < jTable10.getRowCount(); i++) {
            String x = (String) model10.getValueAt(i, 2);
            if (pacjent.equals(x)) {
                jTable10.addRowSelectionInterval(i, i);
                jTable10.scrollRectToVisible(jTable10.getCellRect(i, 0, true));

            }
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable1.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable1.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable1.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jTable1.clearSelection();
        p = evt.getPoint();
        tabela = jTable1;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable1.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
            switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }
            popup.show(jTable1, p.x, p.y);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed

    }//GEN-LAST:event_jTable1KeyPressed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        jTable2.clearSelection();
        p = evt.getPoint();
        tabela = jTable2;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
       DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable2.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
           switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }
            popup.show(jTable2, p.x, p.y);
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable2KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2KeyPressed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable2.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable2.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable2.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3MouseClicked

    private void jTable3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable3KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable3KeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable5MouseClicked
        jTable5.clearSelection();
        p = evt.getPoint();
        tabela = jTable5;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable5.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
             switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }

        popup.show(jTable5, p.x, p.y);
        
        }
    }//GEN-LAST:event_jTable5MouseClicked

    private void jTable5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable5KeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable5.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable5.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable5.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTable6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable6MouseClicked
        jTable6.clearSelection();
        p = evt.getPoint();
        tabela = jTable6;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
       DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable6.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
            switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }
            popup.show(jTable6, p.x, p.y);
        }
    }//GEN-LAST:event_jTable6MouseClicked

    private void jTable6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable6KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable6KeyPressed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable6.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable6.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable6.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
    zapisz();
    }//GEN-LAST:event_zapiszButtonActionPerformed
    void zapisz()
    {
        lista2.clear();
     DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String rodzaj = model.getValueAt(count,0).toString();
     String lozko = model.getValueAt(count,1).toString();
     String pacjent = model.getValueAt(count,2).toString();
     String kod = model.getValueAt(count,3).toString();
     String dataP = model.getValueAt(count,4).toString();
     String dataK = model.getValueAt(count,5).toString();
      String ii =  model.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
     }
      DefaultTableModel model2 = (DefaultTableModel)jTable2.getModel();
     for (int count = 0; count < model2.getRowCount(); count++){
     String rodzaj = model2.getValueAt(count,0).toString();
     String lozko = model2.getValueAt(count,1).toString();
     String pacjent = model2.getValueAt(count,2).toString();
     String kod = model2.getValueAt(count,3).toString();
     String dataP = model2.getValueAt(count,4).toString();
     String dataK = model2.getValueAt(count,5).toString();
      String ii =  model2.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
     }
      DefaultTableModel model3 = (DefaultTableModel)jTable5.getModel();
     for (int count = 0; count < model3.getRowCount(); count++){
     String rodzaj = model3.getValueAt(count,0).toString();
     String lozko = model3.getValueAt(count,1).toString();
     String pacjent = model3.getValueAt(count,2).toString();
     String kod = model3.getValueAt(count,3).toString();
     String dataP = model3.getValueAt(count,4).toString();
     String dataK = model3.getValueAt(count,5).toString();
      String ii =  model3.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
     }
      DefaultTableModel model4 = (DefaultTableModel)jTable6.getModel();
     for (int count = 0; count < model4.getRowCount(); count++){
     String rodzaj = model4.getValueAt(count,0).toString();
     String lozko = model4.getValueAt(count,1).toString();
     String pacjent = model4.getValueAt(count,2).toString();
     String kod = model4.getValueAt(count,3).toString();
     String dataP = model4.getValueAt(count,4).toString();
     String dataK = model4.getValueAt(count,5).toString();
     String ii =  model4.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
    }
      DefaultTableModel model9 = (DefaultTableModel)jTable9.getModel();
     for (int count = 0; count < model9.getRowCount(); count++){
     String rodzaj = model9.getValueAt(count,0).toString();
     String lozko = model9.getValueAt(count,1).toString();
     String pacjent = model9.getValueAt(count,2).toString();
     String kod = model9.getValueAt(count,3).toString();
     String dataP = model9.getValueAt(count,4).toString();
     String dataK = model9.getValueAt(count,5).toString();
      String ii =  model9.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
     }
      DefaultTableModel model10 = (DefaultTableModel)jTable10.getModel();
     for (int count = 0; count < model10.getRowCount(); count++){
     String rodzaj = model10.getValueAt(count,0).toString();
     String lozko = model10.getValueAt(count,1).toString();
     String pacjent = model10.getValueAt(count,2).toString();
     String kod = model10.getValueAt(count,3).toString();
     String dataP = model10.getValueAt(count,4).toString();
     String dataK = model10.getValueAt(count,5).toString();
      String ii =  model10.getValueAt(count,6).toString();
    int index = Integer.parseInt(ii);
     lista2.add(new KolejkaObj(rodzaj,lozko,pacjent,dataP,dataK,kod,index));
     }
     File file = new File("baza/kolejka.txt");
     file.delete();
     String x = "------- --------- -------- 10.10.2999 10.10.2999  123";
         try 
         {            
             PrintWriter zapis = new PrintWriter(new FileWriter("baza/kolejka.txt"));
             zapis.println(x);
             for(KolejkaObj element: lista2)
             {
                 String el = element.toString();
                 zapis.println(el);
             }
             zapis.close();
         }  
         catch (IOException ex) 
         {
             Logger.getLogger(Ustaw_swieta.class.getName()).log(Level.SEVERE, null, ex);
         }

         try 
         {                 
             PrintWriter zapis = new PrintWriter(new FileWriter("baza/lozka.txt"));
             for(lozka element: main.lista)
             {
                 String el = element.toString2();
                 zapis.println(el);
             }
             zapis.close();
         }  
         catch (IOException ex) 
         {
             Logger.getLogger(Ustaw_swieta.class.getName()).log(Level.SEVERE, null, ex);
         }  
         main.setLista(main.lista);
         JOptionPane.showMessageDialog(this, "Zapisano");
         zapis(false);
         lista2.clear();
    }
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
         if(zmiany == true)
        {
            int a = JOptionPane.showConfirmDialog(this,"Nie zapisano zmian \n        Zapisać?");
            if(a==JOptionPane.YES_OPTION)
            {
                zapisz();
            }
            else if(a==JOptionPane.NO_OPTION)
            {
                 new Main().setVisible(true);
        this.dispose();
            }
        }
        else
        {
            new Main().setVisible(true);
        this.dispose();
        }
        
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
         if(zmiany == true)
        {
            int a = JOptionPane.showConfirmDialog(this,"Nie zapisano zmian \n        Zapisać?");
            if(a==JOptionPane.YES_OPTION)
            {
                zapisz();
            }
            else if(a==JOptionPane.NO_OPTION)
            {
                System.exit(0);
            }
        }
        else
        {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        String temp = jComboBox2.getSelectedItem().toString();
         List<String> lozka = new LinkedList<>();
        for(lozka element : main.lista)
        {
            if(element.getRodzaj().equals(temp))
            {
            String tempp = element.getPokoj();
            lozka.add(tempp);
            }
        }
        DefaultComboBoxModel dml= new DefaultComboBoxModel();
        for (int i = 0; i <lozka.size(); i++) {
        dml.addElement(lozka.get(i));
}

        jComboBox1.setModel(dml);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
         String x = jTextField1.getText();
        int y = x.length();
        
        if(!jestLiczba(evt.getKeyChar()))
            evt.consume();
 
        if(y == 11)
            evt.consume();
      
    }//GEN-LAST:event_jTextField1KeyTyped

    private void jTextField2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyTyped
        String x = jTextField2.getText();
        int y = x.length();
        
        if(!jestLiczba(evt.getKeyChar()))
            evt.consume();
 
        if(y == 6)
            evt.consume();
    }//GEN-LAST:event_jTextField2KeyTyped

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       lista2.clear();
       try 
       {
        String rodzaj = jComboBox2.getSelectedItem().toString();
       String pokoj = jComboBox1.getSelectedItem().toString();
        String pacjent = jTextField1.getText();
         String kod = jTextField2.getText(); 
         Date date = jDateChooser1.getDate();
        
           switch(rodzaj)
       {
           case "M.Stabilny":
           {
               tabela = jTable1;
               break;
           }
           case "M.Pilny":
           {
               tabela = jTable2;
               break;
           }
           case "K.Stabilna":
           {
               tabela = jTable5;
               break;
           }
           case "K.Pilna":
           {
               tabela = jTable6;
               break;
           }
            case "K.Niepelnosprawna":
           {
               tabela = jTable9;
               break;
           }
           case "M.Niepelnosprawny":
           {
               tabela = jTable10;
               break;
           }
       }
     DefaultTableModel model = (DefaultTableModel)tabela.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String rodzaj2 = model.getValueAt(count,0).toString();
     String lozko2 = model.getValueAt(count,1).toString();
     String pacjent2 = model.getValueAt(count,2).toString();
     String kod2 = model.getValueAt(count,3).toString();
     String dataP2 = model.getValueAt(count,4).toString();
     String dataK2 = model.getValueAt(count,5).toString();
     String i =  model.getValueAt(count,6).toString();
     int index2 = Integer.parseInt(i);
     lista2.add(new KolejkaObj(rodzaj2,lozko2,pacjent2,dataP2,dataK2,kod2,index2));
     }
     for(KolejkaObj element:lista2)
     {
         if(pokoj.equals(element.getPokoj()))
         {  
             int i = element.getIndex();
             
             if(i==3||i==4||i==5)
             {
               last = element.getDataKoncaDate();
             }
         }
     }
        
        System.out.println(last);
         Ustaw_swieta sw = new Ustaw_swieta();
         SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
         String data_string = formatter.format(date);
         String  dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);

         if(rodzaj.length()<1)
         {
             JOptionPane.showMessageDialog(this, "Nie wybrano rodzaju");
         }
         else if(pokoj.length()<1)
         {
             JOptionPane.showMessageDialog(this, "Nie ma łóżka dla tego rodzaju pacjenta");
         }
         else if(pacjent.length()<1)
         {
             JOptionPane.showMessageDialog(this, "Niepoprawny numer pacjenta");
         }
          else if(kod.length()<1)
         {
             JOptionPane.showMessageDialog(this, "Niepoprawny kod pacjenta");
         }
         
           else if(date.compareTo(last)==-1 || date.compareTo(last)==0)
          {
              JOptionPane.showMessageDialog(this, "Data dodawanego pacjenta musi być późniejsza niż data zwolnienia ostatniego pacjenta oznaczona kolorem niebieskim lub zielonym");
          }
          
          else if(sw.sprawdz_swieta(data_string, dayOfWeek)==true)
                     {
                            boolean zm  = true; 
                            int temp = 0;
                         Calendar cal = Calendar.getInstance();    
                            
                     while(zm==true)
                     {                 
                            cal.setTime(date); 
                            cal.add(Calendar.DAY_OF_MONTH,1);
                            date = cal.getTime();  
                            data_string = formatter.format(date);
                            dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(date);
                            Ustaw_swieta swi = new Ustaw_swieta();
                            zm = swi.sprawdz_swieta(data_string ,dayOfWeek);                  
                     }
                     
                     int a =  JOptionPane.showConfirmDialog(this, "W tym dniu występuje święto lub jest to weekend \n Zapisać na: "+ data_string);
                     if(a == JOptionPane.YES_OPTION)
                     {
                          dodaj( rodzaj, pokoj,  pacjent ,  kod,  date  );
                     }
                     }
         else
          {
                         dodaj( rodzaj, pokoj,  pacjent ,  kod,  date  );
          }
       }
       catch(Exception ex)
          {
              JOptionPane.showMessageDialog(this,"Błąd");          
        
    }//GEN-LAST:event_jButton8ActionPerformed
    }
    private void jTable9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable9MouseClicked
       jTable9.clearSelection();
        p = evt.getPoint();
        tabela = jTable9;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
      DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable9.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
            switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }
            popup.show(jTable9, p.x, p.y);}
    }//GEN-LAST:event_jTable9MouseClicked

    private void jTable9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable9KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable9KeyPressed

    private void jTable10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable10MouseClicked
          jTable10.clearSelection();
        p = evt.getPoint();
        tabela = jTable10;
        int rowAtPoint = tabela.rowAtPoint(p);
        tabela.addRowSelectionInterval(rowAtPoint, rowAtPoint);
        DefaultTableModel model = (DefaultTableModel) tabela.getModel();
        rowAtPoint = jTable10.rowAtPoint(p);
        String x = model.getValueAt(rowAtPoint, 6).toString();
        stan = Integer.parseInt(x);
        
        if (isRightMouseButton(evt)) {
            switch(stan)
            {
                case 1:
                     menuItem2.setForeground(new Color(0,0,0));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 3:
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(0,0,0));
                    menuItem4.setForeground(new Color(0,0,0));
                    break;
                case 4:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                    menuItem.setForeground(new Color(179, 179, 179));
                    menuItem4.setForeground(new Color(179, 179, 179));
                    break;
                case 5:
                    menuItem2.setForeground(new Color(179, 179, 179));
                    menuItem3.setForeground(new Color(179, 179, 179));
                     menuItem.setForeground(new Color(0,0,0));
                     menuItem4.setForeground(new Color(179, 179, 179));
                    break;
            }
            popup.show(jTable10, p.x, p.y);}
    }//GEN-LAST:event_jTable10MouseClicked

    private void jTable10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable10KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable10KeyPressed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable9.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable9.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable9.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

        
    }                                        

    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
         FileOutputStream excelFOU = null;
        BufferedOutputStream excelBOU = null;
        XSSFWorkbook excelJTableExporter = null;

        JFileChooser excelFileChooser = new JFileChooser("C:\\Users\\admin\\Desktop");
        excelFileChooser.setDialogTitle("Save As");
        FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES", "xls", "xlsx", "xlxs");
        excelFileChooser.setFileFilter(fnef);
        int excelChooser = excelFileChooser.showSaveDialog(null);

        if (excelChooser == JFileChooser.APPROVE_OPTION) {

            try {
                excelJTableExporter = new XSSFWorkbook();
                XSSFSheet excelSheet = excelJTableExporter.createSheet("Jtable Export");
                for (int i = 0; i < jTable10.getRowCount(); i++) {
                    XSSFRow excelRow = excelSheet.createRow(i);
                    for (int j = 0; j < jTable10.getColumnCount(); j++) {
                        XSSFCell excelCell = excelRow.createCell(j);

                        excelCell.setCellValue(jTable10.getValueAt(i, j).toString());
                    }
                }
                excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile() + ".xlsx");
                excelBOU = new BufferedOutputStream(excelFOU);
                excelJTableExporter.write(excelBOU);
                JOptionPane.showMessageDialog(null, "Zapisano pomyslnie.");
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                try {
                    if (excelBOU != null) {
                        excelBOU.close();
                    }
                    if (excelFOU != null) {
                        excelFOU.close();
                    }

                    if (excelJTableExporter != null) {
                        excelJTableExporter.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
               }
    }                                        
    }//GEN-LAST:event_jButton10ActionPerformed
   Date dataL;
   Date last;
   String data_dodania_string;
   public void dodaj(String rodzaj,String pokoj, String pacjent , String kod, Date date  )
   {
      
       lista2.clear();
       switch(rodzaj)
       {
           case "M.Stabilny":
           {
               tabela = jTable1;
               break;
           }
           case "M.Pilny":
           {
               tabela = jTable2;
               break;
           }
           case "K.Stabilna":
           {
               tabela = jTable5;
               break;
           }
           case "K.Pilna":
           {
               tabela = jTable6;
               break;
           }
           case "K.Niepelnosprawna":
           {
               tabela = jTable9;
               break;
           }
           case "M.Niepelnosprawny":
           {
               tabela = jTable10;
               break;
           }
       }
       
       DefaultTableModel model = (DefaultTableModel)tabela.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String rodzaj2 = model.getValueAt(count,0).toString();
     String lozko2 = model.getValueAt(count,1).toString();
     String pacjent2 = model.getValueAt(count,2).toString();
     String kod2 = model.getValueAt(count,3).toString();
     String dataP2 = model.getValueAt(count,4).toString();
     String dataK2 = model.getValueAt(count,5).toString();
     String i =  model.getValueAt(count,6).toString();
    int index2 = Integer.parseInt(i);
     lista2.add(new KolejkaObj(rodzaj2,lozko2,pacjent2,dataP2,dataK2,kod2,index2));
     }
     
     KolejkaObj[] tab = new KolejkaObj[lista2.size()+1];
     tab = new KolejkaObj[lista2.size()+1];
     data_poczatku = date; 
     Calendar call = Calendar.getInstance();
     call.setTime(data_poczatku);
     call.add(Calendar.DAY_OF_MONTH, 21);
     data_poczatku  = call.getTime();
    for(KolejkaObj element : lista2)
    {
      if(element.getPokoj().equals(pokoj))
      { 
        StringTokenizer token = new StringTokenizer(element.getData_konca(),".");
        int dzien = Integer.parseInt(token.nextToken());
        int miesiac = Integer.parseInt(token.nextToken());
        int rok = Integer.parseInt(token.nextToken());
        GregorianCalendar cal = new GregorianCalendar(rok,miesiac-1,dzien);
        Date dataKoncaListy = cal.getTime(); 
        
        if(date.compareTo(dataKoncaListy) == 1)
        {
            int i = lista2.indexOf(element);
            tab[i] = element;
        }
        
        else if(date.compareTo(dataKoncaListy) == -1||date.compareTo(dataKoncaListy) == 0)           
        {
                temp = true;
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                String dataa = format.format(data_poczatku);
                String dziennn = new SimpleDateFormat("EEEE", Locale.ENGLISH).format( data_poczatku);
                Ustaw_swieta sw = new Ustaw_swieta();
                
             if(sw.sprawdz_swieta(dataa,dziennn)==true)
             {   
                 
             boolean x = true;
             
             while(x==true)
             {                    
                cal.setTime( data_poczatku); 
                cal.add(Calendar.DAY_OF_MONTH,1);
                 data_poczatku = cal.getTime();  
                Ustaw_swieta swi = new Ustaw_swieta();
                String dzienn;
                 dzienn = new SimpleDateFormat("EEEE", Locale.ENGLISH).format( data_poczatku);
                String data =  format.format( data_poczatku);
               x = swi.sprawdz_swieta(data, dzienn);
             }
             }
             cal.setTime(data_poczatku);
             cal.add(Calendar.DAY_OF_MONTH, 21);
             data_konca = cal.getTime();
             int i = lista2.indexOf(element);
             SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
             String data_pocz = formatter.format(data_poczatku);
             String data_kon  = formatter.format(data_konca);
             element.setData_poczatku(data_pocz);
             element.setData_konca(data_kon);             
             tab[i+1] = element;
             data_poczatku= data_konca;
        }
          
   
   
      }
      else
      {
          int i = lista2.indexOf(element);  
          if(temp == false)
          {
            tab[i] = element;
          }
          else
          {
            tab[i+1]=element;
            temp = false;
          }
      }
       int i =0;
       for(KolejkaObj el:tab)
    { 
    if(el == null)
    {
       SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
       String temp = format.format(date);
       Calendar cal4 = Calendar.getInstance();
       cal4.setTime(date);
       cal4.add(Calendar.DAY_OF_MONTH,21);
       Date d = cal4.getTime();
       String temp2 = format.format(d);       
       tab[i] = new KolejkaObj(rodzaj, pokoj,  pacjent ,temp , temp2  ,  kod ,1);  
    }
        i++;
    }
      } 
        
       model.getDataVector().removeAllElements();
       model.fireTableDataChanged();
       sortByDate(tab);
      for(int i = 0 ;i<tab.length;i++)
      {
          SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
       String temp = format.format(date);
           if(tab[i].getData_poczatku().equals(temp)&&tab[i].getKod()==kod)
         {
             this.z=i;
         }
         model.addRow(new Object[]{tab[i].getRodzaj(),tab[i].getPokoj(),tab[i].getPacjent(),tab[i].getKod(),tab[i].getData_poczatku(),tab[i].getData_konca(),tab[i].getIndex()});
        
      }
      
       tabela.addRowSelectionInterval(z, z);
      lista2.clear();
      zapis(true);
    
   }
   int z=0;
   boolean temp=false;
   Date data_poczatku;
   Date data_konca;
    
    private boolean jestLiczba(char zn) {
        if (zn >= '0' && zn <= '9') {
            return true;
        }
        return false;
    }
    private void popupMenu(JFrame frame) {
      lista2.clear();
        menuItem = new JMenuItem(
                "Usuń"
        );
       menuItem.getAccessibleContext().setAccessibleDescription("Usuń");
       menuItem.addActionListener(new ActionListener() {
       @Override
            public void actionPerformed(ActionEvent ae) {
                
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int rowAtPoint = tabela.rowAtPoint(p);
                String ix = model.getValueAt(rowAtPoint, 6).toString();
                int indeX = Integer.parseInt(ix);
                String data = model.getValueAt(rowAtPoint, 5).toString();
                String pesel = model.getValueAt(rowAtPoint,2).toString();
                StringTokenizer token = new StringTokenizer(data, ".");
                int dzien = Integer.parseInt(token.nextToken());
                int miesiac = Integer.parseInt(token.nextToken());
                int rok = Integer.parseInt(token.nextToken());
                GregorianCalendar cal = new GregorianCalendar(rok, miesiac - 1, dzien);
                Date chosenDate = cal.getTime();
                
                GregorianCalendar cal2 = new GregorianCalendar();
                Date now = cal2.getTime();
                
                 for(int i=0;i<tabela.getRowCount();i++)
                {
                    String temp = model.getValueAt(i, 6).toString();
                    int tempo = Integer.parseInt(temp);
                    if(tempo == 3 && i>rowAtPoint)
                    {
                        tempp = true;
                    }
                }
                  if(indeX == 4)
                {
                    JOptionPane.showMessageDialog(null, "Nie można usunąć trwającej rehabilitacji");
                }
                 else if(indeX == 3)
                {
                    JOptionPane.showMessageDialog(null, "Powiadomiono pacjenta, nie można usunąć");
                }
                else if(indeX == 1 && tempp == false)
                {
                    zapis(true);
                    for (int count = 0; count < model.getRowCount(); count++) {
                        
                            String rodzaj = model.getValueAt(count, 0).toString();
                            String lozko = model.getValueAt(count, 1).toString();
                            String pacjent = model.getValueAt(count, 2).toString();
                            String kod = (String) model.getValueAt(count, 3);
                            String data_poczatku = (String)model.getValueAt(count, 4);
                            String data_konca = model.getValueAt(count, 5).toString();
                            String i =  model.getValueAt(count,6).toString();
                            int index = Integer.parseInt(i);
                            lista2.add(new KolejkaObj(rodzaj, lozko, pacjent, data_poczatku, data_konca, kod,index));
                    }
                  for (int count = model.getRowCount()-1; count >= 0; count--) {
                        String d = lista2.get(count).getData_konca();
                        StringTokenizer token2 = new StringTokenizer(d, ".");
                        int dzien2 = Integer.parseInt(token2.nextToken());
                       int miesiac2 = Integer.parseInt(token2.nextToken());
                       int rok2 = Integer.parseInt(token2.nextToken());
                       GregorianCalendar cal3 = new GregorianCalendar(rok2, miesiac2 - 1, dzien2);
                       Date chosenDate2 = cal3.getTime();
                       if ((chosenDate.compareTo(chosenDate2) == -1 || chosenDate.compareTo(chosenDate2) == 0)) {
                           kod2 = lista2.get(count).getKod();
                           pacjent2 = lista2.get(count).getPacjent();

                           lista2.get(count).setKod(kod1);
                           lista2.get(count).setPacjent(pacjent1);


                           kod1 = kod2;
                           pacjent1 = pacjent2;

                       }
                   }               
                   lista2.remove(lista2.size() - 1);
                   model.getDataVector().removeAllElements();
                   model.fireTableDataChanged();
                   for (KolejkaObj element : lista2) {
                       model.addRow(new Object[]{element.getRodzaj(), element.getPokoj(), element.getPacjent(), element.getKod(), element.getData_poczatku(), element.getData_konca(), element.getIndex()});
                   }
                   JOptionPane.showMessageDialog(null, "Usunięto pacjenta o peslu: "+pesel);
                   lista2.clear();
               }
                else {
                   tempp = false;
                   JOptionPane.showMessageDialog(null, "Powiadomiono pacjenta z późniejszą datą, nie można usunąć tej pozycji");
               }
           }
            boolean tempp = false;

        });
      
       popup.add(menuItem); 
 
          menuItem2 = new JMenuItem(
                "Powiadomiono"
        );
          menuItem2.getAccessibleContext().setAccessibleDescription("Powiadomiono");
        menuItem2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int rowAtPoint = tabela.rowAtPoint(p);
                String x = model.getValueAt(rowAtPoint, 6).toString();
                int i = Integer.parseInt(x);
                if(i==1)
                {
                    model.setValueAt(3, rowAtPoint, 6);
                    zapis(true);
                }
            }
        });
        
      popup.add(menuItem2);
       
         menuItem3 = new JMenuItem(
                "Anuluj powiadomienie"
        );
          menuItem3.getAccessibleContext().setAccessibleDescription("Anuluj powiadomienie");
        menuItem3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int rowAtPoint = tabela.rowAtPoint(p);
                String x = model.getValueAt(rowAtPoint, 6).toString();
                int i = Integer.parseInt(x);
                if(i==3)
                {
                    model.setValueAt(1, rowAtPoint, 6);
                    zapis(true);
                }
            }
        });
        
      popup.add(menuItem3);
      
        menuItem4 = new JMenuItem(
                "Zmień pacjenta"
        );
        
          menuItem4.getAccessibleContext().setAccessibleDescription("Zmień pacjenta");
        menuItem4.addActionListener(new ActionListener() {
                
            @Override
            
            public void actionPerformed(ActionEvent ae) {
                DefaultTableModel model = (DefaultTableModel) tabela.getModel();
                int rowAtPoint = tabela.rowAtPoint(p);
                
                String x = model.getValueAt(rowAtPoint, 6).toString();
                int i = Integer.parseInt(x);
                if(i==3)
                {
                    String code = JOptionPane.showInputDialog(
                     null, 
                     " Wprowadz pesel pacjenta", 
                        "Wprowadz pesel pacjenta", 
        JOptionPane.QUESTION_MESSAGE
    );
                    if(code.length()==11)
                    {
                        model.setValueAt(code, rowAtPoint, 2);
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Nieprawidłowa forma kodu pesel");
                    }
                    zapis(true);
                }
            }
        });
     popup.add(menuItem4);   
    }
    private String pacjentdod;
    private String koddod;
    private String pacjent;
    private String kod;
    private String kodd;
    private String pacjentt;  
    private String kod1;
    private String kod2;    
    private String pacjent1;
    private String pacjent2;
    private String lozko1;
    private String lozko2;

    public void zapis(boolean zmiany)
    {
        this.zmiany = zmiany;
        if(zmiany == false)
        {
            zapiszButton.setBackground(new Color(222,222,222));
        }
        else if(zmiany == true)
        {
            zapiszButton.setBackground(new Color(255, 153, 153));
        }
    } 

    private List<KolejkaObj> Lista = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TF2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable10;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTable jTable5;
    private javax.swing.JTable jTable6;
    private javax.swing.JTable jTable9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JButton zapiszButton;
    // End of variables declaration//GEN-END:variables
    private JPopupMenu popup = new JPopupMenu();
    private JMenuItem menuItem = null;
    private JMenuItem menuItem2 = null;
    private JMenuItem menuItem3 = null;
    private JMenuItem menuItem4 = null;
    private JTable tabela;
    private Point p;
    private JScrollPane scpane;
    public List<KolejkaObj> lista2 = new LinkedList<>();
    int stan;
    private Main main = new Main();
    boolean zmiany = false;
}

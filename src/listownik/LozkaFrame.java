
package listownik;

import java.awt.Color;
import java.awt.Toolkit;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class LozkaFrame extends javax.swing.JFrame {


    public LozkaFrame() {
        super("Edycja łózek");
        this.setResizable(false);
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
        initComponents();
          
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        for(lozka element : main.lista)
        {
            String x = "123456789";
            if(!element.getKod().equals(x))
            {
            Date d = element.getData_konca();
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String da = format.format(d);
           model.addRow(new Object[]{element.getRodzaj(),element.getPokoj(),da,element.getPacjent(),element.getKod()});
            }
        }
         lbLozek(main.lista);
    }
   private void lbLozek(List<lozka> lista)
   { 
       int MScount=0;
           int MPcount=0;
           int KScount=0;
           int KPcount=0;
           int KNcount=0;
           int MNcount=0;
           DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
       for(int i=0;i<model.getRowCount();i++)
       {
           
           String rodzaj = (String) model.getValueAt(i,0);
 
           switch(rodzaj)
           {
                case "M.Stabilny":
           {
              MScount+=1;
               break;
           }
           case "M.Pilny":
           {
               MPcount++;
               break;
           }
           case "K.Stabilna":
           {
               KScount++;
               break;
           }
           case "K.Pilna":
           {
               KPcount++;
               break;
           }
           case "K.Niepelnosprawna":
           {
               KNcount++;
               break;
           }
           case "M.Niepelnosprawny":
           {
               MNcount++;
               break;
           }
           }
          
       }
        jLabel10.setText(Integer.toString(MPcount));
           jLabel12.setText(Integer.toString(MScount));
           jLabel13.setText(Integer.toString(KScount));
           jLabel14.setText(Integer.toString(KPcount));
           jLabel15.setText(Integer.toString(MNcount));
           jLabel16.setText(Integer.toString(KNcount));
           jLabel17.setText(Integer.toString(model.getRowCount()));
   }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};
            jButton5 = new javax.swing.JButton();
            zapiszButton = new javax.swing.JButton();
            jDateChooser1 = new com.toedter.calendar.JDateChooser();
            jTextField1 = new javax.swing.JTextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel2 = new javax.swing.JLabel();
            jButton1 = new javax.swing.JButton();
            jButton2 = new javax.swing.JButton();
            jComboBox1 = new javax.swing.JComboBox<>();
            jLabel3 = new javax.swing.JLabel();
            jButton3 = new javax.swing.JButton();
            jPanel1 = new javax.swing.JPanel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();
            jLabel11 = new javax.swing.JLabel();
            jLabel12 = new javax.swing.JLabel();
            jLabel13 = new javax.swing.JLabel();
            jLabel14 = new javax.swing.JLabel();
            jLabel15 = new javax.swing.JLabel();
            jLabel16 = new javax.swing.JLabel();
            jLabel17 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            addWindowListener(new java.awt.event.WindowAdapter() {
                public void windowClosed(java.awt.event.WindowEvent evt) {
                    formWindowClosed(evt);
                }
                public void windowClosing(java.awt.event.WindowEvent evt) {
                    formWindowClosing(evt);
                }
            });

            jTable1.setForeground(new java.awt.Color(0, 0, 0));
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Rodzaj", "Łóżko", "Data Początkowa", "Ostatni pacjent", "Ocena "
                }
            ));
            jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            jTable1.setRowHeight(30);
            jTable1.setRowMargin(2);
            jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    jTable1MouseClicked(evt);
                }
            });
            jScrollPane1.setViewportView(jTable1);
            if (jTable1.getColumnModel().getColumnCount() > 0) {
                jTable1.getColumnModel().getColumn(0).setPreferredWidth(70);
                jTable1.getColumnModel().getColumn(1).setPreferredWidth(70);
                jTable1.getColumnModel().getColumn(2).setPreferredWidth(100);
                jTable1.getColumnModel().getColumn(3).setPreferredWidth(80);
                jTable1.getColumnModel().getColumn(4).setPreferredWidth(50);
            }

            jButton5.setText("<< Powrót ");
            jButton5.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton5ActionPerformed(evt);
                }
            });

            zapiszButton.setText("Zapisz zmiany");
            zapiszButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    zapiszButtonActionPerformed(evt);
                }
            });

            jLabel1.setText("Łóżko:");

            jLabel2.setText("Data początkowa: ");

            jButton1.setForeground(new java.awt.Color(11, 157, 2));
            jButton1.setText("Dodaj łóżko");
            jButton1.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton1ActionPerformed(evt);
                }
            });

            jButton2.setText("Edytuj");
            jButton2.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton2ActionPerformed(evt);
                }
            });

            jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "M.Stabilny", "M.Pilny", "K.Stabilna", "K.Pilna","M.Niepelnosprawny","K.Niepelnosprawna" }));

            jLabel3.setText("Rodzaj:");

            jButton3.setForeground(new java.awt.Color(255, 23, 0));
            jButton3.setText("Usuń łóżko");
            jButton3.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    jButton3ActionPerformed(evt);
                }
            });

            jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

            jLabel4.setText("M. Pilni ");

            jLabel5.setText("M. Stabilni");

            jLabel6.setText("K. Stabilne");

            jLabel7.setText("K. Pilne");

            jLabel8.setText("M. Niepełnosprawni");

            jLabel9.setText("K. Niepełnosprawne");

            jLabel10.setText("jLabel10");

            jLabel11.setText("Wszystkie ");

            jLabel12.setText("jLabel10");

            jLabel13.setText("jLabel10");

            jLabel14.setText("jLabel10");

            jLabel15.setText("jLabel10");

            jLabel16.setText("jLabel10");

            jLabel17.setText("jLabel10");

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel13))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel14))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel15))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel16))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel17)))
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap(29, Short.MAX_VALUE))
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel10))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jLabel12))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel13))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel14))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(jLabel15))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(jLabel16))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel11)
                        .addComponent(jLabel17))
                    .addContainerGap(14, Short.MAX_VALUE))
            );

            jLabel12.getAccessibleContext().setAccessibleName("jLabel11");
            jLabel13.getAccessibleContext().setAccessibleName("jLabel12");
            jLabel14.getAccessibleContext().setAccessibleName("jLabel13");
            jLabel15.getAccessibleContext().setAccessibleName("jLabel14");
            jLabel16.getAccessibleContext().setAccessibleName("jLabel14");
            jLabel17.getAccessibleContext().setAccessibleName("jLabel15");

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGap(27, 27, 27)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(0, 7, Short.MAX_VALUE)))
                    .addContainerGap())
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jLabel3))
                            .addGap(10, 10, 10))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE))
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap())
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

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

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
        zapisz();
    }//GEN-LAST:event_zapiszButtonActionPerformed
    private void zapisz()
    {
        zapis(false);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String rodzaj = model.getValueAt(count,0).toString();
     String pokoj = model.getValueAt(count,1).toString();
     String dataK = model.getValueAt(count,2).toString();
     String pacjent = model.getValueAt(count, 3).toString();
     String kod = model.getValueAt(count, 4).toString();
      StringTokenizer token = new StringTokenizer(dataK,".");
                 int dzien = Integer.parseInt(token.nextToken());
                 int miesiac = Integer.parseInt(token.nextToken());
                 int rok = Integer.parseInt(token.nextToken());
        GregorianCalendar cal = new GregorianCalendar(rok,miesiac-1,dzien);
        Date dataa = cal.getTime(); 
        Lista.add(new lozka(rodzaj,pokoj,dataa,pacjent,kod));
     }
        try 
         {                 
             PrintWriter zapis = new PrintWriter(new FileWriter("baza/lozka.txt"));
             zapis.println("------- ----------------- 10 10 2999 ------ 123456789");
             for(lozka element: Lista)
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
         JOptionPane.showMessageDialog(this, "Zapisano");
    }
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int x = jTable1.getSelectedRow();
        String rodzaj = (String) model.getValueAt(x, 0);
        String pokoj = (String) model.getValueAt(x, 1);
        String data  = (String) model.getValueAt(x, 2);
        StringTokenizer token = new StringTokenizer(data,".");
                 int dzien = Integer.parseInt(token.nextToken());
                 int miesiac = Integer.parseInt(token.nextToken());
                 int rok = Integer.parseInt(token.nextToken());
        GregorianCalendar cal = new GregorianCalendar(rok,miesiac-1,dzien);
        Date dataa = cal.getTime();
        jTextField1.setText(pokoj);
        jDateChooser1.setDate(dataa);
        jComboBox1.setSelectedItem(rodzaj);   
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        zapis(true); 
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int x = jTable1.getSelectedRow();
        String pokoj = jTextField1.getText();
        Date data = jDateChooser1.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String da = format.format(data);
        String rodzaj =  (String)jComboBox1.getSelectedItem();   
        model.setValueAt(rodzaj, x, 0);
        model.setValueAt(pokoj, x, 1);
        model.setValueAt(da, x, 2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       zapis(true);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        String pokoj = jTextField1.getText();
        String rodzaj =  (String)jComboBox1.getSelectedItem();  
        Date data = jDateChooser1.getDate();
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
            String da = format.format(data);
        model.addRow(new Object[]{rodzaj,pokoj,da,"--------","-----"});
        lbLozek(main.lista);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       zapis(true);
        DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
        int x = jTable1.getSelectedRow();
        model.removeRow(x);
         lbLozek(main.lista);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
      
    }//GEN-LAST:event_formWindowClosed

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
    void zapis(boolean zmiany)
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JButton zapiszButton;
    // End of variables declaration//GEN-END:variables
     public List<lozka> Lista = new LinkedList<>();
    Main main = new Main();
    boolean zmiany=false;
}

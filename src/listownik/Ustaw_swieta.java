package listownik;

import java.awt.Toolkit;
import java.io.*;
import java.lang.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

public class Ustaw_swieta extends JFrame {

    public Ustaw_swieta() {
        this.setResizable(false);
        initComponents();
        this.setTitle("Edycja świąt");
        wczytywanie(); 
    }
    private void wczytywanie()
    {
      try {
            BufferedReader reader = new BufferedReader(new FileReader("baza/swieta.txt"));
            String tresc;
            while ((tresc = reader.readLine()) != null) 
            {
               StringTokenizer token = new StringTokenizer(tresc," ");
               String nazwa = token.nextToken();
               String data = token.nextToken();
               ListaS.add(new listaSwiat(nazwa,data));
               DefaultTableModel model = (DefaultTableModel)Table.getModel();
               model.addRow(new Object[]{nazwa,data});
            }
            reader.close();
        }
      catch (IOException e) {
            System.out.println(e.getMessage());
        }   
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        Dodaj_button = new javax.swing.JButton();
        Edytuj_button = new javax.swing.JButton();
        jTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        UsuńButton = new javax.swing.JButton();
        zapiszButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable(){
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }};

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null},
                    {null, null, null, null}
                },
                new String [] {
                    "Title 1", "Title 2", "Title 3", "Title 4"
                }
            ));
            jScrollPane1.setViewportView(jTable1);

            jTextArea1.setColumns(20);
            jTextArea1.setRows(5);
            jScrollPane3.setViewportView(jTextArea1);

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));

            jLabel1.setText("Wybierz dzień swięta");

            Dodaj_button.setForeground(new java.awt.Color(11, 157, 2));
            Dodaj_button.setText("Dodaj");
            Dodaj_button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Dodaj_buttonActionPerformed(evt);
                }
            });

            Edytuj_button.setText("Edytuj");
            Edytuj_button.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    Edytuj_buttonActionPerformed(evt);
                }
            });

            jLabel2.setText("Nazwa święta");

            UsuńButton.setForeground(new java.awt.Color(255, 23, 0));
            UsuńButton.setText("Usuń");
            UsuńButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    UsuńButtonActionPerformed(evt);
                }
            });

            zapiszButton.setText("Zapisz zmiany");
            zapiszButton.addActionListener(new java.awt.event.ActionListener() {
                public void actionPerformed(java.awt.event.ActionEvent evt) {
                    zapiszButtonActionPerformed(evt);
                }
            });

            Table.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                new String [] {
                    "Nazwa święta", "Data"
                }
            ));
            Table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            Table.addMouseListener(new java.awt.event.MouseAdapter() {
                public void mouseClicked(java.awt.event.MouseEvent evt) {
                    TableMouseClicked(evt);
                }
            });
            Table.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    TableKeyPressed(evt);
                }
            });
            jScrollPane4.setViewportView(Table);

            javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(zapiszButton, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Edytuj_button)
                            .addGap(42, 42, 42)
                            .addComponent(UsuńButton)
                            .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(59, 59, 59)
                                            .addComponent(Dodaj_button))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(55, 55, 55)
                                            .addComponent(jLabel2)))
                                    .addGap(66, 66, 66))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(35, 35, 35)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(6, 6, 6)
                                            .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)))
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(Dodaj_button))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(Edytuj_button)
                                .addComponent(UsuńButton))
                            .addContainerGap(25, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(zapiszButton)
                            .addContainerGap())))
            );

            javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
            getContentPane().setLayout(layout);
            layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            );
            layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );

            pack();
        }// </editor-fold>//GEN-END:initComponents

    private void Dodaj_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Dodaj_buttonActionPerformed
          try
          {
           SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");
           String data = dataFormat.format(jDateChooser.getDate());
           DefaultTableModel model = (DefaultTableModel)Table.getModel();
           String nazwa = jTextField.getText();
           nazwa = nazwa.replaceAll(" ","_").toLowerCase();
           if(nazwa.length()>1)
           {
               model.addRow(new Object[]{nazwa,data});             
           }
           else
           {
               JOptionPane.showMessageDialog(jPanel1,"Nie wprowadczono nazwy"); 
           }
          }
          catch(Exception ex)
          {
              JOptionPane.showMessageDialog(jPanel1,"Wprowadz date");
          }
    }//GEN-LAST:event_Dodaj_buttonActionPerformed

    private void TableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TableKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_TableKeyPressed

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
       try
       {   
           DefaultTableModel model = (DefaultTableModel)Table.getModel();
            int row = Table.getSelectedRow();
            String nazwa = model.getValueAt(row,0).toString();
            Date date = new SimpleDateFormat("dd.MM.yyyy").parse((String)model.getValueAt(row, 1));  
            jDateChooser.setDate(date);
            jTextField.setText(nazwa);
       } 
       catch (ParseException ex) 
       {
            Logger.getLogger(Ustaw_swieta.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_TableMouseClicked

    private void Edytuj_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Edytuj_buttonActionPerformed
       try
          {
           SimpleDateFormat dataFormat = new SimpleDateFormat("dd.MM.yyyy");
           int row = Table.getSelectedRow();
           String data = dataFormat.format(jDateChooser.getDate());
           DefaultTableModel model = (DefaultTableModel)Table.getModel();
           String nazwa = jTextField.getText();
           if(nazwa.length()>1)
           {  
               model.setValueAt(data, row ,1);       
               model.setValueAt(nazwa, row , 0);
           }
           else
           {
               JOptionPane.showMessageDialog(jPanel1,"Nie wprowadczono nazwy");
           }
          }
          catch(Exception ex)
          {
              JOptionPane.showMessageDialog(jPanel1,"Wprowadz date");
          }
    }//GEN-LAST:event_Edytuj_buttonActionPerformed

    private void UsuńButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UsuńButtonActionPerformed

           int row = Table.getSelectedRow();
           DefaultTableModel model = (DefaultTableModel)Table.getModel();
           model.removeRow(row);
           
    }//GEN-LAST:event_UsuńButtonActionPerformed

    private void zapiszButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszButtonActionPerformed
     ListaS.clear();
     DefaultTableModel model = (DefaultTableModel)Table.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String nazwa = model.getValueAt(count,0).toString();
     String data = model.getValueAt(count,1).toString();
     ListaS.add(new listaSwiat(nazwa,data));
    }
     File file = new File("swieta.txt");
     file.delete();
         try 
         {            
             PrintWriter zapis = new PrintWriter(new FileWriter("baza/swieta.txt"));
             for(listaSwiat element: ListaS)
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
         JOptionPane.showMessageDialog(this, "Zapisano święta");
    }//GEN-LAST:event_zapiszButtonActionPerformed

    public boolean sprawdz_swieta(String data,String dayOfWeek)
    {      
        if( dayOfWeek.equals("Sunday")|| dayOfWeek.equals("Saturday"))
         {
             x=true;
         }
        for(listaSwiat element : ListaS)
        { 
          String dataa = element.getData();
         if(data.equals(dataa))  
         {   
             x=true;
         }
         
        }

        return x;
    }
    boolean x=false;
    
    
    
    class listaSwiat
    {
        public listaSwiat(String nazwa,String data)
        
        {
        this.data=data;
        this.nazwa=nazwa;
        }
        
        public String getNazwe()
        {
            return nazwa;
        }
        
        public String getData()
        {
            return data;
        }
        @Override
        public String toString()
        {
            return nazwa+" "+data;
        } 
        String nazwa;
        String data;
    }
          
    private  List<listaSwiat> ListaS = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Dodaj_button;
    private javax.swing.JButton Edytuj_button;
    private javax.swing.JTable Table;
    private javax.swing.JButton UsuńButton;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField;
    private javax.swing.JButton zapiszButton;
    // End of variables declaration//GEN-END:variables
}

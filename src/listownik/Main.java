package listownik;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import listownik.KolejkaObj;
import listownik.Lista;
import listownik.LozkaFrame;
import listownik.Ustaw_swieta;
import listownik.lozka;


public class Main extends javax.swing.JFrame {


    public Main() {
        
        super ("Kolejka Rehabilitacji");
        this.setResizable(false);
        initComponents();
        
         try {
            BufferedReader reader = new BufferedReader(new FileReader("baza/lozka.txt"));
            String tresc;
            while ((tresc = reader.readLine()) != null) 
            {
                StringTokenizer token = new StringTokenizer(tresc, " ");
                String gender = token.nextToken();
                String pokoj = token.nextToken();
                int dzien = Integer.parseInt(token.nextToken());
                int miesiac = Integer.parseInt(token.nextToken());
                int rok = Integer.parseInt(token.nextToken());
                String pacjent = token.nextToken();
                String kod = token.nextToken();
                String data = rok + " " + (miesiac - 1) + " " + dzien;
                GregorianCalendar kalendarz = new GregorianCalendar(rok, miesiac - 1, dzien);
                this.data_konca = kalendarz.getTime();
                lista.add(new lozka(gender, pokoj, data_konca, pacjent,kod));
                ListaBackup.add(new lozka(gender, pokoj, data_konca, pacjent,kod));
            }
            reader.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    
      void setLista(List<lozka> Lista)
   {
       this.lista = Lista;
   }
    
     void reset()
    {
        new Main().setVisible(true);
        System.exit(1);
    }
     
   private void sprawdzanie(String gender) 
    {
        lozka d = lista.get(0);
        Date dd = d.getData_konca();
        for (lozka element: lista) {
            Date ddd = element.getData_konca();
            String gen = element.getRodzaj();
            if (dd.compareTo(ddd) > 0 && gender.equals(gen)) {         
                dd = element.getData_konca();
            }
        }
        for (lozka element: lista) {
            if (element.getData_konca() == dd) {
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                String format = formatter.format(dd);
                pokoj = element.getPokoj();
                str = "Najszybciej dla:  " + gender + "  zwolni sie lozko na:  " + pokoj + "  dnia:  " + format;
            }
        }
    }
    String pokoj;
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        TF1 = new RoundedTextField();
        text1 = new javax.swing.JLabel();
        CB1 = new javax.swing.JComboBox<>();
        dodajbutton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        usunbutton = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        zapiszbutton = new javax.swing.JButton();
        TF2 = new RoundedTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 255, 255));
        setIconImage(Toolkit.getDefaultToolkit().getImage("icon.jpg"));
        setLocationByPlatform(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        TF1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TF1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF1.setAlignmentX(1.0F);
        TF1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF1ActionPerformed(evt);
            }
        });
        TF1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF1KeyTyped(evt);
            }
        });

        text1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        text1.setText("Pesel :");

        CB1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "M.Stabilny", "M.Pilny", "K.Stabilna", "K.Pilna","M.Niepelnosprawny","K.Niepelnosprawna" }));
        CB1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CB1ActionPerformed(evt);
            }
        });

        dodajbutton.setText("Dodaj");
        dodajbutton.setBorder(null);
        dodajbutton.setBorderPainted(false);
        dodajbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dodajbuttonActionPerformed(evt);
            }
        });
        dodajbutton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dodajbuttonKeyPressed(evt);
            }
        });

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jButton2.setText("Święta");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Rodzaj", "Łóżko", "Pesel", "Ocena", "Przyjęcie", "Wypis"
            }
        ));
        Table.setEnabled(false);
        Table.setRowHeight(30);
        Table.setRowMargin(2);
        jScrollPane4.setViewportView(Table);
        if (Table.getColumnModel().getColumnCount() > 0) {
            Table.getColumnModel().getColumn(0).setPreferredWidth(110);
            Table.getColumnModel().getColumn(0).setMaxWidth(160);
            Table.getColumnModel().getColumn(1).setMinWidth(70);
            Table.getColumnModel().getColumn(1).setPreferredWidth(50);
            Table.getColumnModel().getColumn(1).setMaxWidth(90);
            Table.getColumnModel().getColumn(2).setMinWidth(30);
            Table.getColumnModel().getColumn(2).setPreferredWidth(120);
            Table.getColumnModel().getColumn(2).setMaxWidth(100);
            Table.getColumnModel().getColumn(3).setMinWidth(70);
            Table.getColumnModel().getColumn(3).setMaxWidth(70);
            Table.getColumnModel().getColumn(4).setMaxWidth(100);
            Table.getColumnModel().getColumn(5).setMaxWidth(100);
        }

        usunbutton.setForeground(new java.awt.Color(255, 23, 0));
        usunbutton.setText("Usuń ostatnią pozycje");
        usunbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usunbuttonActionPerformed(evt);
            }
        });

        jButton4.setText("Podgląd kolejki");
        jButton4.setBorder(null);
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        zapiszbutton.setForeground(new java.awt.Color(11, 157, 2));
        zapiszbutton.setText("Zapisz kolejke");
        zapiszbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zapiszbuttonActionPerformed(evt);
            }
        });

        TF2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TF2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        TF2.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, dodajbutton, org.jdesktop.beansbinding.ELProperty.create("${selected}"), TF2, org.jdesktop.beansbinding.BeanProperty.create("selectionEnd"));
        bindingGroup.addBinding(binding);

        TF2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF2ActionPerformed(evt);
            }
        });
        TF2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TF2KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TF2KeyTyped(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel1.setText("Kod");

        jButton5.setText("Łóżka");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(TF1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(text1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(dodajbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(TF2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(41, 41, 41)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(usunbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(zapiszbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 607, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(text1)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(TF2)
                            .addComponent(TF1, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dodajbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(CB1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 176, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usunbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(zapiszbutton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.getAccessibleContext().setAccessibleName("Kod");

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TF1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF1ActionPerformed

    }//GEN-LAST:event_TF1ActionPerformed
 
    private void TF1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF1KeyTyped
        String x = TF1.getText();
        int y = x.length();
        
        if(!jestLiczba(evt.getKeyChar()))
            evt.consume();
 
        if(y == 11)
            evt.consume();
      
    }//GEN-LAST:event_TF1KeyTyped

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(zmiany == true)
        {
            int a = JOptionPane.showConfirmDialog(this,"Nie zapisano zmian \n        Zapisać?");
            if(a==JOptionPane.YES_OPTION)
            {
                zapisz();
            }
            else if(a==JOptionPane.NO_OPTION)
            {
                new Lista().setVisible(true);
        this.dispose();
            }
        }
        else
        {
           new Lista().setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void dodajbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dodajbuttonActionPerformed

        dodaj();
    }//GEN-LAST:event_dodajbuttonActionPerformed
    Date data_konca;
    String dayOfWeek;
   String data_string;
   
   private void dodaj()
   {
         pacjent = TF1.getText(); 
            rodzaj = CB1.getSelectedItem().toString();
            int x = pacjent.length();
            String y = TF2.getText();
            
            if (rodzaj != " " && x ==11) {

                sprawdzanie(rodzaj);
                int a = JOptionPane.showConfirmDialog(panel, str + "\n                              Czy wpisać pacjenta " + pacjent + " na dalszy termin?");
                if (a == JOptionPane.YES_OPTION) 
                { 
                    int index = index_finding(pokoj);
                    String pokoj1 = lista.get(index).getPokoj();
                    String gender = lista.get(index).getRodzaj();
                    Date data = lista.get(index).getData_konca();
                    String kod = lista.get(index).getKod();
                    if(y.length() < 1)
                    {
                        kod = "-------";
                    } 
                    else
                    {
                        kod = y;
                    }
                    
                    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                    Calendar cal = Calendar.getInstance();
                    cal.setTime(data);
                    cal.add(Calendar.DAY_OF_MONTH,21);
                    Date data_dodana = cal.getTime();
                     
                    
                    DefaultTableModel model = (DefaultTableModel)Table.getModel();
                    String data_dodania_string = formatter.format(data_dodana);
                    
                    dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(data);
                     Ustaw_swieta sw = new Ustaw_swieta();
                     data_string = formatter.format(data);
                   dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(data);
                     if(sw.sprawdz_swieta(data_string, dayOfWeek)==true)
                     {
                            boolean zm  = true; 
                     while(zm==true)
                     {                           
                            cal.setTime(data); 
                            cal.add(Calendar.DAY_OF_MONTH,1);
                            data = cal.getTime();  
                            data_string = formatter.format(data);
                            dayOfWeek = new SimpleDateFormat("EEEE", Locale.ENGLISH).format(data);
                            Ustaw_swieta swi = new Ustaw_swieta();
                            zm = swi.sprawdz_swieta(data_string ,dayOfWeek);
                            cal.add(Calendar.DAY_OF_MONTH,21);
                            data_dodana = cal.getTime();
                            data_dodania_string = formatter.format(data_dodana);                         
                     }
                     int b = JOptionPane.showConfirmDialog(panel,"W tym dniu występuje święto, następny wolny termin to "+data_string+" Zapisać?");
                     if(b == JOptionPane.YES_OPTION)
                     {
                         lista.set(index, new lozka(gender,pokoj,data_dodana,pacjent,kod));
                          model.addRow(new Object[]{rodzaj,pokoj,pacjent,kod,data_string,data_dodania_string});        
                          zapis(true);
                     }
                }
                else
                     {
                         lista.set(index, new lozka(gender,pokoj,data_dodana,pacjent,kod));
                          model.addRow(new Object[]{rodzaj,pokoj,pacjent,kod,data_string,data_dodania_string});
                          zapis(true);
                     }
                }                  
            }
            else 
            {
                    JOptionPane.showMessageDialog(panel, "Nie wybrano rodzaju pacjenta albo za krótki pesel");
            }
            
            TF1.setText("");
            TF2.setText("");
            TF1.requestFocusInWindow();
   }
   
  
   
    public int index_finding(String pokoj)
    {     
        int y = 0;
        int x = 0 ;
        for(lozka element: lista) 
        {
            if(element.getPokoj().equals(pokoj))
            {
               y=x; 
            }
            x++;
        }
         return y;
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    
            Ustaw_swieta swieta = new Ustaw_swieta();
            swieta.setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void zapiszbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zapiszbuttonActionPerformed
        zapisz();
    }//GEN-LAST:event_zapiszbuttonActionPerformed
    private void zapisz()
    {
         zapis(false);
         ListaKolejki.clear();
     DefaultTableModel model = (DefaultTableModel)Table.getModel();
     for (int count = 0; count < model.getRowCount(); count++){
     String rodzaj = model.getValueAt(count,0).toString();
     String lozko = model.getValueAt(count,1).toString();
     String pacjent = model.getValueAt(count,2).toString();
     String kod = (String) model.getValueAt(count,3);
     String data_poczatku = model.getValueAt(count,4).toString();
     String data_konca = model.getValueAt(count,5).toString();
     
     ListaKolejki.add(new KolejkaObj( rodzaj, lozko, pacjent,  data_poczatku , data_konca , kod ,1 ));
    }

     for(lozka element: lista)
     {
         String pokoj = element.getPokoj();

         for(KolejkaObj el: ListaKolejki)
         {
             String pokoj2 = el.getPokoj();
             if(pokoj.equals(pokoj2))
             {
                 String dataa = el.getData_konca();
                 StringTokenizer token = new StringTokenizer(dataa,".");
                 int dzien = Integer.parseInt(token.nextToken());
                 int miesiac = Integer.parseInt(token.nextToken());
                 int rok = Integer.parseInt(token.nextToken());
                 GregorianCalendar cal = new GregorianCalendar(rok,miesiac-1,dzien);
                 String pacjent = element.getPacjent();
                 String kod = element.getKod();
                 Date datad = element.getData_konca();
                 datad = cal.getTime();
                 pacjent = el.getPacjent();  
                 kod = el.getKod();
             }
     }
     
     }
     
     File plik = new File("baza/lozka.txt");
     plik.delete();
     
        try {
            PrintWriter writer = new PrintWriter("baza/lozka.txt");
            for(lozka element : lista)
            {
                String x = element.toString2();
                writer.println(x);
            }
            writer.close();
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("baza/kolejka.txt",true));
            for(KolejkaObj element: ListaKolejki)
            {
                String x = element.toString();
                writer.append(x+"\n");
               
                
            }
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
     JOptionPane.showMessageDialog(panel, "Zapisano kolejke");
     model.getDataVector().removeAllElements();
     model.fireTableDataChanged();
    }
    private void usunbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usunbuttonActionPerformed
        zapis(true);
        int row = Table.getRowCount()-1;
        DefaultTableModel model = (DefaultTableModel)Table.getModel();
        String pokoj = (String) model.getValueAt(row, 1);
        for(int i=0;i<row;i++)
        {
            bol = false;
            String y = (String) model.getValueAt(i, 1);
            if(pokoj.equals(y))
            {
             pacjentt = (String) model.getValueAt(i,2);
             kod2 = (String) model.getValueAt(i, 3);
           String wypiss = (String) model.getValueAt(i,4);
            StringTokenizer token = new StringTokenizer(wypiss,".");
            int dzien = Integer.parseInt(token.nextToken());
            int miesiac = Integer.parseInt(token.nextToken());
            int rok = Integer.parseInt(token.nextToken());
            GregorianCalendar cal = new GregorianCalendar(rok,miesiac-1,dzien);
            dat = cal.getTime();
            bol=true;
            }
        }
        if(bol == true)
        {
           int x = index_finding(pokoj);
           lozka l = lista.get(x);
           lista.set(x, new lozka(l.getRodzaj(),l.getPokoj(),dat,pacjentt,kod2));
        }
        else
        {
              int x = index_finding(pokoj);
              lozka l = ListaBackup.get(x);                                                                         
              lista.set(x, new lozka(l.getRodzaj(),l.getPokoj(),l.getData_konca(),l.getPacjent(),l.getKod()));
        }
       model.removeRow(row);
    }//GEN-LAST:event_usunbuttonActionPerformed
    private String pacjentt;
    private String kod2;
    private Date dat;
    boolean bol = false;
    
    private void TF2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF2KeyTyped
        // TODO add your handling code here:
        String x = TF2.getText();
        int y = x.length();
        
        if(!jestLiczba(evt.getKeyChar()))
            evt.consume();
 
        if(y == 6)
            evt.consume();
    }//GEN-LAST:event_TF2KeyTyped

    private void TF2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF2ActionPerformed

    private void TF2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF2KeyPressed
           if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           {
            dodaj();
           }
    }//GEN-LAST:event_TF2KeyPressed

    private void dodajbuttonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dodajbuttonKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           {
            dodaj();
           }
    }//GEN-LAST:event_dodajbuttonKeyPressed

    private void TF1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TF1KeyPressed
         if(evt.getKeyCode()==KeyEvent.VK_ENTER)
           {
            TF2.grabFocus();
           }
    }//GEN-LAST:event_TF1KeyPressed

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
                new LozkaFrame().setVisible(true);
        this.dispose();
            }
        }
        else
        {
            new LozkaFrame().setVisible(true);
        this.dispose();
        }
        
    }//GEN-LAST:event_jButton5ActionPerformed

    private void CB1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CB1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CB1ActionPerformed

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
    
    
    private boolean jestLiczba(char zn)
    {
        if(zn >= '0' && zn <= '9')
        return true;
        
        return false;
    }                             
   private void zapis(boolean zmiany)
    {
        this.zmiany = zmiany;
        if(zmiany == false)
        {
            zapiszbutton.setBackground(new Color(222,222,222));
        }
        else if(zmiany == true)
        {
            zapiszbutton.setBackground(new Color(255, 153, 153));
        }
    } 

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB1;
    private javax.swing.JTextField TF1;
    private javax.swing.JTextField TF2;
    private javax.swing.JTable Table;
    private javax.swing.JButton dodajbutton;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel text1;
    private javax.swing.JButton usunbutton;
    private javax.swing.JButton zapiszbutton;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
    private JPanel panel = new JPanel(); 
    public List < lozka > lista = new LinkedList < > ();
    public List<KolejkaObj> ListaKolejki = new LinkedList<>();
    public List<lozka> ListaBackup = new LinkedList<>();
    private String rodzaj;
    private String pacjent;
    private String str;
    private boolean zmiany=false;
}

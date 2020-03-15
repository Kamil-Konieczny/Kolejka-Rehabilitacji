/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listownik;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

 
public class Renderer extends DefaultTableCellRenderer implements TableCellRenderer 
{
 
    public Renderer()
    {
        super.setOpaque(true);
    }
     
    /**
     *
     * @param table
     * @param value
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
    {
        
         Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
          value = table.getModel().getValueAt(row,6);
       
         if (value != null)
         {
        s = value.toString();
      }
         if(isSelected == true)
        {
            c.setBackground(new Color(0, 138, 230));
            c.setForeground(Color.BLACK); 
        }
         else
         {
       int i = Integer.parseInt(s);

             switch (i) {
                 case 1:
                     c.setBackground(new Color(255, 255, 255));
                     c.setForeground(Color.BLACK);
                     break;
                 case 2:
                     c.setBackground(new Color(255, 204, 204));
                     c.setForeground(Color.BLACK);
                     break;
                 case 3:
                     c.setBackground(new Color(179, 224, 255));
                     c.setForeground(Color.BLACK);
                     break;
                 case 4:
                     c.setBackground(new Color(204, 255, 204));
                     c.setForeground(Color.BLACK);
                     break;
                 case 5:
                     c.setBackground(new Color(255, 255, 255));
                     c.setForeground(Color.BLACK);
                     break;
             }
 }
       
        return this;
    }
     String s;
}


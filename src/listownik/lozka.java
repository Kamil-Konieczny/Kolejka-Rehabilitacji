package listownik;

import java.text.SimpleDateFormat;
import java.util.Date;

public class lozka {

   public lozka()
   {}
    public lozka(String rodzaj,String pokoj, Date data_konca , String pacjent,String kod)
    {
        this.rodzaj = rodzaj;
        this.pokoj = pokoj;
        this.data_konca = data_konca;
        this.pacjent = pacjent;  
        this.kod = kod;
    }    
    public String getRodzaj()
    {
        return rodzaj;
    }    
    public String getPokoj()
    {
        return pokoj;
    }   
    public Date getData_konca()
    {
        return data_konca;
    }
    public void setData_konca(Date data_konca)
    {
        this.data_konca = data_konca;
    }
     public void setRodzaj(String rodzaj)
    {
        this.rodzaj = rodzaj;
    }
    
    public String getPacjent()
    {
        return pacjent;
    }
    public String getKod()
    {
    return kod;  
    }
    @Override
      public String toString()
    {
        return rodzaj+" "+pokoj+" "+data_konca+" "+pacjent;
    }
   
    public String toString2()
    {
        SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
        String d = format.format(data_konca);
        return rodzaj+" "+pokoj+" "+d+" "+pacjent+" "+kod;
    }
    private String rodzaj;
    private String pokoj;
    private Date data_konca; 
    private String pacjent;
    private String kod;


}




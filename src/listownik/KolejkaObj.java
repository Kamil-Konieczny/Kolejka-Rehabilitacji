
package listownik;

import java.util.Date;

public class KolejkaObj {

   public KolejkaObj()
   {}
    public KolejkaObj(String rodzaj,String pokoj,String pacjent, String data_poczatku ,String data, String kod,int index )
    {
        this.rodzaj = rodzaj;
        this.pokoj = pokoj;
        this.pacjent = pacjent;  
        this.data = data;
        this.data_poczatku = data_poczatku;
        this.kod = kod;
        this.index = index;
    }
    public String getRodzaj()
    {
        return rodzaj;
    }
    
    public String getPokoj()
    {
        return pokoj;
    }
    public void setPokoj(String pokoj)
    {
        this.pokoj = pokoj;
    }
    
    public String getPacjent()
    {
        return pacjent;
    }
    public String getData_poczatku()
    {
        return data_poczatku;
    }
     public void setData_poczatku(String data_poczatku)
    {
        this.data_poczatku = data_poczatku;
    }
    public String getData_konca()
    {
        return data;
    }
    public void setData_konca(String data)
    {
        this.data = data;
    }
    
    public String getKod()
    {
        return kod;
    }
    public void setKod(String kod)
    {
        this.kod = kod;
    }
     public void setPacjent(String pacjent)
    {
        this.pacjent = pacjent;
    }
     public void setIndex()
     {
         this.index= index;
     }
     public int getIndex()
     {
         return index;
     }
    @Override     
        public String toString()
    {
        return rodzaj+" "+pokoj+" "+pacjent+" "+data_poczatku+" "+data+" "+kod+" "+index;
    }
      
    private String rodzaj;
    private String pokoj;
    private String data;
    private String data_poczatku;
    private String pacjent;
    private String kod;
    int index;

}




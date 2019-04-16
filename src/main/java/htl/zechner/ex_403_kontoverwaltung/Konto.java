/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.ex_403_kontoverwaltung;

import javax.swing.JLabel;

/**
 *
 * @author oskar
 */
public class Konto{
   private double amount;
   private JLabel kontostand;

    public Konto(int amount,JLabel kontostand) {
        this.amount = amount;
        this.kontostand=kontostand;
        setLabel();
    }

    public double getAmount() {
        return amount;
    }
    
   public  String withdraw(int m) throws NoMoneyException{
       if(this.amount<m){
           throw new NoMoneyException();
       }
       
       this.amount-=m;
       setLabel();
       return " withdraws: "+m;
   }
   
   public  String deposit(int m){
       this.amount+=m;
       setLabel();
       return "deposits: "+m;
   }
   
   public void setLabel(){
       kontostand.setText(String.format("%.2f Euro", amount));
   }
   
}

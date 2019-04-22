/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package htl.zechner.ex_403_kontoverwaltung;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTextArea;

/**
 *
 * @author oskar
 */
public class KontoBenutzer implements Runnable {

    private String name;
    private Konto konto;
    private JTextArea ta;

    public KontoBenutzer(String name, Konto konto, JTextArea ta) {
        this.name = name;
        this.konto = konto;
//        this.setName(name);

        this.ta = ta;
    }

    @Override
    public void run() {

        int i = 0;
        String out = "";
        Random r = new Random();
        while (i < 10) {
            System.out.println(Thread.currentThread().getName() + " starts");
            int betrag = 10 + r.nextInt(50 - 10 + 1);

            if (r.nextBoolean()) {
                System.out.println(Thread.currentThread().getName() + " deposits");
                synchronized (konto) {
                    out = konto.deposit(betrag);

                    ta.append(Thread.currentThread().getName() + " " + out + "\n");
                    System.out.println(Thread.currentThread().getName() + "did deposit");
                }
                i++;
            } else {
                System.out.println(Thread.currentThread().getName() + " withdraws");
                synchronized (konto) {
                    try {

                        out = konto.withdraw(betrag);
                        ta.append(Thread.currentThread().getName() + " " + out + "\n");
                        i++;
                    } catch (NoMoneyException ex) {
                        System.out.println("waits");
                        try {
                            konto.notifyAll();
                            konto.wait();
                        } catch (InterruptedException ex1) {
                            Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex1);
                        }

                        Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            try {
                Thread.sleep(1 + r.nextInt(1000));

            } catch (InterruptedException ex) {
                Logger.getLogger(KontoBenutzer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ta.append(Thread.currentThread().getName() + " has finished \n");
    }

    @Override
    public String toString() {
        return name;
    }

}

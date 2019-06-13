
import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Receve implements Runnable {
    private BufferedReader in;
    private String msg=null;
    public Receve(BufferedReader in) {
        this.in=in;
    }

    @Override
    public void run() {
        while(true){
            try {
                msg=in.readLine();
                System.out.println(msg);
            } catch (IOException ex) {
                Logger.getLogger(Receve.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

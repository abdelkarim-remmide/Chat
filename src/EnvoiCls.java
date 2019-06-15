
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class EnvoiCls implements Runnable{
    BufferedReader in;
    PrintWriter out;
    
    public void run() {
        /*String msg;
        msg = Serveur.jTextField1.getText().toString();
        out.println(msg);
        Serveur.jTextArea1.append(msg + "\n");
        out.flush();
        
        Socket s;
        
        for(ClientSocket elt: Serveur.cls){
            try {
                s = elt.getSocket();
                in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                out = new PrintWriter(s.getOutputStream());
                out.println(msg);
                Serveur.jTextArea1.append(msg + "\n");
                out.flush();
            } catch (IOException ex) {
                Logger.getLogger(EnvoiCls.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
        
    }
    
}

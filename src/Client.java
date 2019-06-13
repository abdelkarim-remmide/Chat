
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
 * @author DELL
 */
public class Client {
    
    public static void main(String[] args) {
        Socket s;
        try {
            s=new Socket("localhost",3200);
            Thread t=new Thread(new connection(s));
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class connection implements Runnable{
    private Socket s;
    private Thread t1,t2;
    private PrintWriter out;
    private BufferedReader in;
    public connection(Socket s){
        this.s =s;
    }

    @Override
    public void run() {
        try {
            in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            out=new PrintWriter(s.getOutputStream());
            t1=new Thread(new Send(out));
            t1.start();
            t2=new Thread(new Receve(in));
            t2.start();
        } catch (IOException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

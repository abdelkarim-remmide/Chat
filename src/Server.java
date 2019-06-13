
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
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
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket ss=new ServerSocket(3200);
            System.out.println("Power on and waiting for connection");
            Thread t=new Thread(new Accept(ss));
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

class Accept implements Runnable{
    private ServerSocket ss=null;
    private Socket s=null;
    private Thread t1,t2;
    private PrintWriter out;
    private BufferedReader in;
    public Accept(ServerSocket ss){
        this.ss=ss;
    }

    @Override
    public void run() {
        try {
            s=ss.accept();
            System.out.println("Client Connected ! ");
            in=new BufferedReader(new InputStreamReader(s.getInputStream()));
            out=new PrintWriter(s.getOutputStream());
            t1=new Thread(new Send(out));
            t1.start();
            t2=new Thread(new Receve(in));
            t2.start();

        } catch (IOException ex) {
            Logger.getLogger(Accept.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

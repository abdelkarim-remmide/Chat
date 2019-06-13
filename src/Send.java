
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Send implements Runnable{
    private PrintWriter out;
    private Scanner sc=null;
    private String msg=null;
    public Send(PrintWriter out){
        this.out=out;
    }

    @Override
    public void run() {
        sc=new Scanner(System.in);
        while(true){
            msg=sc.nextLine();
            out.println(msg);
            out.flush();
        }
    }
}

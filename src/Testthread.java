/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
/*
public class Testthread extends Thread {

    public void run(){
        for(int i=1;i<=10;i++)
            System.out.println(i+" "+getName());
    }
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<=5;i++){
            Thread t=new Testthread();
            t.start();
        }
    }
    
}*/

public class Testthread implements Runnable {

    public void run(){
        for(int i=1;i<=10;i++)
            System.out.println(i + " " + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        // TODO code application logic here
        for(int i=0;i<=5;i++){
            Testthread t1=new Testthread();
            Testthread t2=new Testthread();
            new Thread(t1).start();
            new Thread(t2).start();
        }
    }
    
}

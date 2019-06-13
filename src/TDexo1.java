/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class TDexo1 implements Runnable{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*TDexo1 maj=new TDexo1();
        TDexo1 min=new TDexo1();
        Thread t=new Thread(maj);
        t.setName("maj");
        Thread t2=new Thread(min);
        t2.setName("mim");
        t.run();
        t2.run();*/
        
        
        Maj maj1=new Maj();
        Min min1=new Min();
        maj1.run();
        min1.run();
        
        
    }

    @Override
    public void run() {
        if(Thread.currentThread().getName().equals("maj")){
          for(int i='A';i<='Z';i++){
                System.out.println((char)i);
          }
        }else{
           for(int i='a';i<='z';i++){
                System.out.println((char)i);
           }
        }
    }  
}

class Maj extends Thread{

    @Override
    public void run() {
        for(int i='A';i<='Z';i++){
                System.out.println((char)i);
        }    
    }
    
} 

class Min extends Thread{

    @Override
    public void run() {
        for(int i='a';i<='z';i++){
                System.out.println((char)i);
        }    
    }
    
} 
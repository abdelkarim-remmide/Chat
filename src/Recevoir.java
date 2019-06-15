
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.net.Socket;
import java.util.Base64;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class Recevoir implements Runnable{
    PrintWriter out;
    BufferedReader in;
    Socket cs;
    int id;
    public Recevoir(Socket s,int i){
        cs = s;
        id=i;
    }
    
    @Override
    public void run(){
        try {
            String msg;
            in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
            out = new PrintWriter(cs.getOutputStream());
            while(true){
                msg = in.readLine();
                msg=decrypt(msg);
                Serveur.jTextArea1.append("Client(" + id + ") :" + msg + "\n");
                if(msg.contains("#==>Client")){
                    String[] tempArray = msg.split("#==>Client");
                    String MsgToSend = tempArray[0]; 
                    String recipient = tempArray[1].trim();
                    System.out.println(recipient);
                    int recipientId=parseInt(recipient);
                    System.out.println(recipientId);
                    for (ClientSocket elt : Serveur.cls){ 
                        if (elt.getId()==recipientId){ 
                            Socket tmpSocket=elt.getSocket();
                            PrintWriter tmpOut=new PrintWriter(tmpSocket.getOutputStream());
                            tmpOut.println(encrypt("Client(" + id + ") :" + MsgToSend + "\n"));
                            tmpOut.flush();
                            break; 
                        } 
                    }
                }else{
                    for(ClientSocket elt: Serveur.cls){
                        if(elt.getId()!=id){
                            Socket tmpSocket=elt.getSocket();
                            PrintWriter tmpOut=new PrintWriter(tmpSocket.getOutputStream());
                            tmpOut.println(encrypt("Client(" + id + ") :" + msg + "\n"));
                            tmpOut.flush();
                            System.out.println("1");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(Recevoir.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


      
     private static final String key = "aesEncryptionKey";
    private static final String initVector = "encryptionIntVec";
 
    public static String encrypt(String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
    public static String decrypt(String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }  
}

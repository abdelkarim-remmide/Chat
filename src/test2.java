
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Base64;
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
 * @author DELL
 */
public class test2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // TODO code application logic here
            ServerSocket ss=new ServerSocket(3200);
            Socket s=ss.accept();
            /*BufferedReader br;
            br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            String str=br.readLine();
            System.out.println(str);*/
            InputStream inFromServer = s.getInputStream();
    DataInputStream in = new DataInputStream(inFromServer);
    String str=decrypt(in.readLine());
    System.out.println("Server says " + str);
        } catch (IOException ex) {
            Logger.getLogger(test2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private static final String key = "aesEncryptionKey";
private static final String initVector = "encryptionIntVec";
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

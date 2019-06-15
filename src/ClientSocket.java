
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author admin
 */
public class ClientSocket {
    private int id;
    private Socket cs;
    public ClientSocket(Socket s,int i){
        cs=s;
        id=i;
    }
    public int getId(){
        return id;
    }
    public Socket getSocket(){
        return cs;
    }
}

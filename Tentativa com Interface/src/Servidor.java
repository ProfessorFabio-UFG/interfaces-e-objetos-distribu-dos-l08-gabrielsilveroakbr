import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class Servidor implements Sopa {
    public Servidor() {
    }
    public String saySopa(){
        return  "Receita de sopa\n" +
                "500g de Coxão Mole Swift cortado em cubos\n" +
                "2 Caldos Culinários de Carne Swift\n" +
                "1L de água\n" +
                "1 colher (sopa) de Páprica Picante Swift\n" +
                "½ xícara (chá) de Cebola Picada Swift\n" +
                "2 batatas cortadas em cubos\n" +
                "1 chuchu cortado em cubos\n" +
                "1 cenoura cortada em cubos\n" +
                "1 xícara (chá) de macarrão para sopa\n" +
                "Sal a gosto\n" +
                "Cheiro-verde a gosto";
    }
    public double calculoMedia(int a, int b){
        return  (a+b)/2;
    }
    public static void main(String[] args) {

        try{
            Servidor obj = new Servidor();
            Sopa stub = (Sopa) UnicastRemoteObject.exportObject(obj, 0);

            // Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.rebind("Sopa", stub);

            System.err.println("Servidor pronto");
        } catch (Exception e) {
            System.err.println("Exceção de servidor : " + e.toString());
            e.printStackTrace();
        }
        }

    }


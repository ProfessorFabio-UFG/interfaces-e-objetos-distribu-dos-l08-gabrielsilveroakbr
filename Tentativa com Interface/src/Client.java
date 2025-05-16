
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class Client {
    public static void main(String[] args) {

        System.out.println("Iniciando o cliente");

        String host = "192.168.1.183"; //IP da maquina rodei em duas cada pasta com o Sopa.class interface
        int port = 1099;

        try{
            Registry registry = LocateRegistry.getRegistry(host,port);
            System.out.println("Conectado ao servidor RMI em " + host + ":" + port);
            Sopa stub = (Sopa) registry.lookup("Sopa");
            System.out.println("Servidor Encontradp");

            String response = stub.saySopa();
            System.out.println("resposta: " + response);

            double resp = stub.calculoMedia(100,1000);
            System.out.println("Resposta da Média: " + resp);

        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }

    }
}
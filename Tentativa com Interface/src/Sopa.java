import java.rmi.Remote;
import java.rmi.RemoteException;
public interface Sopa extends Remote {
    String saySopa() throws RemoteException;
    double calculoMedia(int a, int b) throws RemoteException;

}

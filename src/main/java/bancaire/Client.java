package bancaire;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Client extends Remote {
    BankManager getBankManager() throws RemoteException;
    String getName() throws RemoteException;
}

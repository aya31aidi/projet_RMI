package bancaire;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BankManager extends Remote {
    Account getAccount(String accountNumber) throws RemoteException;
    Client getClient(String clientName) throws RemoteException;
    boolean addAccount(String clientName, String accountNumber) throws RemoteException;
}

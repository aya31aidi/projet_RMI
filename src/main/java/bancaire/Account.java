package bancaire;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Account extends Remote {
    BankManager getBankManager() throws RemoteException;
    Client getClient() throws RemoteException;
    long getBalance() throws RemoteException;
    boolean deposit(long amount) throws RemoteException;
    boolean getCash(long amount) throws RemoteException;
}

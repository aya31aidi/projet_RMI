package bancaire;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AccountImpl extends UnicastRemoteObject implements Account {
    private BankManager bankManager;
    private Client client;
    private long balance;

    protected AccountImpl(BankManager bankManager, Client client) throws RemoteException {
        super();
        this.bankManager = bankManager;
        this.client = client;
        this.balance = 0;
    }

    @Override
    public BankManager getBankManager() throws RemoteException {
        return bankManager;
    }

    @Override
    public Client getClient() throws RemoteException {
        return client;
    }

    @Override
    public long getBalance() throws RemoteException {
        return balance;
    }

    @Override
    public boolean deposit(long amount) throws RemoteException {
        if (amount <= 0) {
            return false; // Montant invalide
        }
        balance += amount;
        return true;
    }

    @Override
    public boolean getCash(long amount) throws RemoteException {
        if (amount <= 0 || amount > balance) {
            return false; // Montant invalide ou solde insuffisant
        }
        balance -= amount;
        return true;
    }
}

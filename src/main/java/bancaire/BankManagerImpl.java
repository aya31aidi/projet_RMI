package bancaire;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class BankManagerImpl extends UnicastRemoteObject implements BankManager {
    private Map<String, Account> accounts;
    private Map<String, Client> clients;

    protected BankManagerImpl() throws RemoteException {
        super();
        accounts = new HashMap<>();
        clients = new HashMap<>();
    }

    @Override
    public Account getAccount(String accountNumber) throws RemoteException {
        return accounts.get(accountNumber);
    }

    @Override
    public Client getClient(String clientName) throws RemoteException {
        return clients.get(clientName);
    }

    @Override
    public boolean addAccount(String clientName, String accountNumber) throws RemoteException {
        if (!clients.containsKey(clientName)) {
            return false; // Le client n'existe pas
        }

        Client client = clients.get(clientName);
        Account account = new AccountImpl(this, client);
        accounts.put(accountNumber, account);
        return true;
    }
}

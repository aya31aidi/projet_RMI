package bancaire;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements Client {
    private String name;
    private BankManager bankManager;

    protected ClientImpl(String name, BankManager bankManager) throws RemoteException {
        super();
        this.name = name;
        this.bankManager = bankManager;
    }

    @Override
    public BankManager getBankManager() throws RemoteException {
        return bankManager;
    }

    @Override
    public String getName() throws RemoteException {
        return name;
    }
}


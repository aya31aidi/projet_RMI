package bancaire;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServeurBanqueRMI {
    public static void main(String[] args) {
        try {
            // Créer et démarrer le registre RMI
            LocateRegistry.createRegistry(1099);

            // Créer l'objet BankManagerImpl
            BankManager bankManager = new BankManagerImpl();

            // Publier l'objet BankManagerImpl dans le registre RMI
            Naming.rebind("rmi://localhost:1099/BankManager", bankManager);

            System.out.println("Serveur RMI prêt.");
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}


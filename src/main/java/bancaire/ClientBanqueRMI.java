package bancaire;
import java.rmi.Naming;

public class ClientBanqueRMI {
    public static void main(String[] args) {
        try {
            // Récupérer l'objet BankManager distant depuis le registre RMI
            BankManager bankManager = (BankManager) Naming.lookup("rmi://localhost:1099/BankManager");

            // Exemple : obtenir le nom du client
            String clientName = "Aya";

            // Exemple : obtenir le numéro de compte
            String accountNumber = "123457";

            // Utiliser l'objet BankManager pour effectuer des transactions bancaires
            // par exemple, ajouter un client et son compte
            boolean accountAdded = bankManager.addAccount(clientName, accountNumber);

            // Vérifier si le compte a été ajouté avec succès
            if (accountAdded) {
                // Afficher un message indiquant que le compte a été ajouté
                System.out.println("Le compte " + accountNumber + " a été ajouté pour le client " + clientName);
            } else {
                // Afficher un message en cas d'échec de l'ajout du compte
                System.out.println("Échec de l'ajout du compte pour le client " + clientName);
            }

            // Afficher un message indiquant que la connexion au serveur est établie
            System.out.println("Connexion au serveur RMI réussie.");

            // Effectuer d'autres opérations bancaires en utilisant les méthodes de l'interface BankManager
        } catch (Exception e) {
            System.err.println("Erreur : " + e);
        }
    }
}

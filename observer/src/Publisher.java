import java.util.ArrayList;
import java.util.List;

// Publisher (Loja que notifica)
class Publisher {
    private List<ObserverClient> clients = new ArrayList<>();
    private List<ObserverInfluencer> influencers = new ArrayList<>();

    // Adiciona clientes
    public void addClient(ObserverClient client) {
        if (client != null && !clients.contains(client)) {
            clients.add(client);
        }
    }

    // Adiciona influenciadores
    public void addInfluencer(ObserverInfluencer influencer) {
        if (influencer != null && !influencers.contains(influencer)) {
            influencers.add(influencer);
        }
    }

    // Remove um cliente
    public void removeClient(ObserverClient client) {
        clients.remove(client);
    }

    // Remove um influenciador
    public void removeInfluencer(ObserverInfluencer influencer) {
        influencers.remove(influencer);
    }

    // Notifica apenas os clientes
    public void notifyClients(String message) {
        System.out.println("\nNotificando apenas os clientes: " + message);
        for (ObserverClient client : clients) {
            client.update(message);
        }
    }

    // Notifica apenas os influenciadores
    public void notifyInfluencers(String message) {
        System.out.println("\nNotificando apenas os influenciadores: " + message);
        for (ObserverInfluencer influencer : influencers) {
            influencer.update(message);
        }
    }

    // Notifica todos os observadores
    public void notifyAllObservers(String message) {
        System.out.println("\nNotificando todos: " + message);

        for (ObserverClient client : clients) {
            client.update(message);
        }

        for (ObserverInfluencer influencer : influencers) {
            influencer.update(message);
        }
    }

    // Exibe os observadores cadastrados
    public void listObservers() {
        System.out.println("\nClientes cadastrados:");
        for (ObserverClient client : clients) {
            System.out.println("- " + client.getName() + " (" + client.getObserverType() + ")");
        }

        System.out.println("\nInfluenciadores cadastrados:");
        for (ObserverInfluencer influencer : influencers) {
            System.out.println("- " + influencer.getName() + " (" + influencer.getObserverType() + ")");
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // Criando novo publicador (loja)
        Publisher publisher = new Publisher();

        // Criando novos observadores (clientes)
        ObserverClient observer1 = new ObserverClient("Lucas");
        ObserverClient observer2 = new ObserverClient("Ezequiel");
        ObserverClient observer3 = new ObserverClient("Mário");

        // Criando influenciadores
        ObserverInfluencer influencer1 = new ObserverInfluencer("Ana");
        ObserverInfluencer influencer2 = new ObserverInfluencer("Henrique");

        // Adicionando clientes à lista
        publisher.addClient(observer1);
        publisher.addClient(observer2);
        publisher.addClient(observer3);

        // Adicionando influenciadores à lista
        publisher.addInfluencer(influencer1);
        publisher.addInfluencer(influencer2);

        // Publicando primeiro anúncio para todos os observadores
        System.out.println("\nPublicando primeiro anúncio para TODOS os assinantes:\n");
        publisher.notifyAllObservers(" OFERTA RELÂMPAGO: iPhone 15 Pro Max por R$1000 à vista ou 10x de R$100! \n");

        System.out.println("\n----------------------------------------------------");

        // Removendo um observador (cancelamento de assinatura)
        System.out.println("\n " + observer3.getName() + " cancelou a assinatura.");
        publisher.removeClient(observer3);

        // Publicando anúncios separados para influenciadores e clientes
        System.out.println("\nPublicando anúncio EXCLUSIVO para influenciadores:\n");
        publisher.notifyInfluencers("NOVA PARCERIA! Se você divulgar nossos produtos, ganha 20% de comissão por venda!\n");

        System.out.println("\n----------------------------------------------------");

        System.out.println("\nPublicando oferta EXCLUSIVA para CLIENTES cadastrados:\n");
        publisher.notifyClients(" GANHE FRETE GRÁTIS em todas as compras acima de R$300! \n");

        System.out.println("\n----------------------------------------------------");

        publisher.listObservers();
        

       
       
    }
}

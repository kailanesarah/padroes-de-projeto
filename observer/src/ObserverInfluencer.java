
import java.text.MessageFormat;

public class ObserverInfluencer implements ObserverInterface {

    private String name;

    public ObserverInfluencer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getObserverType() {
        return "Influenciador";
    }

    @Override
    public void update(String aviso) {
        System.out.println(MessageFormat.format(
                "Mensagem influencer {0}!!!\n"+
                "Não perca essa oportunidade, confira!\n{1}",
                getName(), aviso));

    }

}


import java.text.MessageFormat;

public class ObserverClient implements ObserverInterface {

    private String name;

    public ObserverClient(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getObserverType() {
        return "Cliente";
    }

    @Override
    public void update(String aviso) {
        System.out.println(MessageFormat.format(
                "{0} recebeu a promoção: \n{1}",
                getName(), aviso));
    }
}

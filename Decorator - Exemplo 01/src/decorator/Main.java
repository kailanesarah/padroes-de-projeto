interface DataSource {
    void writeData(String data);

    String readData();
}

// Implementação concreta: Escreve e lê arquivos
class FileDataSource implements DataSource {
    private String filename;

    public FileDataSource(String filename) {
        this.filename = filename;
    }

    @Override
    public void writeData(String data) {
        System.out.println("Writing data to file: " + filename);
        // Implementação real de escrita em arquivo iria aqui
    }

    @Override
    public String readData() {
        System.out.println("Reading data from file: " + filename);
        return "Dummy Data"; // Implementação real de leitura de arquivo iria aqui
    }
}

// Decorator base
class DataSourceDecorator implements DataSource {
    protected DataSource wrappee;

    public DataSourceDecorator(DataSource source) {
        this.wrappee = source;
    }

    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    @Override
    public String readData() {
        return wrappee.readData();
    }
}

// Decorator de Criptografia
class EncryptionDecorator extends DataSourceDecorator {
    public EncryptionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String encryptedData = "[Encrypted]" + data;
        System.out.println("Encrypting data");
        super.writeData(encryptedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        System.out.println("Decrypting data");
        return data.replace("[Encrypted]", "");
    }
}

// Decorator de Compressão
class CompressionDecorator extends DataSourceDecorator {
    public CompressionDecorator(DataSource source) {
        super(source);
    }

    @Override
    public void writeData(String data) {
        String compressedData = "[Compressed]" + data;
        System.out.println("Compressing data");
        super.writeData(compressedData);
    }

    @Override
    public String readData() {
        String data = super.readData();
        System.out.println("Decompressing data");
        return data.replace("[Compressed]", "");
    }
}

// Cliente
public class Main {
    public static void main(String[] args) {
        DataSource fileSource = new FileDataSource("data.txt");
        DataSource encryptedSource = new EncryptionDecorator(fileSource);
        DataSource compressedEncryptedSource = new CompressionDecorator(encryptedSource);

        System.out.println("Writing compressed and encrypted data:");
        compressedEncryptedSource.writeData("Hello, World!");

        System.out.println("Reading data:");
        String result = compressedEncryptedSource.readData();
        System.out.println("Final data: " + result);
    }
}

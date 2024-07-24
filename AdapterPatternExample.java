// 

// Target Interface
interface Printer {
    void print();
}

// Adaptee (Legacy Printer)
class LegacyPrinter {
    void printDocument() {
        System.out.println("Printing document using Legacy Printer");
    }
}

// Adapter
class PrinterAdapter implements Printer {
    private LegacyPrinter legacyPrinter;

    public PrinterAdapter(LegacyPrinter legacyPrinter) {
        this.legacyPrinter = legacyPrinter;
    }

    @Override
    public void print() {
        // Translate the request from Printer to LegacyPrinter
        legacyPrinter.printDocument();
    }
}

// Client code
public class AdapterPatternExample {
    public static void main(String[] args) {
        LegacyPrinter legacyPrinter = new LegacyPrinter();
        Printer printer = new PrinterAdapter(legacyPrinter);

        // Client uses the Printer interface, unaware of the underlying LegacyPrinter
        printer.print();
    }
}

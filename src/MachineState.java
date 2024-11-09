enum Comanda {
    PLASATA(true, false, false) {
        @Override
        public Comanda schimbaStare() {
            if (permiteTranzactia) {
                return PE_DRUM;
            }
            System.out.println("Tranzactia nu a putut fi procesata");
            return this;
        }
    }, PE_DRUM(false, true, false) {
        @Override
        public Comanda schimbaStare() {
            if (ajunsLaDestinatie) {
                return LIVRATA;
            }
            System.out.println("Comanda este inca pe drum");
            return this;
        }
    }, LIVRATA(false, false, true) {
        @Override
        public Comanda schimbaStare() {
            if (notOK) {
                return PLASATA;
            }
            System.out.println("Comanda a fost ok");
            return this;
        }
    };
    boolean permiteTranzactia;
    boolean ajunsLaDestinatie;
    boolean notOK;

    Comanda(boolean permiteTranzactia, boolean ajunsLaDestinatie, boolean notOK) {
        this.permiteTranzactia = permiteTranzactia;
        this.ajunsLaDestinatie = ajunsLaDestinatie;
        this.notOK = notOK;
    }

    public abstract Comanda schimbaStare();
}

public class MachineState {
    public static void main(String[] args) {
        System.out.println("Starea comenzii: " + Comanda.PLASATA);
        System.out.println("Tranzactia a fost efectuata cu succes: comanda " + Comanda.PLASATA.schimbaStare());
        System.out.println("Comanda a ajuns la destinatie: comanda " + Comanda.PE_DRUM.schimbaStare());
        System.out.println("Comanda nu a ajuns ok la destinatie. Se livreaza din nou comanda corecta: comanda " + Comanda.LIVRATA.schimbaStare());

    }
}

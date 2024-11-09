package Tema;

import java.util.ArrayList;
import java.util.List;

enum TipCladire {
    BLOC, CASA
}

class Localnic {
    private String nume;
    private int varsta;
    private String cnp;
    private List<Proprietate> proprietati;

    public Localnic(String nume, int varsta, String cnp) {
        this.nume = nume;
        this.varsta = varsta;
        this.cnp = cnp;
        this.proprietati = new ArrayList<>();
    }

    public void adaugaProprietate(Proprietate proprietate) {
        this.proprietati.add(proprietate);
    }

    public String getNume() {
        return nume;
    }

    public List<Proprietate> getProprietati() {
        return proprietati;
    }
}

abstract class Proprietate {
    private String numeStrada;
    private int numar;
    private int metriPatrati;

    public Proprietate(String numeStrada, int numar, int metriPatrati) {
        this.numeStrada = numeStrada;
        this.numar = numar;
        this.metriPatrati = metriPatrati;
    }

    public int getMetriPatrati() {
        return metriPatrati;
    }

    public abstract double getImpozit();

    @Override
    public String toString() {
        return "Strada: " + numeStrada + ", Numar=" + numar + ", Suprafata: " + metriPatrati + " mp";
    }
}

class Teren extends Proprietate {
    private int zona;

    public Teren(String numeStrada, int numar, int metriPatrati, int zona) {
        super(numeStrada, numar, metriPatrati);
        this.zona = zona;
    }

    @Override
    public double getImpozit() {
        return 10 * this.getMetriPatrati() + 0.1 * zona;
    }
}

class Cladire extends Proprietate {
    private TipCladire tipCladire;

    public Cladire(String numeStrada, int numar, int metriPatrati, TipCladire tipCladire) {
        super(numeStrada, numar, metriPatrati);
        this.tipCladire = tipCladire;
    }

    @Override
    public double getImpozit() {
        if (this.tipCladire == TipCladire.BLOC) {
            return 10 * this.getMetriPatrati();
        } else if (this.tipCladire == TipCladire.CASA) {
            return 100 + 30 * this.getMetriPatrati();
        }
        return 0;
    }
}

class Primarie {
    private static Primarie instance;

    private Primarie() {
    }

    public static Primarie getInstance() {
        if (instance == null) {
            instance = new Primarie();
        }
        return instance;
    }

    public void afisareImpozit(Localnic localnic) {
        System.out.println("Proprietatile lui " + localnic.getNume() + ":\n");
        double totalImpozit = 0;
        for (Proprietate proprietate : localnic.getProprietati()) {
            System.out.println(proprietate.toString());
            totalImpozit += proprietate.getImpozit();
        }
        System.out.println("Total impozit proprietati: " + totalImpozit);
    }
}

public class P6 {
    public static void main(String[] args) {
        Localnic localnic = new Localnic("Ion Popescu", 45, "1234567890123");

        localnic.adaugaProprietate(new Teren("Strada Verde", 10, 200, 5));
        localnic.adaugaProprietate(new Cladire("Strada Rosu", 22, 100, TipCladire.BLOC));
        localnic.adaugaProprietate(new Cladire("Strada Albastra", 35, 150, TipCladire.CASA));

        Primarie.getInstance().afisareImpozit(localnic);
    }
}

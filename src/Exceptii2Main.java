class ExceptieParinte extends Exception {

}

class ExceptieCopil1 extends ExceptieParinte {

}

class ExceptieCopil2 extends ExceptieParinte {

}

public class Exceptii2Main {
    public static void doSomething(int nr) throws ExceptieCopil1, ExceptieCopil2{
        if (nr < 0) {
            throw new ExceptieCopil1();
        } else {
            throw new ExceptieCopil2();
        }
    }

    public static void doSomething(ExceptieParinte e) {

    }

    public static void main(String[] args) {
        //varianta 1
        try {
            doSomething(5);
        } catch (ExceptieCopil1 e) {

        } catch (ExceptieCopil2 e) {

        }
        //varianta 2
        try {
            doSomething(5);
        } catch (ExceptieCopil1 f) {

        } catch (ExceptieCopil2 f) {

        } catch (ExceptieParinte e) {

        }
        //varianta 3
        try {
            doSomething(5);
        } catch (ExceptieCopil1 | ExceptieCopil2 f) {
            System.out.println("Eroare exceptie copil");
        } catch (ExceptieParinte e) {
            System.out.println("Eroare exceptie parinte");
        }
    }
}

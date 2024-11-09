/*Sa se construiasca o interfata Operation, cu metoda int doOperation
(int a, int b). Construiti un enum cu 4 constante: ADUNARE, SCADERE, INMULTIRE, IMPARTIRE.
 Fiecare constanta din enum va implementa interfata Operation si va realiza operatia
 corespunzatoare constantei (pentru ADUNARE: se aduna a+b, analog pentru celelalte
 constante).
	Demonstrati functionalitatea prin intermediul datelor de test din Main.
*/

//Exceptii verificate-trebuie prinse
//Neverificate-nu trebuie prinse
enum Operatii implements Operation {
    ADUNARE {
        @Override
        public int doOperation(int a, int b) {
            return a + b;
        }
    }, SCADERE {
        @Override
        public int doOperation(int a, int b) {
            return a - b;
        }
    }, INMULTIRE {
        @Override
        public int doOperation(int a, int b) {
            return a * b;
        }
    }, IMPARTIRE {
        @Override
        public int doOperation(int a, int b) {
            return a / b;
        }
    };
}

interface Operation {
    int doOperation(int a, int b);
}

public class P1 {
    public static void main(String[] args) {
        System.out.println(Operatii.ADUNARE.doOperation(10,5));
        System.out.println(Operatii.SCADERE.doOperation(10,5));
        System.out.println(Operatii.INMULTIRE.doOperation(10,5));
        System.out.println(Operatii.IMPARTIRE.doOperation(10,5));
    }
}

package Tema;

/*Construiti o metoda ce calculeaza cate numere dintr-un tablou primit ca parametru sunt
 mai mari decat 100. Numerele ar trebui sa fie pozitive. Construiti metoda astfel incat
 ea sa arunce cel putin doua tipuri de exceptii.
 */
class NegativeNumberException extends Exception {
    public NegativeNumberException(String message) {
        super(message);
    }
}

class EmptyArrayException extends RuntimeException {
    public EmptyArrayException(String message) {
        super(message);
    }
}

public class P2 {
    public static int numereMaiMariDeOSuta(int[] tablou) throws NegativeNumberException {
        if (tablou == null || tablou.length == 0) {
            throw new EmptyArrayException("Tabloul este null sau gol");
        }
        int count = 0;
        for (int i = 0; i < tablou.length; i++) {
            if (tablou[i] < 0) {
                throw new NegativeNumberException("Tabloul trebuie sa contina doar elemente intregi pozitive");
            }
            if (tablou[i] > 100) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] tablou1 = {-10, 5, 130, 56};
        int[] tablou2 = {145, 89, 234, 101, 6, 8};
        int[] tablou3 = {};
        try {
            System.out.println("Numere mai mari decat 100: " + numereMaiMariDeOSuta(tablou3));
        } catch (EmptyArrayException e) {
            System.out.println("Exceptie: " + e.getMessage());
        } catch (NegativeNumberException f) {
            System.out.println("Exceptie: " + f.getMessage());
        }
    }
}

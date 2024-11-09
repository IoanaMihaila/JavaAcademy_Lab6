package Tema;

/*Construiti o metoda care primeste ca parametru un tablou de numere intregi distincte
si un alt parametru, un numar intreg. Daca acel numar se afla in tablou va trebui sters,
 daca nu exista, sa se arunce excepție
 */
class NumarInexistentException extends Exception {
    public NumarInexistentException(String message) {
        super(message);
    }
}

public class P4 {
    public static int[] stergeNumar(int[] numere, int nr) throws NumarInexistentException {
        boolean gasit = false;
        int index = -1;
        for (int i = 0; i < numere.length; i++) {
            if (numere[i] == nr) {
                gasit = true;
                index = i;
                break;
            }
        }
        if (!gasit) {
            throw new NumarInexistentException("Numărul " + nr + " nu se află în tablou.");
        }
        int[] rezultat = new int[numere.length - 1];
        for (int i = 0, j = 0; i < numere.length; i++) {
            if (i != index) {
                rezultat[j++] = numere[i];
            }
        }

        return rezultat;
    }

    public static void main(String[] args) {
        int[] numere = {1, 2, 3, 4, 5};
        int numar = 5;
        try {
            int[] rezultat = stergeNumar(numere, numar);
            System.out.println("Tablou după ștergerea numărului " + numar + ":");
            for (int n : rezultat) {
                System.out.print(n + " ");
            }
        } catch (NumarInexistentException e) {
            System.out.println(e.getMessage());
        }
    }
}

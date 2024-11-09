package Tema;

/*Construiti cate un exemplu prin care sa demonstrati diferenta intre exceptiile
verificate si cele neverificate.
*/
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

class TooOldException extends RuntimeException {
    public TooOldException(String message) {
        super(message);
    }
}

public class P1 {
    public static void verificaVarsta(int varsta) throws InvalidAgeException {
        if (varsta < 18) {
            throw new InvalidAgeException("Varsta trebuie sa fie de minim 18 ani impliniti");
        }
        if (varsta > 70) {
            throw new TooOldException("Varsta depaseste limita maxima permisa(70 de ani)");
        }
        System.out.println("Varsta este valida");
    }

    public static void main(String[] args) {
        try {
            verificaVarsta(15);
        } catch (InvalidAgeException e) {
            System.out.println("Exceptie: " + e.getMessage());
        } catch (TooOldException f) {
            System.out.println("Exceptie: " + f.getMessage());
        }
    }
}

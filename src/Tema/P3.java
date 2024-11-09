package Tema;

/*Construiti o metoda (+ definiti exceptii) care sa aiba in semnatura sa o singura
exceptie pe care o declara ca o arunca, dar, in corpul metodei, sa arunce trei tipuri
de exceptii. Cum s-ar scrie metodele si exceptiile astfel incat sa nu existe eroare de
compilare?
 */
class EmptyTextException extends Exception {
    public EmptyTextException(String message) {
        super(message);
    }
}

class InvalidCharacterException extends RuntimeException {
    public InvalidCharacterException(String message) {
        super(message);
    }
}

class TextTooLongException extends RuntimeException {
    public TextTooLongException(String message) {
        super(message);
    }
}

public class P3 {
    public static void proceseazaText(String text) throws EmptyTextException {
        if (text.isEmpty() || text == null) {
            throw new EmptyTextException("Textul este null sau gol");
        }
        if (text.length() > 60) {
            throw new TextTooLongException("Textul contine prea multe caractere");
        }
        for (char c : text.toCharArray()) {
            if (c == '@' || c == '#') {
                throw new InvalidCharacterException("Textul contine caractere invalide: @ sau #");
            }
        }
        System.out.println("Textul are un format bun!");
    }

    public static void main(String[] args) {
        String text = "Acesta este un exemplu de text cu @caracter invalid";
        String text1 = "Acesta este un exemplu de text care contine prea multe caractere.............................";
        String text2 = "";
        String text3 = "Text ok!";
        try {
            proceseazaText(text1);
        } catch (EmptyTextException e) {
            System.out.println(e.getMessage());
        } catch (TextTooLongException f) {
            System.out.println(f.getMessage());
        } catch (InvalidCharacterException p) {
            System.out.println(p.getMessage());
        }
    }
}

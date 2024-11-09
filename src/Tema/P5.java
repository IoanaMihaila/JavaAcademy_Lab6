package Tema;

class Exc1 extends RuntimeException {
    public Exc1() {
    }
}

class Exc2 extends RuntimeException {
    public Exc2() {
    }
}

public class P5 {
    public void doSometh(int nr) {
        if (nr > 10) {
            throw new Exc1();
        } else {
            throw new Exc2();
        }
    }

}

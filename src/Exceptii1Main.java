//cazul 1:creez o exceptie verificata
class NumarNegativException extends Exception{
    public NumarNegativException(String message){
        super(message);
    }
}
class NumarPreaMareException extends RuntimeException{
    public NumarPreaMareException(String message){
        super(message);
    }
}

public class Exceptii1Main {
    //numerele sa fie pozitive
    //observam:
    // 1.exceptiile verificate trebuie declarate in semnatura metodei
    //2.exceptiile neverificate NU trebuie declarate in semnatura metodei
    //3.exceptiile neverificate POT FI declarate in semnatura metodei
    //4.daca nu vreau sa tratez o exceptie(try-catch) pot alege sa arunc exceptia mai departe(throws in semnatura metodei)
    public static int getMedie(int a,int b) throws NumarNegativException {
        if(a<0||b<0){
            throw new NumarNegativException("a sau b este negativ");
        }
        if(a>10||b>10){
            throw new NumarPreaMareException("a sau b este prea mare");
        }
        return (a+b)/2;
    }
    public static void main(String[] args) {
        try {
            System.out.println(getMedie(7, 8));
        }catch(NumarNegativException e) {
            //am prins exceptia si o afisam clientului
            System.out.println(e.getMessage());
            //throw new RunTimeException(e);
        }catch(NumarPreaMareException e){
            System.out.println(e.getMessage());
        }finally {
            //blocul finally se executa oricand, indiferent daca s-a aruncat exceptie sau nu
            //este util intr-o situatie de genul
            /*accesez un fisier de pe disc, l-am deschis in try, incerc sa citesc date de pe el,
            dar indiferent daca operatia a fost reusita cu succes sau nu, vom inchide fisierul*/
            System.out.println("Operatia a fost realizata");
        }
    }
}

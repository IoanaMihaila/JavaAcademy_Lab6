enum PaymentTransactions implements TransactionComplete{
    REJECTED,CLOSED,ACCEPTED,IN_PROGRES{
        @Override
        public boolean isTansactionCompleted() {
            return false;
        }
    };
//varianta 1:o metoda abstracta poate sa fie implementatala nivel de enum,
    //adica toate constantele din enum ar avea aceasi implemetare
    @Override
    public boolean isTansactionCompleted() {
        return true;
    }
    //public abstract boolean isPaidCash();
}
interface TransactionComplete{
    boolean isTansactionCompleted();
}

public class MainEnums {
    public static void main(String[] args) {
        System.out.println(PaymentTransactions.REJECTED.isTansactionCompleted());
        System.out.println(PaymentTransactions.IN_PROGRES.isTansactionCompleted());
        //un fel de clasa anonima
        TransactionComplete ong=new TransactionComplete() {
            @Override
            public boolean isTansactionCompleted() {
                return false;
            }
        };
    }
}

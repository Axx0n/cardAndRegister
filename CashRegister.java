public class CashRegister {

    private double cashInRegister;
    private int economicalSold;
    private int gourmetSold;
    private static final double PAY_ECONOMICAL = 2.50;
    private static final double PAY_GOURMET = 4.00;

    public CashRegister() {
        this.cashInRegister = 1000; 
    }
    
    public void loadMoneyToCard(LyyraCard card, double sum) {
        if(sum > 0) {
            card.loadMoney(sum);
            this.cashInRegister += sum;
        }
    }

    public double payEconomical(double cashGiven) {
        if(cashGiven >= PAY_ECONOMICAL) {
            this.cashInRegister += PAY_ECONOMICAL;
            this.economicalSold++;
            return cashGiven - PAY_ECONOMICAL;
        } else {
            return cashGiven;
        }
    }
    
    public boolean payEconomical(LyyraCard card) {
        if(card.balance() >= PAY_ECONOMICAL) {
            card.pay(PAY_ECONOMICAL);
            this.economicalSold++;
            return true;
        } else {
            return false;
        }
    }

    public double payGourmet(double cashGiven) {
        if(cashGiven >= PAY_GOURMET) {
            this.cashInRegister += PAY_GOURMET;
            this.gourmetSold++;
            return cashGiven - PAY_GOURMET;
        } else {
            return cashGiven;
        }
    }
    
    public boolean payGourmet(LyyraCard card) {
        if(card.balance() >= PAY_GOURMET) {
            card.pay(PAY_GOURMET);
            this.gourmetSold++;
            return true;
        } else {
            return false;
        }
    }


    public String toString() {
        return "money in register " + cashInRegister + " economical lunches sold: " + economicalSold + " gourmet lunches sold: " + gourmetSold;
    }
}

package com.scope;

public class Main {
    public static void main(String[] args) {

        CreditCardPayment cardPayment = new CreditCardPayment();

        OnlinePayment onlinePayment = new OnlinePayment();

        cardPayment.setFee(2.5);
        onlinePayment.setFee(1.5);
        double netPay = cardPayment.proceedPayment(100);
        System.out.println("Total payment: "+netPay);
        
        
    }
}

abstract class PaymentMethod{
    public static double fee = 0.0f;

    public abstract double proceedPayment(double amount);

    public double getFee(){
        return fee;
    }
}

class CreditCardPayment extends PaymentMethod{

    @Override
    public double proceedPayment(double amount) {
        return amount+fee;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double newFee){
        fee = newFee;
    }
    
}

class OnlinePayment extends PaymentMethod{

    @Override
    public double proceedPayment(double amount) {
        return fee+amount;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double newFee){
        fee = newFee;
    }
    

}
package br.com.ebanx.demo.model;

public class Balance

{
    private Account destination;
    private Account origin;

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public Account getOrigin() {
        return origin;
    }

    public void setOrigin(Account origin) {
        this.origin = origin;
    }
}

package controller;

public class ItemNotFoundException extends Exception {
    public ItemNotFoundException() {
        super("Item With This Id Is Not Exist");
    }
}
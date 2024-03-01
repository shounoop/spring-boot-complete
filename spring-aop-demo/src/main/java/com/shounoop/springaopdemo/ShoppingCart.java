package com.shounoop.springaopdemo;

import org.springframework.stereotype.Component;

@Component
public class ShoppingCart {
    public void checkout() {
        System.out.println("Checking out...");
    }
}

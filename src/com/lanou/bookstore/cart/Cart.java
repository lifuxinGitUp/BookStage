package com.lanou.bookstore.cart;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/9/22.
 */
public class Cart implements Serializable{
    private Map<String,CartItem> cartMap;


    public Cart() {
    }

    public Cart(Map<String, CartItem> cartMap) {
        this.cartMap = cartMap;
    }

    public Map<String, CartItem> getCartMap() {
        return cartMap;
    }

    public void setCartMap(Map<String, CartItem> cartMap) {
        this.cartMap = cartMap;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartMap=" + cartMap +
                '}';
    }

    public void delete(Cart cart,String bid){
        cart.getCartMap().remove(bid);

    }


    public void clear() {
        cartMap = new HashMap<>();
        setCartMap(cartMap);
    }
}

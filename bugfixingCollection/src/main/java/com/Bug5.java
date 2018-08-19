package com;

import java.util.HashMap;
import java.util.Random;

public class Bug5 {
    public static void main(String[] args) {
        HashMap<Key, String> hashMap = new HashMap();
        Key key1 = new Key("sv2");
        Key key2 = new Key("sv3");


        hashMap.put(key1, "k1");
        hashMap.put(key1, "k2");
        hashMap.put(key2, "k2_new");

        System.out.println("k1 =>" + hashMap.get(key1));
        System.out.println("k2 => " + hashMap.get(key2));

// Мы ХешКод определяем по значению, которое всегда null, поэтому и такая лажа)))
        // Но хитро, заставило весь код отдебажить
    }
}

class Key {
    private String secretValue;
    private String salt;
    private final int id;

    public Key(String secretValue) {
        this.secretValue = secretValue;
        this.id = new Random().nextInt();
        salt=id+"";         //Как я)))???
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Key key = (Key) o;

        return salt != null ? salt.equals(key.salt) : key.salt == null;
    }

    @Override
    public int hashCode() {
        return salt != null ? salt.hashCode() : 0;
    }
}

package com.lm.cats;

import java.util.HashMap;

public class CatsDB {
    public Cat get(Integer id) {
        HashMap<Integer, Cat> db = new HashMap<>();
        db.put(0, new Cat("Doug"));
        db.put(1, new Cat("Ozzy"));
        db.put(2, new Cat("Logan"));
        db.put(3, new Cat("Dylan"));

        return db.get(id);
    }
}

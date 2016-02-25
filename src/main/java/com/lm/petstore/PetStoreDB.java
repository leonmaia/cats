package com.lm.petstore;

import java.util.HashMap;

public class PetStoreDB {
    public Pet get(Integer id) {
        HashMap<Integer, Pet> db = new HashMap<>();
        db.put(0, new Pet("Doug"));
        db.put(1, new Pet("Ozzy"));
        db.put(2, new Pet("Logan"));
        db.put(3, new Pet("Dylan"));

        return db.get(id);
    }
}

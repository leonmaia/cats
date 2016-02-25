package com.lm.petstore;

public final class PetStoreService {
    static PetStoreDB petStoreDB = new PetStoreDB();

    public static Pet find(int id) {
        return petStoreDB.get(id);
    }
}

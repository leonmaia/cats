package com.lm.cats;

public final class CatService {
    static CatsDB db = new CatsDB();

    public static Cat find(int id) {
        return db.get(id);
    }
}

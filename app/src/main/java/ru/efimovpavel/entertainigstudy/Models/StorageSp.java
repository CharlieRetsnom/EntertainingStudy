package ru.efimovpavel.entertainigstudy.Models;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class StorageSp {
    SharedPreferences storage;

    public StorageSp(Context context) {
        storage = context.getSharedPreferences("STORAGE", Context.MODE_PRIVATE);
    }

    public void saveProblem(Problem problem) {
        int size = storage.getInt("size", 0);
        SharedPreferences.Editor editor = storage.edit();
        editor.putString("answer" + size, problem.getAnswer());
        editor.putInt("size", size + 1);
        editor.apply();
    }

    public Problem getProblem(int id) {
        return new Problem(storage.getString("taskText" + id, ""), storage.getString("answer" + id, ""));
    }

    public List<Problem> getAllProblem() {
        int size = storage.getInt("size", 0);
        ArrayList<Problem> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++) arrayList.add(getProblem(i));
        return arrayList;
    }
}

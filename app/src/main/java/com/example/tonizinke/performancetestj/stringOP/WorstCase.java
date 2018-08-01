package com.example.tonizinke.performancetestj.stringOP;

class WorstCase {
    public static void main(final String[] args) {
        long now = System.currentTimeMillis();
        slow();
        System.out.println("slow elapsed " + (System.currentTimeMillis() - now) + " ms");

        now = System.currentTimeMillis();
        fast();
        System.out.println("fast elapsed " + (System.currentTimeMillis() - now) + " ms");
    }

    public static void fast() {
        final StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++)
            s.append("*");
    }

    public static void slow() {
        String s = "";
        for (int i = 0; i < 100000; i++) {
            s += "*";
        }
    }
}
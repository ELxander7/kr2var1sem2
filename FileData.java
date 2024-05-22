package org.example;

public class FileData {
    private int k;
    private String s;
    private int d;
    private int p;

    public FileData(int k, String s, int d, int p) {
        this.k = k;
        this.s = s;
        this.d = d;
        this.p = p;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public int getD() {
        return d;
    }

    public void setD(int d) {
        this.d = d;
    }

    public int getP() {
        return p;
    }

    public void setP(int p) {
        this.p = p;
    }
    public String getText() {
        return this.s;
    }
}

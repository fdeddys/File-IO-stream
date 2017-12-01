package com.ddabadi;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: deddy
 * Date: 12/1/17
 * Time: 4:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class FileRahasia implements Serializable {
    private String nama;
    private String katakunci;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKatakunci() {
        return katakunci;
    }

    public void setKatakunci(String katakunci) {
        this.katakunci = katakunci;
    }
}

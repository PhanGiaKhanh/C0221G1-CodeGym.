package com.model.bean;

public class Mailbox {
    private int id;
    private int lang_id;
    private int  size_id;
    private String spamsFilter;
    private String signature;

    public Mailbox() {
    }

    public Mailbox(int lang_id, int size_id, String spamsFilter, String signature) {
        this.id = this.id +1;
        this.lang_id = lang_id;
        this.size_id = size_id;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public Mailbox(int id, int lang_id, int size_id, String spamsFilter, String signature) {
        this.id = id;
        this.lang_id = lang_id;
        this.size_id = size_id;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLang_id() {
        return lang_id;
    }

    public void setLang_id(int lang_id) {
        this.lang_id = lang_id;
    }

    public int getSize_id() {
        return size_id;
    }

    public void setSize_id(int size_id) {
        this.size_id = size_id;
    }

    public String isSpamsFilter() {
        return spamsFilter;
    }

    public void setSpamsFilter(String spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
}

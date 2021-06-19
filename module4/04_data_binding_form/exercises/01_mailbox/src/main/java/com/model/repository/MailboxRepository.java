package com.model.repository;

import com.controller.MailboxController;
import com.model.bean.Mailbox;

import java.util.HashMap;
import java.util.Map;

public class MailboxRepository {
    Map<Integer, Mailbox> map = new HashMap<>();

    public void save(Mailbox mailbox){
        map.put(map.size()+1, mailbox);
    }

    public Mailbox findId(int id) {
        return map.get(id);
    }

    public int size(){
        return map.size();
    }
}

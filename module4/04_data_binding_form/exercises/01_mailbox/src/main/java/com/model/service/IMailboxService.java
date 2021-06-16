package com.model.service;

import com.controller.MailboxController;
import com.model.bean.Mailbox;


public interface IMailboxService {
    public void save(Mailbox mailbox);
    Mailbox findId(int id);
    int size();
}

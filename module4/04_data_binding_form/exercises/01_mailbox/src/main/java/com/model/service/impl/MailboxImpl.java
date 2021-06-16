package com.model.service.impl;

import com.controller.MailboxController;
import com.model.bean.Mailbox;
import com.model.repository.MailboxRepository;
import com.model.service.IMailboxService;
import org.springframework.stereotype.Service;

@Service
public class MailboxImpl implements IMailboxService {
    MailboxRepository mailboxRepository = new MailboxRepository();
    @Override
    public void save(Mailbox mailbox) {
        mailboxRepository.save(mailbox);
    }

    @Override
    public Mailbox findId(int id) {
        return mailboxRepository.findId(id);
    }

    @Override
    public int size() {
        return mailboxRepository.size();
    }


}

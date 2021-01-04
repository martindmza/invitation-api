package com.invitation.repository;

import com.invitation.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    @Override
    public Message save(Message message);
}

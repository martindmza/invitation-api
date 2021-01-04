package com.invitation.service;

import com.invitation.api.request.MessageRequest;
import com.invitation.api.request.PersonRequest;
import com.invitation.model.Message;
import com.invitation.model.Person;
import com.invitation.repository.MessageRepository;
import com.invitation.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfirmationService {

    @Autowired
    PersonRepository personRepository;

    @Autowired
    MessageRepository messageRepository;

    public Person confirmAssistance(PersonRequest personRequest) throws Exception {
        try {
            Person person = new Person();
            person.setName(personRequest.getName());
            person.setLastName(personRequest.getLastName());
            person.setPhone(personRequest.getPhone());

            return personRepository.save(person);
        } catch (Exception e) {
            throw e;
        }
    }

    public Message saveMessage(MessageRequest messageRequest) throws Exception {
        try {
            Message message = new Message();
            message.setName(messageRequest.getName());
            message.setLastName(messageRequest.getLastName());
            message.setEmail(messageRequest.getEmail());

            return messageRepository.save(message);
        } catch (Exception e) {
            throw e;
        }
    }
}

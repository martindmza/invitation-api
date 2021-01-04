package com.invitation.api;

import com.invitation.api.request.MessageRequest;
import com.invitation.api.request.PersonRequest;
import com.invitation.model.Message;
import com.invitation.model.Person;
import com.invitation.service.ConfirmationService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequiredArgsConstructor
@EnableAutoConfiguration
@CrossOrigin(origins = "*", methods= {RequestMethod.GET, RequestMethod.POST})
public class ConfirmAssistenceController {

    @Autowired
    private final ConfirmationService confirmationService;

    @ResponseBody
    @RequestMapping(
            method = POST,
            value = "/api/v1/invitation/confirmAssistance",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Person> confirmAssistance(@RequestBody PersonRequest person) {
        try {
            return new ResponseEntity<>(confirmationService.confirmAssistance(person), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @ResponseBody
    @RequestMapping(
            method = POST,
            value = "/api/v1/invitation/message",
            produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<Message> receiveMessage(@RequestBody MessageRequest messageRequest) {
        try {
            return new ResponseEntity<>(confirmationService.saveMessage(messageRequest), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}

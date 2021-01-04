package com.invitation.api.request;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class MessageRequest {
    private String name;
    private String lastName;
    private String email;
}

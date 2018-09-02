package com.capgemini.talentProfile.utils;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WSResponseMessage {
    private String message;

    public WSResponseMessage(String msg) {
        this.message = msg;
    }

}
package com.example.BlogApp.util.email;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmailDetail {
    private String recipient;
    private String msgBody;
    private String subject;
}

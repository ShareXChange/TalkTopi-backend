package com.example.talktopi.domain.chat.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collation = "TalkTopi")
public class Chat {
    @Id
    private String id;
    private String msg;
    private Integer sender_idx;
    private String sender_name;
    private Integer receiver_idx;
    private Integer room_num;
    private String createdAt;
}

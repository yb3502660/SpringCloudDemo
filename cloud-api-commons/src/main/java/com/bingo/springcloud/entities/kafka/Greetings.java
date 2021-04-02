package com.bingo.springcloud.entities.kafka;

import lombok.*;

/**
 * @author:yaobin
 * @date:2021/3/23,23:45
 */

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Greetings {
    private long timestamp;
    private String message;
    
}

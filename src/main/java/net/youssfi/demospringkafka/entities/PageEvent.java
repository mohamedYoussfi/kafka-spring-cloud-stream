package net.youssfi.demospringkafka.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class PageEvent {
    private String name;
    private String user;
    private Date date;
    private long duration;
}

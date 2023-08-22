package net.qeema.demo.dto;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class UserDTO {
    private String email;
    private String name;
}

package pro.yoric.it.dto;

import lombok.Data;

@Data
public class AddNewUserCommandDto
{
    // FIELDS
    private String name;
    private String secondName;
    private String command;
    private String login;
    private String password;
}

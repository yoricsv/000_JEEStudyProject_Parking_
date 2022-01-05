package pro.yoric.it.dto;

import lombok.Data;

import org.springframework.web.multipart.MultipartFile;

@Data
public class AddNewUserCommandDto
{
    // FIELDS
    private String        name;
    private String        surname;
    private String        command;
    private String        login;
    private String        password;
    private MultipartFile file;
}

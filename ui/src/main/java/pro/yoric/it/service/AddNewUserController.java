package pro.yoric.it.service;

import pro.yoric.it.dto.AddNewUserCommandDto;

import pro.yoric.it.parking.pojo.Person;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@SessionAttributes("currentPerson")             // to using session
public class AddNewUserController
{
    @Autowired
    private PersonService personService;

    @GetMapping("/add-new-user.html")
    public ModelAndView addNewUserView()
    {
        return
            new ModelAndView(
                    "add-person"
                )
                .addObject(
                    "addNewUserCommand",
                    new AddNewUserCommandDto()
                );
    }

    @PostMapping("/add-new-person.do")          // to save data from input form until redirect
    public ModelAndView addNewUser(
            @ModelAttribute("addNewUserCommand")
            AddNewUserCommandDto addNewUserCommandDto,
            @RequestParam("file")
            MultipartFile file,
            BindingResult result
        )
    {
        System.out.println(addNewUserCommandDto);

        final List<String> errors =
            personService
            .addNewUser(
                addNewUserCommandDto
            );

        if(addNewUserCommandDto.getPassword().isEmpty())
        {
            result
            .addError(
                new ObjectError(
                    "password",
                    "Password is empty"
                )
            );
        }

        if (!errors.isEmpty())
        {
            errors
            .forEach(
                s ->
                    result
                    .addError(
                        new ObjectError(
                            "addNewUserCommand",
                            s
                    )
                )
            );
            return
                new ModelAndView(
                    "add-person"
                );
        }

        Person person =
            personService
            .findPerson(
                addNewUserCommandDto.getName(),
                addNewUserCommandDto.getSurname()
            );

        System.out.println(person);

        return
            new ModelAndView(
                "redirect:/index.html"
            )
            .addObject(
                "currentPerson",
                person
            );
    }
}

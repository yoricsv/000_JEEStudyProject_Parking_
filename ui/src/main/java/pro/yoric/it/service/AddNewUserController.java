package pro.yoric.it.service;

import pro.yoric.it.dto.AddNewUserCommandDto;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
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

    @PostMapping("/add-new-person.do")
    public ModelAndView addNewUser(
            @ModelAttribute("addNewUserCommand")
            AddNewUserCommandDto addNewUserCommandDto,
            BindingResult result
        )
    {
        System.out.println(addNewUserCommandDto);

        final List<String> errors =
            personService.addNewUser(addNewUserCommandDto);

        if (!errors.isEmpty())
        {
            errors
            .forEach(
                s -> result
                     .addError(
                         new ObjectError(
                             "addNewUserCommand",
                             s
                         )
                     )
            );
        }
        personService.addNewUser(addNewUserCommandDto);

        return new ModelAndView("add-person");
    }
}

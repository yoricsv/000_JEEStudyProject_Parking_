package pro.yoric.it.service;

import pro.yoric.it.dto.AddNewUserCommandDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddNewUserController
{
    @Autowired
    private PersonService personService;

    @GetMapping("/add-new-user.html")
    public ModelAndView addNewUserView()
    {
        return new ModelAndView("add-person");
    }

    @PostMapping("/add-new-person.do")
    public ModelAndView addNewUser(AddNewUserCommandDto command)
    {
        System.out.println(command);

        personService.addNewUser(command);

        return new ModelAndView("add-person");
    }
}

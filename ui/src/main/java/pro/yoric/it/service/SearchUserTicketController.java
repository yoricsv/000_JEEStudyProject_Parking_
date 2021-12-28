package pro.yoric.it.service;

import pro.yoric.it.dto.SearchTicketCriteriaDto;
import pro.yoric.it.dto.SearchTicketResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchUserTicketController
{
    @Autowired
    private SearchUserTicketService service;

    @GetMapping("/search-ticket.html")
    public ModelAndView searchTickets(
            SearchTicketCriteriaDto criteriaDto
        )
    {
        final List<SearchTicketResultDto> searchTicketResultDtos =
            service.searchUserTickets(criteriaDto);

        ModelAndView modelAndView =
            new ModelAndView(
                "search-ticket-result"
            );

        modelAndView.addObject(
            "tickets",
            searchTicketResultDtos
        );

        return modelAndView;
    }
}

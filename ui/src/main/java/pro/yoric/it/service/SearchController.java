package pro.yoric.it.service;

import pro.yoric.it.dto.SearchResultDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SearchController
{
    @Autowired
    private SearchService searchService;

    @GetMapping(path = "/search.html")
    public ModelAndView search(@RequestParam("str") String str)
    {
        final List<SearchResultDto> results = searchService.searchAll(str);

        ModelAndView modelAndView =
            new ModelAndView(
                "search-result"
            );
        modelAndView.addObject("results", results);

        return modelAndView;
    }
}

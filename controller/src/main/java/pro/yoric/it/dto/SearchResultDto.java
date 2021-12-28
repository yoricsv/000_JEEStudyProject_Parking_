package pro.yoric.it.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SearchResultDto
{
    // FIELDS
    private String uuid;
    private String type;
    private String title;
}

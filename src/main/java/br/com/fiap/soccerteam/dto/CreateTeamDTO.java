package br.com.fiap.soccerteam.dto;

import br.com.fiap.soccerteam.enums.Country;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;

@Data
public class CreateTeamDTO {

    @NotEmpty(message = "Required 'name' field.")
    private String name;

    private String description;

    @PastOrPresent(message = "Invalid 'foundedIn' field. Value cannot be greater than current date")
    @NotNull(message = "Required 'foundedIn' field.")
    private LocalDate foundedIn;

    @NotNull(message = "Required 'country' field.")
    private Country country;

    @NotEmpty(message = "Required 'locatedIn' field.")
    private String locatedIn;

    private String imageUrl;

}

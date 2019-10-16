package br.com.evandropires.legacy;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigDecimal;
import java.time.LocalDate;

@Path("/movements")
@Produces(MediaType.APPLICATION_JSON)
public class MovementController {

    @GET
    @Path("{id}")
    public MovementDTO find(@PathParam("id") Integer id) {
        return MovementDTO.builder().id(1).value(BigDecimal.TEN).competence(LocalDate.now()).build();
    }

    @POST
    public MovementDTO create(MovementCreateDTO movementCreateDTO) {
        return MovementDTO.builder().id(1).value(BigDecimal.TEN).competence(LocalDate.now()).build();
    }

}

package br.com.evandropires.legacy;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Objects;

@Stateless
@Path("/movements")
@Produces(MediaType.APPLICATION_JSON)
public class MovementController {

    @EJB
    private MovementService movementService;

    @GET
    @Path("{id}")
    public MovementDTO find(@PathParam("id") Integer id) {
        var movement = movementService.find(id);
        return Objects.nonNull(movement) ? new MovementDTO(movement) : null;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public MovementDTO create(MovementCreateDTO movementCreateDTO) {
        return new MovementDTO(movementService.save(movementCreateDTO.toEntity()));
    }

}

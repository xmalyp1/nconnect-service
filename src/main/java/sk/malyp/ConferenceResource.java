package sk.malyp;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import sk.malyp.model.Conference;

@Path("/conference")
public class ConferenceResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Conference> getConferences() {
        return Conference.listAll();
    }

}

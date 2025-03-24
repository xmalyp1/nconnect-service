package sk.malyp;

import io.smallrye.common.annotation.RunOnVirtualThread;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.net.URI;
import java.util.List;
import sk.malyp.model.Conference;
import sk.malyp.model.ConferenceRequest;
import sk.malyp.service.ConferenceService;

@Path("/conference")
public class ConferenceResource {

    @Inject
    ConferenceService conferenceService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getConferences() {
        return Response.ok(Conference.listAll()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createConference(ConferenceRequest conferenceRequest) {
        var conference = conferenceService.createConference(conferenceRequest.name(),conferenceRequest.date());
        return Response.ok(conference).build();
    }

    @GET
    @Path("/{conferenceId}")
    public Response getConference(@PathParam("conferenceId") Long conferenceId) {
        var conference = Conference.findByIdOptional(conferenceId);
        if (conference.isEmpty()) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(conference).build();
    }

}

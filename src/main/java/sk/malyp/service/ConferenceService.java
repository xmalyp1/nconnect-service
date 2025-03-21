package sk.malyp.service;

import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import sk.malyp.model.Conference;

@ApplicationScoped
public class ConferenceService {

    @Transactional
    public Conference createConference(String name, LocalDate date) {
        Conference conference = new Conference();
        conference.name = name;
        conference.date = date;
        conference.persist();
        Log.infov("Conference {0} created", name);
        return conference;
    }

}

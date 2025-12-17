package util;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import io.quarkus.runtime.LaunchMode;
import io.quarkus.runtime.StartupEvent;

@ApplicationScoped
public class Startup {
    /**
     * This method is executed at the start of your application
     */
    public void start(@Observes StartupEvent evt) {
        // Placeholder for dev-only startup logic; keeping method to allow easy future seeding.
        if(LaunchMode.current() == LaunchMode.DEVELOPMENT) {
            return;
        }
    }
}

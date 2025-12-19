package rest;

import io.quarkiverse.renarde.Controller;
import io.quarkiverse.renarde.pdf.Pdf;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import model.CardData;
import util.WishFactory;


public class Application extends Controller {

    @Inject
    WishFactory wishFactory;

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance christmasCard(CardData card);
        public static native TemplateInstance christmasCardShimmer(CardData card);
    }

    @GET
    @Path("/christmasPngCard")
    @Produces(Pdf.IMAGE_PNG)
    public TemplateInstance christmasCardPng(@QueryParam("recipient") String recipient,
                                             @QueryParam("message") String message,
                                             @QueryParam("sender") String sender,
                                             @QueryParam("year") String year) {
        return Templates.christmasCard(wishFactory.buildCard(recipient, message, sender, year));
    }

    @GET
    @Path("/christmasHtmlCard")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance christmasCardHTML(@QueryParam("recipient") String recipient,
                                              @QueryParam("message") String message,
                                              @QueryParam("sender") String sender,
                                              @QueryParam("year") String year) {
        return Templates.christmasCard(wishFactory.buildCard(recipient, message, sender, year));
    }

    @GET
    @Path("/christmasShimmerPngCard")
    @Produces(Pdf.IMAGE_PNG)
    public TemplateInstance christmasCardShimmerPng(@QueryParam("recipient") String recipient,
                                                    @QueryParam("message") String message,
                                                    @QueryParam("sender") String sender,
                                                    @QueryParam("year") String year) {
        return Templates.christmasCardShimmer(wishFactory.buildCard(recipient, message, sender, year));
    }

    @GET
    @Path("/christmasShimmerHtmlCard")
    @Produces(MediaType.TEXT_HTML)
    public TemplateInstance christmasCardShimmerHTML(@QueryParam("recipient") String recipient,
                                                     @QueryParam("message") String message,
                                                     @QueryParam("sender") String sender,
                                                     @QueryParam("year") String year) {
        return Templates.christmasCardShimmer(wishFactory.buildCard(recipient, message, sender, year));
    }
}

package util;

import java.time.Year;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

import jakarta.enterprise.context.ApplicationScoped;

import model.CardData;

@ApplicationScoped
public class WishFactory {

    private static final List<String> DEFAULT_RECIPIENTS = List.of(
        "Dear Friends",
        "Dear Family",
        "To You and Yours",
        "Season's Greetings",
        "Dearest Loved One",
        "Dear Readers of The Main Thread"
    );

    private static final List<String> DEFAULT_SENDERS = List.of(
        "With warmth",
        "Eduard",
        "Your Secret Santa",
        "The Arencloud Team",
        "With gratitude",
        "From our home to yours"
    );

    private static final List<String> DEFAULT_MESSAGES = List.of(
        "May your Christmas be wrapped in warmth, joy, and candlelight, and may the New Year greet you with fresh hope.",
        "Here’s to sparkling lights, cozy nights, and a New Year filled with bright beginnings.",
        "Snow-kissed days and fireside nights—may your holidays be merry and your New Year be bold and kind.",
        "May peace rest on your home, laughter ring through your halls, and the coming year overflow with good surprises.",
        "Thank you for being a light this year. Wishing you a Christmas full of comfort and a New Year full of courage.",
        "Under twinkling trees and winter skies, may you feel how loved you are—today and all through the New Year.",
        "Let joy find you in small moments now, and carry you into a generous, hope-filled year ahead.",
        "May the scent of pine and the glow of hearth guide you into a New Year where every sunrise feels like a gift.",
        "Here's to slow mornings, full hearts, and the kind of peace that follows you into every month ahead.",
        "Wrapped in woolen scarves and kindness, may you find rest now and courage for the path the New Year opens.",
        "May every star on your tree mirror a hope realized in the New Year, and may warmth linger long after the lights dim.",
        "Here's to shared cocoa, remembered stories, and a New Year that makes room for your brightest dreams.",
        "Sending you quiet moments of wonder, a table full of laughter, and a New Year that feels like fresh snowfall—soft and bright.",
        "May your home be gentled by candlelight now and your year ahead be brave and bright.",
        "Wishing you the hush of snowfall, the laughter of old friends, and a New Year that keeps that glow.",
        "May kindness fill your table, gratitude fill your heart, and hope stretch into every month of the New Year.",
        "Sending you wool-blanket coziness, cinnamon-scented evenings, and a New Year that answers long-held prayers.",
        "Let every carol remind you you're cherished, and let the New Year greet you with doors flung open to joy.",
        "May this season steady your spirit and the coming year surprise you with gentle, radiant things."
    );

    public CardData buildCard(String recipient, String message, String sender, String year) {
        String resolvedRecipient = firstNonBlank(recipient, random(DEFAULT_RECIPIENTS));
        String resolvedSender = firstNonBlank(sender, random(DEFAULT_SENDERS));
        String resolvedMessage = firstNonBlank(message, random(DEFAULT_MESSAGES));
        String resolvedYear = firstNonBlank(year, String.valueOf(Year.now().getValue()));

        return new CardData(resolvedRecipient, resolvedMessage, resolvedSender, resolvedYear);
    }

    private String random(List<String> values) {
        return values.get(ThreadLocalRandom.current().nextInt(values.size()));
    }

    private String firstNonBlank(String candidate, String fallback) {
        if (candidate != null && !candidate.trim().isEmpty()) {
            return candidate.trim();
        }
        return Objects.requireNonNullElse(fallback, "");
    }
}

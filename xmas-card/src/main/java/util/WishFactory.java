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
        "Dear Friend",
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
        "Thank you for being part of this journey. Wishing you peace, joy, and a home full of laughter this festive season.",
        "May your days be merry, bright, and filled with the people you love most.",
        "Here's to cozy nights, sparkling lights, and memories that last all year.",
        "May kindness find you, may joy surround you, and may the new year bring new adventures.",
        "Your kindness has been a steady light this year. May your holidays be wrapped in warmth and your new year open with wonder.",
        "Between the carols and cocoa, I hope you find quiet moments that remind you how loved you are.",
        "May the glow of this season linger long after the lights come down, filling your days with hope and gentle joy."
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

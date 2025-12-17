package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public record CardData(
    String recipient,
    String message,
    String sender,
    String year
) {}


package dev.cloudy.sential.feature.chat.management;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

/**
 * This handles the in game chat.
 * It allows to format the chat messages and stores a boolean result whether the chat is muted or not.
 *
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 21:27
 */
@Getter
@Setter
public class ChatRepository {
    private final HashMap<String, Boolean> chatMute = new HashMap<>();
    private boolean chatMuted;

    /**
     * Constructor.
     */
    public ChatRepository(boolean chatMuted) {
        this.chatMuted = chatMuted;
    }
}

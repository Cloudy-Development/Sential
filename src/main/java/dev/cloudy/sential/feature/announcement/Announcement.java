package dev.cloudy.sential.feature.announcement;

import lombok.Getter;

import java.util.List;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 18:52
 */
@Getter
public class Announcement {

    private final List<String> lines;

    public Announcement(List<String> lines) {
        this.lines = lines;
    }
}

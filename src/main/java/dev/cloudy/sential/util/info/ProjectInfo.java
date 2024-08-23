package dev.cloudy.sential.util.info;

import dev.cloudy.sential.Sential;
import lombok.experimental.UtilityClass;

/**
 * @author Emmy
 * @project Sential
 * @date 23/08/2024 - 20:12
 */
@UtilityClass
public class ProjectInfo {
    public String NAME = Sential.getInstance().getDescription().getName();
    public String AUTHOR = Sential.getInstance().getDescription().getAuthors().get(0);
    public String AUTHORS = Sential.getInstance().getDescription().getAuthors().toString().replace("[", "").replace("]", "");
    public String VERSION = Sential.getInstance().getDescription().getVersion();
    public String DESCRIPTION = Sential.getInstance().getDescription().getDescription();
    public String DISCORD_LINK = "discord.gg/eT4B65k5E4";
    public String GITHUB_LINK = "github.com/Cloudy-Development/Sential";
}

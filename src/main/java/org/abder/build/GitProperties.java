package org.abder.build;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;


/**
 * Created with IntelliJ IDEA.
 * User: Abderrazak BOUADMA
 * Date: 4/22/15
 * Time: 3:01 PM
 */
@Component
public class GitProperties {


    public static final Logger logger = LoggerFactory.getLogger(GitProperties.class);

    private String branch;
    private final String dirty;
    private final String remoteOriginUrl;
    private final String tags;

    @Inject
    public GitProperties(@Value("git.branch") String branch,
                         @Value("git.dirty") String dirty,
                         @Value("git.remote.origin.url") String remoteOriginUrl,
                         @Value("git.tags") String tags) {
        this.branch = branch;
        this.dirty = dirty;
        this.remoteOriginUrl = remoteOriginUrl;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "GitProperties{" +
                "branch='" + branch + '\'' +
                ", dirty=" + dirty +
                ", remoteOriginUrl='" + remoteOriginUrl + '\'' +
                ", tags='" + tags + '\'' +
                '}';
    }

    @PostConstruct
    public void writeGitPropertiesToLogFile() {
        logger.info("Application was built by using the Git commit: {}", this);
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDirty() {
        return dirty;
    }

    public String getRemoteOriginUrl() {
        return remoteOriginUrl;
    }

    public String getTags() {
        return tags;
    }
}

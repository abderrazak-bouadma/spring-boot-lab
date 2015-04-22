package org.abder.controller;

import org.abder.build.GitProperties;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;

@RestController
public class VersionController {

    private final GitProperties gitProperties;

    @Inject
    public VersionController(GitProperties gitProperties) {
        this.gitProperties = gitProperties;
    }

    @RequestMapping(value = "/version", produces = MediaType.APPLICATION_JSON_VALUE)
    public GitProperties version() {
        return this.gitProperties;
    }

}

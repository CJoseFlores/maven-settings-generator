package com.github.cjflores;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.Unremovable;
import picocli.CommandLine.IVersionProvider;

@ApplicationScoped
@Unremovable
public class SpecBasedVersionProvider implements IVersionProvider {

    @ConfigProperty(name = "quarkus.application.version")
    String appVersion;

    @Override
    public String[] getVersion() throws Exception {
        String[] version = {"maven-settings-generator: " + appVersion};
        return version;
    }
    
}

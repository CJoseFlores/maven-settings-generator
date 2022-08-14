package com.github.cjflores;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import io.quarkus.arc.Unremovable;
import picocli.CommandLine.IVersionProvider;

/**
 * Uses the 'quarkus.application.version' property provided by quarkus to
 * provide the version of the application for '-V' queries fed to picocli
 */
@ApplicationScoped
@Unremovable
public class QuarkusBasedVersionProvider implements IVersionProvider {

    @ConfigProperty(name = "quarkus.application.version")
    String appVersion;

    @Override
    public String[] getVersion() throws Exception {
        String[] version = { "maven-settings-generator: " + appVersion };
        return version;
    }

}

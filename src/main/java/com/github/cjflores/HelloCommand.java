package com.github.cjflores;

import javax.enterprise.context.Dependent;

import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;


@Command(mixinStandardHelpOptions = true, versionProvider = QuarkusBasedVersionProvider.class)
public class HelloCommand implements Runnable {
    @Option(names = {"-n", "--name"}, description = "Who will we greet?", defaultValue = "World")
    private String name;
    private final GreetingService greetingService;

    public HelloCommand(GreetingService greetingService) { 
        this.greetingService = greetingService;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        greetingService.sayHello(name);
    }
}

@Dependent
@Slf4j
class GreetingService {
    void sayHello(String name) {
        log.info("Hello {}!", name);
    }
}
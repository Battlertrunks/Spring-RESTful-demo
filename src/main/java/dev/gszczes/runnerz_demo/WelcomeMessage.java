package dev.gszczes.runnerz_demo;
import org.springframework.stereotype.Component;

@Component
public class WelcomeMessage {

  public String getWelcomeMessage() {
    return "Welcome to my Spring Boot Project!";
  }

}

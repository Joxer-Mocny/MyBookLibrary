package sk.tsystems.mybooklibrary.repository;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("library")
public class BookProperties {
    private String name;

    public String getName(){return name;}

    public void setName(String name) {this.name = name;}

}

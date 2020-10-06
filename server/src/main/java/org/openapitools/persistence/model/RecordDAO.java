package org.openapitools.persistence.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "Record")
public class RecordDAO{
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String accountId;

    private LocalDateTime when;

    private String value;

    private String readingType;

    public RecordDAO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getWhen() {
        return when;
    }

    public void setWhen(LocalDateTime when) {
        this.when = when;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getReadingType() {
        return readingType;
    }

    public void setReadingType(String readingType) {
        this.readingType = readingType;
    }

    private RecordDAO(Builder builder) {
        this.accountId = builder.accountId;
        this.name = builder.name;
        this.readingType = builder.readingType;
        this.when = builder.when;
        this.value = builder.value;
    }

    public static class Builder {
        private String name;

        private String accountId;

        private LocalDateTime when;

        private String value;

        private String readingType;

        public Builder() {

        }
        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder accountId(String accountId) {
            this.accountId = accountId;
            return this;
        }

        public Builder when(LocalDateTime when) {
            this.when = when;
            return this;
        }

        public Builder value(String value) {
            this.value = value;
            return this;
        }

        public Builder readingType(String readingType) {
            this.readingType = readingType;
            return this;
        }

        public RecordDAO build() {
            return new RecordDAO(this);
        }

    }

}
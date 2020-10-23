package org.openapitools.persistence.nosql.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class ReportItem {

    @Id
    private Long id;

    private String name;

    private String accountId;

    private LocalDateTime whenRecorded;

    private String value;

    private String readingType;

    public ReportItem() {
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

    public LocalDateTime getWhenRecorded() {
        return whenRecorded;
    }

    public void setWhenRecorded(LocalDateTime whenRecorded) {
        this.whenRecorded = whenRecorded;
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

    private ReportItem(ReportItem.Builder builder) {
        this.id = builder.id;
        this.accountId = builder.accountId;
        this.name = builder.name;
        this.readingType = builder.readingType;
        this.whenRecorded = builder.when;
        this.value = builder.value;
    }

    public static class Builder {

        private long id;
        private String name;

        private String accountId;

        private LocalDateTime when;

        private String value;

        private String readingType;

        public Builder() {

        }
        public Builder id(long id) {
            this.id = id;
            return this;
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

        public ReportItem build() {
            return new ReportItem(this);
        }

    }
}

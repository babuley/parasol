package org.openapitools.report.model;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDateTime;

@Table
public class RecordItem {

    @PrimaryKey
    private Long id;

    @Column("name")
    private String name;

    @Column("accountId")
    private String accountId;

    @Column("whenRecorded")
    private LocalDateTime whenRecorded;

    @Column("value")
    private String value;

    @Column("readingType")
    private String readingType;

    public RecordItem() {
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

    private RecordItem(RecordItem.Builder builder) {
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

        public RecordItem build() {
            return new RecordItem(this);
        }

    }
}

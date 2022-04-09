package com.pseudo.queue.external.module.Rest.Request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataRequest {
    @JsonProperty("Account Number")
    private String accountNumber;

    @JsonProperty("Type")
    private String type;

    @JsonProperty("Amount")
    private Integer amount;

    @JsonProperty("Currency")
    private String currency;

    @JsonProperty("AccountFrom")
    private String accountFrom;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    @Override
    public String toString() {
        return "{" +
                "\"accountNumber\":\"" + accountNumber + "\"" +
                ", \"type\":\"" + type + "\"" +
                ", \"amount\":" + amount +
                ", \"currency\":\"" + currency + "\"" +
                ", \"accountFrom\":\"" + accountFrom + "\"" +
                "}";
    }
}

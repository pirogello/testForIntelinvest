package ru.intelinvest.career.models;

import lombok.Data;

@Data
public class EthereumBalanceResponse {
    private String status;
    private String message;
    private String result;
}

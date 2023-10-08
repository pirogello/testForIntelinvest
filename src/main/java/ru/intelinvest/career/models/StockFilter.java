package ru.intelinvest.career.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StockFilter {
    @JsonProperty("LISTLEVEL")
    private List<Integer> filteredListLevel;
    @JsonProperty("SECID")
    private List<String> filteredSecId;
    @JsonProperty("LOTSIZE")
    private Integer lotSize;
}

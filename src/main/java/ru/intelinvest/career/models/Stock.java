/*
 * STRICTLY CONFIDENTIAL
 * TRADE SECRET
 * PROPRIETARY:
 *       "Intelinvest" Ltd, TIN 1655386205
 *       420107, REPUBLIC OF TATARSTAN, KAZAN CITY, SPARTAKOVSKAYA STREET, HOUSE 2, ROOM 119
 * (c) "Intelinvest" Ltd, 2019
 *
 * СТРОГО КОНФИДЕНЦИАЛЬНО
 * КОММЕРЧЕСКАЯ ТАЙНА
 * СОБСТВЕННИК:
 *       ООО "Интеллектуальные инвестиции", ИНН 1655386205
 *       420107, РЕСПУБЛИКА ТАТАРСТАН, ГОРОД КАЗАНЬ, УЛИЦА СПАРТАКОВСКАЯ, ДОМ 2, ПОМЕЩЕНИЕ 119
 * (c) ООО "Интеллектуальные инвестиции", 2019
 */

package ru.intelinvest.career.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock implements Serializable {
    @JsonProperty("SECID")
    private String secId;
    @JsonProperty("BOARDID")
    private String boardId;
    @JsonProperty("SHORTNAME")
    private String shortName;
    @JsonProperty("PREVPRICE")
    private BigDecimal prevPrice;
    @JsonProperty("LOTSIZE")
    private Integer lotSize;
    @JsonProperty("FACEVALUE")
    private BigDecimal faceValue;
    @JsonProperty("STATUS")
    private String status;
    @JsonProperty("BOARDNAME")
    private String boardName;
    @JsonProperty("DECIMALS")
    private Integer decimals;
    @JsonProperty("SECNAME")
    private String secName;
    @JsonProperty("REMARKS")
    private String remarks;
    @JsonProperty("MARKETCODE")
    private String marketCode;
    @JsonProperty("INSTRID")
    private String instRid;
    @JsonProperty("SECTORID")
    private String sectorId;
    @JsonProperty("MINSTEP")
    private BigDecimal minStep;
    @JsonProperty("PREVWAPRICE")
    private BigDecimal prevWaPrice;
    @JsonProperty("FACEUNIT")
    private String faceUnit;
    @JsonProperty("PREVDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date prevDate;
    @JsonProperty("ISSUESIZE")
    private Long issueSize;
    @JsonProperty("ISIN")
    private String isin;
    @JsonProperty("LATNAME")
    private String latName;
    @JsonProperty("REGNUMBER")
    private String regNumber;
    @JsonProperty("PREVLEGALCLOSEPRICE")
    private BigDecimal prevLegalClosePrice;
    @JsonProperty("CURRENCYID")
    private String currencyId;
    @JsonProperty("SECTYPE")
    private String secType;
    @JsonProperty("LISTLEVEL")
    private Integer listLevel;
    @JsonProperty("SETTLEDATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date settleDate;
}

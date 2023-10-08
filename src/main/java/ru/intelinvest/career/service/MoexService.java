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

package ru.intelinvest.career.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.models.StockFilter;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MoexService {

    @Value("https://iss.moex.com/iss/engines/stock/markets/shares/boards/TQBR/securities/.json?iss.meta=off&iss.only=securities&iss.json=extended")
    private String urlGetStock;
    private final ObjectMapper mapper;
    private final RestTemplate restTemplate;

    public List<Stock> getStocks() {
        // todo реализация задания № 1 здесь
        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity(urlGetStock, Object[].class);
        try {
            Map securitiesObj = (Map) Objects.requireNonNull(responseEntity.getBody())[1];
            return mapper.convertValue(securitiesObj.get("securities"), new TypeReference<>() {
            });
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e) {
            // todo обработка невалидного ответа от moex
        }
        return null;
    }

    public List<Stock> filter(List<Stock> stocks, StockFilter filters) {
        return stocks.stream()
                .filter(s -> {
                    if (filters.getFilteredListLevel() == null || filters.getFilteredListLevel().size() == 0) return true;
                    return filters.getFilteredListLevel().contains(s.getListLevel());
                })
                .filter(s -> {
                    if (filters.getFilteredSecId() == null|| filters.getFilteredSecId().size() == 0) return true;
                    return filters.getFilteredSecId().contains(s.getSecId());
                })
                .filter(s -> {
                    if (filters.getLotSize() == null) return true;
                    return filters.getLotSize().equals(s.getLotSize());
                })
                .collect(Collectors.toList());
    }

    public List<Stock> getPage(List<Stock> stocks, int page, int size){
        return stocks.stream()
                .skip(page*size)
                .limit(size)
                .collect(Collectors.toList());
    }
}

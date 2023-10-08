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

package ru.intelinvest.career.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.intelinvest.career.models.Stock;
import ru.intelinvest.career.models.StockFilter;
import ru.intelinvest.career.service.MoexService;

import java.awt.print.Pageable;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moex")
public class MoexEndpoint {

    private final MoexService moexService;


    // todo реализация задания № 2 и 3 здесь

    @PostMapping("stocks")
    public ResponseEntity<List<Stock>> processIntegration(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestBody(required = false) StockFilter filter
    ) {
        var stocks = moexService.getStocks();
        if (filter != null)
            stocks = moexService.filter(stocks, filter);
        if (page != null && size != null)
            stocks = moexService.getPage(stocks, page, size);
        return ResponseEntity.ok(stocks);
    }
}


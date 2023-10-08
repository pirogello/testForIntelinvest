package ru.intelinvest.career.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.intelinvest.career.models.EthereumBalanceResponse;
import ru.intelinvest.career.service.EthereumService;

@RestController
@RequestMapping("/eth")
@RequiredArgsConstructor
public class EthereumController {

    private final EthereumService ethereumService;

    @GetMapping("/balance/{address}")
    public ResponseEntity<EthereumBalanceResponse> getBalance(@PathVariable String address){
       return ResponseEntity.ok(ethereumService.getBalance(address));
    }
}

package ru.intelinvest.career.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ru.intelinvest.career.models.EthereumBalanceResponse;

@Service
@RequiredArgsConstructor
public class EthereumService {

    private final RestTemplate restTemplate;

    @Value("https://api.etherscan.io/api?module=%s&action=%s&address=%s&tag=%s&apikey=%s")
    private String urlEth;
    @Value("${eth.apiKey}")
    private String apiKey;


    public EthereumBalanceResponse getBalance(String address) {
        String url = String.format(urlEth,
                "account",
                "balance",
                address,
                "latest",
                apiKey);
        ResponseEntity<EthereumBalanceResponse> res = restTemplate.getForEntity(url, EthereumBalanceResponse.class);
        return res.getBody();
    }
}

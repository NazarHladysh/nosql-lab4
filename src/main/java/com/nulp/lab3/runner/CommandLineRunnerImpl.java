package com.nulp.lab3.runner;

import com.nulp.lab3.model.Trip;
import com.nulp.lab3.service.ParserService;
import com.nulp.lab3.service.Strategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RequiredArgsConstructor
@Component
@Slf4j
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final ParserService parserService;
    private final StringRedisTemplate template;
    private final Strategy strategy;
    @Value("${trip.url}")
    private String tripUrl;

    @Override
    public void run(String... args) throws Exception {
        int offset = 0;
        ValueOperations<String, String> ops = this.template.opsForValue();
        for (int i = 0; i < 6; i++) {
            log.info("Getting {}-{} trips", offset, offset + 100);

            String url = createUrl(tripUrl, offset);

            String key = ops.get(url);
            if (key == null) {
                ops.set(url, url + " - Start Writing");
                log.info("{} - Start Writing", url);
                List<Trip> trips = parserService.parseTrips(url);
                strategy.execute(trips);
                ops.set(url, url + " - Completed");
                log.info("{} - Completed", url);
            } else {
                ops.set(url, "There is an attempt to rewrite");
                log.info("There is an attempt to rewrite");
            }

            offset += 100;
        }
    }

    private String createUrl(String url, int offset) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .buildAndExpand(offset)
                .toUriString();
    }
}

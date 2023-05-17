package com.github.komidawi.interview.example;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@AllArgsConstructor
public class DomainLogic implements Generator {

    private final Provider provider;

    @Override
    public Set<String> generateNumbers() {
        Set<String> collect = calculateMainThing();
        String additionalInfo = provider.provide();
        collect.add(additionalInfo);
        return collect;
    }

    private static Set<String> calculateMainThing() {
        IntStream stream = prepareStream();
        return processStream(stream);
    }

    private static IntStream prepareStream() {
        return ThreadLocalRandom.current()
                .ints()
                .limit(10);
    }

    private static Set<String> processStream(IntStream stream) {
        return stream.peek(System.out::println)
                .map(x -> x * x)
                .mapToObj(String::valueOf)
                .collect(Collectors.toSet());
    }
}

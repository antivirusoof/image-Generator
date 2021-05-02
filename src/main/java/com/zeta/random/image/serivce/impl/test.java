package com.zeta.random.image.serivce.impl;

import org.springframework.stereotype.Service;
import java.util.function.Supplier;

@Service
public class test {
    public <T> T run(Supplier<T> process) {
        return process.get();

    }
}

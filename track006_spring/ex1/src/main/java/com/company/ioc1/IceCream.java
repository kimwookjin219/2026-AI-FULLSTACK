package com.company.ioc1;

import org.springframework.stereotype.Component;

@Component
public interface IceCream {
    public String flavor();
    public String scoop();
    public String melt();
}

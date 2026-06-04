package com.company.ioc1;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Component("iceCreamShop")
@Data
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class IceCreamShop {
	//@Value("${shopName}")
    private String shopName;
	
	//@Resource(name="${iceCream}")
    private IceCream iceCream;

    public String serveFlavor() { return shopName + ">" + iceCream.flavor(); }
    public String serveScoop()  { return shopName + ">" + iceCream.scoop(); }
    public String serveMelt()   { return shopName + ">" + iceCream.melt(); }

    public void print() {
        System.out.println(serveFlavor());
        System.out.println(serveScoop());
        System.out.println(serveMelt());
    }
}

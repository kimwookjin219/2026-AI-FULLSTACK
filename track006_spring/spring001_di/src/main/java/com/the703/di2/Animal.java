package com.the703.di2;

import org.springframework.stereotype.Component;

@Component
public interface Animal {
	public String eat();
	public String sleep();
	public String poo();
}

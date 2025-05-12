package com.example.controller;

import com.example.service.ExServiceImpl;

public class ExMain {
	public static void main(String[] args) {
		System.out.println(ExServiceImpl.getInstance().now());
	}
}

package io.blog.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLifeCycle {

	@BeforeAll
	static void beforeAll() {
		System.out.println("## BeforeAll Annotation 호출 ##");
		System.out.println();
	}
	
	@AfterAll
	static void afterAll() {
		System.out.println("## AfterAll Annotation 호출 ##");
		System.out.println();
	}
	
	@AfterEach
	void afterEach() {
		System.out.println("## AfterEach Annotation 호출 ##");
		System.out.println();
	}
	
	@Test
	@DisplayName("## Test1 시작 ##")
	void test1() {	
		System.out.println("## Test1 시작 ##");
		System.out.println();
	}
	
	@Test
	@DisplayName("## Test2 시작 ##")
	void test2() {	
		System.out.println("## Test2 시작 ##");
		System.out.println();
	}
	
	@Test
	@Disabled
	void test3() {
		System.out.println("## Test3 시작 ##");
		System.out.println();
	}
}
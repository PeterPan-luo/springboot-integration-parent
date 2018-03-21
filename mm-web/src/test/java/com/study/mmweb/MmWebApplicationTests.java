package com.study.mmweb;

import com.google.common.collect.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MmWebApplicationTests {

	@Test
	public void contextLoads() {
		List<String> strList = Arrays.asList("aaa", "bbb", "ccc", "ddd", "eee");

		Stream<String> stream = strList.stream()
				.map(String::toUpperCase);

		//stream.forEach(System.out::println);

		ArrayList<Integer> intList = Lists.newArrayList(60,55,40,10, 20, 30, 40, 50);
		intList.stream().limit(3).filter( x -> x < 50).forEach(System.out::println);

	}

}

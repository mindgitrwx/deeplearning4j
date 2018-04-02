package org.deeplearning4j.graph.api;

import lombok.Data;

import org.junit.Test;
import java.io.IOException;
import java.util.List;

public class EdgeTest(){
	Edge<int> Test_class_int;
	Edge<float> Test_class_float;
	Edge<double> Test_class_double;
	Edge<char> Test_class_char;
	Edge<string> Test_class_string;
	
	
	//Test for Class Edge constructor.
	//Given parameter values have no effect on this test.
	@Test
	public void constructor_test(){
		assertNotNull(Test_class_int(0,1,1,0));
		assertNotNull(Test_class_float(0,1,1.1,0));
		assertNotNull(Test_class_double(0,1,1.1,0));
		assertNotNull(Test_class_char(0,1,'a',0));
		assertNotNull(Test_class_string(0,1,"a",0));
	}
	
	//Test for Class Edge constructor with invalid input.
    //Expected invalid arguments error.
	@Test
	public void constructor_test(){
		assertNotNull(Test_class_int('a','b','c','d'));
		assertNotNull(Test_class_float('a','b','c','d'));
		assertNotNull(Test_class_int('a','b','c','d'));
		assertNotNull(Test_class_char('a','b',"c",'d'));
		assertNotNull(Test_class_string('a','b','c','d'));
	}
	
	
}
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
	
	//Delete after test is over.
	@After
	public void TearDown(){
		Test_class_int = null;
		Test_class_float = null;
		Test_class_double = null;
		Test_class_char = null;
		Test_class_string = null;
	}
	
	//Test for Class Edge constructor.
	//Given parameter values have no effect on this test.
	@Test
	public void constructor_test(){
		Test_class_int = new Test_class_int(0,1,1,0);
		Test_class_float = new Test_class_float(0,1,1.1,0);
		Test_class_double = new Test_class_double(0,1,1.1,0);
		Test_class_char = new Test_class_char(0,1,'a',0); 
		Test_class_string = new Test_class_string(0,1,"a",0);
		
		assertNotNull(Test_class_int(0,1,1,0));
		assertNotNull(Test_class_float(0,1,1.1,0));
		assertNotNull(Test_class_double(0,1,1.1,0));
		assertNotNull(Test_class_char(0,1,'a',0));
		assertNotNull(Test_class_string(0,1,"a",0));
	}
	
	//Test for Class Edge constructor. When parameter value input is NULL
	//Given other parameter values have no effect on this test.
	//Class Edge must accept this command when value is null.
	@Test
	public void constructor_with_null_test(){
		
		Test_class_int = new Test_class_int(0,1,null,0);
		Test_class_float = new Test_class_float(0,1,null,0);
		Test_class_double = new Test_class_double(0,1,null,0);
		Test_class_char = new Test_class_char(0,1,null,0); 
		Test_class_string = new Test_class_string(0,1,null,0);
		
		assertNotNull(Test_class_int(0,1,null,0));
		assertNotNull(Test_class_float(0,1,null,0));
		assertNotNull(Test_class_double(0,1,null,0));
		assertNotNull(Test_class_char(0,1,null,0));
		assertNotNull(Test_class_string(0,1,null,0));
	}
	
	//Test for Class Edge constructor with invalid input.
    //Expected invalid arguments error.
	@Test
	public void constructor_with_invalid_input_test(){
		
		Test_class_int = new Test_class_int('a','b','c','d');
		Test_class_float = new Test_class_float('a','b','c','d');
		Test_class_double = new Test_class_double('a','b','c','d');
		Test_class_char = new Test_class_char('a','b',"c",'d'); 
		Test_class_string = new Test_class_string('a','b','c','d');
		
		assertNotNull(Test_class_int('a','b','c','d'));
		assertNotNull(Test_class_float('a','b','c','d'));
		assertNotNull(Test_class_double('a','b','c','d'));
		assertNotNull(Test_class_char('a','b',"c",'d'));
		assertNotNull(Test_class_string('a','b','c','d'));
	}
	
	//Boundary Test for Class Edge constructor when argument value type is int.
	//Test minimum, maximum int value.
	@Test
	public void int_edge_boundary_test(){
		Test_class_int = new Test_class_int(0,1,Int.MIN_VALUE,0);		
		assertNotNull(Test_class_int);
		
		
		Test_class_int = new Test_class_int(0,1,Int.MAX_VALUE,0);
		assertNotNull(Test_class_int);
	}
	
	
	//Boundary Test for Class Edge constructor when argument value type is float.
	//Test minimum, maximum float value.
	@Test
	public void float_edge_boundary_test(){
		
		Test_class_float = new Test_class_float(0,1,Float.MIN_VALUE,0);
		assertNotNull(Test_class_float);
		
		Test_class_float = new Test_class_float(0,1,Float.MAX_VALUE,0);
		assertNotNull(Test_class_float);
	}
		
	//Boundary Test for Class Edge constructor when argument value type is double.
	//Test minimum, maximum double value.
	@Test
	public void double_edge_boundary_test(){
		Test_class_double = new Test_class_double(0,1,Double.MIN_VALUE,0)
		assertNotNull(Test_class_double);
		
		Test_class_double = new Test_class_double(0,1,Double.MAX_VALUE,0)
		assertNotNull(Test_class_double);
	}
	
	//Boundary Test for Class Edge constructor when argument value type is double.
	//Minimum 0(null), Maximum 127(DEL)
	//Skip case when Type is string.
	@Test
	public void char_edge_boundary_test(){
		Test_class_char = new Test_class_char(0,1,(char)0,0)
		assertNotNull(Test_class_char);
		
		Test_class_char = new Test_class_char(0,1,(char)127,0)
		assertNotNull(Test_class_char);
	}
	

	//Test for valid operation of Edge.toString().
	//Confirm each type cases.
	@Test
	public void int_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_int = new Test_class_int(0,1,1,0);
		assertEquals( "edge(undirected,0--1,1)", Test_class_int.toString());
		
		//When edge undirected and value is null.
		Test_class_int = new Test_class_int(0,1,null,0);
		assertEquals( "edge(undirected,0--1,)", Test_class_int.toString());
		
		//When edge directed and value is not null.
		Test_class_int = new Test_class_int(0,1,1,1);
		assertEquals( "edge(directed,0->1,1)", Test_class_int.toString());
				
		//When edge directed and value is null.
		Test_class_int = new Test_class_int(0,1,null,1);
		assertEquals( "edge(directed,0->1,)", Test_class_int.toString());
	}
	
	@Test
	public void float_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_float = new Test_class_float(0,1,1.0,0);
		assertEquals( "edge(undirected,0--1,1.0)", Test_class_float.toString());
		
		//When edge undirected and value is null.
		Test_class_float = new Test_class_float(0,1,null,0);
		assertEquals( "edge(undirected,0--1,)", Test_class_float.toString());
		
		//When edge directed and value is not null.
		Test_class_float = new Test_class_float(0,1,1,1);
		assertEquals( "edge(directed,0->1,1.0)", Test_class_float.toString());
				
		//When edge directed and value is null.
		Test_class_float = new Test_class_float(0,1,null,1);
		assertEquals( "edge(directed,0->1,)", Test_class_float.toString());
	}
	
	@Test
	public void double_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_double = new Test_class_double(0,1,1.0,0);
		assertEquals( "edge(undirected,0--1,1.0)", Test_class_double.toString());
		
		//When edge undirected and value is null.
		Test_class_double = new Test_class_double(0,1,null,0);
		assertEquals( "edge(undirected,0--1,)", Test_class_double.toString());
		
		//When edge directed and value is not null.
		Test_class_double = new Test_class_double(0,1,1.0,1);
		assertEquals( "edge(directed,0->1,1.0)", Test_class_double.toString());
				
		//When edge directed and value is null.
		Test_class_double = new Test_class_double(0,1,null,1);
		assertEquals( "edge(directed,0->1,)", Test_class_double.toString());
	}
	
	@Test
	public void char_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_char = new Test_class_char(0,1,'a',0);
		assertEquals( "edge(undirected,0--1,a)", Test_class_char.toString());
		
		//When edge undirected and value is null.
		Test_class_char = new Test_class_char(0,1,null,0);
		assertEquals( "edge(undirected,0--1,)", Test_class_char.toString());
		
		//When edge directed and value is not null.
		Test_class_char = new Test_class_char(0,1,'a',1);
		assertEquals( "edge(directed,0->1,a)", Test_class_char.toString());
				
		//When edge directed and value is null.
		Test_class_char = new Test_class_char(0,1,null,1);
		assertEquals( "edge(directed,0->1,)", Test_class_char.toString());
	}
	
	@Test
	public void string_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_string = new Test_class_string(0,1,"Test string",0);
		assertEquals( "edge(undirected,0--1,Test string)", Test_class_string.toString());
		
		//When edge undirected and value is null.
		Test_class_string = new Test_class_string(0,1,null,0);
		assertEquals( "edge(undirected,0--1,)", Test_class_string.toString());
		
		//When edge directed and value is not null.
		Test_class_string = new Test_class_string(0,1,"Test string",1);
		assertEquals( "edge(directed,0->1,1.Test string)", Test_class_string.toString());
				
		//When edge directed and value is null.
		Test_class_string = new Test_class_string(0,1,null,1);
		assertEquals( "edge(directed,0->1,)", Test_class_string.toString());
	}
	
	
	//Test for valid operation of Edge.equals().
	//Confirm all branches in this method.
	//Also check all type cases.
	@Test
	public void int_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_int = new Test_class_int(0,1,1,0);
		
		//Set another test class. Directed, value is not null.
		Test_class_int_2 = new Test_class_int(1,2,2,1);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_int.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_int = new Test_class_int(0,2,2,1);
		assertTrue(!Test_class_int.equals(Test_class_int_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_int = new Test_class_int(1,0,2,1);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_int = new Test_class_int(1,0,2,0);
		Test_class_int_2 = new Test_class_int(1,2,2,0);
		assertTrue(!Test_class_int.equals(Test_class_int_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_int = new Test_class_int(0,1,2,0);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		Test_class_int = new Test_class_int(2,3,2,0);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_int = new Test_class_int(0,1,null,0);
		Test_class_int2 = new Test_class_int(0,1,1,0);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		Test_class_int = new Test_class_int(0,1,1,0);
		Test_class_int2 = new Test_class_int(0,1,null,0);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		Test_class_int = new Test_class_int(0,1,1,0);
		Test_class_int2 = new Test_class_int(0,1,1,0);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		Test_class_int = new Test_class_int(0,1,null,0);
		Test_class_int2 = new Test_class_int(0,1,null,0);
		assertTrue(Test_class_int.equals(Test_class_int_2));
	}
	
	@Test
	public void float_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_float = new Test_class_float(0,1,1,0);
		
		//Set another test class. Directed, value is not null.
		Test_class_float_2 = new Test_class_float(1,2,2,1);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_float.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_float = new Test_class_float(0,2,2,1);
		assertTrue(!Test_class_float.equals(Test_class_float_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_float = new Test_class_float(1,0,2,1);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_float = new Test_class_float(1,0,2,0);
		Test_class_float_2 = new Test_class_float(1,2,2,0);
		assertTrue(!Test_class_float.equals(Test_class_float_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_float = new Test_class_float(0,1,2,0);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		Test_class_float = new Test_class_float(2,3,2,0);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_float = new Test_class_float(0,1,null,0);
		Test_class_float2 = new Test_class_float(0,1,1,0);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		Test_class_float = new Test_class_float(0,1,1,0);
		Test_class_float2 = new Test_class_float(0,1,null,0);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		Test_class_float = new Test_class_float(0,1,1,0);
		Test_class_float2 = new Test_class_float(0,1,1,0);
		assertTrue(Test_class_float.equals(Test_class_float_2));
		Test_class_float = new Test_class_float(0,1,null,0);
		Test_class_float2 = new Test_class_float(0,1,null,0);
		assertTrue(Test_class_float.equals(Test_class_float_2));
	}
	
	@Test
	public void double_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_double = new Test_class_double(0,1,1,0);
		
		//Set another test class. Directed, value is not null.
		Test_class_double_2 = new Test_class_double(1,2,2,1);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_double.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_double = new Test_class_double(0,2,2,1);
		assertTrue(!Test_class_double.equals(Test_class_double_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_double = new Test_class_double(1,0,2,1);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_double = new Test_class_double(1,0,2,0);
		Test_class_double_2 = new Test_class_double(1,2,2,0);
		assertTrue(!Test_class_double.equals(Test_class_double_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_double = new Test_class_double(0,1,2,0);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		Test_class_double = new Test_class_double(2,3,2,0);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_double = new Test_class_double(0,1,null,0);
		Test_class_double2 = new Test_class_double(0,1,1,0);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		Test_class_double = new Test_class_double(0,1,1,0);
		Test_class_double2 = new Test_class_double(0,1,null,0);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		Test_class_double = new Test_class_double(0,1,1,0);
		Test_class_double2 = new Test_class_double(0,1,1,0);
		assertTrue(Test_class_double.equals(Test_class_double_2));
		Test_class_double = new Test_class_double(0,1,null,0);
		Test_class_double2 = new Test_class_double(0,1,null,0);
		assertTrue(Test_class_double.equals(Test_class_double_2));
	}
	
	@Test
	public void char_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_char = new Test_class_char(0,1,'t',0);
		
		//Set another test class. Directed, value is not null.
		Test_class_char_2 = new Test_class_char(1,2,'t',1);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_char.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_char = new Test_class_char(0,2,'t',1);
		assertTrue(!Test_class_char.equals(Test_class_char_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_char = new Test_class_char(1,0,'t',1);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_char = new Test_class_char(1,0,'t',0);
		Test_class_char_2 = new Test_class_char(1,2,'t',0);
		assertTrue(!Test_class_char.equals(Test_class_char_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_char = new Test_class_char(0,1,'t',0);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		Test_class_char = new Test_class_char(2,3,'t',0);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_char = new Test_class_char(0,1,null,0);
		Test_class_char2 = new Test_class_char(0,1,'t',0);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		Test_class_char = new Test_class_char(0,1,'t',0);
		Test_class_char2 = new Test_class_char(0,1,null,0);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		Test_class_char = new Test_class_char(0,1,'t',0);
		Test_class_char2 = new Test_class_char(0,1,'t',0);
		assertTrue(Test_class_char.equals(Test_class_char_2));
		Test_class_char = new Test_class_char(0,1,null,0);
		Test_class_char2 = new Test_class_char(0,1,null,0);
		assertTrue(Test_class_char.equals(Test_class_char_2));
	}
	
	@Test
	public void string_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_string = new Test_class_string(0,1,"Test string",0);
		
		//Set another test class. Directed, value is not null.
		Test_class_string_2 = new Test_class_string(1,2,"Test string",1);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_string.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_string = new Test_class_string(0,2,"Test string",1);
		assertTrue(!Test_class_string.equals(Test_class_string_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_string = new Test_class_string(1,0,"Test string",1);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_string = new Test_class_string(1,0,"Test string",0);
		Test_class_string_2 = new Test_class_string(1,2,"Test string",0);
		assertTrue(!Test_class_string.equals(Test_class_string_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_string = new Test_class_string(0,1,"Test string",0);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		Test_class_string = new Test_class_string(2,3,"Test string",0);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_string = new Test_class_string(0,1,null,0);
		Test_class_string2 = new Test_class_string(0,1,"Test string",0);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		Test_class_string = new Test_class_string(0,1,"Test string",0);
		Test_class_string2 = new Test_class_string(0,1,null,0);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		Test_class_string = new Test_class_string(0,1,"Test string",0);
		Test_class_string2 = new Test_class_string(0,1,"Test string",0);
		assertTrue(Test_class_string.equals(Test_class_string_2));
		Test_class_string = new Test_class_string(0,1,null,0);
		Test_class_string2 = new Test_class_string(0,1,null,0);
		assertTrue(Test_class_string.equals(Test_class_string_2));
	}
	
	
	//Test for valid operation of Edge.hashCode().
	//Also check all type cases.
	@Test
	public void int_edge_hashCode_test(){
		
		int value = 1;  //To use hashcode method.
		int direction = 0;
		int from = 0;
		int to = 1;
		
		//When value is not null
		Test_class_int = new Test_class_int(from,to,value,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)+value.hashCode())+, Test_class_int.hashCode());
		
		//When value is null
		Test_class_int = new Test_class_int(from,to,null,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)), Test_class_int.hashCode());
	}
	
	@Test
	public void float_edge_hashCode_test(){
		
		float value = 1;  //To use hashcode method.
		int direction = 0;
		int from = 0;
		int to = 1;
		
		//When value is not null
		Test_class_float = new Test_class_float(from,to,value,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)+value.hashCode())+, Test_class_float.hashCode());
		
		//When value is null
		Test_class_float = new Test_class_float(from,to,null,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)), Test_class_float.hashCode());
	}
	
	@Test
	public void double_edge_hashCode_test(){
		
		double value = 1;  //To use hashcode method.
		int direction = 0;
		int from = 0;
		int to = 1;
		
		//When value is not null
		Test_class_double = new Test_class_double(from,to,value,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)+value.hashCode())+, Test_class_double.hashCode());
		
		//When value is null
		Test_class_double = new Test_class_double(from,to,null,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)), Test_class_double.hashCode());
	}
	
	@Test
	public void char_edge_hashCode_test(){
		
		char value = 'T';  //To use hashcode method.
		int direction = 0;
		int from = 0;
		int to = 1;
		
		//When value is not null
		Test_class_char = new Test_class_char(from,to,value,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)+value.hashCode())+, Test_class_char.hashCode());
		
		//When value is null
		Test_class_char = new Test_class_char(from,to,null,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)), Test_class_char.hashCode());
	}
	
	@Test
	public void string_edge_hashCode_test(){
		
		string value = "Test string";  //To use hashcode method.
		int direction = 0;
		int from = 0;
		int to = 1;
		
		//When value is not null
		Test_class_string = new Test_class_string(from,to,value,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)+value.hashCode())+, Test_class_string.hashCode());
		
		//When value is null
		Test_class_string = new Test_class_string(from,to,null,direction);
		assertEquals(31*(31*(31*(31*17+direction)+from)+to)), Test_class_string.hashCode());
	}	
}
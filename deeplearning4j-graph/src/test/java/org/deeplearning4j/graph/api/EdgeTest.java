package org.deeplearning4j.graph.api;

import lombok.Data;

import org.junit.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.*;

import static org.junit.Assert.*;

import org.junit.*;

public class EdgeTest {

	Edge<Integer> Test_class_int;
	Edge<Float> Test_class_float;
	Edge<Double> Test_class_double;
	Edge<Character> Test_class_char;
	Edge<String> Test_class_string;
	
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
		Test_class_int = new Edge<Integer>(0,1,1,false);
		Test_class_float = new Edge<Float>(0,1,1f,false);
		Test_class_double = new Edge<Double>(0,1,1.1,false);
		Test_class_char = new Edge<Character>(0,1,'a',false); 
		Test_class_string = new Edge<String>(0,1,"a",false);
		
		assertNotNull(Test_class_int);
		assertNotNull(Test_class_float);
		assertNotNull(Test_class_double);
		assertNotNull(Test_class_char);
		assertNotNull(Test_class_string);
	}
	
	//Test for Class Edge constructor. When parameter value input is NULL
	//Given other parameter values have no effect on this test.
	//Class Edge must accept this command when value is null.
	@Test
	public void constructor_with_null_test(){
		
		Test_class_int = new Edge<Integer>(0,1,null,false);
		Test_class_float = new Edge<Float>(0,1,null,false);
		Test_class_double = new Edge<Double>(0,1,null,false);
		Test_class_char = new Edge<Character>(0,1,null,false); 
		Test_class_string = new Edge<String>(0,1,null,false);
		
		assertNotNull(Test_class_int);
		assertNotNull(Test_class_float);
		assertNotNull(Test_class_double);
		assertNotNull(Test_class_char);
		assertNotNull(Test_class_string);
	}
	
	//Boundary Test for Class Edge constructor when argument value type is int.
	//Test minimum, maximum int value.
	@Test
	public void int_edge_boundary_test(){
		Test_class_int = new Edge<Integer>(0,1,Integer.MAX_VALUE,false);		
		assertNotNull(Test_class_int);
		
		
		Test_class_int = new Edge<Integer>(0,1,Integer.MAX_VALUE,false);
		assertNotNull(Test_class_int);
	}
	
	
	//Boundary Test for Class Edge constructor when argument value type is float.
	//Test minimum, maximum float value.
	@Test
	public void float_edge_boundary_test(){
		
		Test_class_float = new Edge<Float>(0,1,Float.MIN_VALUE,false);
		assertNotNull(Test_class_float);
		
		Test_class_float = new Edge<Float>(0,1,Float.MAX_VALUE,false);
		assertNotNull(Test_class_float);
	}
		
	//Boundary Test for Class Edge constructor when argument value type is double.
	//Test minimum, maximum double value.
	@Test
	public void double_edge_boundary_test(){
		Test_class_double = new Edge<Double>(0,1,Double.MIN_VALUE,false);
		assertNotNull(Test_class_double);
		
		Test_class_double = new Edge<Double>(0,1,Double.MAX_VALUE,false);
		assertNotNull(Test_class_double);
	}
	
	//Boundary Test for Class Edge constructor when argument value type is double.
	//Minimum 0(null), Maximum 127(DEL)
	//Skip case when Type is string.
	@Test
	public void char_edge_boundary_test(){
		Test_class_char = new Edge<Character>(0,1,(char)0,false);
		assertNotNull(Test_class_char);
		
		Test_class_char = new Edge<Character>(0,1,(char)127,false);
		assertNotNull(Test_class_char);
	}
	

	//Test for valid operation of Edge.toString().
	//Confirm each type cases.
	@Test
	public void int_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_int = new Edge<Integer>(0,1,1,false);
		assertEquals( "edge(undirected,0--1,1)", Test_class_int.toString());
		
		//When edge undirected and value is null.
		Test_class_int = new Edge<Integer>(0,1,null,false);
		assertEquals( "edge(undirected,0--1,)", Test_class_int.toString());
		
		//When edge directed and value is not null.
		Test_class_int = new Edge<Integer>(0,1,1,true);
		assertEquals( "edge(directed,0->1,1)", Test_class_int.toString());
				
		//When edge directed and value is null.
		Test_class_int = new Edge<Integer>(0,1,null,true);
		assertEquals( "edge(directed,0->1,)", Test_class_int.toString());
	}
	
	@Test
	public void float_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_float = new Edge<Float>(0,1,1f,false);
		assertEquals( "edge(undirected,0--1,1.0)", Test_class_float.toString());
		
		//When edge undirected and value is null.
		Test_class_float = new Edge<Float>(0,1,null,false);
		assertEquals( "edge(undirected,0--1,)", Test_class_float.toString());
		
		//When edge directed and value is not null.
		Test_class_float = new Edge<Float>(0,1,1f,true);
		assertEquals( "edge(directed,0->1,1.0)", Test_class_float.toString());
				
		//When edge directed and value is null.
		Test_class_float = new Edge<Float>(0,1,null,true);
		assertEquals( "edge(directed,0->1,)", Test_class_float.toString());
	}
	
	@Test
	public void double_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_double = new Edge<Double>(0,1,1.0,false);
		assertEquals( "edge(undirected,0--1,1.0)", Test_class_double.toString());
		
		//When edge undirected and value is null.
		Test_class_double = new Edge<Double>(0,1,null,false);
		assertEquals( "edge(undirected,0--1,)", Test_class_double.toString());
		
		//When edge directed and value is not null.
		Test_class_double = new Edge<Double>(0,1,1.0,true);
		assertEquals( "edge(directed,0->1,1.0)", Test_class_double.toString());
				
		//When edge directed and value is null.
		Test_class_double = new Edge<Double>(0,1,null,true);
		assertEquals( "edge(directed,0->1,)", Test_class_double.toString());
	}
	
	@Test
	public void char_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_char = new Edge<Character>(0,1,'a',false);
		assertEquals( "edge(undirected,0--1,a)", Test_class_char.toString());
		
		//When edge undirected and value is null.
		Test_class_char = new Edge<Character>(0,1,null,false);
		assertEquals( "edge(undirected,0--1,)", Test_class_char.toString());
		
		//When edge directed and value is not null.
		Test_class_char = new Edge<Character>(0,1,'a',true);
		assertEquals( "edge(directed,0->1,a)", Test_class_char.toString());
				
		//When edge directed and value is null.
		Test_class_char = new Edge<Character>(0,1,null,true);
		assertEquals( "edge(directed,0->1,)", Test_class_char.toString());
	}
	
	@Test
	public void string_edge_toString_test(){
		
		//When edge undirected and value is not null.
		Test_class_string = new Edge<String>(0,1,"Test string",false);
		assertEquals( "edge(undirected,0--1,Test string)", Test_class_string.toString());
		
		//When edge undirected and value is null.
		Test_class_string = new Edge<String>(0,1,null,false);
		assertEquals( "edge(undirected,0--1,)", Test_class_string.toString());
		
		//When edge directed and value is not null.
		Test_class_string = new Edge<String>(0,1,"Test string",true);
		assertEquals( "edge(directed,0->1,Test string)", Test_class_string.toString());
				
		//When edge directed and value is null.
		Test_class_string = new Edge<String>(0,1,null,true);
		assertEquals( "edge(directed,0->1,)", Test_class_string.toString());
	}
	
	
	//Test for valid operation of Edge.equals().
	//Confirm all branches in this method.
	//Also check all type cases.
	@Test
	public void int_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_int = new Edge<Integer>(0,1,1,false);
		
		//Set another test class. Directed, value is not null.
		Edge<Integer> Test_class_int_2 = new Edge<Integer>(1,2,2,true);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_int.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_int = new Edge<Integer>(0,2,2,true);
		assertTrue(!Test_class_int.equals(Test_class_int_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_int = new Edge<Integer>(1,0,2,true);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_int = new Edge<Integer>(1,0,2,false);
		Test_class_int_2 = new Edge<Integer>(1,2,2,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_int = new Edge<Integer>(0,1,2,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		Test_class_int = new Edge<Integer>(2,3,2,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_int = new Edge<Integer>(0,1,null,false);
		Test_class_int_2 = new Edge<Integer>(0,1,1,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		Test_class_int = new Edge<Integer>(0,1,1,false);
		Test_class_int_2 = new Edge<Integer>(0,1,null,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		
		//Undirected edge, same from and to with not null value
		Test_class_int = new Edge<Integer>(0,1,1,false);
		Test_class_int_2 = new Edge<Integer>(0,1,1,false);		
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Undirected edge, same from and to with null value
		Test_class_int = new Edge<Integer>(0,1,null,false);
		Test_class_int_2 = new Edge<Integer>(0,1,null,false);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Undirected edge, crossover from and to with not null value
		Test_class_int = new Edge<Integer>(1,0,1,false);
		Test_class_int_2 = new Edge<Integer>(0,1,1,false);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Undirected edge, crossover from and to with null value
		Test_class_int = new Edge<Integer>(1,0,null,false);
		Test_class_int_2 = new Edge<Integer>(0,1,null,false);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Same object case with not null value in directed edge.		
		Test_class_int = new Edge<Integer>(0,1,1,true);
		Test_class_int_2 = new Edge<Integer>(0,1,1,true);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Same object case with null value in directed edge.
		Test_class_int = new Edge<Integer>(0,1,null,true);
		Test_class_int_2 = new Edge<Integer>(0,1,null,true);
		assertTrue(Test_class_int.equals(Test_class_int_2));
		
		//Test branch 7. (Only differ value case.)
		
		//Undirected
		Test_class_int = new Edge<Integer>(0,1,1,false);
		Test_class_int_2 = new Edge<Integer>(0,1,2,false);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
		
		//Directed
		Test_class_int = new Edge<Integer>(0,1,1,true);
		Test_class_int_2 = new Edge<Integer>(0,1,2,true);
		assertTrue(!Test_class_int.equals(Test_class_int_2));
	}
	
	@Test
	public void float_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_float = new Edge<Float>(0,1,1f,false);
		
		//Set another test class. Directed, value is not null.
		Edge <Float> Test_class_float_2 = new Edge<Float>(1,2,2f,true);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_float.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_float = new Edge<Float>(0,2,2f,true);
		assertTrue(!Test_class_float.equals(Test_class_float_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_float = new Edge<Float>(1,0,2f,true);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_float = new Edge<Float>(1,0,2f,false);
		Test_class_float_2 = new Edge<Float>(1,2,2f,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_float = new Edge<Float>(0,1,2f,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		Test_class_float = new Edge<Float>(2,3,2f,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_float = new Edge<Float>(0,1,null,false);
		Test_class_float_2 = new Edge<Float>(0,1,1f,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		Test_class_float = new Edge<Float>(0,1,1f,false);
		Test_class_float_2 = new Edge<Float>(0,1,null,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		
		//Undirected edge, same from and to with not null value
		Test_class_float = new Edge<Float>(0,1,1f,false);
		Test_class_float_2 = new Edge<Float>(0,1,1f,false);		
		assertTrue(Test_class_float.equals(Test_class_float_2));
		
		//Undirected edge, same from and to with null value
		Test_class_float = new Edge<Float>(0,1,null,false);
		Test_class_float_2 = new Edge<Float>(0,1,null,false);
		assertTrue(Test_class_float.equals(Test_class_float_2));
				
		//Undirected edge, crossover from and to with not null value
		Test_class_float = new Edge<Float>(1,0,1f,false);
		Test_class_float_2 = new Edge<Float>(0,1,1f,false);
		assertTrue(Test_class_float.equals(Test_class_float_2));
				
		//Undirected edge, crossover from and to with null value
		Test_class_float = new Edge<Float>(1,0,null,false);
		Test_class_float_2 = new Edge<Float>(0,1,null,false);
		assertTrue(Test_class_float.equals(Test_class_float_2));
				
		//Same object case with not null value in directed edge.		
		Test_class_float = new Edge<Float>(0,1,1f,true);
		Test_class_float_2 = new Edge<Float>(0,1,1f,true);
		assertTrue(Test_class_float.equals(Test_class_float_2));
				
		//Same object case with null value in directed edge.
		Test_class_float = new Edge<Float>(0,1,null,true);
		Test_class_float_2 = new Edge<Float>(0,1,null,true);
		assertTrue(Test_class_float.equals(Test_class_float_2));
		
		//Test branch 7. (Only differ value case.)
		
		//Undirected
		Test_class_float = new Edge<Float>(0,1,1f,false);
		Test_class_float_2 = new Edge<Float>(0,1,2f,false);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
				
		//Directed
		Test_class_float = new Edge<Float>(0,1,1f,true);
		Test_class_float_2 = new Edge<Float>(0,1,2f,true);
		assertTrue(!Test_class_float.equals(Test_class_float_2));
	}
	
	@Test
	public void double_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_double = new Edge<Double>(0,1,1.0,false);
		
		//Set another test class. Directed, value is not null.
		Edge<Double> Test_class_double_2 = new Edge<Double>(1,2,2.0,true);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_double.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_double = new Edge<Double>(0,2,2.0,true);
		assertTrue(!Test_class_double.equals(Test_class_double_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_double = new Edge<Double>(1,0,2.0,true);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_double = new Edge<Double>(1,0,2.0,false);
		Test_class_double_2 = new Edge<Double>(1,2,2.0,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_double = new Edge<Double>(0,1,2.0,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		Test_class_double = new Edge<Double>(2,3,2.0,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_double = new Edge<Double>(0,1,null,false);
		Test_class_double_2 = new Edge<Double>(0,1,1.0,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		Test_class_double = new Edge<Double>(0,1,1.0,false);
		Test_class_double_2 = new Edge<Double>(0,1,null,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		
		//Undirected edge, same from and to with not null value
		Test_class_double = new Edge<Double>(0,1,1.0,false);
		Test_class_double_2 = new Edge<Double>(0,1,1.0,false);		
		assertTrue(Test_class_double.equals(Test_class_double_2));
				
		//Undirected edge, same from and to with null value
		Test_class_double = new Edge<Double>(0,1,null,false);
		Test_class_double_2 = new Edge<Double>(0,1,null,false);
		assertTrue(Test_class_double.equals(Test_class_double_2));
						
		//Undirected edge, crossover from and to with not null value
		Test_class_double = new Edge<Double>(1,0,1.0,false);
		Test_class_double_2 = new Edge<Double>(0,1,1.0,false);
		assertTrue(Test_class_double.equals(Test_class_double_2));
						
		//Undirected edge, crossover from and to with null value
		Test_class_double = new Edge<Double>(1,0,null,false);
		Test_class_double_2 = new Edge<Double>(0,1,null,false);
		assertTrue(Test_class_double.equals(Test_class_double_2));
						
		//Same object case with not null value in directed edge.		
		Test_class_double = new Edge<Double>(0,1,1.0,true);
		Test_class_double_2 = new Edge<Double>(0,1,1.0,true);
		assertTrue(Test_class_double.equals(Test_class_double_2));
						
		//Same object case with null value in directed edge.
		Test_class_double = new Edge<Double>(0,1,null,true);
		Test_class_double_2 = new Edge<Double>(0,1,null,true);
		assertTrue(Test_class_double.equals(Test_class_double_2));
		
		//Test branch 7. (Only differ value case.)
		
		//Undirected
		Test_class_double = new Edge<Double>(0,1,1.0,false);
		Test_class_double_2 = new Edge<Double>(0,1,2.0,false);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
						
		//Directed
		Test_class_double = new Edge<Double>(0,1,1.0,true);
		Test_class_double_2 = new Edge<Double>(0,1,2.0,true);
		assertTrue(!Test_class_double.equals(Test_class_double_2));
	}
	
	@Test
	public void char_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_char = new Edge<Character>(0,1,'t',false);
		
		//Set another test class. Directed, value is not null.
		Edge<Character> Test_class_char_2 = new Edge<Character>(1,2,'t',true);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_char.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_char = new Edge<Character>(0,2,'t',true);
		assertTrue(!Test_class_char.equals(Test_class_char_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_char = new Edge<Character>(1,0,'t',true);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_char = new Edge<Character>(1,0,'t',false);
		Test_class_char_2 = new Edge<Character>(1,2,'t',false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_char = new Edge<Character>(0,1,'t',false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		Test_class_char = new Edge<Character>(2,3,'t',false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_char = new Edge<Character>(0,1,null,false);
		Test_class_char_2 = new Edge<Character>(0,1,'t',false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		Test_class_char = new Edge<Character>(0,1,'t',false);
		Test_class_char_2 = new Edge<Character>(0,1,null,false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		
		//Undirected edge, same from and to with not null value
		Test_class_char = new Edge<Character>(0,1,'a',false);
		Test_class_char_2 = new Edge<Character>(0,1,'a',false);		
		assertTrue(Test_class_char.equals(Test_class_char_2));
				
		//Undirected edge, same from and to with null value
		Test_class_char = new Edge<Character>(0,1,null,false);
		Test_class_char_2 = new Edge<Character>(0,1,null,false);
		assertTrue(Test_class_char.equals(Test_class_char_2));
						
		//Undirected edge, crossover from and to with not null value
		Test_class_char = new Edge<Character>(1,0,'a',false);
		Test_class_char_2 = new Edge<Character>(0,1,'a',false);
		assertTrue(Test_class_char.equals(Test_class_char_2));
						
		//Undirected edge, crossover from and to with null value
		Test_class_char = new Edge<Character>(1,0,null,false);
		Test_class_char_2 = new Edge<Character>(0,1,null,false);
		assertTrue(Test_class_char.equals(Test_class_char_2));
						
		//Same object case with not null value in directed edge.		
		Test_class_char = new Edge<Character>(0,1,'a',true);
		Test_class_char_2 = new Edge<Character>(0,1,'a',true);
		assertTrue(Test_class_char.equals(Test_class_char_2));
						
		//Same object case with null value in directed edge.
		Test_class_char = new Edge<Character>(0,1,null,true);
		Test_class_char_2 = new Edge<Character>(0,1,null,true);
		assertTrue(Test_class_char.equals(Test_class_char_2));
		
		//Test branch 7. (Only differ value case.)
		
		//Undirected
		Test_class_char = new Edge<Character>(1,0,'t',false);
		Test_class_char_2 = new Edge<Character>(0,1,'f',false);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
								
		//Directed
		Test_class_char = new Edge<Character>(0,1,'T',true);
		Test_class_char_2 = new Edge<Character>(0,1,'F',true);
		assertTrue(!Test_class_char.equals(Test_class_char_2));
	}
	
	@Test
	public void string_edge_equals_test(){
		
		//Set initial test class. Undirected, value is not null.
		Test_class_string = new Edge<String>(0,1,"Test string",false);
		
		//Set another test class. Directed, value is not null.
		Edge<String> Test_class_string_2 = new Edge<String>(1,2,"Test string",true);
		
		//Test branch 1. (Inconsistency of type)
		assertTrue(!Test_class_string.equals("Dummy string"));				
		
		//Test branch 2. (Inconsistency of direction)
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		
		//Set first test class to directed, value is not null.
		//Test branch 3-1. (Inconsistency of 'from' argument when both directed)
		Test_class_string = new Edge<String>(0,2,"Test string",true);
		assertTrue(!Test_class_string.equals(Test_class_string_2));		
		
		//Test branch 3-2. (Inconsistency of 'to' argument when both directed)
		Test_class_string = new Edge<String>(1,0,"Test string",true);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 4-1. (Same 'from', differ 'to' when both undirected)
		Test_class_string = new Edge<String>(1,0,"Test string",false);
		Test_class_string_2 = new Edge<String>(1,2,"Test string",false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));		
				
		//Test branch 4-2, 4-3. (Cross over but different cases when both undirected)
		Test_class_string = new Edge<String>(0,1,"Test string",false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		Test_class_string = new Edge<String>(2,3,"Test string",false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 5-1, 5-2. (Only oneside of Edge.value is null)
		Test_class_string = new Edge<String>(0,1,null,false);
		Test_class_string_2 = new Edge<String>(0,1,"Test string",false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		Test_class_string = new Edge<String>(0,1,"Test string",false);
		Test_class_string_2 = new Edge<String>(0,1,null,false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
		
		//Test branch 6-1, 6-2. (Both are same object. Edge value null, not null cases.)
		
		//Undirected edge, same from and to with not null value
		Test_class_string = new Edge<String>(0,1,"Test string",false);
		Test_class_string_2 = new Edge<String>(0,1,"Test string",false);		
		assertTrue(Test_class_string.equals(Test_class_string_2));
				
		//Undirected edge, same from and to with null value
		Test_class_string = new Edge<String>(0,1,null,false);
		Test_class_string_2 = new Edge<String>(0,1,null,false);
		assertTrue(Test_class_string.equals(Test_class_string_2));
						
		//Undirected edge, crossover from and to with not null value
		Test_class_string = new Edge<String>(1,0,"Test string",false);
		Test_class_string_2 = new Edge<String>(0,1,"Test string",false);
		assertTrue(Test_class_string.equals(Test_class_string_2));
						
		//Undirected edge, crossover from and to with null value
		Test_class_string = new Edge<String>(1,0,null,false);
		Test_class_string_2 = new Edge<String>(0,1,null,false);
		assertTrue(Test_class_string.equals(Test_class_string_2));
						
		//Same object case with not null value in directed edge.		
		Test_class_string = new Edge<String>(0,1,"Test string",true);
		Test_class_string_2 = new Edge<String>(0,1,"Test string",true);
		assertTrue(Test_class_string.equals(Test_class_string_2));
						
		//Same object case with null value in directed edge.
		Test_class_string = new Edge<String>(0,1,null,true);
		Test_class_string_2 = new Edge<String>(0,1,null,true);
		assertTrue(Test_class_string.equals(Test_class_string_2));
		
		//Test branch 7. (Only differ value case.)
		
		//Undirected
		Test_class_string = new Edge<String>(1,0,"Test string",false);
		Test_class_string_2 = new Edge<String>(0,1,"Different string!",false);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
										
		//Directed
		Test_class_string = new Edge<String>(1,0,"Test string",true);
		Test_class_string_2 = new Edge<String>(0,1,"Different string!",true);
		assertTrue(!Test_class_string.equals(Test_class_string_2));
										
	}
	
	
	//Test of valid operation and branch of Edge.hashCode()
	//Test type is string
	@Test
	public void string_edge_hashCode_test(){
		int from = 0;
		int to = 1;
		boolean direction = false ;
		String value = "This is Test string.";
		
		//Undirected with not null value
		Test_class_string = new Edge<String>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_string.hashCode());
		
		//Undirected with null value
		Test_class_string = new Edge<String>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_string.hashCode());
		
		direction = true ;
		
		//Directed with not null value
		Test_class_string = new Edge<String>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_string.hashCode());
				
		//Directed with null value
		Test_class_string = new Edge<String>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_string.hashCode());
	}
	
	//Test of valid operation of Edge.hashCode()
	//Test type is char
	@Test
	public void char_edge_hashCode_test(){
		int from = 0;
		int to = 1;
		boolean direction = false ;
		Character value = 'T';
			
		//Undirected with not null value
		Test_class_char = new Edge<Character>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_char.hashCode());
				
		//Undirected with null value
		Test_class_char = new Edge<Character>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_char.hashCode());
				
		direction = true ;
				
		//Directed with not null value
		Test_class_char = new Edge<Character>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_char.hashCode());
						
		//Directed with null value
		Test_class_char = new Edge<Character>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_char.hashCode());
	}
	
	//Test of valid operation of Edge.hashCode()
	//Test type is int
	@Test
	public void int_edge_hashCode_test(){
		int from = 0;
		int to = 1;
		boolean direction = false ;
		Integer value = 1;
				
		//Undirected with not null value
		Test_class_int = new Edge<Integer>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_int.hashCode());
					
		//Undirected with null value
		Test_class_int = new Edge<Integer>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_int.hashCode());
					
		direction = true ;
					
		//Directed with not null value
		Test_class_int = new Edge<Integer>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_int.hashCode());
							
		//Directed with null value
		Test_class_int = new Edge<Integer>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_int.hashCode());
	}
	
	//Test of valid operation of Edge.hashCode()
	//Test type is float
	@Test
	public void float_edge_hashCode_test(){
		int from = 0;
		int to = 1;
		boolean direction = false ;
		Float value = 1f;
					
		//Undirected with not null value
		Test_class_float = new Edge<Float>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_float.hashCode());
						
		//Undirected with null value
		Test_class_float = new Edge<Float>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_float.hashCode());
						
		direction = true ;
						
		//Directed with not null value
		Test_class_float = new Edge<Float>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_float.hashCode());
								
		//Directed with null value
		Test_class_float = new Edge<Float>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_float.hashCode());
	}
	
	
	//Test of valid operation of Edge.hashCode()
	//Test type is float
	@Test
	public void double_edge_hashCode_test(){
		int from = 0;
		int to = 1;
		boolean direction = false ;
		Double value = 1.0;
						
		//Undirected with not null value
		Test_class_double = new Edge<Double>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_double.hashCode());
							
		//Undirected with null value
		Test_class_double = new Edge<Double>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_double.hashCode());
							
		direction = true ;
							
		//Directed with not null value
		Test_class_double = new Edge<Double>(from, to, value, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+value.hashCode(), Test_class_double.hashCode());
									
		//Directed with null value
		Test_class_double = new Edge<Double>(from, to, null, direction);		
		assertEquals(31*(31*(31*(31*17+(direction? 1 : 0))+from)+to)+0, Test_class_double.hashCode());
	}
}

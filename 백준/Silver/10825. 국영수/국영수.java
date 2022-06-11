import java.io.*;
import java.util.*;
public class Main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Student[] students = new Student[N];
        
        for(int i=0;i<N;i++) {
        	String[] score = br.readLine().split(" ");
        	
        	students[i] = new Student(score[0],
        			Integer.parseInt(score[1]),
        			Integer.parseInt(score[2]),
        			Integer.parseInt(score[3]));
        	}
        
        Comparator<Student> myComparator = new Comparator<Student>() {
        	@Override
        	public int compare(Student o1, Student o2) {
        		if(o1.korean==o2.korean) {
        			if(o1.english==o2.english) {
        				
        				if(o1.math==o2.math) {
        					return o1.name.compareTo(o2.name);
        				}
        				
        				return o2.math-o1.math;
        			}
        			return o1.english - o2.english;
        		}
        		return o2.korean-o1.korean;
        	}
        };
        
        Arrays.sort(students, myComparator);
        for(int i=0;i<N;i++) System.out.println(students[i].name);
    }
    
    
}

class Student{
	String name;
	int korean;
	int english;
	int math;
	
	Student(String name, int korean, int english, int math){
		this.name = name;
		this.korean = korean;
		this.english = english;
		this.math = math;
	}
}
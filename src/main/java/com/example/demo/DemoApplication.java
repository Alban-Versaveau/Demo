package com.example.demo;

import com.example.demo.services.Computer;

public class DemoApplication {

<<<<<<< HEAD
	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext run = SpringApplication.run(DemoApplication.class, args);
		MyService myService = run.getBean(MyService.class);
		System.out.println(myService.m());
	}

=======
    public static void main(String[] args) throws Exception {
        Computer computer = new Computer();
        //STEP1
        System.out.println(computer.add("")); //SUM=0
        System.out.println(computer.add("1")); //SUM=1
        System.out.println(computer.add("1,2")); //SUM=3
        //STEP2
        System.out.println(computer.add("1,2,3,4,5,6,7,8,9,10")); //SUM=55
        //STEP3
        System.out.println(computer.add("1,2\n3")); //SUM=6
        //STEP4
        System.out.println(computer.add("//;\n1;2")); //SUM=3
        //STEP5
        System.out.println(computer.add("-1,-2,3")); //EXCEPTION RAISED
    }
>>>>>>> 3c21c1e... First commit
}

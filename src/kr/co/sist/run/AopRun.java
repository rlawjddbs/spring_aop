package kr.co.sist.run;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.co.sist.domain.ItemDomain;
import kr.co.sist.service.ItemService;
import kr.co.sist.service.ItemServiceImpl;

public class AopRun {
	
	public void execute() {
		//�������� ����ֱ�
		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/run/applicationContext.xml");
		ItemService is = ac.getBean(ItemService.class);
//		System.out.println("---------------------run getAddr-----------------------");
//		is.getAddr();
//		System.out.println("---------------------run getName-----------------------");
//		is.getName();
//		System.out.println("---------------------run getAge-----------------------");
//		is.getAge();
		
//		ItemDomain result = is.searchItem("������");
//		System.out.println(result.getItemNo()+"///"+result.getItem());
		
		ItemDomain id = is.searchData("���ü�");
		System.out.println(id.getItemNo()+" / "+id.getItem());
		
	} // execute
	
	public static void main(String[] args) {
		AopRun ar = new AopRun();
		ar.execute();
	} // main

} // class

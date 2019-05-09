package kr.co.sist.aop;


import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.ItemDomain;

/**
 * Aspect�� Advice�� Pointcut�� ������ �ִ�.
 */
@Aspect
@Component
public class ItemAOP {
	
	@Before("execution(* searchItem(String))")
	public void beforeItem( JoinPoint jp ) {
		System.out.println("=======before advice=====");
		// target method�� �Ű����� ó�� ( JoinPoint )
		Object[] params = jp.getArgs();
		// target method�� method ����
		Signature sig = jp.getSignature();
		System.out.println( "target method�� " +sig.getName() );
//		System.out.println( "target method ���������� " +sig.getModifiers() ); // 1025 - public�� �ǹ�
//		System.out.println( "target method ���������� " +(Modifier.isPublic(sig.getModifiers())?"public":"")); // 1025 - public�� �ǹ�
		System.out.println( "target method ���������� " +Modifier.toString(sig.getModifiers())); // 1025 - public�� �ǹ�
		
		if( params != null ) {
			System.out.println("�Ű����� ���� "+params.length);
			for(Object param:params) {
				System.out.println("�Ű����� �� : "+param);
			} // end for
		} // end if
	} // before
	
//	@Before("execution(* searchItem(String))")
//	public void before() {
//		System.out.println("before advice");
//	} // before
	
	@After("execution(* searchItem(String))")
	public void after() {
		System.out.println("after advice");
	} // before
	
	@Before("execution(String kr.co.sist.service.ItemServiceImpl.get*())")
	public void getter() {
		System.out.println("getter before advice");
	} // getter
	
//	@Around("execution(* searchData(..))")
//	public Object around(ProceedingJoinPoint pjp) throws Throwable {
//		
//		// target�� ��ȯ���� �޾ƿͼ� ��ȯ���� �����.
//		Object o = pjp.proceed(); // target method�� ������ �϶�
//		
//		return o;
//	} // around
	
	@Around("execution(* searchData(..))")
	public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
		pjp.getArgs(); // target �Ķ���� ó��
		pjp.getSignature(); // target method ����
		// target�� ��ȯ���� �޾ƿͼ� ��ȯ���� �����.
		ItemDomain id = (ItemDomain)pjp.proceed(); // target method�� ������ ��
		id.setItem(id.getItem()+" s('. ^)v");
		return id;
	} // around
	
}//Class

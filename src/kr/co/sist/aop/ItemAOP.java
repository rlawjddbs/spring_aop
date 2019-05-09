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
 * Aspect는 Advice와 Pointcut을 가지고 있다.
 */
@Aspect
@Component
public class ItemAOP {
	
	@Before("execution(* searchItem(String))")
	public void beforeItem( JoinPoint jp ) {
		System.out.println("=======before advice=====");
		// target method의 매개변수 처리 ( JoinPoint )
		Object[] params = jp.getArgs();
		// target method의 method 정보
		Signature sig = jp.getSignature();
		System.out.println( "target method명 " +sig.getName() );
//		System.out.println( "target method 접근지정자 " +sig.getModifiers() ); // 1025 - public을 의미
//		System.out.println( "target method 접근지정자 " +(Modifier.isPublic(sig.getModifiers())?"public":"")); // 1025 - public을 의미
		System.out.println( "target method 접근지정자 " +Modifier.toString(sig.getModifiers())); // 1025 - public을 의미
		
		if( params != null ) {
			System.out.println("매개변수 갯수 "+params.length);
			for(Object param:params) {
				System.out.println("매개변수 값 : "+param);
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
//		// target의 반환형을 받아와서 반환값을 만든다.
//		Object o = pjp.proceed(); // target method가 여러개 일때
//		
//		return o;
//	} // around
	
	@Around("execution(* searchData(..))")
	public ItemDomain around(ProceedingJoinPoint pjp) throws Throwable {
		pjp.getArgs(); // target 파라메터 처리
		pjp.getSignature(); // target method 정보
		// target의 반환형을 받아와서 반환값을 만든다.
		ItemDomain id = (ItemDomain)pjp.proceed(); // target method가 유일할 때
		id.setItem(id.getItem()+" s('. ^)v");
		return id;
	} // around
	
}//Class

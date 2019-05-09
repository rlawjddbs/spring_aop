package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.ItemDAOImpl;
import kr.co.sist.domain.ItemDomain;

@Component
public class ItemServiceImpl implements ItemService{
	
//	@Autowired(required=false)
//	private ItemDAO iDAO;
	
	@Autowired(required=false)
	private ItemDAOImpl iDi;
	
	@Override
	public ItemDomain searchItem(String name) {
		System.out.println("------------searchItem¿Ã »£√‚-------------");
		return iDi.selectItem(name);
	}//searchItem

	@Override
	public String getName() {
		String name = "±Ë¡§¿±";
		System.out.println("getName /// " + name );
		return name;
	} // getName

	@Override
	public String getAddr() {
		String addr = "º≠øÔΩ√ ∞≠≥≤±∏ ø™ªÔµø";
		System.out.println("getAddr /// " + addr);
		return addr;
	} // getAddr

	@Override
	public int getAge() {
		int age = 31;
		System.out.println("getAge /// "+age);
		return age;
	} // getAge

	@Override
	public ItemDomain searchData(String name) {
		return new ItemDomain("IO_O001", name+" ");
	} // searchData
	
} // class

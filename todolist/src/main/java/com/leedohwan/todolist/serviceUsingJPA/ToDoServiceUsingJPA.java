package com.leedohwan.todolist.serviceUsingJPA;

import java.util.List;
import com.leedohwan.todolist.modelUsingJPA.ToDo;

/***
 * <p><b>ToDoServiceUsingJPA</b></p>
 * <em>ToDoServiceUsingJPA의 구현클래스인 ToDoServiceUsingJpaImpl에서<br> ToDoRepository(JPA 사용)를 통해 DAO 기능구현</em> 
 * <p><b>기능목록</b></p>
 * <ul>
 * 	<li><em>List&lt;ToDo&gt; findByUsernameOrderByTargetDate(String username)</em></li><br>
 * 	<li><em>List&lt;ToDo&gt; findByUsernameOrderByTargetDateDesc(String username)</em></li><br>
 * 	<li><em>ToDo findById(int id)</em></li><br>
 * 	<li><em>void deleteById(int id)</em></li><br>
 * 	<li><em>ToDo save(ToDo toDo)</em></li><br>
 * </ul>
 * @author <b>이도환</b>
 * @see ToDoServiceUsingJpaImpl
 * @see ToDo
 */
public interface ToDoServiceUsingJPA {
	/***
	 * @author <b>이도환</b>
	 * @기능1 일치하는 <b>username</b>의 데이터 목록조회
	 * @기능2 목록조회시 <b>target_date</b> 컬럼으로 정렬수행
	 * @return <b>List&lt;ToDo&gt;</b>
	 */
	List<ToDo> findByUsernameOrderByTargetDate(String username);
	/***
	 * @author <b>이도환</b>
	 * @기능1 일치하는 <b>username</b>의 데이터 목록조회
	 * @기능2 목록조회시 <b>target_date</b> 컬럼으로 정렬수행(desc)
	 * @return <b>List&lt;ToDo&gt;</b>
	 */
	List<ToDo> findByUsernameOrderByTargetDateDesc(String username);
	/***
	 * @author <b>이도환</b>
	 * @기능1 일치하는 <b>id</b>의 데이터 단건조회
	 * @return <b>ToDo</b>
	 */
	ToDo findById(int id);
	/***
	 * @author <b>이도환</b>
	 * @기능1 일치하는 <b>id</b>의 데이터 삭제
	 * @return <b>void</b>
	 */
	void deleteById(int id);
	
	/***
	 * @author <b>이도환</b>
	 * @기능1 <b>id</b>가 <em>존재하면 단건 업데이트</em>
	 * @기능2 <b>id</b>가 <em>0이거나 일치하는 것이 없으면 단건 추가</em>
	 * @return <b>ToDo</b>
	 */
	ToDo save(ToDo toDo);
}

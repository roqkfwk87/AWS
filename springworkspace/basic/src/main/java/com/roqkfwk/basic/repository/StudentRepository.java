package com.roqkfwk.basic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.roqkfwk.basic.entity.StudentEntity;
import java.util.List;


// Repository 레이어 : 
// - 데이터베이스와 관련된 작업들을 처리하는 영역
// - Service가 비즈니스 로직 수행 중 데이터베이스 작업이 필요할 때 Repository를 거쳐서 데이터 작업을 수행

// @Repository : 해당 클래스를 Spring Bean으로 등록하는 어노테이션, @Component와 동일
// - interface에 @Repository를 사용한 이유
// - JPA를 사용하면 JpaRepository 인터페이스를 상속받은 인터페이스의 구현체를 JPA가 자동으로 생성
@Repository // studentnumber의 타입으로 Integer
public interface StudentRepository
// JpaRepository<T, ID> :
// - JPA 기반의 Repository를 구현하는 주요 인터페이스
// - 기본 CRUD, 정렬 기능을 제공 하고있음
// - JPA 기반 Repository를 생성할 때 반드시 상속해야함
// - 매개타입 T : 해당 Repository가 어떤 Entity의 Repository인지 나타내는 매개타입
// - 매개타입 ID : 해당 Repository에서 사용하는 Entity의 Primary key 데이터 타입을 지정하는 매개타입
extends JpaRepository<StudentEntity, Integer> {
    // Student 테이블에서 address가 '서울특별시'인 레코드를 조회
    
    // SQL : 
    // SELECT * FROM student
    // WHERE address = '서울특별시';
    // findByAddress만 쳐도 자동 완성 가능
    List<StudentEntity> findByAddress(String address);

    // SQL : 
    // SELECT * FROM student
    // WHERE graduation IS true
    // ORDER BY age DESC;
    List<StudentEntity> findByGraduationOrderByAgeDesc(Boolean graduation);

    // SQL :
    // SELECT * FROM student
    // WHERE student_number = 5
    // AND age > 20;
    // 0 ~ 1개까지일 때는 List 형태 X
    StudentEntity findByStudentNumberAndAgeGreaterThan(Integer studentNumber, Integer age);

    // SQL :
    // SELECT count(*) FROM student
    // WHERE graduation IS false
    // 기본적으로 정수형태
    int countByGraduation(Boolean graduation);

    // address가 '서울특별시' 이면서 graduation이 true인 레코드가 존재하는가?
    boolean existsByAddressAndGraduation(String address, Boolean graduation);

    // @Query : 
    // - 쿼리 메서드 생성 방식만으로는 실제 SQL을 작성하는 데 한계 있음
    // - 복잡한 쿼리, 조인, 서브쿼리, 그룹화를 사용할 수 없음
    // - 직접 SQL문으로 쿼리를 생성하도록 하는 어노테이션

    // JPQL (Java Persistence Query Language) :
    // - 표준 SQL과 매우 흡사하지만 Entity명과 Entity 속성으로 쿼리를 작성하는 방법
    @Query(value = 
        "SELECT s FROM student s WHERE s.studentNumber = ?1 AND age > ?2",
        nativeQuery = false
    )
    List<StudentEntity> getStudent2(Integer studentNumber, Integer age);


    // Native SQL : 
    // - 현재 사용하고 있는 RDBMS의 SQL 문법을 그대로 따르는 방식
    @Query(value = 
        "SELECT " +
            "student_number AS studentNumber, " +
            "name, " +
            "age, " +
            "address, " +
            "graduation " +
        "FROM student " +
        "WHERE student_number = :student_number " +
        "AND age > :age ",
        nativeQuery = true
    )
    List<StudentEntity> getStudent3(@Param("student_number") Integer studentNumber, @Param("age") Integer age
    );

    StudentEntity findByStudentNumber(Integer studentNUmber);
    
} 



// int는 함수의 반환 데이터 타입을 말하니까 int인거고 () 안에서는 객체를 선언해서 매개변수로 적는거라 대문자 쓰는 거 아님?
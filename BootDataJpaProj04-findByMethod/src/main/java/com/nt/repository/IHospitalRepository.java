package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Hospital;

public interface IHospitalRepository extends JpaRepository<Hospital, Integer>    {
	//Entity queries
  public   List<Hospital>  findByLocationEquals(String  location);
  public  List<Hospital>  readByLocationIs(String loc);
    public  List<Hospital>  getByLocation(String loc);
    
    public  List<Hospital>  queryBySizeBetween(int start,int end);
    
    public  List<Hospital>  findByNameStartingWith(String initChars);
    public  List<Hospital>  findByNameEndingWith(String lastChars);
    public  List<Hospital>  findByNameContaining(String chars);
    
    
    public  List<Hospital>  findByNameLike(String chars);
    public  List<Hospital>  findByNameLikeOrderByNameDesc(String chars);
    
    public  List<Hospital>  getBySizeBetweenAndLocationIn(int start,int end,List<String> cities);
    
    public  List<Hospital>  findByLocationOrNameIn(String loc,String ... names);
    
    
    public  Optional<Hospital>  findByName(String name);
    
    public  long  countByLocation(String  loc);
    public   boolean existsByName(String name);
    
    @Transactional
    public int deleteByNameIn(String  ... names);  
}

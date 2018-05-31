package com.demo.Station.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.demo.Station.model.Station;

@Repository
@Mapper
public interface StationRepository {
	@Select("select * from STATION")
	public List<Station> findAll();

	@Insert("INSERT INTO station(stationId, name, hdEnabled,callSign) VALUES (#{stationId}, #{name}, #{hdEnabled},#{callSign})")
	public int insert(Station station);

	@Delete("DELETE FROM station WHERE stationID = #{stationId}")
	public int deleteById(String stationId);
	
	@Update("Update station set name=#{name}, hdEnabled=#{hdEnabled},callSign=#{callSign} where stationId=#{stationId}")
	public int update(Station station);
	
	@Select("SELECT * FROM station WHERE stationId = #{stationId}")
	public Station findById(String stationId);
	
	@Select("SELECT * FROM station WHERE name = #{name}")
	public Station findByName(String name);
	
	@Select("SELECT * FROM station WHERE hdEnabled = true")
	public List<Station> hasEnable();

}

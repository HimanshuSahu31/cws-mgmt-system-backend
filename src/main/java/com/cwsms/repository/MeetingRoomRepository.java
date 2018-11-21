package com.cwsms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwsms.model.office.type.MeetingRoom;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long>{

}

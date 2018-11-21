package com.cwsms.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cwsms.constants.RESTConstants;
import com.cwsms.exception.MeetingRoomNotFoundException;
import com.cwsms.model.office.type.MeetingRoom;
import com.cwsms.repository.MeetingRoomRepository;

@RestController
public class MeetingRoomController {
	
	@Autowired
	private MeetingRoomRepository meetingRoomRepository;
	
	@GetMapping(RESTConstants.MEETING_ROOM)
	public List<MeetingRoom> getAllMeetingRooms() {
		return meetingRoomRepository.findAll();
	}
	
	@GetMapping(value=RESTConstants.MEETING_ROOM_ID, produces={MediaType.APPLICATION_JSON_VALUE,RESTConstants.MEDIA_TYPE_JSON_HAL})
	public Resource<MeetingRoom> getMeetingRoomById(@PathVariable Long id) throws MeetingRoomNotFoundException {
		Optional<MeetingRoom> meetingRoom = meetingRoomRepository.findById(id);
		if(!meetingRoom.isPresent()) throw new MeetingRoomNotFoundException("MeetingRoom ID: "+id);
		Resource<MeetingRoom> resource = new Resource<MeetingRoom>(meetingRoom.get());
		ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(this.getClass()).getAllMeetingRooms());
		resource.add(linkTo.withRel(RESTConstants.MEETING_ROOM_LINK));
		return resource;
	}
	
	@DeleteMapping(RESTConstants.MEETING_ROOM_ID)
	public void deleteMeetingRoomById(@PathVariable Long id) {
		meetingRoomRepository.deleteById(id);
	}
	
	@PostMapping(RESTConstants.MEETING_ROOM)
	public ResponseEntity<Object> addNewMeetingRoom(@RequestBody MeetingRoom meetingRoom) {
		MeetingRoom newMeetingRoom = meetingRoomRepository.save(meetingRoom);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path(RESTConstants.ID).buildAndExpand(newMeetingRoom.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping(RESTConstants.MEETING_ROOM_ID)
	public ResponseEntity<Object> updateMeetingRoom(@RequestBody MeetingRoom meetingRoom, @PathVariable Long id) {
		Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(id);
		
		if(!optionalMeetingRoom.isPresent())
			return ResponseEntity.notFound().build();
		else {
			meetingRoom.setId(id);
			meetingRoomRepository.save(meetingRoom);
			return ResponseEntity.noContent().build();
		}
	}
}

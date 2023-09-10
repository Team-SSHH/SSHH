package com.shinhan.hack.friends.controller;

import com.shinhan.hack.category.dto.CategoryDto;
import com.shinhan.hack.friends.dto.FriendsDto;
import com.shinhan.hack.friends.entity.Friends;
import com.shinhan.hack.friends.service.FriendsService;
import com.shinhan.hack.history.dto.HistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sshh/friends")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true", allowedHeaders = "*", methods = {
        RequestMethod.GET, RequestMethod.POST, RequestMethod.OPTIONS, RequestMethod.HEAD, RequestMethod.DELETE,
        RequestMethod.PUT })
@RequiredArgsConstructor public class FriendsController {

    private final FriendsService friendsService;

    @GetMapping("/{studentid}")
    public ResponseEntity<List<FriendsDto>> getFriends(
            @PathVariable("studentid") Long studentid) {
        List<FriendsDto> friendsList= friendsService.getFriendsByStudent(studentid);
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }

    @PostMapping("/{studentid}/store/{friendStudentId}")
    public ResponseEntity<List<FriendsDto>> saveFriend(
            @PathVariable("studentid") Long studentid, @PathVariable("friendStudentId") Long friendStudentId, @RequestBody Map<String, Long> body) {
        Long categoryId = body.get("categoryId");
        List<FriendsDto> friendsList= friendsService.saveFriend(studentid,friendStudentId, categoryId );
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }

    @DeleteMapping("/{studentid}/delete/{friendStudentId}")
    public ResponseEntity<List<FriendsDto>> deleteFriend(
            @PathVariable("studentid") Long studentid, @PathVariable("friendStudentId") Long friendStudentId) {
        List<FriendsDto> friendsList= friendsService.deleteFriend(studentid,friendStudentId);
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }


    @PutMapping("/{studentid}/update/{friendStudentId}")
    public ResponseEntity<List<FriendsDto>> updateFriend(
            @PathVariable("studentid") Long studentid, @PathVariable("friendStudentId") Long friendStudentId, @RequestBody Map<String, Long> body) {
        Long categoryId = body.get("categoryId");
        List<FriendsDto> friendsList = friendsService.updateFriend(studentid, friendStudentId, categoryId);
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }

    @GetMapping("/{studentid}/certify/{friendStudentId}")
    public ResponseEntity<List<FriendsDto>> getFriends(
            @PathVariable("studentid") Long studentid, @PathVariable("friendStudentId") Long friendStudentId) {
        List<FriendsDto> friendsList= friendsService.getFriendsByStudent(studentid);
        return new ResponseEntity<>(friendsList, HttpStatus.OK);
    }


}


//    @PostMapping("/{studentId}/store/{friendStudentId}")
//    public ResponseEntity<String> abc(@PathVariable("studentId") Long studentId, @PathVariable("friendStudentId") Long friendStudentId) {
//
//
//        friendsService.addFriend(studentId, friendStudentId, 1L);
//        return new ResponseEntity<>("Success", HttpStatus.OK);
//    }
//
//


//    @GetMapping("/history")
//    public ResponseEntity<List<HistoryDto.Response>> getAllHistory() {
//        List<HistoryDto.Response> responses = historyService.getAllHistory();
//        return new ResponseEntity<>(responses, HttpStatus.OK);
//    }
//}

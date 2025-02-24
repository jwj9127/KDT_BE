package com.server.moabook.group.controller;

import com.server.moabook.global.exception.dto.SuccessStatusResponse;
import com.server.moabook.global.exception.message.SuccessMessage;
import com.server.moabook.global.jwt.JwtTokenProvider;
import com.server.moabook.group.dto.request.CreateGroupRequestDto;
import com.server.moabook.group.dto.request.DeleteGroupRequestDto;
import com.server.moabook.group.dto.request.UpdateGroupRequestDto;
import com.server.moabook.group.dto.response.SelectGroupResponseDto;
import com.server.moabook.group.service.GroupService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final JwtTokenProvider jwtTokenProvider;
    private final GroupService groupService;

    @PostMapping
    public ResponseEntity<SuccessStatusResponse<Void>> create(@RequestHeader("Authorization") String token,
                                                                                @Valid @RequestBody CreateGroupRequestDto createGroupRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        groupService.createGroup(userId, createGroupRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.CREATE_GROUP_SUCCESS, null
                )
        );
    }

    @GetMapping
    public ResponseEntity<SuccessStatusResponse<SelectGroupResponseDto>> select(@RequestHeader("Authorization") String token){

        Long userId = jwtTokenProvider.getUserFromJwt(token);
        SelectGroupResponseDto selectGroupResponseDto = groupService.selectGroup(userId);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.SELECT_GROUP_SUCCESS,selectGroupResponseDto
                )
        );
    }

    @PutMapping
    public ResponseEntity<SuccessStatusResponse<Void>> update(@RequestHeader("Authorization") String token,
                                                                             @Valid @RequestBody UpdateGroupRequestDto updateGroupRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        groupService.updateGroup(userId, updateGroupRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.UPDATE_GROUP_SUCCESS, null
                )
        );
    };

    @DeleteMapping
    public ResponseEntity<SuccessStatusResponse<Void>> delete(@RequestHeader("Authorization") String token,
                                                                                @Valid @RequestBody DeleteGroupRequestDto deleteGroupRequestDto){
        Long userId = jwtTokenProvider.getUserFromJwt(token);
        groupService.deleteGroup(userId, deleteGroupRequestDto);

        return ResponseEntity.status(HttpStatus.OK).body(
                SuccessStatusResponse.of(
                        SuccessMessage.DELETE_GROUP_SUCCESS, null
                )
        );
    };

}

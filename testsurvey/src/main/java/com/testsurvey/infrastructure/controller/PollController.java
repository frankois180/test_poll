package com.testsurvey.infrastructure.controller;

import com.testsurvey.application.PollAppService;
import com.testsurvey.infrastructure.controller.dto.ApiResponseDto;
import com.testsurvey.infrastructure.controller.dto.PollDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/poll")
@RequiredArgsConstructor
public class PollController {

    private final PollAppService pollAppService;

    @PostMapping
    public ApiResponseDto save(@Validated @RequestBody PollDTO pollDTO) {
        return ApiResponseDto.builder()
                .data(pollAppService.save(pollDTO))
                .build();

    }

    @GetMapping(path = "/{code}")
    public  ApiResponseDto findByCode(@PathVariable String code){
        return ApiResponseDto.builder()
                .data(pollAppService.findByCode(code))
                .build();
    }

}

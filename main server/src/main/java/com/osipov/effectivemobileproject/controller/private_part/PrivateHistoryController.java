package com.osipov.effectivemobileproject.controller.private_part;

import com.osipov.effectivemobileproject.dto.history.HistoryOutDto;
import com.osipov.effectivemobileproject.service.private_part.PrivateHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{userId}/history")
public class PrivateHistoryController {

    private final PrivateHistoryService historyService;

    @Autowired
    public PrivateHistoryController(PrivateHistoryService historyService) {
        this.historyService = historyService;
    }

    @GetMapping()
    public List<HistoryOutDto> getHistoryByUser(
            @PathVariable(value = "userId") final long userId,
            @RequestParam(defaultValue = "0") final int from,
            @RequestParam(defaultValue = "10") final int size
    ) {
        return historyService.getHistoryByUser(userId, from, size);
    }

    @PatchMapping("{historyId}/cancel")
    public HistoryOutDto cancelProduct(
            @PathVariable final Long historyId,
            @PathVariable final Long userId
    ) {
        return historyService.cancelProduct(historyId, userId);
    }
}
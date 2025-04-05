package com.example.todoapi.api;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.example.todoapi.common.model.common.ResourceNotFoundError;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Min;

@CrossOrigin(origins = "http://localhost:4200")
@Validated
@Tag(name = "tasks", description = "タスク関連のAPI")
public interface TasksDeleteApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * DELETE /tasks/{taskId} : タスク削除
     * 指定されたタスクを削除します
     *
     * @param taskId 更新するタスクのID (required)
     * @return No Content (status code 204)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "deleteTask",
        summary = "タスク削除",
        description = "指定されたタスクを削除します",
        tags = { "tasks" },
        responses = {
            @ApiResponse(responseCode = "204", description = "No Content"),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceNotFoundError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.DELETE,
        value = "/tasks/{taskId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Void> deleteTask(
        @Min(1L) @Parameter(name = "taskId", description = "更新するタスクのID", required = true, in = ParameterIn.PATH) @PathVariable("taskId") Long taskId
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

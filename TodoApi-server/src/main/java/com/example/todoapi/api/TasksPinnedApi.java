/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.4.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.example.todoapi.api;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import com.example.todoapi.common.model.common.BadRequestError;
import com.example.todoapi.common.model.common.ResourceNotFoundError;
import com.example.todoapi.common.model.task.TaskDto;
import com.example.todoapi.common.model.task.TaskPinForm;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-03-17T08:54:47.507584900+09:00[Asia/Tokyo]")
@Validated
@Tag(name = "tasks", description = "タスク関連のAPI")
public interface TasksPinnedApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * PUT /tasks/ : タスクピン留め
     * 指定されたタスクをピン留めします
     *
     * @param taskPinDto  (required)
     * @return OK (status code 200)
     *         or Bad Request (status code 400)
     *         or Not Found (status code 404)
     */
    @Operation(
        operationId = "pinnedTask",
        summary = "タスクピン留め",
        description = "指定されたタスクをピン留めします",
        tags = { "tasks" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TaskDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = BadRequestError.class))
            }),
            @ApiResponse(responseCode = "404", description = "Not Found", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ResourceNotFoundError.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/tasks/",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TaskDto> pinnedTask(
        @Parameter(name = "TaskPinDto", description = "", required = true) @Valid @RequestBody TaskPinForm taskPinDto
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"compF\" : 5, \"pinF\" : 2, \"id\" : 5, \"title\" : \"title\", \"content\" : \"content\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}

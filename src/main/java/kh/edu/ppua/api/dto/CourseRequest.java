package kh.edu.ppua.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequest implements Serializable {

    private String title;
    private String description;
    private String code;

}

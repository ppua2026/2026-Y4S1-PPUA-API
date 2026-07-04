package kh.edu.ppua.api.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResourceNotFoundException extends  Exception{
    String message;

    public ResourceNotFoundException(String message){
        this.message = message;
    }

}

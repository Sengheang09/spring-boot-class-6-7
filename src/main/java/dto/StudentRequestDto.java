package dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentRequestDto {
    private String fullName;

    private String gender;

    private String email;

    private String phone;
}

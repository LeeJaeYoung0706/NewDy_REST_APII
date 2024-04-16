package ToyProject.NewDy.REST_API.auth.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "회원 저장 객체")
public class SignUpMemberDTO {

    @Pattern(regexp = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}$")
    @Schema(description = "이메일 형식 로그인 아이디")
    private String signinId;

    @Pattern(regexp = "^(?!((?:[A-Za-z]+)|(?:[~!@#$%^&*()_+=]+)|(?:[0-9]+))$)[A-Za-z\\d~!@#$%^&*()_+=]{8,20}$")
    @Schema(description = "비밀번호 대소문자, 특수문자, 숫자 중 2개이상 포함 8~20글자")
    private String password;

    @Schema(description = "생일")
    private Date birth;

    @NotBlank
    @Schema(description = "상위 주소")
    private String city;

    @NotBlank
    @Schema(description = "하위 주소")
    private String street;

    @NotBlank
    @Schema(description = "우편 번호")
    private String zipCode;

}

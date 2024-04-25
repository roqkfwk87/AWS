public class sampleDto {
    @ NotNull // 해당 속성을 null이 올 수 없도록 지정
    private String notNull;

    @NotEmpty // 문자열일 경우 null 또는 빈 문자열이 올 수 없도록 지정
    private String notEmpty;

    @NotBlank // 문자열일 경우 null 또는 빈 문자열 또는 공백으로된 문자열이 올 수 없도록 지정
    private String notBlank;

    // 문자열일 경우 문자열 길이의 최소 최대를 지정 
    @Length (min=5, max=10)
    private String length;
}
// http://localhost:4000/request-data/post

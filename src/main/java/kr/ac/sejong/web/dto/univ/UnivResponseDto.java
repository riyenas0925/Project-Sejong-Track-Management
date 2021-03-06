package kr.ac.sejong.web.dto.univ;

import kr.ac.sejong.domain.univ.Univ;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class UnivResponseDto {
    private Long id;
    private String title;
    private Long univNo;

    public UnivResponseDto(Univ entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.univNo = entity.getUnivNo();
    }
}

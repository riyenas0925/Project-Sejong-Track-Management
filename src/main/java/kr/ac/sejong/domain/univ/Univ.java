package kr.ac.sejong.domain.univ;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kr.ac.sejong.domain.track.Track;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Entity
@Table(name = "univ")
@ToString(exclude = "tracks")
public class Univ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Long univNo;

    @JsonIgnore
    @OneToMany(mappedBy = "univ", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Track> tracks;

    public Univ() {

    }

    @Builder
    public Univ(Long id, String title, Long univNo) {
        this.id = id;
        this.title = title;
        this.univNo = univNo;
    }
}

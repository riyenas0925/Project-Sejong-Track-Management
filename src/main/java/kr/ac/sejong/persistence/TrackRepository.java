package kr.ac.sejong.persistence;

import kr.ac.sejong.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long>, TrackCustomRepository {

}

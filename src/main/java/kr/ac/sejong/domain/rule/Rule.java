package kr.ac.sejong.domain.rule;

import kr.ac.sejong.domain.track.Track;
import kr.ac.sejong.domain.degree.Degree;
import lombok.*;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "tbl_rule")
@ToString(exclude = {"degree", "track"})
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ruleId;

    private Long basicCredit;
    private Long appliedCredit;
    private Long industryCredit;
    private Long expertCredit;
    private Long commonCredit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trackId")
    Track track;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "degreeId")
    Degree degree;

    public Rule() {

    }

    @Builder
    public Rule(Track track, Degree degree,
                Long ruleId, Long basicCredit, Long appliedCredit,
                Long industryCredit, Long expertCredit, Long commonCredit) {
        this.track = track;
        this.degree = degree;
        this.ruleId = ruleId;
        this.basicCredit = basicCredit;
        this.appliedCredit = appliedCredit;
        this.industryCredit = industryCredit;
        this.expertCredit = expertCredit;
        this.commonCredit = commonCredit;
    }

    public static Rule createRule(Track track, Degree degree,
                                  Long basicCredit, Long appliedCredit,
                                  Long industryCredit, Long expertCredit, Long commonCredit) {
        Rule rule = Rule.builder()
                .track(track)
                .degree(degree)
                .basicCredit(basicCredit)
                .appliedCredit(appliedCredit)
                .industryCredit(industryCredit)
                .expertCredit(expertCredit)
                .commonCredit(commonCredit)
                .build();

        return rule;
    }
}

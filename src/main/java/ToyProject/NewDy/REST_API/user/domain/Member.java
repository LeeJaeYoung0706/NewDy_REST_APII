package ToyProject.NewDy.REST_API.user.domain;

import ToyProject.NewDy.REST_API.common.domain.Address;
import ToyProject.NewDy.REST_API.common.domain.DateBaseEntity;
import ToyProject.NewDy.REST_API.common.enums.YesOrNo;
import ToyProject.NewDy.REST_API.common.sequences.CustomSequenceGenerator;
import ToyProject.NewDy.REST_API.user.enums.MemberGarde;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;
import java.util.List;

@Entity
@Getter @Setter
public class Member extends DateBaseEntity {

    @Id
    @GeneratedValue(generator = "custom_generator")
    @GenericGenerator(name = "custom_generator",
            parameters = {
                    @org.hibernate.annotations.Parameter(
                            name = "initial_value",
                            value = "1"
                    ), // 시작점
                    @org.hibernate.annotations.Parameter(
                            name = "increment_size",
                            value = "50"
                    ), // 캐싱 사이즈
                    @org.hibernate.annotations.Parameter(
                            name = "prefix",
                            value = "member"
                    )
            },
            type = CustomSequenceGenerator.class)
    @Column(name = "member_id")
    private String id;

    /**
     * 기존 OneToMany 이지만 다대일로 변경해서 사용합니다. 성능이슈 및 유지보수를 위해서
     */
    @OneToMany(mappedBy = "member")
    private List<Address> address;

    @Column(unique = true, name = "email", nullable = false, columnDefinition = "varchar(512)")
    private String email;

    @Column(name = "birth")
    @Temporal(TemporalType.DATE)
    private Date birth;

    @Column(name = "signin_id" , unique = true, nullable = false)
    private String signin_id;

    //탈퇴 여부
    @Column(name = "secessionYN")
    @Enumerated(EnumType.STRING)
    private YesOrNo secessionYesOrNo;

    @Column(name = "grade")
    @Enumerated(EnumType.STRING)
    private MemberGarde garde;

    @OneToMany(mappedBy = "member")
    private List<Point> point;
}
